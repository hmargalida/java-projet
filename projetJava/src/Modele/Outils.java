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
    
    /**
     *
     */
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Date dateAuj = new Date();
    
    public static void chargerCompetence(String fileName) throws FileNotFoundException {
        File fic = new File("data/"+fileName);
        Scanner scan = new Scanner(fic);
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] tab = line.split(";");
            Competence comp = new Competence(tab[0], tab[1], tab[2]);
            Entreprise.addCompetence(comp);
        }
    }
    
    public static void chargerPersonnel(String fileName) throws IOException, ParseException {
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
    
    public static void chargerCompetencePers(String fileName) throws FileNotFoundException, IOException {
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
    }
    
    public static void chargerMission(String fileName) {
        
    }
    
    public static void sauvegarderPersonnel(String fileName) throws IOException {
        File f = new File("./data/"+fileName+".csv");
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
    
    public static void sauvegarderCompPersonnel(String fileName) throws IOException {
        File f = new File("./data/"+fileName+".csv");
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
    
    public static void sauvegarderCompetence(String fileName) throws IOException {
        File f = new File("./data/"+fileName+".csv");
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
    
    public static void sauvegarderMission(String fileName) {
        
    }
}
