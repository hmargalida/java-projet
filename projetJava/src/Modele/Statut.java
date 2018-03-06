/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Color;

/**
 *
 * @author heloise
 */
public enum Statut {
    en_preparation("En préparation",Color.LIGHT_GRAY),
    plannifie("Plannifié",Color.ORANGE),
    en_cours("En cours",Color.CYAN),
    terminee("Terminée", Color.GREEN);
    
    private String name;
    private Color color;
    
    Statut(String name, Color color) {
        this.name = name;
        this.color = color;
    }
    
    public String toString() {
        return name;
    }
    
    public Color getCouleur() {
        return this.color;
    }
}
