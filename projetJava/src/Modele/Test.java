package Modele;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            Outils.chargerCompetence("liste_competences.csv");
            Outils.chargerPersonnel("liste_personnel.csv");
        }
        catch (FileNotFoundException eF) {
            System.err.println("ERREUR - Le fichier est introuvable");
        }
        catch (IOException eIO) {
            System.err.println("ERREUR I/O");
        }
        Personnel p1 = new Personnel("MacFly", "Marty", "25/01/2018", 1);
        Competence c1 = new Competence("1", "Test FR", "Test EN");
        Entreprise.addCompetence(c1);
        p1.addCompetencePers(c1);
        Entreprise.personnels.add(p1);
        Outils.sauvegarderPersonnel("persSauv");
        Outils.sauvegarderCompetence("compSauv");
    }
}
