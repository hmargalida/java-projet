package Modele;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        Outils.chargerCompetence("liste_competences.csv");
        Outils.chargerPersonnel("liste_personnel.csv");
        Entreprise e = new Entreprise();
        for(Personnel p : Personnel.personnels) {
            System.out.println(p.toString());
        }
    }
}
