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
public class EmpAffecteException extends Exception {
    
    /**
     * Constructeur de l'exception EmpAffecteException
     */
    public EmpAffecteException() {
        this.toString();
    }
    
    /**
     * Retourne le message d'erreur
     * @return String message d'erreur
     */
    public String getMessage() {
        return "Cet employé est affecté sur une mission, vous ne pouvez pas le supprimer";
    }
}
