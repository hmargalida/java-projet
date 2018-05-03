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
    
    public QuotaDepasseException() {
        this.toString();
    }   
    
    public String getMessage() {
        return "Le quota pour cette compétence est atteint";
    } 
}
