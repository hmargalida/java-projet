/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Entreprise;
import Modele.Mission;
import Modele.Besoin;
import Modele.Competence;
import Modele.FormatFichierException;
import Modele.NbEmployeDepasseException;
import Modele.Outils;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heloise
 */
public class AjoutBesoinMission extends javax.swing.JFrame {
    private static int idMission=0;
    private Mission m;
    private Besoin b;

    /**
     * Creates new form AjoutBesoinMission
     * @param idm Identifiant de la mission
     */
    public AjoutBesoinMission(int idm) {
        initComponents();
        this.setLocationRelativeTo(null);
        idMission = idm;
        m = Entreprise.getMission(idMission);
        b = m.getBesoins();
        
        l_besoinVal.setText(String.valueOf(b.getNbPersNecessaire()));
        ArrayList<String> strings = new ArrayList<>();
        for(String comp : Entreprise.competences.keySet()) {
            strings.add(Entreprise.getCompetence(comp).getIdComp()+ " - " + Entreprise.getCompetence(comp).getCompFR());
        }
        list_comp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] elements = strings.toArray(new String[strings.size()]);
            public int getSize() { return elements.length; }
            public String getElementAt(int i) { return elements[i]; }
        });
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
        p_comp = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_comp = new javax.swing.JList<>();
        s_nbEmpComp = new javax.swing.JSpinner();
        l_titrelist = new javax.swing.JLabel();
        l_titreSpinner = new javax.swing.JLabel();
        b_ajouter = new javax.swing.JButton();
        l_compAjoutee = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_tabCompAjoutee = new javax.swing.JTable();
        b_retourMission = new javax.swing.JButton();
        l_besoin = new javax.swing.JLabel();
        l_besoinVal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(790, 605));
        setMinimumSize(new java.awt.Dimension(790, 605));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pBandeau.setBackground(new java.awt.Color(255, 153, 51));
        pBandeau.setPreferredSize(new java.awt.Dimension(317, 73));

        l_titre.setFont(new java.awt.Font("Lucida Grande", 0, 22)); // NOI18N
        l_titre.setText("Ajout d'une mission (2/2)");

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

        p_comp.setBorder(javax.swing.BorderFactory.createTitledBorder("Compétences nécessaires à la mission"));

        list_comp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list_compMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(list_comp);

        s_nbEmpComp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 500, 1));
        s_nbEmpComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_nbEmpCompMousePressed(evt);
            }
        });

        l_titrelist.setText("Compétences disponibles :");

        l_titreSpinner.setText("Nombre d'employé nécessaire :");

        b_ajouter.setText("Ajouter");
        b_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ajouterActionPerformed(evt);
            }
        });

        l_compAjoutee.setText("Compétences ajoutées :");

        t_tabCompAjoutee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libellé de la compétence", "Nombre d'employé nécessaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(t_tabCompAjoutee);

        javax.swing.GroupLayout p_compLayout = new javax.swing.GroupLayout(p_comp);
        p_comp.setLayout(p_compLayout);
        p_compLayout.setHorizontalGroup(
            p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_compLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_compLayout.createSequentialGroup()
                        .addGroup(p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_titrelist)
                            .addGroup(p_compLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_titreSpinner)
                                    .addComponent(s_nbEmpComp, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(111, Short.MAX_VALUE))
                    .addGroup(p_compLayout.createSequentialGroup()
                        .addGroup(p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_compAjoutee)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        p_compLayout.setVerticalGroup(
            p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_compLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(l_titrelist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_compLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(p_compLayout.createSequentialGroup()
                        .addComponent(l_titreSpinner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_nbEmpComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(l_compAjoutee, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        b_retourMission.setText("Retour page Mission");
        b_retourMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_retourMissionActionPerformed(evt);
            }
        });

        l_besoin.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        l_besoin.setText("Besoin total pour la mission : ");

        l_besoinVal.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPageLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addComponent(l_besoin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_besoinVal))
                    .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(b_retourMission)
                        .addComponent(p_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_besoin)
                    .addComponent(l_besoinVal))
                .addGap(14, 14, 14)
                .addComponent(p_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_retourMission, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list_compMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_compMousePressed
        s_nbEmpComp.setValue(Integer.valueOf(0));
        String row = list_comp.getSelectedValue();
        String idComp = row.split("-")[0].trim();
        int valueSpinner = (int)s_nbEmpComp.getValue();
    }//GEN-LAST:event_list_compMousePressed

    private void s_nbEmpCompMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_nbEmpCompMousePressed
        String row = list_comp.getSelectedValue();
        String idComp = row.split("-")[0].trim();
        int valueSpinner = (int)s_nbEmpComp.getValue();
    }//GEN-LAST:event_s_nbEmpCompMousePressed

    private void b_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ajouterActionPerformed
        String row = list_comp.getSelectedValue();
        String idComp = row.split("-")[0].trim();
        int valueSpinner = (int)s_nbEmpComp.getValue();
        if (idComp!=null && valueSpinner!=0 && idMission!=0) {
            try {
                b.besoinParCompetence(Entreprise.getCompetence(idComp), valueSpinner);
            } catch (NbEmployeDepasseException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage() , "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            DefaultTableModel model = (DefaultTableModel) t_tabCompAjoutee.getModel();
            model.setRowCount(0);
            for (Competence comp : b.getMapBesoins().keySet()) {
                int c = b.getMapBesoins().get(comp);
                model.addRow(new Object[]{comp.getCompFR(), c});
            }
        }
    }//GEN-LAST:event_b_ajouterActionPerformed

    private void b_retourMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_retourMissionActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_retourMissionActionPerformed

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

    private void bRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetourActionPerformed
        new GestionMission(Entreprise.missions).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bRetourActionPerformed

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
            java.util.logging.Logger.getLogger(AjoutBesoinMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutBesoinMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutBesoinMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutBesoinMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutBesoinMission(idMission).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetour;
    private javax.swing.JButton b_ajouter;
    private javax.swing.JButton b_retourMission;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_besoin;
    private javax.swing.JLabel l_besoinVal;
    private javax.swing.JLabel l_compAjoutee;
    private javax.swing.JLabel l_titre;
    private javax.swing.JLabel l_titreSpinner;
    private javax.swing.JLabel l_titrelist;
    private javax.swing.JList<String> list_comp;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    private javax.swing.JPanel p_comp;
    private javax.swing.JSpinner s_nbEmpComp;
    private javax.swing.JTable t_tabCompAjoutee;
    // End of variables declaration//GEN-END:variables
}
