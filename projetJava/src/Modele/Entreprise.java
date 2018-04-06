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
    
    /**
     * méthode ajoutant un employé à la "bd" de l'entreprise 
     * @param p le personnel ajouté
     */
    public static void addPersonnel(Personnel p) {
        if (!personnels.containsKey(p.getId())) {
            Entreprise.personnels.put(p.getId(),p);
        }
        else {
            System.err.println("L'employé fait déjà partie de l'entreprise");
        }
    }
    
    /**
     * méthode ajoutant une compétence à la "bd" de l'entreprise
     * @param c la compétence ajoutée
     */
    public static void addCompetence(Competence c) {
        if(!competences.containsValue(c)) {
            competences.put(c.getIdComp(),c);
        }
        else {
            System.err.println("Cette compétence est déjà dans la liste");
        }
    }
    
    /**
     * méthode ajoutant une mission à la "bd" de l'entreprise
     * @param m la mission ajoutée
     */
    public static void addMission(Mission m) {
        if(!missions.containsKey(m.getIdM())) {
            missions.put(m.getIdM(), m);
        }
        else {
            System.err.println("Cette mission est déjà dans la liste");
        }
    }
    
    /**
     * méthode enlevant un employé de la "bd" de l'entreprise
     * @param idp le personnel à supprimer
     * @throws Modele.EmpInexistantException
     */
    public static void removePersonnel(int idp) throws EmpInexistantException {
        if (personnels.containsKey(idp)) {
            Entreprise.personnels.remove(idp);
        }
        else {
            throw new EmpInexistantException();
        }
    }
    
    /**
     * méthode enlevant une mission de la "bd" de l'entreprise
     * @param idm la mission à supprimer
     */
    public static void removeMission(int idm) {
        if (missions.containsKey(idm)) {
            Entreprise.personnels.remove(idm);
        }
        else {
            System.err.println("Cette mission n'existe pas");
        }
    }
    
    /**
     * méthode retournant un employé de l'entreprise
     * @param idEmp l'identifiant de l'employé recherché
     * @return Personnel 
     */
    public static Personnel getEmploye(int idEmp) {
        return personnels.get(idEmp);
    }
    
    /**
     * méthode retournant une mission de l'entreprise
     * @param idM l'identifiant de la mission recherchée
     * @return Mission
     */
    public static Mission getMission(int idM) {
        return missions.get(idM);
    }
    
    /**
     * méthode retournant une compétence de l'entreprise
     * @param idC l'identifiant de la compétence
     * @return Competence
     */
    public static Competence getCompetence(String idC) {
        return competences.get(idC);
    }
}
