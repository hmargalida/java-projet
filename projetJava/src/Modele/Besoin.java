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
    
    public Besoin(int nbPersNecessaire) {
        this.nbPersNecessaire = nbPersNecessaire;
        nbPersComp = new HashMap<>();
    }
    
    public void besoinParCompetence(Competence c, int nbPers) {
        int nbAct=0;
        for(Competence comp : this.nbPersComp.keySet()) {
            nbAct += this.nbPersComp.get(comp);
        }
        if((nbPers+nbAct)<=nbPersNecessaire || nbAct==0) {
            this.nbPersComp.put(c, nbPers);
        }
        else {
            System.err.println("Le nombre de personnel pour cette compétence dépasse le besoin total");
        }
    }
    
    public Map<Competence, Integer> getNbPersComp() {
        return this.nbPersComp;
    }
    
    public int getNbPersNecessaire() {
        return this.nbPersNecessaire;
    }
}