/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogue;

import Controle.Fonctions.GestionDates;
import Controle.Fonctions.Mois;
import Entité.FicheFrais;
import Modele.ModeleFicheFrais;
import Modele.RenderDate;
import Modele.RenderDouble;
import Modele.RenderMois;
import Modele.RenderNum;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FenListerPayer extends javax.swing.JFrame {

    // On fait appel au controler de ModeleFicheFrais qui prend en paramètre le "IdEtat" qu'on rentre en dur
    private ModeleFicheFrais leModeleFicheFrais = new ModeleFicheFrais("VA");

    /**
     * Creates new form FenMenuPrincipal
     */
    // On change le format du contenu des cellules du tableau
    public FenListerPayer() {
        initComponents();
        complementGUI();
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new RenderDate());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new RenderNum());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new RenderDouble());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new RenderMois());
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
        jBtn_Quitter = new javax.swing.JButton();
        jBtn_Retour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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

        jBtn_Retour.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jBtn_Retour.setText("Retour");
        jBtn_Retour.setName("jBtn_Retour"); // NOI18N
        jBtn_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_RetourActionPerformed(evt);
            }
        });
        getContentPane().add(jBtn_Retour, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));

        jTable1.setModel(leModeleFicheFrais);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 710, 660));

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

    private void jBtn_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_RetourActionPerformed
        FenMenuPrincipal laFen = new FenMenuPrincipal();
        laFen.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jBtn_RetourActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Date du jour
        Calendar cale = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateJ = (sdf.format(cale.getTime()));
        Date dateJJ;
        try {
            dateJJ = GestionDates.chaineENversDateJava(dateJ);
          Date dateJJJ = GestionDates.dateJavaEnDateSQL(dateJJ);
       
        int numLigne = jTable1.getSelectedRow();
        String visiteur = String.valueOf(jTable1.getValueAt(numLigne, 0));
        String lemois = String.valueOf(jTable1.getValueAt(numLigne, 3));
        FicheFrais laFiche = new FicheFrais("", visiteur, lemois);

        if (evt.getClickCount() == 2) {
            int rep = JOptionPane.showConfirmDialog(null, "Voulez-vous rembourser les fiches de frais du mois de "
                    + lemois, "Rembourser", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                laFiche.Modifier(visiteur, lemois, dateJJJ, "RB");
                JOptionPane.showMessageDialog(null, "Les fiches de frais ont été remboursés ", "Rembourser", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Annulation du remboursement", "rembourser", JOptionPane.INFORMATION_MESSAGE);
            }
        }
         } catch (ParseException ex) {
            Logger.getLogger(FenListerPayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(FenListerPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenListerPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenListerPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenListerPayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FenListerPayer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Quitter;
    private javax.swing.JButton jBtn_Retour;
    private javax.swing.JLabel jLab_Fond;
    private javax.swing.JLabel jLab_Fond2;
    private javax.swing.JLabel jLab_NomMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
