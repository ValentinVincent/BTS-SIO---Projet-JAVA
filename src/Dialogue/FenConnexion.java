/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogue;

import Controle.Connexion.ControleConnexion;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class FenConnexion extends javax.swing.JFrame {

    /**
     * Creates new form FenConnexion
     */
    public FenConnexion() {
        initComponents();
        complementGUI();
    }

    private void complementGUI() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo/logo.png")));
        setTitle("GSB_Frais Compta");
    }

    //on fait appel à controle connection pour vérifier s'il y a bien connexion à la bdd avec le MDP et id
    private boolean controleConnexion_Appel() {
        String leNom = jTxt_Nom.getText();
        String leMotDePasse = String.valueOf(jPassword_Mdp.getPassword());
        boolean bControle = false;

        if (ControleConnexion.control(leNom, leMotDePasse)) {
            bControle = true;
        } else {
            JOptionPane.showMessageDialog(null, "Impossible de se connecter "
                    + "à la base de données \n\n"
                    + "Vos noms et mots de passe sont corrects \n"
                    + "Mais les paramètres de pilote de base de données doivent "
                    + "être vérifiées \n Contacter le responsable informatique", "ALERT", JOptionPane.ERROR_MESSAGE);
        }
        return bControle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLab_Ecran = new javax.swing.JLabel();
        jLab_Nom = new javax.swing.JLabel();
        jLab_Mdp = new javax.swing.JLabel();
        jLab_Param = new javax.swing.JLabel();
        jTxt_Nom = new javax.swing.JTextField();
        jPassword_Mdp = new javax.swing.JPasswordField();
        jLab_Minifond = new javax.swing.JLabel();
        jBtn_Valider = new javax.swing.JButton();
        jBtn_Quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLab_Ecran.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLab_Ecran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/ecran.png"))); // NOI18N
        jLab_Ecran.setText("Connexion GSB Frais Comptable");
        jLab_Ecran.setName("jLab_Ecran"); // NOI18N
        getContentPane().add(jLab_Ecran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 460, -1));

        jLab_Nom.setDisplayedMnemonic('u');
        jLab_Nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLab_Nom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/utilisateur.png"))); // NOI18N
        jLab_Nom.setLabelFor(jTxt_Nom);
        jLab_Nom.setText("Utilisateur");
        jLab_Nom.setToolTipText("");
        jLab_Nom.setName("jLab_Nom"); // NOI18N
        getContentPane().add(jLab_Nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLab_Mdp.setDisplayedMnemonic('m');
        jLab_Mdp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLab_Mdp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/key.png"))); // NOI18N
        jLab_Mdp.setLabelFor(jPassword_Mdp);
        jLab_Mdp.setText("Mot de passe");
        jLab_Mdp.setName("jLab_Mdp"); // NOI18N
        getContentPane().add(jLab_Mdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLab_Param.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLab_Param.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/switch-on.png"))); // NOI18N
        jLab_Param.setText("Paramètres de connexion");
        jLab_Param.setName("jLab_Param"); // NOI18N
        jLab_Param.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLab_ParamMouseClicked(evt);
            }
        });
        jLab_Param.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLab_ParamKeyPressed(evt);
            }
        });
        getContentPane().add(jLab_Param, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jTxt_Nom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxt_Nom.setText("Comptable");
        jTxt_Nom.setToolTipText("Saisissez votre identifiant");
        jTxt_Nom.setName("jTxt_Nom"); // NOI18N
        getContentPane().add(jTxt_Nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 180, -1));

        jPassword_Mdp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPassword_Mdp.setText("azerty");
        jPassword_Mdp.setToolTipText("");
        jPassword_Mdp.setName("jPassword_Mdp"); // NOI18N
        getContentPane().add(jPassword_Mdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 180, -1));

        jLab_Minifond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/ban.png"))); // NOI18N
        jLab_Minifond.setName("jLab_Minifond"); // NOI18N
        getContentPane().add(jLab_Minifond, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 420, 180));

        jBtn_Valider.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jBtn_Valider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/valider.png"))); // NOI18N
        jBtn_Valider.setMnemonic('v');
        jBtn_Valider.setText("Valider");
        jBtn_Valider.setToolTipText("");
        jBtn_Valider.setName("jBtn_Valider"); // NOI18N
        jBtn_Valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtn_Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ValiderActionPerformed(evt);
            }
        });
        jBtn_Valider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtn_ValiderKeyPressed(evt);
            }
        });
        getContentPane().add(jBtn_Valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jBtn_Quitter.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jBtn_Quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connexion/quitter.png"))); // NOI18N
        jBtn_Quitter.setMnemonic('q');
        jBtn_Quitter.setText("Quitter");
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
        getContentPane().add(jBtn_Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ValiderActionPerformed
        // Pour un clic sur le bouton
        if (controleConnexion_Appel()) {
            FenMenuPrincipal laFenetre = new FenMenuPrincipal();
            laFenetre.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jBtn_ValiderActionPerformed

    private void jBtn_ValiderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtn_ValiderKeyPressed
        // Pour une touche entrée
        if (evt.getKeyCode() == 10) {
            if (controleConnexion_Appel()) {
                FenMenuPrincipal laFenetre = new FenMenuPrincipal();
                laFenetre.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_jBtn_ValiderKeyPressed

    private void jBtn_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_QuitterActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtn_QuitterActionPerformed

    private void jBtn_QuitterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtn_QuitterKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10) {
            System.exit(0);
        }
    }//GEN-LAST:event_jBtn_QuitterKeyPressed

    private void jLab_ParamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLab_ParamKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLab_ParamKeyPressed

    private void jLab_ParamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab_ParamMouseClicked
        
            FenConnexionBase laFenetre = new FenConnexionBase();
            laFenetre.setVisible(true);
            dispose();
           // TODO add your handling code here:
    }//GEN-LAST:event_jLab_ParamMouseClicked

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
            java.util.logging.Logger.getLogger(FenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenConnexion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Quitter;
    private javax.swing.JButton jBtn_Valider;
    private javax.swing.JLabel jLab_Ecran;
    private javax.swing.JLabel jLab_Mdp;
    private javax.swing.JLabel jLab_Minifond;
    private javax.swing.JLabel jLab_Nom;
    private javax.swing.JLabel jLab_Param;
    private javax.swing.JPasswordField jPassword_Mdp;
    private javax.swing.JTextField jTxt_Nom;
    // End of variables declaration//GEN-END:variables
}
