package Modele;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

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
        // Liste des employés AVANT ajout 
        System.out.println("////// Employés AVANT ajout");
        for (int p : Entreprise.personnels.keySet()) {
            System.out.println(Entreprise.personnels.get(p));
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
        Entreprise.addCompetence(c3);
        
        p1.addCompetencePers(c1);
        p2.addCompetencePers(c3);
        p2.addCompetencePers(c2);
        p2.addCompetencePers(c1);
        p3.addCompetencePers(c1);
        p3.addCompetencePers(c3);
        
        Entreprise.addPersonnel(p1);
        Entreprise.addPersonnel(p2);
        Entreprise.addPersonnel(p3);
        Entreprise.removePersonnel(50);
        
        // Liste des employés après ajout
        System.out.println("////// Employés APRES ajout et suppression d'un employé");
        for (int p : Entreprise.personnels.keySet()) {
            System.out.println(Entreprise.personnels.get(p));
        }
        
        // Liste des missions avant ajout
        System.out.println("////// Missions AVANT ajout");
        for (int m : Entreprise.missions.keySet()) {
            System.out.println(Entreprise.missions.get(m));
        }
        
        // sauvegarde des missions dans des fichiers 
        Outils.chargerMission("missionsSauv.csv");
        Outils.chargerBesoinMission("missionsBesoinsSauv.csv");
        Outils.chargerAffectation("affectationsSauv.csv");
        
        //création d'une mission
        Besoin b = new Besoin(4);
        Mission m5 = new Mission(Outils.sdf.parse("01/02/2018"), 5, b);
        Entreprise.addMission(m5);

        // ajout des besoins en compétence pour la mission 
        b.besoinParCompetence(c1, 1);
        b.besoinParCompetence(c2, 1);
        b.besoinParCompetence(c3, 2);
        // affectation des employés à la mission en fonction de leurs compétences
        m5.affecterPersonnel(p1, c1);
        m5.affecterPersonnel(p2, c2);
        m5.affecterPersonnel(p2, c3);
        m5.affecterPersonnel(p3, c3);
        m5.affecterPersonnel(p3, c2); // ERREUR : L'employé n'a pas la compétence
        m5.affecterPersonnel(p1, c1); // ERREUR : L'employé p1 est déjà assigné à cette compétence 
        m5.affecterPersonnel(p3, c1); // ERREUR : Le quota pour cette compétence est atteint
        
        System.out.println("////// Missions APRES ajout");
        for (int m : Entreprise.missions.keySet()) {
            System.out.println(Entreprise.missions.get(m));
        }

        System.out.println("////// Tests statuts Missions");
        System.out.println(Entreprise.missions.get(m5.getIdM()));
        System.out.println(m5.getStatut()); //en_preparation
        //m5.missionEnCours(); // ERREUR : La mission n'est pas correctement plannifiée - pas d'erreur
        
        m5.missionPlannifiee(); 
        System.out.println(m5.getStatut()); // plannifie
        //m1.missionPlannifiee(); //ERREUR :La mission doit être en préparation
         
        Calendar c = Calendar.getInstance();
        c.setTime(Outils.dateAuj);
        System.out.println("DateAuj: " + Outils.dateAuj);
        //c.add(Calendar.DATE, 1); // ERREUR: La mission n'est pas terminée
        c.add(Calendar.DATE, 20);
        
        Outils.dateAuj = c.getTime();
        System.out.println("Avancé de 20 jours : dateAuj: " + Outils.dateAuj);
        //m1.missionEnCours(); //ERREUR : La mission commencera le :Sun Feb 25 00:00:00 CET 2018
        //m1.afficherStatut(); // plannifie
        
        m5.missionEnCours(); 
        System.out.println(m5.getStatut()); // en cours
        
        m5.missionTermine();
        System.out.println(m5.getStatut()); // terminée*/
        
        Vue.Accueil accueil = new Vue.Accueil();
        accueil.setVisible(true);
        
        // sauvegarde dans les fichiers
        /*Outils.sauvegarderPersonnel("persTest.csv");
        Outils.sauvegarderCompetence("compSauv");
        Outils.sauvegarderCompPersonnel("compPersSauv");
        Outils.sauvegarderMission("missionsSauv");
        Outils.sauvegarderBesoinMission("missionsBesoinsSauv");
        Outils.sauvegarderAffectation("affectationsSauv");*/
    }
}
