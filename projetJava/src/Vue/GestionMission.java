/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Entreprise;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modele.FormatFichierException;
import Modele.Outils;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heloise
 */
public class GestionMission extends javax.swing.JFrame {
    protected Map<Integer,Modele.Mission> missions;
    /**
     * Creates new form GestionMission
     */
    public GestionMission(Map<Integer,Modele.Mission> missions) {
        initComponents();
        this.setLocationRelativeTo(null);
        bModif.setEnabled(false);
        bSuppr.setEnabled(false);
        bAffectEmp.setEnabled(false);
        this.missions = missions;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exportFic = new javax.swing.JFileChooser();
        group_filtres = new javax.swing.ButtonGroup();
        pBandeau = new javax.swing.JPanel();
        l_titre = new javax.swing.JLabel();
        bRetour = new javax.swing.JButton();
        pPage = new javax.swing.JPanel();
        bAjoutMission = new javax.swing.JButton();
        bModif = new javax.swing.JButton();
        bSuppr = new javax.swing.JButton();
        bExportFic = new javax.swing.JButton();
        bAffectEmp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        p_recherche2 = new javax.swing.JPanel();
        tf_recherche = new javax.swing.JTextField();
        rb_idMission = new javax.swing.JRadioButton();
        rb_compM = new javax.swing.JRadioButton();
        rb_emp = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        l_titreTabMission = new javax.swing.JLabel();
        l_titreTabEmpM = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMission = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMissionEmp = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        menuAccueil = new javax.swing.JMenu();
        menuEmploye = new javax.swing.JMenu();
        itemAllEmp = new javax.swing.JMenuItem();
        itemNewEmp = new javax.swing.JMenuItem();
        menuMission = new javax.swing.JMenu();
        itemAllMission = new javax.swing.JMenuItem();
        itemNewMission = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pBandeau.setBackground(new java.awt.Color(255, 153, 51));
        pBandeau.setPreferredSize(new java.awt.Dimension(317, 73));

        l_titre.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        l_titre.setText("Gestion des missions");

        bRetour.setText("<");
        bRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBandeauLayout = new javax.swing.GroupLayout(pBandeau);
        pBandeau.setLayout(pBandeauLayout);
        pBandeauLayout.setHorizontalGroup(
            pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBandeauLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(bRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(l_titre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pBandeauLayout.setVerticalGroup(
            pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBandeauLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bRetour)
                    .addComponent(l_titre))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pPage.setBackground(new java.awt.Color(255, 255, 255));

        bAjoutMission.setText("Ajouter une mission");
        bAjoutMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjoutMissionActionPerformed(evt);
            }
        });

        bModif.setText("Modifier");
        bModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifActionPerformed(evt);
            }
        });

        bSuppr.setText("Supprimer");

        bExportFic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/img/sauvegarder.jpeg"))); // NOI18N
        bExportFic.setText("Exporter les fiches");
        bExportFic.setToolTipText("");
        bExportFic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportFicActionPerformed(evt);
            }
        });

        bAffectEmp.setText("Affecter un employé");

        p_recherche2.setBorder(javax.swing.BorderFactory.createTitledBorder("Options de recherche"));

        tf_recherche.setForeground(new java.awt.Color(153, 153, 153));
        tf_recherche.setText("Entrez votre recherche");
        tf_recherche.setToolTipText("");
        tf_recherche.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_rechercheFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_rechercheFocusLost(evt);
            }
        });

        group_filtres.add(rb_idMission);
        rb_idMission.setText("Identifiant");
        rb_idMission.setSelected(true);

        group_filtres.add(rb_compM);
        rb_compM.setText("Compétence");

        group_filtres.add(rb_emp);
        rb_emp.setText("Employé");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En préparation", "Plannifiée", "En cours", "Terminée"}));
        jComboBox1.setSelectedItem(jComboBox1);
        jComboBox1.setToolTipText("");

        javax.swing.GroupLayout p_recherche2Layout = new javax.swing.GroupLayout(p_recherche2);
        p_recherche2.setLayout(p_recherche2Layout);
        p_recherche2Layout.setHorizontalGroup(
            p_recherche2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_recherche2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jComboBox1, 0, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rb_idMission)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_compM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_emp)
                .addGap(23, 23, 23))
        );
        p_recherche2Layout.setVerticalGroup(
            p_recherche2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_recherche2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(p_recherche2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_idMission)
                    .addComponent(rb_compM)
                    .addComponent(rb_emp)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        l_titreTabMission.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        l_titreTabMission.setText("Liste des missions");

        l_titreTabEmpM.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        l_titreTabEmpM.setText("Liste des employés sur la mission");

        tableMission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Nombre d'employés", "Date de lancement", "Durée (en jour)", "Statut"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableMission);

        tableMissionEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Nom", "Prénom", "Compétences sur la mission"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMissionEmp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_titreTabMission, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_titreTabEmpM, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(p_recherche2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(p_recherche2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_titreTabMission, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(l_titreTabEmpM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(bAjoutMission, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bModif)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAffectEmp)
                .addGap(18, 18, 18)
                .addComponent(bSuppr)
                .addGap(18, 18, 18)
                .addComponent(bExportFic, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bExportFic, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(bSuppr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAffectEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAjoutMission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bModif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuAccueil.setText("Accueil");
        menuAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAccueilMouseClicked(evt);
            }
        });
        menu.add(menuAccueil);

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

        menu.add(menuEmploye);

        menuMission.setText("Missions");

        itemAllMission.setText("Liste des missions");
        itemAllMission.setEnabled(false);
        itemAllMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAllMissionActionPerformed(evt);
            }
        });
        menuMission.add(itemAllMission);

        itemNewMission.setText("Nouvelle mission");
        menuMission.add(itemNewMission);

        menu.add(menuMission);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBandeau, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
            .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBandeau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourActionPerformed
        new Accueil().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bRetourActionPerformed

    private void menuAccueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAccueilMouseClicked
        new Accueil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAccueilMouseClicked

    private void itemAllEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAllEmpActionPerformed
        // TODO add your handling code here:
        new GestionPersonnel(Modele.Entreprise.personnels).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemAllEmpActionPerformed

    private void itemNewEmpActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new AjoutPersonnel().setVisible(true);
        this.dispose();
    } 
    
    private void itemAllMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAllMissionActionPerformed
        // TODO add your handling code here:
        new GestionMission(Modele.Entreprise.missions).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemAllMissionActionPerformed

    private void bExportFicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportFicActionPerformed
        // TODO add your handling code here:
        int returnVal = exportFic.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File f = exportFic.getSelectedFile();
            try {
                Outils.sauvegarderMission(f.toString());
            }
            catch (FormatFichierException ef) {
                JOptionPane.showMessageDialog(rootPane, ef.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException ioe) {
                Logger.getLogger(GestionPersonnel.class.getName()).log(Level.SEVERE, null, ioe);
            }
        }
        else {
            System.out.println("File access cancel by user");
        }
    }//GEN-LAST:event_bExportFicActionPerformed

    private void bAjoutMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjoutMissionActionPerformed
        new AjoutMission().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bAjoutMissionActionPerformed

    private void bModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bModifActionPerformed

    private void tf_rechercheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_rechercheFocusGained
        tf_recherche.setText("");
    }//GEN-LAST:event_tf_rechercheFocusGained

    private void tf_rechercheFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_rechercheFocusLost
        tf_recherche.setText("Entrez votre recherche");
    }//GEN-LAST:event_tf_rechercheFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionMission(Modele.Entreprise.missions).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAffectEmp;
    private javax.swing.JButton bAjoutMission;
    private javax.swing.JButton bExportFic;
    private javax.swing.JButton bModif;
    private javax.swing.JButton bRetour;
    private javax.swing.JButton bSuppr;
    private javax.swing.JFileChooser exportFic;
    private javax.swing.ButtonGroup group_filtres;
    private javax.swing.JMenuItem itemAllEmp;
    private javax.swing.JMenuItem itemAllMission;
    private javax.swing.JMenuItem itemNewEmp;
    private javax.swing.JMenuItem itemNewMission;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_titre;
    private javax.swing.JLabel l_titreTabEmpM;
    private javax.swing.JLabel l_titreTabMission;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAccueil;
    private javax.swing.JMenu menuEmploye;
    private javax.swing.JMenu menuMission;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    private javax.swing.JPanel p_recherche2;
    private javax.swing.JRadioButton rb_compM;
    private javax.swing.JRadioButton rb_emp;
    private javax.swing.JRadioButton rb_idMission;
    private javax.swing.JTable tableMission;
    private javax.swing.JTable tableMissionEmp;
    private javax.swing.JTextField tf_recherche;
    // End of variables declaration//GEN-END:variables
}
