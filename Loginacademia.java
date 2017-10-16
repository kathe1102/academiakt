/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACADEMIA;

import Controlador.Conexionaca;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kt
 */
public class Loginacademia extends javax.swing.JFrame {
    Conexionaca con=new Conexionaca();
    Connection cnn=con.Conexionacadb(); 
    
    public Loginacademia() {
        initComponents();
    }
public void validarusuario(String pro,String clav ){
    PreparedStatement op=null;
        ResultSet rs=null;
        try{
            
        op=cnn.prepareStatement("SELECT *FROM  profesor WHERE Pro_Nom ='"+pro+"'AND Pro_clave ='"+clav+"'");
        rs=op.executeQuery();
        if(rs.next()){
          Macademia cap=new Macademia();
          cap.setLocationRelativeTo(null);
          cap.setSize(800,600);
            cap.setVisible(true);
            
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"Datos no Validos");
        }
        }
        catch (Exception e){
            System.out.print("Error"+e);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usua = new javax.swing.JTextField();
        clave = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 50, 69, 35);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 255));
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(93, 203, 130, 65);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(65, 105, 52, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 255));
        jLabel3.setText("CONTRASEÑA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(56, 147, 79, 15);

        usua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuaKeyTyped(evt);
            }
        });
        getContentPane().add(usua);
        usua.setBounds(139, 103, 124, 20);

        clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                claveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                claveKeyTyped(evt);
            }
        });
        getContentPane().add(clave);
        clave.setBounds(139, 145, 124, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/LOGIN2.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 310, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String p,c;
    p=usua.getText();
    c=clave.getText();
        validarusuario(p, c);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuaKeyTyped
  
    }//GEN-LAST:event_usuaKeyTyped

    private void claveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveKeyTyped

    }//GEN-LAST:event_claveKeyTyped

    private void usuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuaKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
 clave.requestFocus();
   }
    }//GEN-LAST:event_usuaKeyPressed

    private void claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
   jButton1.requestFocus();
   }
    }//GEN-LAST:event_claveKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
  if(evt.getKeyCode()==evt.VK_ENTER){
   jButton1.doClick();
   }
    }//GEN-LAST:event_jButton1KeyPressed

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
            java.util.logging.Logger.getLogger(Loginacademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginacademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginacademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginacademia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginacademia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField clave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField usua;
    // End of variables declaration//GEN-END:variables
}
