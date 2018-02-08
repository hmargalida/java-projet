/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author heloise
 */
public class Mission {
    
    private int idMission;
    private int nbPersNecessaire;
    private Map<Competence, Integer> nbPersComp;
    private Date dateDebut;
    private int dureeJ;
    private List<Personnel> personnels;
    private List<Personnel> personnelsRec;
    private Statut statut;
    private boolean modifiable;
    
    public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.nbPersNecessaire = nbPersNecessaire;
        this.statut = Statut.en_preparation;
        this.modifiable = true;
    }
    
    public String toString(){
        String chaine;
        chaine = "ID mission: " + this.idMission + ". debut mission: " + this.dateDebut + ". durée: " + this.dureeJ + " jours. Nombre de personnes nécessaires: " + this.nbPersNecessaire +". Statut: " + this.statut;
        return chaine;
    }
    
    public String formatFic() {
        return this.idMission+ ";" + this.dateDebut + ";" + this.dureeJ + ";" + this.nbPersNecessaire + ";" + this.statut;
    }
    
    public void changerStatutPlannifiee(){
    
    }
    
    public void affecterPersonnel(Personnel p) {
        
    }
}
