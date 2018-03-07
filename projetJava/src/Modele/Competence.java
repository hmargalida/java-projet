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
    
    /**
     * Constructeur d'un objet Compétence
     * @param idComp l'identifiant de la compétence
     * @param libelleEN le libellé en français de la compétence
     * @param libelleFR le libellé en anglais de la compétence
     */
    public Competence(String idComp, String libelleEN, String libelleFR) {
        this.idComp = idComp;
        this.libelleFR = libelleFR;
        this.libelleEN = libelleEN;
    }
    
    /**
     * méthode retournant l'identifiant de la compétence
     * @return String - l'identifiant
     */
    public String getIdComp() {
        return this.idComp;
    }
    
    /**
     * méthode retournant le libellé en français de la compétence
     * @return String - le libellé en français
     */
    public String getCompFR() {
        return this.libelleFR;
    }
    
    /**
     * méthode retournant le libellé en anglais de la compétence
     * @return String - le libellé en anglais
     */
    public String getCompEN() {
        return this.libelleEN;
    }
    
    /**
     * méthode d'affichage (console) des informations concernant la compétence
     * @return String - une chaine de caractère
     */
    public String toString() {
        return this.idComp + " - " + this.libelleFR + " (" + this.libelleEN + ")";
    }
    
    /**
     * méthode d'affichage dans le fichier CSV lors de l'export
     * @return String - une chaine de caractère formatée
     */
    public String formatFic() {
        return this.idComp + ";" + this.libelleEN + ";" + this.libelleFR;
    }
}
