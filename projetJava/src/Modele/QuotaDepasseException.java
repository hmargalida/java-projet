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
public class QuotaDepasseException extends Exception {
    
    /**
     * Constructeur de l'exception QuotaDepasseException
     */
    public QuotaDepasseException() {
        this.toString();
    }   
    
    /**
     * Retourne le message d'erreur
     * @return String message d'erreur
     */
    public String getMessage() {
        return "Le quota pour cette compétence est atteint";
    } 
}
