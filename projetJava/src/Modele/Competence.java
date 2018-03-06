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
    
    public Competence(String idComp, String libelleEN, String libelleFR) {
        this.idComp = idComp;
        this.libelleFR = libelleFR;
        this.libelleEN = libelleEN;
    }
    
    public String getIdComp() {
        return this.idComp;
    }
    
    public String getCompFR() {
        return this.libelleFR;
    }
    
    public String getCompEN() {
        return this.libelleEN;
    }
    
    public String toString() {
        return this.idComp + " - " + this.libelleFR + " (" + this.libelleEN + ")";
    }
    
    public String formatFic() {
        return this.idComp + ";" + this.libelleEN + ";" + this.libelleFR;
    }
}
