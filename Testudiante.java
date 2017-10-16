/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACADEMIA;

import Controlador.Conexionaca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kt
 */
public class Testudiante extends javax.swing.JInternalFrame {
  Conexionaca con=new Conexionaca();
    Connection  cnn=con.Conexionacadb();
    PreparedStatement op=null;
    ResultSet rs=null;
    
    public Testudiante() {
        initComponents();
        tablaestudiante();
    }
   public void tablaestudiante(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Documento");
      tabla.addColumn("Nombre Estudiante");
      tabla.addColumn("Apellido");
      tabla.addColumn("Edad");
      estudiante.setModel(tabla);
      String dato[]=new String[4];
      
       try {
        op=cnn.prepareStatement("SELECT * FROM estudiante");
        rs=op.executeQuery();
        while (rs.next()){
         dato[0]=rs.getString(1);
         dato[1]=rs.getString(2);
         dato[2]=rs.getString(3);
         dato[3]=rs.getString(4);  
         tabla.addRow(dato);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
   }
    public void filtrar(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Documento");
      tabla.addColumn("Nombre Estudiante");
      tabla.addColumn("Apellido");
      tabla.addColumn("Edad");
      estudiante.setModel(tabla);
      String dato[]=new String[4];
      
       try {
        op=cnn.prepareStatement("SELECT * FROM estudiante  where Est_Doc like '%"+filtro.getText()+"%' or Est_Nom like '%"+filtro.getText()+"%' or  Est_Apell like '%"+filtro.getText()+"%' or Est_Edad  like '%"+filtro.getText()+"%'");
        rs=op.executeQuery();
        while (rs.next()){
         dato[0]=rs.getString(1);
         dato[1]=rs.getString(2);
         dato[2]=rs.getString(3);
         dato[3]=rs.getString(4);  
         tabla.addRow(dato);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
   }
      public void listardatos(){
     
      int lis=estudiante.getSelectedRow();
     if(lis>=0){ 
    DOC.setText(estudiante.getValueAt(lis,0).toString());
    NOM.setText(estudiante.getValueAt(lis,1).toString());
    APE.setText(estudiante.getValueAt(lis,2).toString());
    EDAD.setText(estudiante.getValueAt(lis,3).toString());
     
     }
      }
    public void Registrar(){
        try {
            op=cnn.prepareStatement("INSERT INTO Estudiante(Est_Doc , Est_Nom , Est_Apell , Est_Edad) Values (?,?,?,?)");  
              op.setString(1,DOC.getText());
              op.setString(2,NOM.getText());
              op.setString(3,APE.getText());
              op.setInt(4,Integer.parseInt(EDAD.getText()));
             
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=cnn.prepareStatement("DELETE from  Estudiante WHERE Est_Doc ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
     
     }
       public void modificar(String doc ,String nom, String ape,String eda){
        
        try {
         op=cnn.prepareStatement("UPDATE Estudiante set Est_Nom='"+nom+"' , Est_Apell='"+ape+"' , Est_Edad='"+eda+"' where Est_Doc ='"+doc+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("error"+e);  
        }
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        estudiante = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NOM = new javax.swing.JTextField();
        APE = new javax.swing.JTextField();
        EDAD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DOC = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ESTUDIANTES");
        getContentPane().setLayout(null);

        estudiante.setBackground(new java.awt.Color(255, 204, 255));
        estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(estudiante);
        estudiante.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 215, 665, 180);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DOCUMENTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(75, 27, 90, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 60, 90, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APELLIDO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 100, 90, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EDAD");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 140, 90, 15);

        NOM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NOM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NOM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NOMKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NOMKeyTyped(evt);
            }
        });
        getContentPane().add(NOM);
        NOM.setBounds(200, 60, 160, 21);

        APE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        APE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        APE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                APEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                APEKeyTyped(evt);
            }
        });
        getContentPane().add(APE);
        APE.setBounds(200, 100, 160, 21);

        EDAD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        EDAD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EDAD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EDADKeyTyped(evt);
            }
        });
        getContentPane().add(EDAD);
        EDAD.setBounds(200, 140, 70, 21);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("MODIFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 0, 100, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 51));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 0, 90, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 51));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(290, 0, 110, 20);

        DOC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        DOC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DOC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DOCKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DOCKeyTyped(evt);
            }
        });
        getContentPane().add(DOC);
        DOC.setBounds(200, 30, 160, 20);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 51));
        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 0, 89, 20);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("BUSCAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(400, 0, 80, 20);
        getContentPane().add(filtro);
        filtro.setBounds(480, 0, 180, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/academia.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-20, 0, 710, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String d, n, a, e;
       d=DOC.getText();
       n=NOM.getText();
       a=APE.getText();
       e=EDAD.getText();
        modificar(d, n, a, e);
    tablaestudiante();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String dat=DOC.getText();
        Eliminar(dat);
        tablaestudiante();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       DOC.setText(null);
       NOM.setText(null);
       APE.setText(null);
       EDAD.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void NOMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMKeyTyped
    String texto= NOM.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
       NOM.setText(texto);
    }   
        char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_NOMKeyTyped
    }
    private void APEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APEKeyTyped
      String texto= APE.getText();
    if(texto.length()>0) {
         char primeraletra=texto.charAt(0);
         texto=Character.toUpperCase(primeraletra)+texto.substring(1, texto.length() );
        APE.setText(texto);
      
    }
        
        char c=evt.getKeyChar();
     if (Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_APEKeyTyped
    }
    private void EDADKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EDADKeyTyped
  char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    
    }//GEN-LAST:event_EDADKeyTyped
    }
    private void DOCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCKeyTyped
      char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }//GEN-LAST:event_DOCKeyTyped
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      Registrar();
      tablaestudiante();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DOCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
        NOM.requestFocus();
      }
    }//GEN-LAST:event_DOCKeyPressed

    private void NOMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
        APE.requestFocus();
    }//GEN-LAST:event_NOMKeyPressed
    }
    private void APEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APEKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
        EDAD.requestFocus();
    }//GEN-LAST:event_APEKeyPressed
    }
    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
      filtrar();
    }//GEN-LAST:event_jButton5KeyPressed

    private void estudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estudianteMouseClicked
     listardatos();
    }//GEN-LAST:event_estudianteMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
       filtrar();
    }//GEN-LAST:event_jButton5MouseClicked
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField APE;
    private javax.swing.JTextField DOC;
    private javax.swing.JTextField EDAD;
    private javax.swing.JTextField NOM;
    private javax.swing.JTable estudiante;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
