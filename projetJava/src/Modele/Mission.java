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
    private Statut status;
    
    public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.nbPersNecessaire = nbPersNecessaire;
    }
}
