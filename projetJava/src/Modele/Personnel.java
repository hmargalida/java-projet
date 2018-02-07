/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author heloise
 */
public class Personnel {
    
    private int idPersonnel;
    private String nom;
    private String prenom;
    private Date dateEntree;
    private Set<Competence> competencesPers;
    
    public Personnel(String nom, String prenom, Date dateEntree, int idP) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.idPersonnel = idP; // incrémentation automatique ? Surcharge de constructeur ?
        this.competencesPers = new HashSet<>();
    }
    
    public void addCompetencePers(Competence comp) {
        if (!competencesPers.contains(comp)) {
            this.competencesPers.add(comp);
        }
        else  {
            System.err.println("L'employé possède déjà cette compétence");
        }
    }
    
    public void removeCompetencePers(Competence comp) {
        if (competencesPers.contains(comp)) {
            this.competencesPers.remove(comp);
        }
        else  {
            System.err.println("L'employé ne possède pas cette compétence");
        }
        
    }
    
    public int getId() {
        return this.idPersonnel;
    }
    
    public String toString() {
        String msg = this.prenom + " " + this.nom + " (" + this.idPersonnel + "), date d'entree : " + this.dateEntree + "\n";
        for (Competence c : this.competencesPers) {
            msg += "\t" + c.toString() + "\n";
        }
        return msg;
    }
    
    public String formatFic() {
        return this.prenom + ";" + this.nom + ";" + Outils.sdf.format(this.dateEntree) + ";" + this.idPersonnel;
    }
    
    public String formatFicComp() {
        String msg = ""+this.idPersonnel;
        for(Competence c : this.competencesPers) {
            msg += ";" + c.getIdComp();
        }
        return msg;
    }
}
