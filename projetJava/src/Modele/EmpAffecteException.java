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
    // en cours et plannifié
    public EmpAffecteException() {
        this.toString();
    }
    
    public String getMessage() {
        return "Cet employé est affecté sur une mission, vous ne pouvez pas le supprimer";
    }
}
