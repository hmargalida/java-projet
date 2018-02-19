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
        System.out.println("////// Employés");
        /*for (int p : Entreprise.personnels.keySet()) {
            System.out.println(Entreprise.personnels.get(p));
        }*/
        // création d'une mission
        /*Besoin b = new Besoin(3);
        Besoin b2 = new Besoin(4);
        Mission m1 = new Mission(Outils.sdf.parse("01/02/2018"), 5, b);
        Mission m2 = new Mission(Outils.sdf.parse("20/02/2018"), 2, b2);
        Entreprise.addMission(m1);
        Entreprise.addMission(m2);

        // ajout des besoins en compétence pour la mission 
        b.besoinParCompetence(c1, 1);
        b.besoinParCompetence(c2, 1);
        b.besoinParCompetence(c3, 1);
        b2.besoinParCompetence(c3, 2);
        b2.besoinParCompetence(c1, 2);
        // affectation des employés à la mission en fonction de leurs compétences
        m1.affecterPersonnel(p1, c1);
        m1.affecterPersonnel(p2, c2);
        m1.affecterPersonnel(p2, c3);
        m2.affecterPersonnel(p3, c3);
        m2.affecterPersonnel(p1, c1);
        m2.affecterPersonnel(p2, c1);*/
        //m1.affecterPersonnel(p3, c2); // ERREUR : L'employé n'a pas la compétence
        //m1.affecterPersonnel(p1, c1); // ERREUR : L'employé p1 est déjà assigné à cette compétence 
        //m1.affecterPersonnel(p3, c1); // ERREUR : Le quota pour cette compétence est atteint
        Outils.chargerMission("missionsSauv.csv");
        Outils.chargerBesoinMission("missionsBesoinsSauv.csv");
        Outils.chargerAffectation("affectationsSauv.csv");
        System.out.println("////// Missions");
        for (int m : Entreprise.missions.keySet()) {
            System.out.println(Entreprise.missions.get(m));
        }

        /*System.out.println("/////////// Tests statuts Missions");
        //System.out.println(m1.afficherStatut()); //en_preparation
        //m1.missionEnCours(); // ERREUR : La mission n'est pas correctement plannifiée - pas d'erreur
        
        m1.missionPlannifiee(); 
        //m1.afficherStatut(); // plannifie
        //m1.missionPlannifiee(); //ERREUR :La mission doit être en préparation
         
        Calendar c = Calendar.getInstance();
        c.setTime(Outils.dateAuj);
        //c.add(Calendar.DATE, 1); // ERREUR: La mission n'est pas terminée
        c.add(Calendar.DATE, 50);
        
        Outils.dateAuj = c.getTime();
        //System.out.println("DateAuj: " + Outils.dateAuj);
        //m1.missionEnCours(); //ERREUR : La mission commencera le :Sun Feb 25 00:00:00 CET 2018
        //m1.afficherStatut(); // plannifie
         
       // Outils.dateAuj = Outils.sdf.parse("18/02/2018");
        m1.missionEnCours(); 
       // m1.afficherStatut(); // en cours
        
        m1.missionTermine();
        //m1.afficherStatut(); // terminée*/

        // sauvegarde dans les fichiers
        Outils.sauvegarderPersonnel("persSauv");
        Outils.sauvegarderCompetence("compSauv");
        Outils.sauvegarderCompPersonnel("compPersSauv");
        Outils.sauvegarderMission("missionsSauv");
        Outils.sauvegarderBesoinMission("missionsBesoinsSauv");
        Outils.sauvegarderAffectation("affectationsSauv");
    }
}
