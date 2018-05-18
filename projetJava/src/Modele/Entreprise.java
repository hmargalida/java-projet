/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author heloise
 */
public class Entreprise {
    public static TreeMap<Integer,Personnel> personnels = new TreeMap<Integer,Personnel>();
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
            System.err.println("L'employé " + p.getId() + " fait déjà partie de l'entreprise");
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
     * permet de désaffecter un employé de toutes ses missions
     * @param idp identifiant de l'employé
     */
    public static void desaffecterTouteMission(int idp) {
        Personnel p = Entreprise.getEmploye(idp);
        // pour toutes les missions 
        for (int idm : missions.keySet()) {
            Mission m = Entreprise.getMission(idm);
            // pour toutes les compétences nécessaires à la mission 
            for (Competence c : m.getAffectations().keySet()) {
                ArrayList<Personnel> listeEmp = Entreprise.getMission(idm).getAffectations().get(c);
                if (listeEmp.contains(p)) {
                    m.desaffecterEmploye(p, c);
                }
            }
        }
    }
    
    /**
     * méthode enlevant un employé de la "bd" de l'entreprise
     * @param idp le personnel à supprimer
     * @throws EmpInexistantException si l'employé est introuvable
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
     * @throws MissionInexistanteException si la mission est introuvable
     */
    public static void removeMission(int idm) throws MissionInexistanteException {
        if (missions.containsKey(idm)) {
            Entreprise.missions.remove(idm);
        }
        else {
            throw new MissionInexistanteException();
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
