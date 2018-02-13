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
    
    private boolean  bienPreparee(){
		
	int nbPersonneActMission = 0;
	
	//Vérifier que la mission est modifiable
	if(this.modifiable == false){
	System.err.println( "La mission n'est plus modifiable");
            return false;
	}
		
	for(Competence comp : this.besoins.getNbPersComp().keySet()) {
            nbPersonneActMission += this.besoins.getNbPersComp().get(comp);// nombre actuel de personne sur la mission
        }
	
        // vérification nb de personnes totales nécessaires sur la mission
	if(this.besoins.getNbPersNecessaire() > nbPersonneActMission){
            int manque = this.besoins.getNbPersNecessaire() - nbPersonneActMission;
            
            System.err.println("Le nombre de personne affectées à la mission est insufisant. Ajouter " + manque + " personnes");
            return false;
	}
	
	// Vérifier que chaque compétence à le nb de personnes qu'il faut
	int besoin;
        int actuel;
	for(Competence comp : this.besoins.getNbPersComp().keySet()) { // On regarde le nb de personnes nécessaires pour chaque compétence
             besoin = this.besoins.getNbPersComp().get(comp);// nb de personne necessaire à une compétence
             actuel = this.affectations.get(comp).size(); // nb de personne actuelle à la mission
             
             if(besoin > actuel){
                 int manque = besoin- actuel;
                 System.err.println("Le nombre de personnes affiliées à la compétence" + comp + "est insufisant, Ajouter " + manque + "personnes");
             }
             
	}
        
        return true;
}
	

private void  MissionPlannifiee(){
    
   // Vérifier que la mission est modifiable
   
    if(this.modifiable == false){
        System.err.println("Cette mission n'est plus modifiable");
    }
    //Vérifier que la mission est en préparation
    else if(this.statut != Statut.en_preparation){
        System.err.println("La mission doit être en préparation");
    }
    // Vérifier que la maison est bien préparée
    else if(this.bienPreparee() == false){
        System.err.println("Veuillez compléter la mission");
    }
    else{
    this.statut =Statut.plannifie;}
     
}
    
private void  MissionEnCours(){
    
    // Vérifier que la mission est planifiée
    if(this.statut == Statut.en_preparation){
        System.err.println("La mission n'est pas correctement plannifiée");
    }
    else if(this.statut == Statut.terminee){
        System.err.println("La mission est déjà terminée");
    }
    // Vérifier que la mission a bien commencée -> !!! Déclencher la fonction en cours lors d'un changement de date?
    else if(this.dateDebut.before(Outils.dateAuj) == true ){
         System.err.println("La mission n'a pas commencée. La date de début est le :" + this.dateDebut);
    }
    // Vérifier que la durée plus la date de debut est < a date du jour?
   /* else if(){
        this.MissionTermine();
    }
    */
    else{ this.statut =Statut.en_cours;}

}

private void  MissionTermine(){
	// Vérifier que la mission est en cours
        if(this.statut == Statut.en_cours){
        System.err.println("La mission n'est pas en cours? N'a pas commencée?");
    }
     // Vérifier que la durée plus la date de debut est < a date du jour?
   /* else if(){
        this.MissionTermine();
    }
    */
   else{ this.statut =Statut.terminee;}
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
