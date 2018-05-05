/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author heloise
 */
public class Mission {

    private int idMission;
    public static int countMission;
    private Date dateDebut;
    private int dureeJ;
    private Besoin besoins;
    private Map<Competence, ArrayList<Personnel>> affectations;
    private ArrayList<Personnel> persAffect;
    private Statut statut;
    private boolean modifiable;

    /**
     * Constructeur d'un objet Mission
     *
     * @param dateDebut La date de début de la mission
     * @param dureeJ La durée de la mission (en jour)
     * @param b Le besoin (nb de personne totale)
     */
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

    /**
     * Constructeur d'un objet Mission lorsque l'identifiant est précisé (import
     * fichier)
     *
     * @param idMission Identifiant de la mission
     * @param dateDebut La date de lancement de la mission
     * @param dureeJ La durée de la mission (en jour)
     * @param statut Le statut de la mission
     * @param b Le besoin de la mission (nb de personne totale)
     */
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

    /**
     * Méthode permettant d'affecter un employé sur la mission
     *
     * @param p L'employé à affecter
     * @param c La compétence sur laquelle est affecté l'employé
     */
    public void affecterPersonnel(Personnel p, Competence c) throws QuotaDepasseException {
        int nbPersAct = 0;
        boolean inscrit = false; // vérifie si l'employé est déjà inscrit sur cette compétence
        int nbPersVoulu = this.besoins.getNbPersComp(c);
        if (this.affectations.get(c) != null) {
            nbPersAct = this.affectations.get(c).size();
            inscrit = this.affectations.get(c).contains(p);
        }
        if (Entreprise.personnels.containsKey(p.getId())) {
            if (p.aCompetence(c)) {
                if (nbPersAct < nbPersVoulu) {
                    if (!inscrit) {
                        ArrayList<Personnel> persM = this.affectations.get(c);
                        if (persM == null) {
                            persM = new ArrayList<>();
                        }
                        persM.add(p);
                        this.affectations.put(c, persM);
                    } else {
                        System.err.println("L'employé est déjà assigné à cette compétence");
                    }
                } else {
                    throw new QuotaDepasseException();
                }
            } else {
                System.err.println("L'employe " + p.getId() + " ne possède pas cette compétence");
            }
        } else {
            System.err.println("La personne que vous tentez d'insérer ne fait pas partie de l'entreprise");
        }
    }

    public void desaffecterEmploye(Personnel p, Competence c) {
        if (this.affectations.containsKey(c)) {
            ArrayList<Personnel> persAffect = this.affectations.get(c);
            if (persAffect.contains(p)) {
                persAffect.remove(p);
                this.affectations.put(c, persAffect);
            } else {
                System.err.println("L'employé " + p.getId() + " ne participe pas à cette mission");
            }
        } else {
            System.err.println("La compétence '" + c.getCompFR() + "' ne fait pas partie des besoins de la mission");
        }
    }

    /**
     * Affichage du statut de la mission (en préparation, plannifiée, en cours,
     * terminée)
     *
     * @return String - Le statut de la mission
     */
    public String afficherStatut() {
        return this.statut.toString();
    }

    private void changerStatut() {
        switch (this.statut) {
            case en_preparation:
                if (this.bienPreparee()) {
                    this.statut = Statut.plannifie;
                }
            case plannifie:
                // Vérifier si la mission a commencée 
                if (Outils.dateAuj.before(this.dateDebut) == false) {
                    this.statut = Statut.en_cours;
                    this.modifiable=false;
                }
            case en_cours:
                // Vérifier que la durée est respectée
                Calendar dateFin = Calendar.getInstance();

                dateFin.setTime(this.dateDebut);
                dateFin.add(Calendar.DATE, this.dureeJ);

                if (Outils.dateAuj.before(dateFin.getTime()) == false) {
                    this.statut = Statut.terminee;
                }
        }
    }
    
    private boolean bienPreparee() {
        int nbPersonneActMission = 0;
        int besoin;
        int actuel = 0;

        //Vérifier que la mission est modifiable
        if (this.modifiable == false) {
            System.err.println("La mission n'est plus modifiable");
            return false;
        }

        for (Competence comp : this.affectations.keySet()) {
            nbPersonneActMission += this.affectations.get(comp).size(); //nombre actuel de personne sur la mission
        }

        // vérification nb de personnes totales nécessaires sur la mission
        if (this.besoins.getNbPersNecessaire() > nbPersonneActMission) {
            int manque = this.besoins.getNbPersNecessaire() - nbPersonneActMission;
            System.err.println("Le nombre de personne affectées à la mission est insufisant. Ajouter " + manque + " personnes");
            return false;
        }

        // Vérifier que chaque compétence à le nb de personnes qu'il faut
        for (Competence comp : this.besoins.getMapBesoins().keySet()) { // On regarde le nb de personnes nécessaires pour chaque compétence
            besoin = this.besoins.getNbPersComp(comp);// nb de personne necessaire à une compétence

            if (this.affectations.get(comp) != null) {
                actuel = this.affectations.get(comp).size(); // nb de personne actuelle à la mission
            }
            if (besoin > actuel) {
                int manque = besoin - actuel;
                System.err.println("Le nombre de personnes affiliées à la compétence" + comp + "est insufisant, Ajouter " + manque + " personnes");
                return false;
            }
        }
        return true;
    }

    /**
     * Accesseur identifiant de la mission
     *
     * @return int - l'identifiant de la mission
     */
    public int getIdM() {
        return this.idMission;
    }

    /**
     * Accesseur besoin de la mission
     *
     * @return Besoin
     */
    public Besoin getBesoins() {
        return this.besoins;
    }

    /**
     * Accesseur des affectations de la mission
     *
     * @return Map - Map des affectations
     */
    public Map<Competence, ArrayList<Personnel>> getAffectations() {
        return this.affectations;
    }

    /**
     * Accesseur date de lancement de la mission
     *
     * @return Date
     */
    public Date getDateDebut() {
        return this.dateDebut;
    }

    /**
     * Accesseur durée de la mission (en jour)
     *
     * @return int - nb de jour
     */
    public int getDuree() {
        return this.dureeJ;
    }

    /**
     * Accesseur du statut de la mission
     *
     * @return String
     */
    public String getStatut() {
        return this.statut.toString();
    }

    /**
     * Accesseur de la couleur associée au statut de la mission
     *
     * @return Color
     */
    public Color getColorStatut() {
        return this.statut.getCouleur();
    }

    public int getNbActuelEmp() {
        int nbPersonneActMission = 0;
        for (Competence comp : this.getAffectations().keySet()) {
            nbPersonneActMission += this.getAffectations().get(comp).size(); //nombre actuel de personne sur la mission
        }
        return nbPersonneActMission;
    }

    public void setDuree(int dureeM) {
        this.dureeJ = dureeM;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDebut = dateDeb;
    }

    /**
     * Affichage d'une chaine de caractère comportant les infos de la mission
     *
     * @return String
     */
    public String toString() {
        String msg = "Mission " + this.idMission + ", date de debut : " + this.dateDebut + " (" + this.dureeJ + " jours) Nb d'employé nécessaires : " + besoins.getNbPersNecessaire() + " - " + this.getStatut();
        for (Competence comp : besoins.getMapBesoins().keySet()) {
            msg += "\n\t compétence n°" + comp.getIdComp() + " (" + besoins.getNbPersComp(comp) + " employés) - ";
            if (this.affectations.get(comp) != null) {
                for (Personnel p : this.affectations.get(comp)) {
                    msg += p.getId() + ", ";
                }
            }
        }
        return msg;
    }

    /**
     * Chaine de caractère formatée pour l'export dans un fichier CSV
     *
     * @return String
     */
    public String formatFic() {
        return this.idMission + ";" + Outils.sdf.format(this.dateDebut) + ";" + this.dureeJ + ";" + besoins.getNbPersNecessaire() + ";" + this.statut.getNormName();
    }

    /**
     * Chaine de caractère formatée pour l'export dans un fichier CSV des
     * affectations (Affectations)
     *
     * @param c la compétence
     * @return String
     */
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

    /**
     * Chaine de caractère formatée pour l'export dans un fichier CSV (Besoin)
     *
     * @param c Competence
     * @return String
     */
    public String formatFicBesoin(Competence c) {
        return this.idMission + ";" + c.getIdComp() + ";" + besoins.getNbPersComp(c);
    }
}
