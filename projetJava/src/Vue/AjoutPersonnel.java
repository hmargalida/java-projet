/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Entreprise;
import Modele.Outils;
import Modele.Personnel;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author heloise
 */
public class AjoutPersonnel extends javax.swing.JFrame {

    /**
     * Creates new form AjoutPersonnel
     */
    public AjoutPersonnel() {
        initComponents();
        this.setLocationRelativeTo(null);
        b_Enreg.setEnabled(false);
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
        pPage = new javax.swing.JPanel();
        l_infoPrinc = new javax.swing.JLabel();
        l_nomEmp = new javax.swing.JLabel();
        l_prenomEmp = new javax.swing.JLabel();
        l_dateEntree = new javax.swing.JLabel();
        tf_nom = new javax.swing.JTextField();
        tf_prenom = new javax.swing.JTextField();
        tf_date = new javax.swing.JFormattedTextField();
        b_Enreg = new javax.swing.JButton();
        l_err = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuAccueil = new javax.swing.JMenu();
        menuEmploye = new javax.swing.JMenu();
        itemAllEmp = new javax.swing.JMenuItem();
        itemNewEmp = new javax.swing.JMenuItem();
        menuMission = new javax.swing.JMenu();
        itemAllMission = new javax.swing.JMenuItem();
        itemNewMission = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pBandeau.setBackground(new java.awt.Color(102, 153, 255));
        pBandeau.setPreferredSize(new java.awt.Dimension(317, 73));

        l_titre.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        l_titre.setText("Ajout d'un employé");

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

        l_infoPrinc.setFont(new java.awt.Font("American Typewriter", 0, 18)); // NOI18N
        l_infoPrinc.setText("Informations principales :");

        l_nomEmp.setText("Nom de l'employé :");

        l_prenomEmp.setText("Prénom de l'employé :");

        l_dateEntree.setText("Date d'entrée dans l'entreprise :");

        tf_nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_nomFocusLost(evt);
            }
        });

        tf_prenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_prenomFocusLost(evt);
            }
        });

        tf_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        tf_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_dateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_dateFocusLost(evt);
            }
        });

        b_Enreg.setText("Enregistrer");
        b_Enreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_EnregActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pPageLayout.createSequentialGroup()
                                .addComponent(l_prenomEmp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_prenom))
                            .addGroup(pPageLayout.createSequentialGroup()
                                .addComponent(l_nomEmp)
                                .addGap(18, 18, 18)
                                .addComponent(tf_nom))
                            .addComponent(l_infoPrinc)
                            .addGroup(pPageLayout.createSequentialGroup()
                                .addComponent(l_dateEntree)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_err))
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(b_Enreg)))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(l_infoPrinc)
                .addGap(18, 18, 18)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nomEmp)
                    .addComponent(tf_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_prenomEmp)
                    .addComponent(tf_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_dateEntree)
                    .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_err))
                .addGap(27, 27, 27)
                .addComponent(b_Enreg, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
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

        itemNewEmp.setEnabled(false);
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
            .addComponent(pBandeau, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
            .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBandeau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAccueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAccueilMouseClicked
        new Accueil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAccueilMouseClicked

    private void itemAllEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAllEmpActionPerformed
        // TODO add your handling code here:
        new GestionPersonnel(Modele.Entreprise.personnels).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemAllEmpActionPerformed

    private void itemAllMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAllMissionActionPerformed
        // TODO add your handling code here:
        new GestionMission(Modele.Entreprise.missions).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemAllMissionActionPerformed

    private void bRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourActionPerformed
        new GestionPersonnel(Entreprise.personnels).setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bRetourActionPerformed

    private void b_EnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_EnregActionPerformed
        // TODO add your handling code here:
        String nomEmp = tf_nom.getText();
        String prenomEmp = tf_prenom.getText();
        Date dateEntreeEmp=null;
        try {
            dateEntreeEmp = Outils.sdf.parse(tf_date.getText());
        } catch (ParseException ex) {
            l_err.setText("Erreur format date");
        }
        if(nomEmp.isEmpty() || prenomEmp.isEmpty() || dateEntreeEmp == null) {
            JOptionPane.showMessageDialog(rootPane, "Erreur lors de la saisie du formulaire", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Personnel p = new Personnel(nomEmp, prenomEmp, dateEntreeEmp);
            Entreprise.addPersonnel(p);
            JOptionPane.showMessageDialog(rootPane, "L'employé " + prenomEmp + " " + nomEmp + " a bien été enregistré", "Enregistrement de l'employé", JOptionPane.INFORMATION_MESSAGE);
            // retour page précédente
            new GestionPersonnel(Modele.Entreprise.personnels).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_b_EnregActionPerformed

    private void tf_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dateFocusLost
        // TODO add your handling code here:
        try {
            Outils.sdf.parse(tf_date.getText());
        } catch (ParseException ex) {
            l_err.setText("Erreur format date");
            l_err.setForeground(Color.red);
        }
        if (!tf_nom.getText().isEmpty() && !tf_prenom.getText().isEmpty() && !tf_date.getText().isEmpty()) {
            b_Enreg.setEnabled(true);
        }
        else {
            b_Enreg.setEnabled(false);
        }
    }//GEN-LAST:event_tf_dateFocusLost

    private void tf_dateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dateFocusGained
        // TODO add your handling code here:
        l_err.setText("");
    }//GEN-LAST:event_tf_dateFocusGained

    private void tf_nomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nomFocusLost
        // TODO add your handling code here:
        if (!tf_nom.getText().isEmpty() && !tf_prenom.getText().isEmpty() && !tf_date.getText().isEmpty()) {
            b_Enreg.setEnabled(true);
        }
        else {
            b_Enreg.setEnabled(false);
        }
    }//GEN-LAST:event_tf_nomFocusLost

    private void tf_prenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_prenomFocusLost
        // TODO add your handling code here:
        if (!tf_nom.getText().isEmpty() && !tf_prenom.getText().isEmpty() && !tf_date.getText().isEmpty()) {
            b_Enreg.setEnabled(true);
        }
        else {
            b_Enreg.setEnabled(false);
        }
    }//GEN-LAST:event_tf_prenomFocusLost

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
            java.util.logging.Logger.getLogger(AjoutPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutPersonnel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetour;
    private javax.swing.JButton b_Enreg;
    private javax.swing.JMenuItem itemAllEmp;
    private javax.swing.JMenuItem itemAllMission;
    private javax.swing.JMenuItem itemNewEmp;
    private javax.swing.JMenuItem itemNewMission;
    private javax.swing.JLabel l_dateEntree;
    private javax.swing.JLabel l_err;
    private javax.swing.JLabel l_infoPrinc;
    private javax.swing.JLabel l_nomEmp;
    private javax.swing.JLabel l_prenomEmp;
    private javax.swing.JLabel l_titre;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAccueil;
    private javax.swing.JMenu menuEmploye;
    private javax.swing.JMenu menuMission;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    private javax.swing.JFormattedTextField tf_date;
    private javax.swing.JTextField tf_nom;
    private javax.swing.JTextField tf_prenom;
    // End of variables declaration//GEN-END:variables
}
