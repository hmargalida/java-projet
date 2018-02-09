/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author heloise
 */
public class Entreprise {
    public static Map<Integer,Personnel> personnels = new HashMap<Integer,Personnel>();
    public static Map<Integer,Mission> missions = new HashMap<Integer,Mission>();
    public static Map<String,Competence> competences = new HashMap<String,Competence>();
    
    public static void addPersonnel(Personnel p) {
        if (!personnels.containsKey(p.getId())) {
            Entreprise.personnels.put(p.getId(),p);
        }
        else {
            System.err.println("L'employé fait déjà partie de l'entreprise");
        }
    }
    
    public static void addCompetence(Competence c) {
        if(!competences.containsValue(c)) {
            competences.put(c.getIdComp(),c);
        }
        else {
            System.err.println("Cette compétence est déjà dans la liste");
        }
    }
    
    public static void addMission(Mission m) {
        if(!missions.containsKey(m.getIdM())) {
            missions.put(m.getIdM(), m);
        }
        else {
            System.err.println("Cette mission est déjà dans la liste");
        }
    }
    
    public static void removePersonnel(Personnel p) {
        if (personnels.containsValue(p)) {
            Entreprise.personnels.remove(p.getId());
        }
        else {
            System.err.println("Cet employé ne fait pas partie de l'entreprise");
        }
    }
    
    public static Personnel getEmploye(int idEmp) {
        return personnels.get(idEmp);
    }
}
