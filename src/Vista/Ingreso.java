/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Lighthouse
 */
public class Ingreso extends javax.swing.JFrame implements Observer {

   /**
    * Creates new form Ingreso
    */
   public Ingreso() {
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

        jLabel4 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        passField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Novae", 0, 17)); // NOI18N
        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 80, 100, 30);

        userField.setBackground(new java.awt.Color(51, 51, 51));
        userField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        userField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(userField);
        userField.setBounds(120, 120, 220, 40);

        jLabel5.setFont(new java.awt.Font("Novae", 0, 17)); // NOI18N
        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 190, 120, 30);

        loginBtn.setBackground(new java.awt.Color(51, 51, 51));
        loginBtn.setFont(new java.awt.Font("Felix Titling", 1, 15)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(204, 204, 204));
        loginBtn.setText("INGRESAR");
        getContentPane().add(loginBtn);
        loginBtn.setBounds(170, 320, 130, 40);

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/return.png"))); // NOI18N
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        getContentPane().add(backBtn);
        backBtn.setBounds(0, 410, 40, 40);

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/exitbutton11.png"))); // NOI18N
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        getContentPane().add(exitBtn);
        exitBtn.setBounds(410, 410, 43, 33);

        passField.setBackground(new java.awt.Color(51, 51, 51));
        passField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        passField.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(passField);
        passField.setBounds(120, 230, 220, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/loginbackgrnd.gif"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 450, 450);

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
         java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Ingreso().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton backBtn;
    public javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JButton loginBtn;
    public javax.swing.JPasswordField passField;
    public javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables

   @Override
   public void update(Observable o, Object o1) {
      
   }

}
