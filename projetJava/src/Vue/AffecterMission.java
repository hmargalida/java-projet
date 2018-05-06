/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Besoin;
import Modele.Competence;
import Modele.Entreprise;
import Modele.FormatFichierException;
import Modele.Mission;
import Modele.Outils;
import Modele.Personnel;
import Modele.QuotaDepasseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heloise
 */
public class AffecterMission extends javax.swing.JFrame {
    private static int idMission;
    private Mission missionAct;
    private Besoin b;
    
    /**
     * Creates new form AffecterMission
     */
    public AffecterMission(int idM) {
        initComponents();
        b_ajout.setEnabled(false);
        b_suppr.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.idMission = idM;
        missionAct=Entreprise.getMission(idM);
        b = missionAct.getBesoins();
        
        DefaultTableModel model = (DefaultTableModel) table_comp.getModel();
        for (Competence comp : b.getMapBesoins().keySet()) {
            model.addRow(new Object[]{comp.getIdComp() + " - " + comp.getCompFR(), b.getNbPersComp(comp)});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pBandeau = new javax.swing.JPanel();
        l_titre = new javax.swing.JLabel();
        bRetour = new javax.swing.JButton();
        l_nom_prenom = new javax.swing.JLabel();
        pPage = new javax.swing.JPanel();
        l_tablecomp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_comp = new javax.swing.JTable();
        l_empComp = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_EmpComp = new javax.swing.JList<>();
        b_ajout = new javax.swing.JButton();
        b_suppr = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_affect = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        menu4 = new javax.swing.JMenuBar();
        menuAccueil4 = new javax.swing.JMenu();
        menuEmploye = new javax.swing.JMenu();
        itemAllEmp = new javax.swing.JMenuItem();
        itemNewEmp = new javax.swing.JMenuItem();
        menuMission = new javax.swing.JMenu();
        itemAllMission = new javax.swing.JMenuItem();
        itemNewMission = new javax.swing.JMenuItem();
        menuComp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pBandeau.setBackground(new java.awt.Color(255, 153, 51));
        pBandeau.setPreferredSize(new java.awt.Dimension(317, 73));

        l_titre.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        l_titre.setText("Modifier les affectations à la mission");

        bRetour.setText("<");
        bRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetourActionPerformed(evt);
            }
        });

        l_nom_prenom.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N

        javax.swing.GroupLayout pBandeauLayout = new javax.swing.GroupLayout(pBandeau);
        pBandeau.setLayout(pBandeauLayout);
        pBandeauLayout.setHorizontalGroup(
            pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBandeauLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(bRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(l_titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l_nom_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pBandeauLayout.setVerticalGroup(
            pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBandeauLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bRetour)
                    .addGroup(pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(l_nom_prenom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(l_titre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        l_tablecomp.setText("Compétences nécessaires pour la mission :");

        table_comp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Compétence", "Besoin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_compMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_comp);

        l_empComp.setText("Employés possédant la compétence :");

        list_EmpComp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_EmpComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list_EmpCompMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(list_EmpComp);

        b_ajout.setText(">");
        b_ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ajoutActionPerformed(evt);
            }
        });

        b_suppr.setText("<");
        b_suppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_supprActionPerformed(evt);
            }
        });

        list_affect.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_affect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list_affectMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(list_affect);

        jLabel1.setText("Employés affectés à la mission :");

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_tablecomp)
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPageLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_ajout, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_suppr, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(l_empComp, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(l_tablecomp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_empComp))
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(b_ajout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_suppr, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        menuAccueil4.setText("Accueil");
        menuAccueil4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAccueil4MouseClicked(evt);
            }
        });
        menu4.add(menuAccueil4);

        menuEmploye.setText("Employés");

        itemAllEmp.setText("Liste des employés");
        itemAllEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAllEmpActionPerformed(evt);
            }
        });
        menuEmploye.add(itemAllEmp);

        itemNewEmp.setText("Nouvel employé");
        menuEmploye.add(itemNewEmp);

        menu4.add(menuEmploye);

        menuMission.setText("Missions");

        itemAllMission.setText("Liste des missions");
        itemAllMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAllMissionActionPerformed(evt);
            }
        });
        menuMission.add(itemAllMission);

        itemNewMission.setEnabled(false);
        itemNewMission.setText("Nouvelle mission");
        menuMission.add(itemNewMission);

        menu4.add(menuMission);

        menuComp.setText("Compétences");
        menuComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCompMouseClicked(evt);
            }
        });
        menu4.add(menuComp);

        setJMenuBar(menu4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBandeau, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
            .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBandeau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAccueil4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAccueil4MouseClicked
        new Accueil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAccueil4MouseClicked

    private void itemAllEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAllEmpActionPerformed
        // TODO add your handling code here:
        new GestionPersonnel(Modele.Entreprise.personnels).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemAllEmpActionPerformed

    private void itemAllMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAllMissionActionPerformed
        new GestionMission(Modele.Entreprise.missions).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemAllMissionActionPerformed
   
    private void bRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourActionPerformed
        new GestionMission(Entreprise.missions).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bRetourActionPerformed

    private void table_compMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_compMousePressed
        // recherche des employés ayant cette compétence
        int row = table_comp.getSelectedRow();
        String comp = (String)table_comp.getValueAt(row, 0);
        String idComp = comp.split("-")[0].trim();
        Competence c = Entreprise.getCompetence(idComp);
        int besoin = (int)table_comp.getValueAt(row, 1);
        
        // affichage des employés avec cette compétence
        ArrayList<String> persAvecComp = new ArrayList<>();
        for(int idp : Entreprise.personnels.keySet()) {
            Personnel p = Entreprise.getEmploye(idp);
            if(p.aCompetence(c)) {
                persAvecComp.add(p.getId() + " - " + p.getPrenom() + " " + p.getNom());
            }
        }
        list_EmpComp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] elements = persAvecComp.toArray(new String[persAvecComp.size()]);
            public int getSize() { return elements.length; }
            public String getElementAt(int i) { return elements[i]; }
        });
        
        // affichage des employés déjà affectés à la mission sur cette compétence
        DefaultListModel dm = new DefaultListModel();
        dm.clear();
        list_affect.setModel(dm);
        ArrayList<String> persAffect = new ArrayList<>();
        if(missionAct.getAffectations().get(c) != null) {
            for(Personnel p : missionAct.getAffectations().get(c)) {
                persAffect.add(p.getId() + " - " + p.getPrenom() + " " + p.getNom());
            }
            list_affect.setModel(new javax.swing.AbstractListModel<String>() {
                String[] elements = persAffect.toArray(new String[persAffect.size()]);
                public int getSize() { return elements.length; }
                public String getElementAt(int i) { return elements[i]; }
            });
        }
    }//GEN-LAST:event_table_compMousePressed

    private void list_EmpCompMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_EmpCompMousePressed
        b_ajout.setEnabled(true);
        b_suppr.setEnabled(false);
    }//GEN-LAST:event_list_EmpCompMousePressed

    private void list_affectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_affectMousePressed
        b_suppr.setEnabled(true);
        b_ajout.setEnabled(false);
    }//GEN-LAST:event_list_affectMousePressed

    private void b_ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ajoutActionPerformed
        // ajout de l'employe sur la competence
        String compSelect = (String)table_comp.getValueAt(table_comp.getSelectedRow(), 0);
        String idCompSelect = compSelect.split("-")[0].trim();
        int idEmpSelect = Integer.valueOf(list_EmpComp.getSelectedValue().split("-")[0].trim());
        Personnel p = Entreprise.getEmploye(idEmpSelect);
        Competence c = Entreprise.getCompetence(idCompSelect);
        try {
            missionAct.affecterPersonnel(p, c);
        } catch (QuotaDepasseException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        // affichage des employés déjà affectés à la mission sur cette compétence 
        ArrayList<String> persAffect = new ArrayList<>();
        if(missionAct.getAffectations().get(c) !=null) {
            for(Personnel pers : missionAct.getAffectations().get(c)) {
                persAffect.add(pers.getId() + " - " + pers.getPrenom() + " " + pers.getNom());
            }
            list_affect.setModel(new javax.swing.AbstractListModel<String>() {
                String[] elements = persAffect.toArray(new String[persAffect.size()]);
                public int getSize() { return elements.length; }
                public String getElementAt(int i) { return elements[i]; }
            });
        }
    }//GEN-LAST:event_b_ajoutActionPerformed

    private void b_supprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_supprActionPerformed
        String compSelect = (String)table_comp.getValueAt(table_comp.getSelectedRow(), 0);
        String idCompSelect = compSelect.split("-")[0].trim();
        int idEmpSelect = Integer.valueOf(list_affect.getSelectedValue().split("-")[0].trim());
        Personnel p = Entreprise.getEmploye(idEmpSelect);
        Competence c = Entreprise.getCompetence(idCompSelect);
        
        missionAct.desaffecterEmploye(p, c);
        
        // mise à jour de la liste des employés affectés
        ArrayList<String> persAffect = new ArrayList<>();
        if(missionAct.getAffectations().get(c) !=null) {
            for(Personnel pers : missionAct.getAffectations().get(c)) {
                persAffect.add(pers.getId() + " - " + pers.getPrenom() + " " + pers.getNom());
            }
            list_affect.setModel(new javax.swing.AbstractListModel<String>() {
                String[] elements = persAffect.toArray(new String[persAffect.size()]);
                public int getSize() { return elements.length; }
                public String getElementAt(int i) { return elements[i]; }
            });
        }
    }//GEN-LAST:event_b_supprActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       try {
            Outils.sauvegarderPersonnel("data/liste_personnel.csv");
            Outils.sauvegarderCompPersonnel("data/competences_personnel.csv");
            Outils.sauvegarderCompetence("data/liste_competences.csv");
            Outils.sauvegarderMission("data/liste_missions.csv");
            Outils.sauvegarderBesoinMission("data/liste_besoins.csv");
            Outils.sauvegarderAffectation("data/liste_affectations.csv");
        } catch (IOException ex) {
            Logger.getLogger(GestionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormatFichierException ex) {
            Logger.getLogger(GestionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void menuCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCompMouseClicked
        new GestionComp(Entreprise.competences).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCompMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AffecterMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AffecterMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AffecterMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AffecterMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffecterMission(idMission).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetour;
    private javax.swing.JButton b_ajout;
    private javax.swing.JButton b_suppr;
    private javax.swing.JMenuItem itemAllEmp;
    private javax.swing.JMenuItem itemAllMission;
    private javax.swing.JMenuItem itemNewEmp;
    private javax.swing.JMenuItem itemNewMission;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l_empComp;
    private javax.swing.JLabel l_nom_prenom;
    private javax.swing.JLabel l_tablecomp;
    private javax.swing.JLabel l_titre;
    private javax.swing.JList<String> list_EmpComp;
    private javax.swing.JList<String> list_affect;
    private javax.swing.JMenuBar menu4;
    private javax.swing.JMenu menuAccueil4;
    private javax.swing.JMenu menuComp;
    private javax.swing.JMenu menuEmploye;
    private javax.swing.JMenu menuMission;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    private javax.swing.JTable table_comp;
    // End of variables declaration//GEN-END:variables
}
