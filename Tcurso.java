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
public class Tcurso extends javax.swing.JInternalFrame {

     Conexionaca con=new Conexionaca();
    Connection  cnn=con.Conexionacadb();
    PreparedStatement op=null;
    ResultSet rs=null;
    public Tcurso() {
     initComponents();
     tablacurso();
    }
  public void tablacurso(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo Curso");
      tabla.addColumn("Nombre Curso");
      tabla.addColumn("Horas");
      tabla.addColumn("Valor del Curso");
      curso.setModel(tabla);
      String datos[]=new String[4];
      tabla.addRow(datos);
      
       try {
        op=cnn.prepareStatement("SELECT * FROM curso1");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4);  
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
  }
   public void filtrar(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo Curso");
      tabla.addColumn("Nombre Curso");
      tabla.addColumn("Horas");
      tabla.addColumn("Valor del Curso");
      curso.setModel(tabla);
      String datos[]=new String[4];
      tabla.addRow(datos);
      
       try {
        op=cnn.prepareStatement("SELECT * FROM curso1 where Cur_Cod like '%"+filtro.getText()+"%' or Cur_Nom like '%"+filtro.getText()+"%' or Cur_Horas like '%"+filtro.getText()+"%' or Cur_Valor like '%"+filtro.getText()+"%'");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4);  
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
  }
   public void Registrar(){
        try {
            op=cnn.prepareStatement("INSERT INTO Curso1( Cur_Cod , Cur_Nom , Cur_Horas , Cur_Valor) Values (?,?,?,?)");  
              op.setInt(1,Integer.parseInt(COD.getText()));
              op.setString(2,NOM.getText());
              op.setInt(3,Integer.parseInt(HORAS.getText()));
              op.setInt(4,Integer.parseInt(VALOR.getText()));
             
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("eee"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=cnn.prepareStatement("DELETE from  Curso1 WHERE Cur_Cod ='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("eee"+e);
        }
    
    } 
      public void modificar(String cod,String nom,String val,String hor){
        
        try {
         op=cnn.prepareStatement("UPDATE  Curso1 set Cur_Nom='"+nom+"',Cur_Horas='"+hor+"',Cur_Valor='"+val+"' where Cur_Cod='"+cod+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
    }
       public void listardatos(){
     
      int lis=curso.getSelectedRow();
     if(lis>=0){ 
     COD.setText(curso.getValueAt(lis,0).toString());
    NOM.setText(curso.getValueAt(lis,1).toString());
     HORAS.setText(curso.getValueAt(lis,2).toString());
     VALOR.setText(curso.getValueAt(lis,3).toString());
   
     }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        curso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mod = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        COD = new javax.swing.JTextField();
        NOM = new javax.swing.JTextField();
        HORAS = new javax.swing.JTextField();
        VALOR = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CURSO");
        getContentPane().setLayout(null);

        curso.setBackground(new java.awt.Color(255, 204, 255));
        curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        curso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(curso);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 255, 550, 150);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CODIGO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(47, 32, 90, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 70, 90, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HORAS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 110, 90, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VALOR");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 150, 90, 15);

        mod.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mod.setForeground(new java.awt.Color(255, 51, 51));
        mod.setText("MODIFICAR");
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });
        getContentPane().add(mod);
        mod.setBounds(100, 0, 100, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 0, 100, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 0, 100, 20);

        COD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        COD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        COD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CODKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CODKeyTyped(evt);
            }
        });
        getContentPane().add(COD);
        COD.setBounds(160, 30, 140, 21);

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
        NOM.setBounds(160, 70, 240, 21);

        HORAS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        HORAS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        HORAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HORASKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HORASKeyTyped(evt);
            }
        });
        getContentPane().add(HORAS);
        HORAS.setBounds(160, 110, 140, 21);

        VALOR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        VALOR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VALOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                VALORKeyTyped(evt);
            }
        });
        getContentPane().add(VALOR);
        VALOR.setBounds(160, 150, 140, 21);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(0, 0, 100, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("BUSCAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 0, 80, 20);
        getContentPane().add(filtro);
        filtro.setBounds(480, 0, 140, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/aca2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 620, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed
     String c, n, v, h;
       c=COD.getText();
       n=NOM.getText();
       v=VALOR.getText();
       h=HORAS.getText();   
        modificar(c, n, v, h);
       
        tablacurso();
    }//GEN-LAST:event_modActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String dat=COD.getText();
        Eliminar(dat);
        tablacurso();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     COD.setText(null);
     NOM.setText(null);
     HORAS.setText(null);
     VALOR.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     Registrar();
     tablacurso();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CODKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyTyped
       char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                      
    }//GEN-LAST:event_CODKeyTyped

    private void HORASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HORASKeyTyped
       char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                      
    }//GEN-LAST:event_HORASKeyTyped

    private void VALORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VALORKeyTyped
        char c=evt.getKeyChar();
     if (!Character.isDigit(c)){
         evt.consume();
    }                      
    }//GEN-LAST:event_VALORKeyTyped

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
    }                      
    }//GEN-LAST:event_NOMKeyTyped

    private void CODKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER){
        NOM.requestFocus();
    }//GEN-LAST:event_CODKeyPressed
    }
    private void NOMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMKeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER){
       HORAS.requestFocus();
    }//GEN-LAST:event_NOMKeyPressed
    }
    private void HORASKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HORASKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
       VALOR.requestFocus();
    }//GEN-LAST:event_HORASKeyPressed
    }
    private void cursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursoMouseClicked
      listardatos();
    }//GEN-LAST:event_cursoMouseClicked

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        filtrar();
    }//GEN-LAST:event_jButton1KeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    filtrar();
    }//GEN-LAST:event_jButton1MouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField COD;
    private javax.swing.JTextField HORAS;
    private javax.swing.JTextField NOM;
    private javax.swing.JTextField VALOR;
    private javax.swing.JTable curso;
    private javax.swing.JTextField filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mod;
    // End of variables declaration//GEN-END:variables
}
