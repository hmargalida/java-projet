/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heloise
 */
public class Entreprise {
    public static List<Personnel> personnels = new ArrayList<Personnel>();
    public static List<Mission> missions = new ArrayList<Mission>();
    public static List<Competence> competences = new ArrayList<Competence>();
    
    public static void addPersonnel(Personnel p) {
        if (!personnels.contains(p)) {
            Entreprise.personnels.add(p);
        }
        else {
            System.err.println("L'employé fait déjà partie de l'entreprise");
        }
    }
    
    public static void removePersonnel(Personnel p) {
        if (personnels.contains(p)) {
            Entreprise.personnels.remove(p);
        }
        else {
            System.err.println("Cet employé ne fait pas partie de l'entreprise");
        }
    }
    
    public static void addCompetence(Competence c) {
        if(!competences.contains(c)) {
            competences.add(c);
        }
    }
}
