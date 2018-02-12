package Modele;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heloise
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        // chargement des fichiers Employés, Missions et Compétences
        try {
            Outils.chargerCompetence("liste_competences.csv");
            Outils.chargerPersonnel("liste_personnel.csv");
            Outils.chargerCompetencePers("competences_personnel.csv");
            Outils.chargerMission("missions.csv");
        }
        catch (FileNotFoundException eF) {
            System.err.println("ERREUR - Le fichier est introuvable");
        }
        catch (IOException eIO) {
            System.err.println("ERREUR I/O");
        } catch (ParseException ex) {
            System.err.println("ERREUR - Format de date incorrecte");
        }
        // creation d'employés
        Personnel p1 = new Personnel("MacFly", "Marty", Outils.sdf.parse("25/01/2018"));
        Personnel p2 = new Personnel("Marga", "Helo", Outils.sdf.parse("25/01/2018"));
        Personnel p3 = new Personnel("Jean", "Dupont", Outils.sdf.parse("25/01/2018"));
        // creation de compétences
        Competence c1 = new Competence("1", "Test EN", "Test FR");
        Competence c2 = new Competence("2", "Test EN", "Test 2");
        Competence c3 = new Competence("3", "Test EN", "Test 3");
        Entreprise.addCompetence(c1);
        Entreprise.addCompetence(c2);
        p1.addCompetencePers(c1);
        p2.addCompetencePers(c3);
        p2.addCompetencePers(c1);
        p3.addCompetencePers(c1);
        Entreprise.addPersonnel(p1);
        Entreprise.addPersonnel(p2);
        Entreprise.addPersonnel(p3);
        System.out.println("////// Employés");
        for (int p : Entreprise.personnels.keySet()) {
            System.out.println(Entreprise.personnels.get(p));
        }
        // création d'une mission
        Mission m1 = new Mission(2, Outils.sdf.parse("10/02/2018"), 5, 5);
        Entreprise.addMission(m1);
        // ajout des besoins en compétence pour la mission 
        m1.besoinParCompetence(c1, 2);
        m1.besoinParCompetence(c2, 2);
        m1.besoinParCompetence(c3, 1);
        // affectation des employés à la mission en fonction de leurs compétences
        m1.affecterPersonnel(p1, c1);
        m1.affecterPersonnel(p2, c3);
        m1.affecterPersonnel(p2, c1);
        //m1.affecterPersonnel(p1, c1); // ERREUR : L'employé p1 est déjà assigné à cette compétence 
        //m1.affecterPersonnel(p3, c1); // ERREUR : Le quota pour cette compétence est atteint
        System.out.println("////// Missions");
        for (int m : Entreprise.missions.keySet()) {
            System.out.println(Entreprise.missions.get(m));
        }
        // sauvegarde dans les fichiers
        Outils.sauvegarderPersonnel("persSauv");
        Outils.sauvegarderCompetence("compSauv");
        Outils.sauvegarderCompPersonnel("compPersSauv");
        Outils.sauvegarderMission("missionsSauv");
    }
}
