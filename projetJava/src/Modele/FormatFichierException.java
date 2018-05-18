/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author heloise
 */
public class FormatFichierException extends Exception {

    /**
     * Constructeur de l'exception FormatFichierException
     */
    public FormatFichierException() {
        this.toString();
    }
    
    /**
     * Retourne le message d'erreur
     * @return String message d'erreur
     */
    public String getMessage() {
        return "Le format du fichier doit être un fichier CSV";
    }
}
