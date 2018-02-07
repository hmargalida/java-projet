package Modele;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        }
        catch (FileNotFoundException eF) {
            System.err.println("ERREUR - Le fichier est introuvable");
        }
        catch (IOException eIO) {
            System.err.println("ERREUR I/O");
        } catch (ParseException ex) {
            System.err.println("ERREUR - Format de date incorrecte");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Personnel p1 = new Personnel("MacFly", "Marty", sdf.parse("25/01/2018"), 1);
        Competence c1 = new Competence("1", "Test FR", "Test EN");
        Entreprise.addCompetence(c1);
        p1.addCompetencePers(c1);
        Entreprise.addPersonnel(p1);
        for (int p : Entreprise.personnels.keySet()) {
            System.out.println(Entreprise.personnels.get(p));
        }
        System.out.println(Outils.dateAuj);
        Outils.sauvegarderPersonnel("persSauv");
        Outils.sauvegarderCompetence("compSauv");
    }
}
