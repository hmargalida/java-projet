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
    //public static int countEmp;
    
    /**
    * Constructeur d'un objet Personnel lorsque l'identifiant de l'employé
    * est précisé (lors de l'import de fichier notamment)
    * @param nom Le nom de l'employé
    * @param prenom Le prenom de l'employé
    * @param dateEntree la date d'arrivée dans l'entreprise
    * @param idP l'identifiant/matricule de l'employé
    */
    
    public Personnel(String nom, String prenom, Date dateEntree, int idP) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        this.idPersonnel = idP; 
        this.competencesPers = new HashSet<>();
    }
    
    /**
    * Constructeur d'un objet Personnel 
    * @param nom Le nom de l'employé
    * @param prenom Le prenom de l'employé
    * @param dateEntree la date d'arrivée dans l'entreprise
    */
    public Personnel(String nom, String prenom, Date dateEntree) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEntree = dateEntree;
        int index = 1;
        while (Entreprise.personnels.containsKey(index)) {
            index++;
        }
        this.idPersonnel = index;
        this.competencesPers = new HashSet<>();
    }
    
    /**
    * méthode permettant l'ajout d'une compétence passée en paramètre 
    * @param comp La compétence a ajouter à l'employé
    */
    public void addCompetencePers(Competence comp) {
        if (!competencesPers.contains(comp)) {
            this.competencesPers.add(comp);
        }
        else  {
            System.err.println("L'employé possède déjà cette compétence");
        }
    }
    
    /**
    * méthode permettant la suppression d'une compétence passée en paramètre 
    * @param comp La compétence a enlever à l'employé
    */
    public void removeCompetencePers(Competence comp) {
        if (competencesPers.contains(comp)) {
            this.competencesPers.remove(comp);
        }
        else  {
            System.err.println("L'employé ne possède pas cette compétence");
        }
        
    }
    
    /**
    * méthode retournant l'identifiant de l'employé
    * @return int - l'identifiant de l'employé
    */
    public int getId() {
        return this.idPersonnel;
    }
    
    /**
    * méthode retournant le nom de l'employé
    * @return String - le nom de l'employé
    */
    public String getNom() {
        return this.nom;
    }
    
    /**
    * méthode retournant le prénom de l'employé
    * @return String - le prénom de l'employé
    */
    public String getPrenom() {
        return this.prenom;
    }
    
    /**
    * méthode retournant la date d'arrivée dans l'entreprise de l'employé
    * @return Date - la date d'entrée
    */
    public Date getDateEntree() {
        return this.dateEntree;
    }
    
    /**
    * méthode retournant un set des compétences de l'employé
    * @return Set - les compétences acquises par l'employé
    */
    public Set<Competence> getCompPers() {
        return this.competencesPers;
    }
    
    /**
    * méthode retournant si l'employé possède la compétence passée en paramètre
    * @return boolean - true si l'employé possède déjà la compétence, false sinon
    */
    public boolean aCompetence(Competence c) {
        return this.competencesPers.contains(c);
    }
    
    /**
    * méthode d'affichage de l'employé et de ses compétences
    * @return String - une chaine de caractère composée des informations de l'employé
    */
    public String toString() {
        String msg = this.prenom + " " + this.nom + " (" + this.idPersonnel + "), date d'entree : " + Outils.sdf.format(this.dateEntree) + "\n";
        for (Competence c : this.competencesPers) {
            msg += "\t" + c.toString() + "\n";
        }
        return msg;
    }
    
    /**
    * méthode d'affichage des infos de l'employé dans le fichier d'export
    * @return String - une chaine de caractère formatée pour le fichier CSV d'export
    */
    public String formatFic() {
        return this.prenom + ";" + this.nom + ";" + Outils.sdf.format(this.dateEntree) + ";" + this.idPersonnel;
    }
    
    /**
    * méthode d'affichage des compétences de l'employé dans le fichier d'export
    * @return String - une chaine de caractère formatée pour le fichier CSV d'export
    */
    public String formatFicComp() {
        String msg = ""+this.idPersonnel;
        for(Competence c : this.competencesPers) {
            msg += ";" + c.getIdComp();
        }
        return msg;
    }
}
