/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author heloise
 */
public class Mission {
    
    private String idMission;
    private int nbPersNecessaire;
    private Map<String, Integer> nbPersComp; // idComp, nbPers
    private Date dateDebut;
    private int dureeJ;
    private List<Personnel> personnels;
    private List<Personnel> personnelsRec;
    private Statut statut;
    
    public Mission(String idMission, Date dateDebut, int dureeJ, int nbPersNecessaire) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.nbPersNecessaire = nbPersNecessaire;
        this.statut = Statut.en_preparation;
        nbPersComp = new HashMap<>();
    }
    
    public void competencesReq(String idComp, int nbPersComp) {
        this.nbPersComp.put(idComp, nbPersComp);
    }
    
    public void affecterPersonnel(Personnel p, Competence c) {
        // il faudrait préciser pour quelle compétence on affecte le personnel à la mission
        // peut être une map affectation ? Map<idComp, List<Personnel>> 
        // Vérifier que le personnel p possede la competence c
        // vérifier que le besoin n'est pas encore rempli dans la competence c
    }
}
