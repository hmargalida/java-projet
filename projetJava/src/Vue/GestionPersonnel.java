/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Competence;
import Modele.EmpInexistantException;
import Modele.Entreprise;
import Modele.FormatFichierException;
import Modele.Outils;
import Modele.Personnel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heloise
 */
public class GestionPersonnel extends javax.swing.JFrame {
    protected Map<Integer,Modele.Personnel> personnels;
    protected int idEmpSelect;
    /**
     * Creates new form GestionPersonnel
     */
    public GestionPersonnel(Map<Integer,Modele.Personnel> personnels) {
        initComponents();
        this.setLocationRelativeTo(null);
        bModifComp.setEnabled(false);
        bSuppr.setEnabled(false);
        this.personnels = personnels;
        DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
        for (int pers : personnels.keySet()) {
            Modele.Personnel p = Entreprise.getEmploye(pers);
            model.addRow(new Object[]{p.getId(), p.getNom(), p.getPrenom(), Modele.Outils.sdf.format(p.getDateEntree())});
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

        exportFic = new javax.swing.JFileChooser();
        bg_recherche = new javax.swing.ButtonGroup();
        pBandeau = new javax.swing.JPanel();
        l_titre = new javax.swing.JLabel();
        bRetour = new javax.swing.JButton();
        pPage = new javax.swing.JPanel();
        bAjoutPers = new javax.swing.JButton();
        bExportFic = new javax.swing.JButton();
        bSuppr = new javax.swing.JButton();
        bModifComp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        p_recherche = new javax.swing.JPanel();
        tf_recherche = new javax.swing.JTextField();
        rb_nomEmp = new javax.swing.JRadioButton();
        rb_comp = new javax.swing.JRadioButton();
        lTitreListe = new javax.swing.JLabel();
        l_titreComp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmp = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCompEmp = new javax.swing.JTable();
        menu = new javax.swing.JMenuBar();
        menuAccueil = new javax.swing.JMenu();
        menuEmploye = new javax.swing.JMenu();
        itemAllEmp = new javax.swing.JMenuItem();
        itemNewEmp = new javax.swing.JMenuItem();
        menuMission = new javax.swing.JMenu();
        itemAllMission = new javax.swing.JMenuItem();
        itemNewMission = new javax.swing.JMenuItem();

        exportFic.setApproveButtonText("");
        exportFic.setApproveButtonToolTipText("");
        exportFic.setBackground(java.awt.Color.white);
        exportFic.setDialogTitle("Export des fiches employés");
        exportFic.setToolTipText("");
        exportFic.getAccessibleContext().setAccessibleName("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(102, 102, 102));

        pBandeau.setBackground(new java.awt.Color(102, 153, 255));
        pBandeau.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder()));

        l_titre.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        l_titre.setText("Gestion des employés");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBandeauLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(bRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(l_titre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pBandeauLayout.setVerticalGroup(
            pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBandeauLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pBandeauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bRetour)
                    .addComponent(l_titre))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pPage.setBackground(new java.awt.Color(255, 255, 255));

        bAjoutPers.setText("Ajouter un employé");
        bAjoutPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjoutPersActionPerformed(evt);
            }
        });

        bExportFic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/img/sauvegarder.jpeg"))); // NOI18N
        bExportFic.setText("Exporter les fiches");
        bExportFic.setToolTipText("");
        bExportFic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportFicActionPerformed(evt);
            }
        });

        bSuppr.setText("Supprimer");
        bSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSupprActionPerformed(evt);
            }
        });

        bModifComp.setText("Modifier les compétences");
        bModifComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifCompActionPerformed(evt);
            }
        });

        p_recherche.setBorder(javax.swing.BorderFactory.createTitledBorder("Options de recherche"));

        tf_recherche.setForeground(new java.awt.Color(153, 153, 153));
        tf_recherche.setText("Entrez votre recherche");
        tf_recherche.setToolTipText("");
        tf_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rechercheKeyPressed(evt);
            }
        });

        bg_recherche.add(rb_nomEmp);
        rb_nomEmp.setText("Nom de l'employé");
        rb_nomEmp.setSelected(true);

        bg_recherche.add(rb_comp);
        rb_comp.setText("Compétence");

        javax.swing.GroupLayout p_rechercheLayout = new javax.swing.GroupLayout(p_recherche);
        p_recherche.setLayout(p_rechercheLayout);
        p_rechercheLayout.setHorizontalGroup(
            p_rechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_rechercheLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(tf_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(rb_nomEmp)
                .addGap(18, 18, 18)
                .addComponent(rb_comp)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        p_rechercheLayout.setVerticalGroup(
            p_rechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_rechercheLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(p_rechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_nomEmp)
                    .addComponent(rb_comp))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lTitreListe.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        lTitreListe.setText("Liste des employés");

        l_titreComp.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        l_titreComp.setText("Compétences de l'employé");

        tableEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Nom", "Prénom", "Date d'entrée"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmp.getTableHeader().setReorderingAllowed(false);
        tableEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableEmpFocusLost(evt);
            }
        });
        tableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableEmpMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmp);

        tableCompEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Libellé de la compétence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableCompEmp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_titreComp)
                    .addComponent(lTitreListe))
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(p_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTitreListe)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_titreComp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(bAjoutPers)
                .addGap(18, 18, 18)
                .addComponent(bModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bExportFic, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSuppr, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pPageLayout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAjoutPers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bModifComp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bExportFic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSuppr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(631, Short.MAX_VALUE))
            .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPageLayout.createSequentialGroup()
                    .addContainerGap(57, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)))
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
        itemAllEmp.setEnabled(false);
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
        itemAllMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAllMissionActionPerformed(evt);
            }
        });
        menuMission.add(itemAllMission);

        itemNewMission.setEnabled(false);
        itemNewMission.setText("Nouvelle mission");
        menuMission.add(itemNewMission);

        menu.add(menuMission);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBandeau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBandeau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourActionPerformed
        new Accueil().setVisible(true);
        this.dispose();
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

    private void tableEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpMousePressed
        // TODO add your handling code here:
        bModifComp.setEnabled(true);
        bSuppr.setEnabled(true);
        int row = tableEmp.getSelectedRow();
        idEmpSelect = (int) tableEmp.getValueAt(row, 0);

        Personnel p = Entreprise.getEmploye(idEmpSelect);
        Iterator<Competence> it = p.getCompPers().iterator();
        DefaultTableModel model = (DefaultTableModel) tableCompEmp.getModel();
        model.setRowCount(0);
        while(it.hasNext()) {
            Competence c = it.next();
            model.addRow(new Object[]{c.getIdComp(), c.getCompFR()});
        }
    }//GEN-LAST:event_tableEmpMousePressed

    private void bModifCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifCompActionPerformed
        int row = tableEmp.getSelectedRow();
        int idp = (int) tableEmp.getValueAt(row, 0);
        String nom = (String) tableEmp.getValueAt(row, 1);
        String prenom = (String) tableEmp.getValueAt(row, 2);
        new AjoutComp(idp, nom, prenom).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bModifCompActionPerformed

    private void bSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSupprActionPerformed
        try {
            Entreprise.removePersonnel(idEmpSelect);
            // Pour mettre a jour la JTable après la suppression
            DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
            // remise à zéro de la jtable
            model.setRowCount(0);
            // re remplissage
            for (int pers : personnels.keySet()) {
                Modele.Personnel p = Entreprise.getEmploye(pers);
                model.addRow(new Object[]{p.getId(), p.getNom(), p.getPrenom(), Modele.Outils.sdf.format(p.getDateEntree())});
            }
            DefaultTableModel modelComp = (DefaultTableModel) tableCompEmp.getModel();
            modelComp.setRowCount(0);
        } catch (EmpInexistantException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " " + idEmpSelect, "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bSupprActionPerformed

    private void bExportFicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportFicActionPerformed
        // TODO add your handling code here:
        int returnVal = exportFic.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = exportFic.getSelectedFile();
            try {
                Outils.sauvegarderPersonnel(file.toString());
                JOptionPane.showMessageDialog(rootPane, "Les fiches employés ont bien été sauvegardées dans le fichier " + file.getPath(), "Exportation réussie", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (FormatFichierException ef) {
                JOptionPane.showMessageDialog(rootPane, ef.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ex) {
                Logger.getLogger(GestionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_bExportFicActionPerformed

    private void bAjoutPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjoutPersActionPerformed
        // TODO add your handling code here:
        new AjoutPersonnel().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bAjoutPersActionPerformed

    private void tf_rechercheKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rechercheKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nomRech = tf_recherche.getText();
            List<Personnel> persRech = new ArrayList<>();
            
            if (!nomRech.isEmpty()) {
                if (rb_nomEmp.isSelected()) {
                    for(int idp : this.personnels.keySet()) {
                        Personnel p = Entreprise.getEmploye(idp);
                        if (p.getNom().toLowerCase().equals(nomRech.toLowerCase())) {
                            persRech.add(p);
                        }
                    }
                }
                else if (rb_comp.isSelected()) {
                    for(int idp : this.personnels.keySet()) {
                        Personnel p = Entreprise.getEmploye(idp);
                        for (Competence c : p.getCompPers()) {
                            if (c.getCompFR().toLowerCase().contains(nomRech.toLowerCase())) {
                                if (!persRech.contains(p)){
                                    persRech.add(p);
                                }
                            }
                        }
                    }

                }
                DefaultTableModel modelComp = (DefaultTableModel) tableCompEmp.getModel();
                modelComp.setRowCount(0);
                DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
                model.setRowCount(0);
                for (Personnel p: persRech) {
                    model.addRow(new Object[]{p.getId(), p.getNom(), p.getPrenom(), Modele.Outils.sdf.format(p.getDateEntree())});
                }
                persRech.clear();
            }
            else {
                DefaultTableModel modelComp = (DefaultTableModel) tableCompEmp.getModel();
                modelComp.setRowCount(0);
                DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
                model.setRowCount(0);
                for (int pers : personnels.keySet()) {
                    Modele.Personnel p = Entreprise.getEmploye(pers);
                    model.addRow(new Object[]{p.getId(), p.getNom(), p.getPrenom(), Modele.Outils.sdf.format(p.getDateEntree())});
                }
                persRech.clear();
            }
        }
    }//GEN-LAST:event_tf_rechercheKeyPressed

    private void tableEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableEmpFocusLost
        // TODO add your handling code here:
        //bModifComp.setEnabled(false);
        //bSuppr.setEnabled(false);
    }//GEN-LAST:event_tableEmpFocusLost

    
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
            java.util.logging.Logger.getLogger(GestionPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionPersonnel(Modele.Entreprise.personnels).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAjoutPers;
    private javax.swing.JButton bExportFic;
    private javax.swing.JButton bModifComp;
    private javax.swing.JButton bRetour;
    private javax.swing.JButton bSuppr;
    private javax.swing.ButtonGroup bg_recherche;
    private javax.swing.JFileChooser exportFic;
    private javax.swing.JMenuItem itemAllEmp;
    private javax.swing.JMenuItem itemAllMission;
    private javax.swing.JMenuItem itemNewEmp;
    private javax.swing.JMenuItem itemNewMission;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lTitreListe;
    private javax.swing.JLabel l_titre;
    private javax.swing.JLabel l_titreComp;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAccueil;
    private javax.swing.JMenu menuEmploye;
    private javax.swing.JMenu menuMission;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    private javax.swing.JPanel p_recherche;
    private javax.swing.JRadioButton rb_comp;
    private javax.swing.JRadioButton rb_nomEmp;
    private javax.swing.JTable tableCompEmp;
    private javax.swing.JTable tableEmp;
    private javax.swing.JTextField tf_recherche;
    // End of variables declaration//GEN-END:variables
}
