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
public class Competence {

    private String idComp;
    private String libelleFR;
    private String libelleEN;
    public static List<Competence> competences = new ArrayList<Competence>();
    
    public Competence(String idComp, String libelleFR, String libelleEN) {
        this.idComp = idComp;
        this.libelleFR = libelleFR;
        this.libelleEN = libelleEN;
        competences.add(this);
    }
    
    public void addCompetence(Competence c) {
        if(!competences.contains(c)) {
            competences.add(c);
        }
    }
    
    public String toString() {
        return this.idComp + " - " + this.libelleFR + " (" + this.libelleEN + ")";
    }
}
