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
    en_preparation("En préparation", "en_preparation", Color.LIGHT_GRAY),
    plannifie("Plannifié", "plannifie", Color.ORANGE),
    en_cours("En cours", "en_cours", Color.CYAN),
    terminee("Terminée", "terminee", Color.GREEN);
    
    private String name;
    private String normName;
    private Color color;
    
    /**
     * Constructeur du Statut
     */
    Statut(String name, String normName, Color color) {
        this.name = name;
        this.normName = normName;
        this.color = color;
    }
    
    /**
     * Retourne le libellé du statut
     * @return String libellé du statut
     */
    public String toString() {
        return name;
    }
    
    /**
     * Retourne la couleur associée au statut
     * @return Color couleur
     */
    public Color getCouleur() {
        return this.color;
    }
    
    /**
     * Retourne le libellé normalisé du statut
     * @return String
     */
    public String getNormName() {
        return this.normName;
    }
}
