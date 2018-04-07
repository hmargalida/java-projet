/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Competence;
import Modele.Entreprise;
import Modele.Personnel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;

/**
 *
 * @author heloise
 */
public class AjoutComp extends javax.swing.JFrame {
    private int idp;
    private String nomEmp;
    private String prenomEmp;
    private Personnel p;
    private ArrayList<String> compEmp ;
    private ArrayList<String> compEntreprise;

    /**
     * Creates new form AjoutComp
     */
    public AjoutComp(int idp, String nom, String prenom) {
        initComponents();
        b_ajoutComp.setEnabled(false);
        b_removeComp.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.idp = idp;
        this.nomEmp = nom;
        this.prenomEmp = prenom;
        this.p = Entreprise.getEmploye(idp);
        l_nom_prenom.setText(this.prenomEmp + " " + this.nomEmp);
        initList();
    }

    public void initList() {
        compEmp = new ArrayList<>();
        compEntreprise = new ArrayList<>();
        // mise a zéro des listes de compétences 
        list_compEmp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_compEntr.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        // remplissage des listes
        // compétences de l'employé
        for(Competence c : p.getCompPers()) {
            compEmp.add(c.getIdComp() + " - " + c.getCompFR());
        }
        list_compEmp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] elements = compEmp.toArray(new String[compEmp.size()]);
            public int getSize() { return elements.length; }
            public String getElementAt(int i) { return elements[i]; }
        });
        
        // compétences de l'entreprise
        for(String idc : Entreprise.competences.keySet()) {
            String compI = Entreprise.getCompetence(idc).getCompFR();
            String id = Entreprise.getCompetence(idc).getIdComp();
            if (!compEmp.contains(id + " - " + compI)) {
                compEntreprise.add(idc + " - " +compI);
            }
        }
        list_compEntr.setModel(new javax.swing.AbstractListModel<String>() {
            String[] elements = compEntreprise.toArray(new String[compEntreprise.size()]);
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
        l_nom_prenom = new javax.swing.JLabel();
        pPage = new javax.swing.JPanel();
        lTitreListe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_compEntr = new javax.swing.JList<>();
        lTitreListe1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_compEmp = new javax.swing.JList<>();
        b_ajoutComp = new javax.swing.JButton();
        b_removeComp = new javax.swing.JButton();
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
        l_titre.setText("Ajout/Modifications des compétences de ");

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
                .addContainerGap(21, Short.MAX_VALUE))
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

        lTitreListe.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        lTitreListe.setText("Compétences disponibles");

        list_compEntr.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list_compEntr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list_compEntrMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(list_compEntr);

        lTitreListe1.setFont(new java.awt.Font("American Typewriter", 0, 14)); // NOI18N
        lTitreListe1.setText("Compétences de l'employé");

        list_compEmp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list_compEmp);

        b_ajoutComp.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        b_ajoutComp.setText(">");
        b_ajoutComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ajoutCompActionPerformed(evt);
            }
        });

        b_removeComp.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        b_removeComp.setText("<");

        javax.swing.GroupLayout pPageLayout = new javax.swing.GroupLayout(pPage);
        pPage.setLayout(pPageLayout);
        pPageLayout.setHorizontalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addContainerGap(76, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_ajoutComp)
                            .addComponent(b_removeComp))
                        .addGap(47, 47, 47))
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lTitreListe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPageLayout.createSequentialGroup()
                        .addComponent(lTitreListe1)
                        .addGap(42, 42, 42)))
                .addGap(47, 47, 47))
        );
        pPageLayout.setVerticalGroup(
            pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPageLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addComponent(lTitreListe1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pPageLayout.createSequentialGroup()
                        .addComponent(lTitreListe, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pPageLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(b_ajoutComp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(b_removeComp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(81, Short.MAX_VALUE))
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
            .addComponent(pBandeau, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
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

    private void b_ajoutCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ajoutCompActionPerformed
        String value = list_compEntr.getSelectedValue();
        String id = value.split("-")[0].trim();
        this.p.addCompetencePers(Entreprise.getCompetence(id));
        //this.compEntreprise.remove(value);
        initList();
    }//GEN-LAST:event_b_ajoutCompActionPerformed

    private void list_compEntrMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_compEntrMousePressed
        b_ajoutComp.setEnabled(true);
    }//GEN-LAST:event_list_compEntrMousePressed

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
            java.util.logging.Logger.getLogger(AjoutComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AjoutComp(nomEmp, prenomEmp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetour;
    private javax.swing.JButton b_ajoutComp;
    private javax.swing.JButton b_removeComp;
    private javax.swing.JMenuItem itemAllEmp;
    private javax.swing.JMenuItem itemAllMission;
    private javax.swing.JMenuItem itemNewEmp;
    private javax.swing.JMenuItem itemNewMission;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lTitreListe;
    private javax.swing.JLabel lTitreListe1;
    private javax.swing.JLabel l_nom_prenom;
    private javax.swing.JLabel l_titre;
    private javax.swing.JList<String> list_compEmp;
    private javax.swing.JList<String> list_compEntr;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAccueil;
    private javax.swing.JMenu menuEmploye;
    private javax.swing.JMenu menuMission;
    private javax.swing.JPanel pBandeau;
    private javax.swing.JPanel pPage;
    // End of variables declaration//GEN-END:variables
}
