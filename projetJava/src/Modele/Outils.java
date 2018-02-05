/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heloise
 */
public class Outils {
    
    public static void chargerCompetence(String fileName) throws FileNotFoundException {
        File fic = new File("data/"+fileName);
        Scanner scan = new Scanner(fic);
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] tab = line.split(";");
            Competence comp = new Competence(tab[0], tab[1], tab[2]);
            Entreprise.addCompetence(comp);
        }
    }
    
    public static void chargerPersonnel(String fileName) throws IOException {
        FileReader fr = new FileReader("data/"+fileName);
        BufferedReader br = new BufferedReader(fr);
        br.readLine(); // skip first line
        while(br.ready()) { 
            String line = br.readLine();
            if (!line.equals("")) { // ignore empty lines
                String [] tab = line.split(";");
                String nom = tab[1];
                String prenom = tab[0];
                String dateEntree = tab[2];
                int idp = Integer.parseInt(tab[3]);
                Personnel p = new Personnel(nom, prenom, dateEntree, idp);
                Entreprise.personnels.add(p);
            }
        }
        br.close();
        fr.close();
    }
    
    public static void sauvegarderPersonnel(String fileName) throws IOException {
        File f = new File("./data/"+fileName+".csv");
        FileWriter fw;
        if (f.exists()) {
            fw = new FileWriter(f, false);
        }
        else {
            f.createNewFile();
            fw = new FileWriter(f);
        }

        fw.write("prenom;nom;dateEntreeEntreprise;identifiant\n");
        for (Personnel p : Entreprise.personnels) {
            fw.write(p.formatFic()+"\n");
        }
        fw.close();
    }
    
    public void sauvegarderCompetence(String fileName) {
        // Lecture de la liste
        // Affichage ligne par ligne des infos comp
        // Ecriture dans le fichier ligne par ligne
    }
}
