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
    
    public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire, String statut) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.nbPersNecessaire = nbPersNecessaire;
        this.statut = Statut.valueOf(statut);
        this.modifiable = true;
    }
    
    public int getIdM() {
        return this.idMission;
    }
    
    public String toString(){
        return "Mission " + this.idMission + ", date de debut : " + this.dateDebut + " (" + this.dureeJ + " jours) Nb d'employé nécessaires: " + this.nbPersNecessaire + " - " + this.statut;
    }
    
    public String formatFic() {
        return this.idMission+ ";" + Outils.sdf.format(this.dateDebut) + ";" + this.dureeJ + ";" + this.nbPersNecessaire + ";" + this.statut;
    }
    
    public void changerStatutPlannifiee(){
    
    }
    
    public void affecterPersonnel(Personnel p) {
        // il faudrait préciser pour quelle compétence on affecte le personnel à la mission
        // peut être une map affectation ? Map<idComp, List<Personnel>> 
        // Vérifier que le personnel p possede la competence c
        // vérifier que le besoin n'est pas encore rempli dans la competence c
    }
}
