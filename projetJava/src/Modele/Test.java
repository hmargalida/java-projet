package Modele;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        Personnel p1 = new Personnel("MacFly", "Marty", Outils.sdf.parse("25/01/2018"));
        Competence c1 = new Competence("1", "Test EN", "Test FR");
        Competence c2 = new Competence("2", "Test EN", "Test 2");
        Competence c3 = new Competence("3", "Test EN", "Test 3");
        Entreprise.addCompetence(c1);
        Entreprise.addCompetence(c2);
        p1.addCompetencePers(c1);
        Entreprise.addPersonnel(p1);
        for (int p : Entreprise.personnels.keySet()) {
            //System.out.println(Entreprise.personnels.get(p));
        }
        // Création mission
        Mission m1 = new Mission(2, Outils.sdf.parse("10/02/2018"), 5, 5);
        Entreprise.addMission(m1);
        m1.besoinParCompetence(c1, 2);
        m1.besoinParCompetence(c2, 2);
        m1.besoinParCompetence(c3, 1);
        m1.affecterPersonnel(p1, c1);
        for (int m : Entreprise.missions.keySet()) {
            System.out.println(Entreprise.missions.get(m));
        }
        Outils.sauvegarderPersonnel("persSauv");
        Outils.sauvegarderCompetence("compSauv");
        Outils.sauvegarderCompPersonnel("compPersSauv");
        Outils.sauvegarderMission("missionsSauv");
    }
}
