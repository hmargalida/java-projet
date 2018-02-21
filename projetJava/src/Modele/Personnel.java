/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;
import java.util.HashSet;
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
    private static int countEmp;
    
    public Personnel(String nom, String prenom, Date dateEntree, int idP) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.idPersonnel = idP; 
        Personnel.countEmp++;
        this.competencesPers = new HashSet<>();
    }
    
    public Personnel(String nom, String prenom, Date dateEntree) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.idPersonnel = ++Personnel.countEmp;
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
    
    public String getNomPrenom() {
        return this.nom + " " + this.prenom;
    }
    
    public boolean aCompetence(Competence c) {
        return this.competencesPers.contains(c);
    }
    
    public String toString() {
        String msg = this.prenom + " " + this.nom + " (" + this.idPersonnel + "), date d'entree : " + Outils.sdf.format(this.dateEntree) + "\n";
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
