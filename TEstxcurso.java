

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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kt
 */
public class TEstxcurso extends javax.swing.JInternalFrame {

  
     Conexionaca con=new Conexionaca();
    Connection  cnn=con.Conexionacadb();
    PreparedStatement op=null;
    ResultSet rs=null;
    public TEstxcurso() {
        initComponents();
        tablaestxcurso();
        cargarcombo();
        cargarcodigo();
    }
public void tablaestxcurso(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo Curso");
      tabla.addColumn("Documento Estudiante");
      tabla.addColumn("Fecha de Inicio");
      estxcur.setModel(tabla);
      String datos[]=new String[3];
      tabla.addRow(datos);
      
       try {
        op=cnn.prepareStatement("SELECT * FROM estudiantexcurso1");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3); 
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
}
  public void listardatos(){
      int lis=estxcur.getSelectedRow();
     if(lis>=0){ 
     COD.setSelectedItem(estxcur.getValueAt(lis,0).toString());
     DOCU.setSelectedItem(estxcur.getValueAt(lis,1).toString());
     FECHA.setText(estxcur.getValueAt(lis,2).toString());
     
     }
  }
public void filtrar(){
     DefaultTableModel tabla=new DefaultTableModel ();
      tabla.addColumn("Codigo Curso");
      tabla.addColumn("Documento Estudiante");
      tabla.addColumn("Fecha de Inicio");
      estxcur.setModel(tabla);
      String datos[]=new String[3];
      tabla.addRow(datos);
      
       try {
        op=cnn.prepareStatement("SELECT * FROM estudiantexcurso1 where Estcur_Cur_Cod like '%"+filtro.getText()+"%' or Estcur_Doc_Est like '%"+filtro.getText()+"%'or Estcur_fec_Ini like '%"+filtro.getText()+"%'");
        rs=op.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3); 
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
}
public void Registrar(){
        try {
            op=cnn.prepareStatement("INSERT INTO ESTUDIANTEXCURSO1(Estcur_Cur_Cod,Estcur_Doc_Est,Estcur_fec_Ini) Values ( ?,?,?)");  
              op.setInt(1,Integer.parseInt(COD.getSelectedItem().toString()));
              op.setString(2,DOCU.getSelectedItem().toString());
              op.setString(3,FECHA.getText());
             op.executeUpdate();
             JOptionPane.showMessageDialog(null,"Datos Guardados");
             
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    
    }
     public void Eliminar(String dat){
    try {
   op=cnn.prepareStatement("DELETE from ESTUDIANTEXCURSO1 WHERE Estcur_Cur_Cod='"+dat+"'");
      op.executeUpdate();
      JOptionPane.showMessageDialog(null,"Datos Eliminados");
        } catch (Exception e) {
             System.out.println("error"+e);
        }
    } 
     public void cargarcombo(){
        try {
            DOCU.removeAll();
            DOCU.addItem("SELECCIONE DOCUMENTO");
          op=cnn.prepareStatement("Select Est_Doc from  Estudiante ");
          rs=op.executeQuery();
         while(rs.next()){
             String aux=rs.getString("Est_Doc");
             this.DOCU.addItem(aux);
         }
  
        } catch (Exception e) {
        }
     }
   public void cargarcodigo(){
        try {
            COD.removeAll();
            COD.addItem("SELECCIONE CODIGO");
          op=cnn.prepareStatement("Select Cur_Cod  from Curso1 ");
          rs=op.executeQuery();
         while(rs.next()){
             String aux=rs.getString("Cur_Cod");
             this.COD.addItem(aux);
         }
  
        } catch (Exception e) {
        }
     }
     public void modificar(String da,String doc, String FE ){
        
        try {
         op=cnn.prepareStatement("UPDATE  ESTUDIANTEXCURSO1 set Estcur_fec_Ini='"+FE+"',Estcur_Doc_Est='"+doc+"' where Estcur_Cur_Cod='"+da+"'");
           op.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos modificados");
            
        } catch (Exception e) {
         System.out.println("eee"+e);  
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FECHA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DOCU = new javax.swing.JComboBox<>();
        COD = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        estxcur = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ESTUDIANTE X CURSO");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CODIGO CURSO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(65, 42, 100, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DOCUMENTO ESTUDIANTE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(14, 84, 160, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FECHA INICIO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(64, 124, 100, 20);

        FECHA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        FECHA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FECHA.setToolTipText("");
        FECHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FECHAKeyTyped(evt);
            }
        });
        getContentPane().add(FECHA);
        FECHA.setBounds(200, 120, 180, 30);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 153));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 100, 20);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 153));
        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 0, 100, 20);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 153));
        jButton3.setText("LIMPÌAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 0, 100, 20);

        DOCU.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DOCU.setForeground(new java.awt.Color(255, 0, 0));
        DOCU.setToolTipText("");
        DOCU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DOCUKeyPressed(evt);
            }
        });
        getContentPane().add(DOCU);
        DOCU.setBounds(200, 80, 180, 30);

        COD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        COD.setForeground(new java.awt.Color(255, 0, 0));
        COD.setToolTipText("");
        COD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CODKeyPressed(evt);
            }
        });
        getContentPane().add(COD);
        COD.setBounds(200, 40, 180, 30);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 153));
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(100, 0, 100, 20);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(255, 0, 204));
        jButton5.setText("BUSCAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(400, 0, 80, 20);
        getContentPane().add(filtro);
        filtro.setBounds(480, 0, 150, 20);

        estxcur.setBackground(new java.awt.Color(255, 204, 255));
        estxcur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        estxcur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estxcurMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(estxcur);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 561, 140);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/acade.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 630, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Registrar();
      tablaestxcurso();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String dat=COD.getSelectedItem().toString();
        Eliminar(dat);
        tablaestxcurso();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     COD.removeAllItems();
     cargarcodigo();
      DOCU.removeAllItems();
     cargarcombo();
     FECHA.setText(null);
    }//GEN-LAST:event_jButton3ActionPerformed
        
    private void FECHAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FECHAKeyTyped
       char caracter=evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) &&(caracter !='-')){ 
              evt.consume();
        }     
    }//GEN-LAST:event_FECHAKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      String d,da,f;
      d=COD.getSelectedItem().toString();
      da=DOCU.getSelectedItem().toString();
       f=FECHA.getText();
        modificar(d, da, f);
        tablaestxcurso();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CODKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CODKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
        DOCU.requestFocus();
    }                            
    }//GEN-LAST:event_CODKeyPressed

    private void DOCUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DOCUKeyPressed
         if(evt.getKeyCode()==evt.VK_ENTER){
        FECHA.requestFocus();
    }                            
    }//GEN-LAST:event_DOCUKeyPressed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
  filtrar();
    }//GEN-LAST:event_jButton5MouseClicked

    private void estxcurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estxcurMouseClicked
    listardatos();
    }//GEN-LAST:event_estxcurMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> COD;
    private javax.swing.JComboBox<String> DOCU;
    private javax.swing.JTextField FECHA;
    private javax.swing.JTable estxcur;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
