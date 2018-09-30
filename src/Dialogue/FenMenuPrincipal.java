/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogue;

import Controle.Connexion.ControleConnexion;
import Controle.Fonctions.GestionDates;
import Controle.Fonctions.Mois;
import Entité.FicheFrais;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FenMenuPrincipal extends javax.swing.JFrame {

    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();

    /**
     * Creates new form FenMenuPrincipal
     */
    public FenMenuPrincipal() {
        initComponents();
        complementGUI();
    }

    private void complementGUI() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo/logo.png")));
        setTitle("GSB_Frais Compta");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLab_NomMenu = new javax.swing.JLabel();
        jBtn_Cloturer = new javax.swing.JButton();
        jBtn_Valider = new javax.swing.JButton();
        jBtn_Payer = new javax.swing.JButton();
        jBtn_Visualiser = new javax.swing.JButton();
        jBtn_Quitter = new javax.swing.JButton();
        jLab_Fond2 = new javax.swing.JLabel();
        jLab_Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLab_NomMenu.setBackground(new java.awt.Color(255, 255, 255));
        jLab_NomMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLab_NomMenu.setForeground(new java.awt.Color(255, 255, 255));
        jLab_NomMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo/logo.png"))); // NOI18N
        jLab_NomMenu.setText("GSB Frais Comptable");
        jLab_NomMenu.setToolTipText("");
        jLab_NomMenu.setName("jLab_NomMenu"); // NOI18N
        getContentPane().add(jLab_NomMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jBtn_Cloturer.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Cloturer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtn_Cloturer.setText("Clôturer les fiches du mois");
        jBtn_Cloturer.setName("jBtn_Cloturer"); // NOI18N
        jBtn_Cloturer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Cloturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_CloturerActionPerformed(evt);
            }
        });
        getContentPane().add(jBtn_Cloturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 200, 30));

        jBtn_Valider.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Valider.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtn_Valider.setText("Valider les fiches de frais");
        jBtn_Valider.setName("jBtn_Valider"); // NOI18N
        jBtn_Valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ValiderActionPerformed(evt);
            }
        });
        getContentPane().add(jBtn_Valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, -1));

        jBtn_Payer.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Payer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtn_Payer.setText("Payer les fiches de frais");
        jBtn_Payer.setName("jBtn_Payer"); // NOI18N
        jBtn_Payer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Payer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_PayerActionPerformed(evt);
            }
        });
        getContentPane().add(jBtn_Payer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 200, -1));

        jBtn_Visualiser.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Visualiser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtn_Visualiser.setText("Visualiser les fiches de frais");
        jBtn_Visualiser.setName("jBtn_Visualiser"); // NOI18N
        jBtn_Visualiser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Visualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_VisualiserActionPerformed(evt);
            }
        });
        getContentPane().add(jBtn_Visualiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 200, -1));

        jBtn_Quitter.setBackground(new java.awt.Color(204, 204, 204));
        jBtn_Quitter.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jBtn_Quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accueil/quitter1.png"))); // NOI18N
        jBtn_Quitter.setMnemonic('q');
        jBtn_Quitter.setToolTipText("");
        jBtn_Quitter.setName("jBtn_Quitter"); // NOI18N
        jBtn_Quitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_QuitterActionPerformed(evt);
            }
        });
        jBtn_Quitter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtn_QuitterKeyPressed(evt);
            }
        });
        getContentPane().add(jBtn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        jLab_Fond2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLab_Fond2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond/fond_blanc.png"))); // NOI18N
        jLab_Fond2.setToolTipText("");
        jLab_Fond2.setName("jLab_Fond2"); // NOI18N
        getContentPane().add(jLab_Fond2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 1040, 660));

        jLab_Fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond/fond2.png"))); // NOI18N
        jLab_Fond.setToolTipText("");
        jLab_Fond.setName("jLab_Fond"); // NOI18N
        getContentPane().add(jLab_Fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBtn_QuitterActionPerformed

    private void jBtn_QuitterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtn_QuitterKeyPressed
        if (evt.getKeyCode() == 10) {
            System.exit(0);
        }
    }//GEN-LAST:event_jBtn_QuitterKeyPressed

    private void jBtn_CloturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_CloturerActionPerformed
        // TODO add your handling code here:
        FicheFrais laFiche = new FicheFrais("CR", "", "");
        //récupérer le mois
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String mois = (sdf.format(cal.getTime()));

        String leMois = GestionDates.MoisAvant(mois);
        Mois lMois = new Mois();
        //Boite de dialogue pour confirmer la cloture de la fiche
        int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous clôturer les fiches de frais du mois de "
                + lMois.Nommois(leMois), "Clôture", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            laFiche.Modifier(leMois, "CL");
            laFiche.Supprimer(mois);
            JOptionPane.showMessageDialog(null, "Les fiches de frais ont été clôturées ", "Clôture", JOptionPane.INFORMATION_MESSAGE);
            laFiche.Generer(mois);
        } else {
            JOptionPane.showMessageDialog(null, "Annulation de la clôture", "Clôture", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBtn_CloturerActionPerformed

    private void jBtn_ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ValiderActionPerformed
        FenListeUserValider laFenetre = new FenListeUserValider();
        laFenetre.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBtn_ValiderActionPerformed

    private void jBtn_VisualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_VisualiserActionPerformed
        FenVisualiserUserTrier laFenetre = new FenVisualiserUserTrier();
        laFenetre.setVisible(true);
        dispose();
    }//GEN-LAST:event_jBtn_VisualiserActionPerformed

    private void jBtn_PayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_PayerActionPerformed
        FenListerPayer laFenetre = new FenListerPayer();
        laFenetre.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jBtn_PayerActionPerformed

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
            java.util.logging.Logger.getLogger(FenMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenMenuPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Cloturer;
    private javax.swing.JButton jBtn_Payer;
    private javax.swing.JButton jBtn_Quitter;
    private javax.swing.JButton jBtn_Valider;
    private javax.swing.JButton jBtn_Visualiser;
    private javax.swing.JLabel jLab_Fond;
    private javax.swing.JLabel jLab_Fond2;
    private javax.swing.JLabel jLab_NomMenu;
    // End of variables declaration//GEN-END:variables
}
