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
                Outils.chargerMission("liste_missions.csv");
                Outils.chargerBesoinMission("liste_besoins.csv");
                Outils.chargerAffectation("liste_affectations.csv");
                
            }
            catch (FileNotFoundException eF) {
                System.err.println("ERREUR - Le fichier est introuvable");
            }
            catch (IOException eIO) {
                System.err.println("ERREUR I/O");
            } catch (ParseException ex) {
                System.err.println("ERREUR - Format de date incorrecte");
            }
            Vue.Accueil accueil = new Vue.Accueil();
            accueil.setVisible(true);
    }
}
