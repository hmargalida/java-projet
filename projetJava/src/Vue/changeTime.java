/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Outils;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JSlider;

/**
 *
 * @author heloise
 */
public class changeTime extends javax.swing.JFrame {
    protected GregorianCalendar calendar = new GregorianCalendar();
    /**
     * Creates new form changeTime
     */
    public changeTime() {
        initComponents();
        jLabel3.setText(Outils.sdf.format(Outils.dateAuj));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        s_annee = new JSlider(JSlider.HORIZONTAL, 2017, 2025, calendar.get(Calendar.YEAR));
        s_mois = new JSlider(JSlider.HORIZONTAL, 1, 12, calendar.get(Calendar.MONTH) + 1);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        s_jour = new javax.swing.JSlider(JSlider.HORIZONTAL, 1, maxDays, calendar.get(Calendar.DAY_OF_MONTH));
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(4, 0));

        s_annee.setMajorTickSpacing(1);
        s_annee.setPaintTicks(true);
        s_annee.setSnapToTicks(true);
        s_annee.setBorder(javax.swing.BorderFactory.createTitledBorder("Année"));
        s_annee.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                s_anneeStateChanged(evt);
            }
        });
        getContentPane().add(s_annee);

        s_mois.setMajorTickSpacing(1);
        s_mois.setPaintTicks(true);
        s_mois.setPaintTrack(false);
        s_mois.setSnapToTicks(true);
        s_mois.setBorder(javax.swing.BorderFactory.createTitledBorder("Mois"));
        s_mois.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                s_moisStateChanged(evt);
            }
        });
        getContentPane().add(s_mois);

        s_jour.setMajorTickSpacing(1);
        s_jour.setPaintTicks(true);
        s_jour.setSnapToTicks(true);
        s_jour.setBorder(javax.swing.BorderFactory.createTitledBorder("Jour"));
        s_jour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                s_jourStateChanged(evt);
            }
        });
        getContentPane().add(s_jour);

        jLabel3.setText("Date sélectionnée : ");
        getContentPane().add(jLabel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void s_anneeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_s_anneeStateChanged
        jLabel3.setText(s_jour.getValue() + "/" + s_mois.getValue() + "/" + s_annee.getValue());
    }//GEN-LAST:event_s_anneeStateChanged

    private void s_moisStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_s_moisStateChanged
        jLabel3.setText(s_jour.getValue() + "/" + s_mois.getValue() + "/" + s_annee.getValue());
    }//GEN-LAST:event_s_moisStateChanged

    private void s_jourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_s_jourStateChanged
        System.out.println(calendar.DAY_OF_MONTH + " " + calendar.getActualMaximum(calendar.DAY_OF_MONTH));
        jLabel3.setText(s_jour.getValue() + "/" + s_mois.getValue() + "/" + s_annee.getValue());
    }//GEN-LAST:event_s_jourStateChanged

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
            java.util.logging.Logger.getLogger(changeTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changeTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changeTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changeTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSlider s_annee;
    private javax.swing.JSlider s_jour;
    private javax.swing.JSlider s_mois;
    // End of variables declaration//GEN-END:variables
}
