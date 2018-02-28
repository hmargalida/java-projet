/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Calendar;
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
    private static int countMission;
    private Date dateDebut;
    private int dureeJ;
    private Besoin besoins;
    private Map<Competence, ArrayList<Personnel>> affectations;
    private ArrayList<Personnel> persAffect;
    private Statut statut;
    private boolean modifiable;
    
    public Mission(Date dateDebut, int dureeJ, Besoin b) {
        this.idMission = ++Mission.countMission;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.besoins = b;
        this.affectations = new HashMap<>();
        this.persAffect = new ArrayList<>();
        this.statut = Statut.en_preparation;
        this.modifiable = true;
    }
    
    public Mission(int idMission, Date dateDebut, int dureeJ, String statut, Besoin b) {
        this.idMission = idMission;
        Mission.countMission++;
        this.dateDebut = dateDebut;
        this.dureeJ = dureeJ;
        this.besoins = b;
        this.affectations = new HashMap<>();
        this.persAffect = new ArrayList<>();
        this.statut = Statut.valueOf(statut);
        this.modifiable = true;
    }
    
    public void affecterPersonnel(Personnel p, Competence c) {
        int nbPersAct=0;
        boolean inscrit = false; // vérifie si l'employé est déjà inscrit sur cette compétence
        int nbPersVoulu = this.besoins.getNbPersComp(c);
        if (this.affectations.get(c) != null) {
            nbPersAct = this.affectations.get(c).size();
            inscrit = this.affectations.get(c).contains(p);
        }
        if (Entreprise.personnels.containsKey(p.getId())) {
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
        else {
            System.err.println("La personne que vous tentez d'insérer ne fait pas partie de l'entreprise");
        }
        
    }
    
    public String afficherStatut() {
        return this.statut.toString();
    }
    
    private boolean bienPreparee(){
	int nbPersonneActMission = 0;
        int besoin;
        int actuel=0;
	
	//Vérifier que la mission est modifiable
	if(this.modifiable == false){
            System.err.println( "La mission n'est plus modifiable");
            return false;
	}
		
	for(Competence comp : this.affectations.keySet()) {
            nbPersonneActMission += this.affectations.get(comp).size(); //nombre actuel de personne sur la mission
        }
        
        // vérification nb de personnes totales nécessaires sur la mission
	if(this.besoins.getNbPersNecessaire() > nbPersonneActMission){
            int manque = this.besoins.getNbPersNecessaire() - nbPersonneActMission;
            System.err.println("Le nombre de personne affectées à la mission est insufisant. Ajouter " + manque + " personnes");
            return false;
	}
      
	// Vérifier que chaque compétence à le nb de personnes qu'il faut
	for(Competence comp : this.besoins.getMapBesoins().keySet()) { // On regarde le nb de personnes nécessaires pour chaque compétence
            besoin = this.besoins.getNbPersComp(comp);// nb de personne necessaire à une compétence
            
            if (this.affectations.get(comp) != null) {
                actuel = this.affectations.get(comp).size(); // nb de personne actuelle à la mission
            }
            if(besoin > actuel){
                int manque = besoin- actuel;
                System.err.println("Le nombre de personnes affiliées à la compétence" + comp + "est insufisant, Ajouter " + manque + " personnes");
                return false;
            }    
	}
        return true;
    }

    public void missionPlannifiee(){
       // Vérifier que la mission est modifiable
        if(!this.modifiable){
            System.err.println("Cette mission n'est plus modifiable");
        }
        //Vérifier que la mission est en préparation
        else if(this.statut != Statut.en_preparation){
            System.err.println("La mission doit être en préparation");
        }
        // Vérifier que la maison est bien préparée
        else if(!this.bienPreparee()){
            System.err.println("Veuillez compléter la mission");
        }
        else{ //Changement de statut
            this.statut = Statut.plannifie;
            System.out.println("Mission correctement plannifiée!");
        }
    }
    
    public void  missionEnCours(){
        // Vérifier que la mission est planifiée
        if(this.statut == Statut.en_preparation){
            System.err.println("La mission n'est pas correctement plannifiée");
        }
        else if(this.statut == Statut.terminee){
            System.err.println("La mission est déjà terminée");
        }
        // Vérifier que la mission a bien commencée 
        else if(Outils.dateAuj.before(this.dateDebut) == true ){
            System.err.println("La mission commencera le :" + this.dateDebut);
        }
        else{ 
            this.statut = Statut.en_cours;
            System.out.println("Mission en cours!");
        }
    }

    public void missionTermine(){
        // Vérifier que la mission est en cours
        if(this.statut != Statut.en_cours){
            System.err.println("La mission n'a pas encore commencée");
        }
        // Vérifier que la durée est respectée
        Calendar dateFin = Calendar.getInstance();
        dateFin.setTime(this.dateDebut);
        dateFin.add(Calendar.DATE, this.dureeJ);
        
        if(Outils.dateAuj.before(dateFin.getTime()) == true ){
            System.err.println("La mission n'est pas terminée");
        }
        else{
            this.statut =Statut.terminee;
            System.out.println("Mission terminée!");
        }  
    }
    
    public int getIdM() {
        return this.idMission;
    }
    
    public Besoin getBesoins() {
        return this.besoins;
    }
    
    public Map<Competence, ArrayList<Personnel>> getAffectations() {
        return this.affectations;
    }
    
    public Date getDateDebut() {
        return this.dateDebut;
    }
    
    public int getDuree() {
        return this.dureeJ;
    }
    
    public String getStatut() {
        return this.statut.toString().replaceAll("_", " ");
    }
    
    public String toString(){
        String msg = "Mission " + this.idMission + ", date de debut : " + this.dateDebut + " (" + this.dureeJ + " jours) Nb d'employé nécessaires : " + besoins.getNbPersNecessaire() + " - " + this.getStatut();
        for(Competence comp : besoins.getMapBesoins().keySet()) {
            msg += "\n\t compétence n°" + comp.getIdComp() + " (" + besoins.getNbPersComp(comp) + " employés) - ";
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
    
    public String formatFicAffect(Competence c) {
        String msg = this.idMission + ";" + c.getIdComp() + ";" + besoins.getNbPersComp(c);
        ArrayList<Personnel> affectationComp = this.affectations.get(c) == null ? new ArrayList<>() : this.affectations.get(c);
        if (!affectationComp.isEmpty()) {
            for (Personnel p : affectationComp) {
                msg += ";" + p.getId();
            }
        }
        //System.out.println(msg);
        return msg;
    }
    
    public String formatFicBesoin(Competence c) {
        return this.idMission + ";" + c.getIdComp() + ";" + besoins.getNbPersComp(c);
    }
}
