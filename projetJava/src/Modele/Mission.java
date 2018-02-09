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
    private int nbPersNecessaire;
    private Map<Competence, Integer> nbPersComp;
    private Map<Competence, ArrayList<Personnel>> affectations;
    private ArrayList<Personnel> persAffect;
    private Statut statut;
    private boolean modifiable;
    
    public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.nbPersNecessaire = nbPersNecessaire;
        this.nbPersComp = new HashMap<>();
        this.affectations = new HashMap<>();
        this.persAffect = new ArrayList<>();
        this.statut = Statut.en_preparation;
        this.modifiable = true;
    }
    
    public Mission(int idMission, Date dateDebut, int dureeJ, int nbPersNecessaire, String statut) {
        this.idMission = idMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.nbPersNecessaire = nbPersNecessaire;
        this.nbPersComp = new HashMap<>();
        this.affectations = new HashMap<>();
        this.persAffect = new ArrayList<>();
        this.statut = Statut.valueOf(statut);
        this.modifiable = true;
    }
    
    public void besoinParCompetence(Competence c, int nbPers) {
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
    }
    
    public void affecterPersonnel(Personnel p, Competence c) {
        int nbPersAct=0;
        int nbPersVoulu = this.nbPersComp.get(c);
        if (this.affectations.get(c) != null) {
            nbPersAct = this.affectations.get(c).size();
        }
        System.out.println("act " +nbPersAct);
        System.out.println("voulu " +nbPersVoulu);
        if(p.aCompetence(c)) {
            if (nbPersAct<nbPersVoulu) {
                ArrayList<Personnel> persM = this.affectations.get(c);
                if(persM==null) {
                    persM = new ArrayList<>();
                }
                persM.add(p);
                this.affectations.put(c, persM);
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
        String msg = "Mission " + this.idMission + ", date de debut : " + this.dateDebut + " (" + this.dureeJ + " jours) Nb d'employé nécessaires : " + this.nbPersNecessaire + " - " + this.statut;
        for(Competence comp : this.nbPersComp.keySet()) {
            msg += "\n\t compétence n°" + comp.getIdComp() + " (" + this.nbPersComp.get(comp) + " employés) - ";
            if (this.affectations.get(comp) != null) {
                for (Personnel p : this.affectations.get(comp)) {
                    msg += p.getId() + ", ";
                }
            }
        }
        return msg;
    }
    
    public String formatFic() {
        return this.idMission+ ";" + Outils.sdf.format(this.dateDebut) + ";" + this.dureeJ + ";" + this.nbPersNecessaire + ";" + this.statut;
    }
}
