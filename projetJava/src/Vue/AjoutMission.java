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
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heloise
 */
public class AjoutMission extends javax.swing.JFrame {
    private int idMission=0;
    /**
     * Creates new form AjoutMission
     */
    public AjoutMission() {
        initComponents();
        this.setLocationRelativeTo(null);
        b_enrg.setEnabled(false);
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
        p_infosP = new javax.swing.JPanel();
        l_dateDeb = new javax.swing.JLabel();
        tf_date = new javax.swing.JFormattedTextField();
        l_duree = new javax.swing.JLabel();
        tf_duree = new javax.swing.JTextField();
        l_nbEmp = new javax.swing.JLabel();
        s_nbEmp = new javax.swing.JSpinner();
        l_err_date = new javax.swing.JLabel();
        l_err_duree = new javax.swing.JLabel();
        b_enrg = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuAccueil = new javax.swing.JMenu();
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
        l_titre.setText("Ajout d'une mission (1/2)");

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

        p_infosP.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations principales"));

        l_dateDeb.setText("Date de lancement :");

        tf_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        tf_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_dateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_dateFocusLost(evt);
            }
        });

        l_duree.setText("Durée (en jour) :");

        tf_duree.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_dureeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_dureeFocusLost(evt);
            }
        });

        l_nbEmp.setText("Nombre d'employés total :");
        l_nbEmp.setToolTipText("");

        s_nbEmp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        s_nbEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        s_nbEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                s_nbEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                s_nbEmpFocusLost(evt);
            }
        });

        l_err_date.setToolTipText("");

        l_err_duree.setToolTipText("");

        b_enrg.setText("Enregistrer");
        b_enrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_enrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_infosPLayout = new javax.swing.GroupLayout(p_infosP);
        p_infosP.setLayout(p_infosPLayout);
        p_infosPLayout.setHorizontalGroup(
            p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_infosPLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(p_infosPLayout.createSequentialGroup()
                        .addComponent(l_dateDeb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(l_err_date, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_infosPLayout.createSequentialGroup()
                        .addComponent(l_duree)
                        .addGap(36, 36, 36)
                        .addComponent(tf_duree, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(l_err_duree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_infosPLayout.createSequentialGroup()
                        .addComponent(l_nbEmp)
                        .addGap(18, 18, 18)
                        .addComponent(s_nbEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_infosPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_enrg)
                .addGap(78, 78, 78))
        );
        p_infosPLayout.setVerticalGroup(
            p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_infosPLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_dateDeb)
                        .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_err_date, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_duree)
                        .addComponent(tf_duree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(l_err_duree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_infosPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nbEmp)
                    .addComponent(s_nbEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_enrg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPageLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(p_infosP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_infosP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
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

        menuComp.setText("Compétences");
        menuComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCompMouseClicked(evt);
            }
        });
        menu.add(menuComp);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBandeau, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBandeau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
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
        new GestionMission(Entreprise.missions).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bRetourActionPerformed

    private void b_enrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_enrgActionPerformed
        int duree = 0;
        int nbEmp = 0;

        duree = Integer.valueOf(tf_duree.getText());
        nbEmp = (int) s_nbEmp.getValue();
        Date dateDeb = null;

        try {
            dateDeb = Outils.sdf.parse(tf_date.getText());
        } catch (ParseException ex) {
            l_err_date.setText("Erreur format date");
        }
        if (duree <= 0 || nbEmp <= 0 || dateDeb == null) {
            JOptionPane.showMessageDialog(rootPane, "Erreur lors de la saisie du formulaire", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Besoin b = new Besoin(nbEmp);
            Mission m = new Mission(dateDeb, duree, b);
            Entreprise.addMission(m);
            this.idMission = m.getIdM();
            JOptionPane.showMessageDialog(rootPane, "La mission " + m.getIdM() + " a bien été enregistrée.\nVous pouvez renseigner les compétences de la mission.", "Enregistrement de la mission", JOptionPane.INFORMATION_MESSAGE);
            // retour page précédente
            new AjoutBesoinMission(m.getIdM()).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_b_enrgActionPerformed

    private void tf_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dateFocusLost
        try {
            Outils.sdf.parse(tf_date.getText());
        } catch (ParseException ex) {
            l_err_date.setText("Le format de la date est incorrect");
            l_err_date.setForeground(Color.red);
        }
        if (!tf_duree.getText().isEmpty() && !((int) s_nbEmp.getValue() <= 0) && !tf_date.getText().isEmpty()) {
            b_enrg.setEnabled(true);
        } else {
            b_enrg.setEnabled(false);
        }
    }//GEN-LAST:event_tf_dateFocusLost

    private void tf_dateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dateFocusGained
        l_err_date.setText("");
    }//GEN-LAST:event_tf_dateFocusGained

    private void tf_dureeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dureeFocusLost
        int duree;
        try {
            duree = Integer.parseInt(tf_duree.getText());
            if (duree <= 0) {
                l_err_duree.setText("Veuillez rentrer un nombre positif");
                l_err_duree.setForeground(Color.red);
            }
        } catch (NumberFormatException ex) {
            l_err_duree.setText("Veuillez rentrer un nombre positif");
            l_err_duree.setForeground(Color.red);
        }

    }//GEN-LAST:event_tf_dureeFocusLost

    private void s_nbEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_s_nbEmpFocusLost
        if (!tf_duree.getText().isEmpty() && !((int) s_nbEmp.getValue() <= 0) && !tf_date.getText().isEmpty()) {
            b_enrg.setEnabled(true);
        } else {
            b_enrg.setEnabled(false);
        }
    }//GEN-LAST:event_s_nbEmpFocusLost

    private void tf_dureeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_dureeFocusGained
        l_err_duree.setText("");
        if (!tf_duree.getText().isEmpty() && !((int) s_nbEmp.getValue() <= 0) && !tf_date.getText().isEmpty()) {
            b_enrg.setEnabled(true);
        } else {
            b_enrg.setEnabled(false);
        }
    }//GEN-LAST:event_tf_dureeFocusGained

    private void s_nbEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_s_nbEmpFocusGained
        if (!tf_duree.getText().isEmpty() && !((int) s_nbEmp.getValue() <= 0) && !tf_date.getText().isEmpty()) {
            b_enrg.setEnabled(true);
        } else {
            b_enrg.setEnabled(false);
        }
    }//GEN-LAST:event_s_nbEmpFocusGained

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
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutMission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetour;
    private javax.swing.JButton b_enrg;
    private javax.swing.JMenuItem itemAllEmp;
    private javax.swing.JMenuItem itemAllMission;
    private javax.swing.JMenuItem itemNewEmp;
    private javax.swing.JMenuItem itemNewMission;
    private javax.swing.JLabel l_dateDeb;
    private javax.swing.JLabel l_duree;
    private javax.swing.JLabel l_err_date;
    private javax.swing.JLabel l_err_duree;
    private javax.swing.JLabel l_nbEmp;
    private javax.swing.JLabel l_titre;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAccueil;
    private javax.swing.JMenu menuComp;
    private javax.swing.JMenu menuEmploye;
    private javax.swing.JMenu menuMission;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    private javax.swing.JPanel p_infosP;
    private javax.swing.JSpinner s_nbEmp;
    private javax.swing.JFormattedTextField tf_date;
    private javax.swing.JTextField tf_duree;
    // End of variables declaration//GEN-END:variables
}
