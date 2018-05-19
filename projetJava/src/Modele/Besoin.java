/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author heloise
 */
public class Besoin {
    
    private int nbPersNecessaire;
    private Map<Competence, Integer> nbPersComp;
    
    /**
     * Constructeur d'un Besoin
     * @param nbPersNecessaire nb de personne nécessaire sur la mission
     */
    public Besoin(int nbPersNecessaire) {
        this.nbPersNecessaire = nbPersNecessaire;
        nbPersComp = new HashMap<>();
    }
    
    /**
     * Ajout d'une compétence au besoin de la mission et du nombre d'employés nécessaire 
     * @param c Compétence
     * @param nbPers Nombre d'employé nécessaire pour cette compétence
     * @throws NbEmployeDepasseException si le quotat pour cette compétence est dépassé
     */
    public void besoinParCompetence(Competence c, int nbPers) throws NbEmployeDepasseException {
        int nbAct=0;
        for(Competence comp : this.nbPersComp.keySet()) {
            nbAct += this.nbPersComp.get(comp);
        }
        if((nbPers+nbAct)<=nbPersNecessaire) {
            this.nbPersComp.put(c, nbPers);
        }
        else {
            throw new NbEmployeDepasseException();
        }
    }
    
    /**
     * Retourne le nombre d'employé demandé pour cette compétence 
     * @param c Compétence
     * @return int Nombre d'employé 
     */
    public int getNbPersComp(Competence c) {
        return this.nbPersComp.get(c);
    }
    
    /**
     * Retourne le nombre d'employé total pour la mission
     * @return int Nombre d'employé total
     */
    public int getNbPersNecessaire() {
        return this.nbPersNecessaire;
    }
    
    /**
     * setteur du nombre d'employé pour la mission 
     * @param nbPers Nombre d'employé total
     */
    public void setNbPersNecessaire(int nbPers) {
        this.nbPersNecessaire = nbPers;
    }
    
    /**
     * Retourne la map contenant pour chaque compétence, le nombre d'employé a affecter 
     * @return Map Map des besoins
     */
    public Map<Competence, Integer> getMapBesoins() {
        return this.nbPersComp;
    }
}
