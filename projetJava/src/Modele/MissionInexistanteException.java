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
public class MissionInexistanteException extends Exception {

    public MissionInexistanteException() {
        this.toString();
    }
    
    public String getMessage() {
        return "Cette mission n'existe pas";
    }
    
}
