/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author heloise
 */
public class Outils {
    
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Date dateAuj = new Date();
    public static File f = new File("t");
    
    /**
     * méthode de chargement du fichier CSV de compétence de l'entreprise
     * @param fileName Le nom du fichier à charger
     * @throws FileNotFoundException fichier introuvable
     */
    public static void chargerCompetence(String fileName) throws FileNotFoundException {
        try {
            File fic = new File("data/"+fileName);
            Scanner scan = new Scanner(fic);
            while(scan.hasNext()) {
                String line = scan.nextLine();
                String[] tab = line.split(";");
                Competence comp = new Competence(tab[0], tab[1].trim(), tab[2].trim());
                Entreprise.addCompetence(comp);
            }
        }
        catch (Exception e) {
            System.err.println("Fichier incorrect, impossible de charger les compétences");
        }
    }
    
    /**
     * méthode de chargement du fichier CSV des employés de l'entreprise
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
     */
    public static void chargerPersonnel(String fileName) throws IOException, ParseException {
        try {
            FileReader fr = new FileReader("data/"+fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); // skip first line
            while(br.ready()) { 
                String line = br.readLine();
                if (!line.equals("")) { // ignore empty lines
                    String [] tab = line.split(";");
                    String nom = tab[1];
                    String prenom = tab[0];
                    String dateEntreeS = tab[2];
                    Date dateEntree = sdf.parse(dateEntreeS);
                    int idp = Integer.parseInt(tab[3]);
                    Personnel p = new Personnel(nom, prenom, dateEntree, idp);
                    Entreprise.personnels.put(idp,p);
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.err.println("Fichier incorrect, impossible de charger les employés");
        }
    }
    
    /**
     * méthode de chargement du fichier CSV des compétences des employés de l'entreprise
     * @param fileName Le nom du fichier à charger
     * @throws FileNotFoundException fichier introuvable
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     */
    public static void chargerCompetencePers(String fileName) throws FileNotFoundException, IOException {
        try {
            FileReader fr = new FileReader("data/"+fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); //skip first line
            while(br.ready()) {//tant qu'il y a des lignes à lire
                String line = br.readLine();
                if(!line.equals("")) { 
                    String [] extract = line.split(";");
                    int idEmp = Integer.parseInt(extract[0]);
                    Personnel p = Entreprise.personnels.get(idEmp);
                    for(int i=1; i<extract.length; i++) {
                        p.addCompetencePers(Entreprise.competences.get(extract[i])); // affecter compétences
                    }
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.err.println("Fichier incorrect, impossible de charger les compétences des employés");
        }
    }
    
    /**
     * méthode de chargement du fichier CSV des missions de l'entreprise
     * @param fileName Le nom du fichier à charger
     * @throws FileNotFoundException fichier introuvable
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
     */
    public static void chargerMission(String fileName) throws FileNotFoundException, IOException, ParseException {
        try {
            FileReader fr = new FileReader("data/"+fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); // skip first line
            while(br.ready()) { 
                String line = br.readLine();
                if (!line.equals("")) { // ignore empty lines
                    String [] tab = line.split(";");
                    int idM = Integer.parseInt(tab[0]);
                    Date dateDeb = sdf.parse(tab[1]);
                    int duree = Integer.parseInt(tab[2]);
                    int nbPers = Integer.parseInt(tab[3]);
                    String statut = tab[4];
                    Besoin b = new Besoin(nbPers);
                    Mission m = new Mission(idM, dateDeb, duree, statut, b);
                    Entreprise.missions.put(idM,m);
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.err.println("Fichier incorrect, impossible de charger les missions");
        }
    }
    
    /**
     * méthode de chargement du fichier CSV des besoins pour chaque mission 
     * de l'entreprise
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     */
    public static void chargerBesoinMission(String fileName) throws IOException {
        try {
            FileReader fr = new FileReader("data/"+fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); // vérifier que l'en tete est bon
            while(br.ready()) {
                String line = br.readLine();
                if(!line.equals("")) { // ignore empty lines
                    String [] extract = line.split(";");
                    int idM = Integer.parseInt(extract[0]);
                    String idComp = extract[1];
                    int nbPersComp = Integer.parseInt(extract[2]);
                    Mission m = Entreprise.getMission(idM); // Message d'erreur si la mission n'existe pas
                    Besoin b = m.getBesoins();
                    b.besoinParCompetence(Entreprise.getCompetence(idComp), nbPersComp);
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.err.println("Fichier incorrect, impossible de charger les besoins de la mission");
        }
    }
    
    /**
     * méthode de chargement du fichier CSV d'affectation des employés 
     * aux missions de l'entreprise
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     */
    public static void chargerAffectation(String fileName) throws IOException {
        try {
            FileReader fr = new FileReader("data/"+fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); // vérifier que l'en tete est bon
            while(br.ready()) {
                String line = br.readLine();
                if(!line.equals("")) { // ignore empty lines
                    String [] extract = line.split(";");
                    int idM = Integer.parseInt(extract[0]);
                    String idComp = extract[1];
                    int nbPersComp = Integer.parseInt(extract[2]);
                    Mission m = Entreprise.getMission(idM); // Message d'erreur si la mission n'existe pas
                    for(int i=3; i<extract.length; i++) {
                        int idEmp = Integer.parseInt(extract[i]);
                        Personnel p = Entreprise.getEmploye(idEmp);
                        Competence c = Entreprise.getCompetence(idComp);
                        m.affecterPersonnel(p, c); // message d'erreur si l'employé et la comp n'existe pas
                    }
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e) {
            System.err.println("Fichier incorrect, impossible de charger les affectations des employés");
        }
    }
    
    /**
     * méthode de sauvegarde des fiches employés dans un fichier CSV
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws FormatFichierException si un mauvais format de fichier est spécifié
     */
    public static void sauvegarderPersonnel(String fileName) throws IOException, FormatFichierException {
        if(!fileName.contains(".csv")) {
            throw new FormatFichierException();
        }
        else {
            File f = new File(fileName);
            FileWriter fw;
            if (f.exists()) {
                fw = new FileWriter(f, false);
            }
            else {
                f.createNewFile();
                fw = new FileWriter(f);
            }
            fw.write("prenom;nom;dateEntreeEntreprise;identifiant\n");
            for (int idp : Entreprise.personnels.keySet()) {
                fw.write(Entreprise.personnels.get(idp).formatFic()+"\n");
            }
            fw.close();
        }
    }
    
    /**
     * méthode de sauvegarde des compétences des employés dans un fichier CSV
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws FormatFichierException si un mauvais format de fichier est spécifié
     */
    public static void sauvegarderCompPersonnel(String fileName) throws IOException, FormatFichierException {
        if(!fileName.contains(".csv")) {
            throw new FormatFichierException();
        }
        else {
            File f = new File(fileName);
            FileWriter fw;
            if (f.exists()) {
                fw = new FileWriter(f, false);
            }
            else {
                f.createNewFile();
                fw = new FileWriter(f);
            }
            fw.write("Employe;Liste competence\n");
            for (int idp : Entreprise.personnels.keySet()) {
                fw.write(Entreprise.personnels.get(idp).formatFicComp()+"\n");
            }
            fw.close();
        }
    }
    
    /**
     * méthode de sauvegarde des compétences de 'entreprise dans un fichier CSV
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws FormatFichierException si un mauvais format de fichier est spécifié
     */
    public static void sauvegarderCompetence(String fileName) throws IOException, FormatFichierException {
        if(!fileName.contains(".csv")) {
            throw new FormatFichierException();
        }
        else {
            File f = new File(fileName);
            FileWriter fw;
            if (f.exists()) {
                fw = new FileWriter(f, false);
            }
            else {
                f.createNewFile();
                fw = new FileWriter(f);
            }
            for (String idcomp : Entreprise.competences.keySet()) {
                fw.write(Entreprise.competences.get(idcomp).formatFic()+"\n");
            }
            fw.close();
        }
    }
    
    /**
     * méthode de sauvegarde des missions dans un fichier CSV
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws FormatFichierException si un mauvais format de fichier est spécifié
     */
    public static void sauvegarderMission(String fileName) throws IOException, FormatFichierException {
        if(!fileName.contains(".csv")) {
            throw new FormatFichierException();
        }
        else {
            File f = new File(fileName);
            FileWriter fw;
            if (f.exists()) {
                fw = new FileWriter(f, false);
            }
            else {
                f.createNewFile();
                fw = new FileWriter(f);
            }
            fw.write("idM;dateDeb;duree;nombreEmpNecessaire;statut\n");
            for (int idMission : Entreprise.missions.keySet()) {
                fw.write(Entreprise.missions.get(idMission).formatFic()+"\n");
            }
            fw.close();
        }
    }
    
    /**
     * méthode de sauvegarde du besoin pour chaque mission dans un fichier CSV
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws FormatFichierException si un mauvais format de fichier est spécifié
     */
    public static void sauvegarderBesoinMission(String fileName) throws IOException, FormatFichierException {
        if(!fileName.contains(".csv")) {
            throw new FormatFichierException();
        }
        else {
            File f = new File(fileName);
            FileWriter fw;
            if (f.exists()) {
                fw = new FileWriter(f, false);
            }
            else {
                f.createNewFile();
                fw = new FileWriter(f);
            }
            fw.write("idM;idComp;nbEmpNecessaire\n");
            for (int idMission : Entreprise.missions.keySet()) {
                for (Competence compM : Entreprise.missions.get(idMission).getBesoins().getMapBesoins().keySet()) {
                    fw.write(Entreprise.missions.get(idMission).formatFicBesoin(compM)+"\n");
                }
            }
            fw.close();
        }
    }
    
    /**
     * méthode de sauvegarde des affectations des employés
     * aux missions de l'entreprise dans un fichier CSV
     * @param fileName Le nom du fichier à charger
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws FormatFichierException si un mauvais format de fichier est spécifié
     */
    public static void sauvegarderAffectation(String fileName) throws IOException, FormatFichierException {
        if(!fileName.contains(".csv")) {
            throw new FormatFichierException();
        }
        else {
           File f = new File(fileName);
            FileWriter fw;
            if (f.exists()) {
                fw = new FileWriter(f, false);
            }
            else {
                f.createNewFile();
                fw = new FileWriter(f);
            }
            fw.write("idM;idComp;nbEmpNecessaire;idPers\n");
            for (int idMission : Entreprise.missions.keySet()) {
                for (Competence compM : Entreprise.missions.get(idMission).getBesoins().getMapBesoins().keySet()) {
                    fw.write(Entreprise.missions.get(idMission).formatFicAffect(compM)+"\n");
                }
            }
            fw.close(); 
        }
    }
}
