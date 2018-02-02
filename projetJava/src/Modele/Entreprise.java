/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author heloise
 */
public class Entreprise {
    public static List<Personnel> personnels;
    private static List<Mission> missions;
    
    public Entreprise() {
        this.personnels = new ArrayList<Personnel>();
        this.missions = new ArrayList<Mission>();
    }
    
    public void addPersonnel(Personnel p) {
        this.personnels.add(p);
    }
    
    public void removePersonnel(Personnel p) {
        this.personnels.remove(p);
    }
}
