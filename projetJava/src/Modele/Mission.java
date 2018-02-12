/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author heloise
 */
public class Mission {
    
    private int idMission;
    private Date dateDebut;
    private int dureeJ;
    //private int nbPersNecessaire;
    //private Map<Competence, Integer> nbPersComp;
    private Besoin besoins;
    private Map<Competence, ArrayList<Personnel>> affectations;
    private ArrayList<Personnel> persAffect;
    private Statut statut;
    private boolean modifiable;
    
    //public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire) {
    public Mission(int idMission, Date dateDebut, int dureeJ, Besoin b) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        //this.nbPersNecessaire = nbPersNecessaire;
        //this.nbPersComp = new HashMap<>();
        this.besoins = b;
        this.affectations = new HashMap<>();
        this.persAffect = new ArrayList<>();
        this.statut = Statut.en_preparation;
        this.modifiable = true;
    }
    
    //public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire, String statut) {
    public Mission(int idMission, Date dateDebut, int dureeJ, String statut, Besoin b) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        //this.nbPersNecessaire = nbPersNecessaire;
        //this.nbPersComp = new HashMap<>();
        this.besoins = b;
        this.affectations = new HashMap<>();
        this.persAffect = new ArrayList<>();
        this.statut = Statut.valueOf(statut);
        this.modifiable = true;
    }
    
    /*public void besoinParCompetence(Competence c, int nbPers) {
        int nbAct=0;
        for(Competence comp : this.nbPersComp.keySet()) {
            nbAct += this.nbPersComp.get(comp);
        }
        if((nbPers+nbAct)<=nbPersNecessaire || nbAct==0) {
            this.nbPersComp.put(c, nbPers);
        }
        else {
            System.err.println("Le nombre de personnel pour cette compétence dépasse le besoin total");
        }
    }*/
    
    public void affecterPersonnel(Personnel p, Competence c) {
        int nbPersAct=0;
        boolean inscrit = false; // Vérifie si l'employé est déjà inscrit sur cette compétence
        int nbPersVoulu = this.besoins.getNbPersComp().get(c);
        if (this.affectations.get(c) != null) {
            nbPersAct = this.affectations.get(c).size();
            inscrit = this.affectations.get(c).contains(p);
        }
        if(p.aCompetence(c)) {
            if (nbPersAct<nbPersVoulu) {
                if (!inscrit) {
                    ArrayList<Personnel> persM = this.affectations.get(c);
                    if(persM==null) {
                        persM = new ArrayList<>();
                    }
                    persM.add(p);
                    this.affectations.put(c, persM);
                }
                else {
                    System.err.println("L'employé est déjà assigné à cette compétence");
                }
            }
            else {
                System.err.println("Le quota pour cette compétence est atteint");
            }
        }
        else {
            System.err.println("L'employe " + p.getId() + " ne possède pas cette compétence");
        }
    }
    
    public void changerStatutPlannifiee(){
    }
    
    public int getIdM() {
        return this.idMission;
    }
    
    public String toString(){
        String msg = "Mission " + this.idMission + ", date de debut : " + this.dateDebut + " (" + this.dureeJ + " jours) Nb d'employé nécessaires : " + besoins.getNbPersNecessaire() + " - " + this.statut;
        for(Competence comp : besoins.getNbPersComp().keySet()) {
            msg += "\n\t compétence n°" + comp.getIdComp() + " (" + besoins.getNbPersComp().get(comp) + " employés) - ";
            if (this.affectations.get(comp) != null) {
                for (Personnel p : this.affectations.get(comp)) {
                    msg += p.getId() + ", ";
                }
            }
        }
        return msg;
    }
    
    public String formatFic() {
        return this.idMission+ ";" + Outils.sdf.format(this.dateDebut) + ";" + this.dureeJ + ";" + besoins.getNbPersNecessaire() + ";" + this.statut;
    }
}
