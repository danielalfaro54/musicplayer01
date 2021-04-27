/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Validators.Usuario;
import Validators.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Lighthouse
 */
public class Registro extends javax.swing.JFrame implements Observer {

   /**
    * Creates new form Registro
    */
   public Registro() {
      initComponents();
   }
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lnameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        birthyear = new javax.swing.JComboBox<>();
        birthday = new javax.swing.JComboBox<>();
        birthmonth = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Novae", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 10, 70, 30);

        nameField.setBackground(new java.awt.Color(0, 0, 0));
        nameField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nameField);
        nameField.setBounds(150, 10, 190, 30);

        jLabel2.setFont(new java.awt.Font("Novae", 0, 14)); // NOI18N
        jLabel2.setText("Apellido");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 70, 70, 19);

        lnameField.setBackground(new java.awt.Color(0, 0, 0));
        lnameField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        lnameField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lnameField);
        lnameField.setBounds(150, 70, 190, 30);

        jLabel3.setFont(new java.awt.Font("Novae", 0, 14)); // NOI18N
        jLabel3.setText("E-mail");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 190, 60, 20);

        userField.setBackground(new java.awt.Color(0, 0, 0));
        userField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        userField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(userField);
        userField.setBounds(150, 130, 190, 30);

        jLabel4.setFont(new java.awt.Font("Novae", 0, 14)); // NOI18N
        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 130, 70, 30);

        emailField.setBackground(new java.awt.Color(0, 0, 0));
        emailField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        emailField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(emailField);
        emailField.setBounds(150, 190, 190, 30);

        jLabel5.setFont(new java.awt.Font("Novae", 0, 13)); // NOI18N
        jLabel5.setText("Nacimiento");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 310, 90, 20);

        registerBtn.setBackground(new java.awt.Color(19, 19, 19));
        registerBtn.setFont(new java.awt.Font("Felix Titling", 0, 14)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(204, 204, 204));
        registerBtn.setText("Registrar usuario");
        getContentPane().add(registerBtn);
        registerBtn.setBounds(130, 360, 190, 25);

        backBtn.setBackground(new java.awt.Color(243, 241, 241));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/return.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        getContentPane().add(backBtn);
        backBtn.setBounds(0, 390, 40, 40);

        exitBtn.setBackground(new java.awt.Color(245, 240, 240));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/exitbutton11.png"))); // NOI18N
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        getContentPane().add(exitBtn);
        exitBtn.setBounds(396, 390, 40, 40);

        passField.setBackground(new java.awt.Color(0, 0, 0));
        passField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        passField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(passField);
        passField.setBounds(150, 250, 190, 30);

        jLabel7.setFont(new java.awt.Font("Novae", 0, 13)); // NOI18N
        jLabel7.setText("Contraseña");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 250, 90, 20);

        birthyear.setBackground(new java.awt.Color(0, 0, 0));
        birthyear.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        birthyear.setForeground(new java.awt.Color(255, 255, 255));
        birthyear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970" }));
        getContentPane().add(birthyear);
        birthyear.setBounds(310, 300, 60, 40);

        birthday.setBackground(new java.awt.Color(0, 0, 0));
        birthday.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        birthday.setForeground(new java.awt.Color(255, 255, 255));
        birthday.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(birthday);
        birthday.setBounds(150, 300, 50, 40);

        birthmonth.setBackground(new java.awt.Color(0, 0, 0));
        birthmonth.setFont(new java.awt.Font("Segoe UI Semilight", 0, 15)); // NOI18N
        birthmonth.setForeground(new java.awt.Color(255, 255, 255));
        birthmonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        getContentPane().add(birthmonth);
        birthmonth.setBounds(210, 300, 90, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/registerbackgrnd.gif"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 437, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
         java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Registro().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton backBtn;
    public javax.swing.JComboBox<String> birthday;
    public javax.swing.JComboBox<String> birthmonth;
    public javax.swing.JComboBox<String> birthyear;
    public javax.swing.JTextField emailField;
    public javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField lnameField;
    public javax.swing.JTextField nameField;
    public javax.swing.JPasswordField passField;
    public javax.swing.JButton registerBtn;
    public javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
   @Override
   public void update(Observable o, Object o1) {
      
   }

}