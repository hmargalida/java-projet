/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author heloise
 */
public class Entreprise {
    public static List<Personnel> personnels = new ArrayList<Personnel>();
    private static List<Mission> missions = new ArrayList<Mission>();
    public static List<Competence> competences = new ArrayList<Competence>();
    
    public static void addPersonnel(Personnel p) {
        Entreprise.personnels.add(p);
    }
    
    public static void removePersonnel(Personnel p) {
        Entreprise.personnels.remove(p);
    }
    
    public static void addCompetence(Competence c) {
        if(!competences.contains(c)) {
            competences.add(c);
        }
    }
}
