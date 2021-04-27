/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MusicClient;
import Modelo.PausablePlayer;
import Validators.Usuario;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Lighthouse
 */
public class Controlador implements Observer, ActionListener {

   public MusicClient modelo;
   public Menu menu;
   public Registro registro;
   public Ingreso ingreso;
   public Reproductor reproductor;
   

   public MusicClient getModelo() {
      return modelo;
   }

   public void setModelo(MusicClient modelo) {
      this.modelo = modelo;
   }

   public Menu getMenu() {
      return menu;
   }

   public void setMenu(Menu menu) {
      this.menu = menu;
      this.menu.exitBtn.addActionListener(this);
      this.menu.loginBtn.addActionListener(this);
      this.menu.registerBtn.addActionListener(this);
      this.menu.setSize(500, 539);
      this.menu.setVisible(true);
   }

   public Registro getRegistro() {
      return registro;

   }

   public void setRegistro(Registro registro) {
      this.registro = registro;
      this.registro.backBtn.addActionListener(this);
      this.registro.exitBtn.addActionListener(this);
      this.registro.registerBtn.addActionListener(this);
      this.registro.birthmonth.addActionListener(this);
      this.registro.birthyear.addActionListener(this);
      this.registro.setSize(452, 469);

   }

   public Ingreso getIngreso() {
      return ingreso;
   }

   public void setIngreso(Ingreso ingreso) {
      this.ingreso = ingreso;
      this.ingreso.backBtn.addActionListener(this);
      this.ingreso.exitBtn.addActionListener(this);
      this.ingreso.loginBtn.addActionListener(this);
      this.ingreso.setSize(466, 489);

   }

   public Reproductor getReproductor() {
      return reproductor;
   }

   public void setReproductor(Reproductor reproductor) {
      this.reproductor = reproductor;
      this.reproductor.addBtn.addActionListener(this);
      this.reproductor.exitBtn.addActionListener(this);
      this.reproductor.nextBtn.addActionListener(this);
      this.reproductor.playBtn.addActionListener(this);
      this.reproductor.prevBtn.addActionListener(this);
      this.reproductor.removeBtn.addActionListener(this);
      this.reproductor.myBox.addActionListener(this);
      this.reproductor.setSize(816, 479);
   }

   @Override
   public void update(Observable o, Object o1) {
      try {
        
         if (o1.equals("RegisterFalse")) {
            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente. \nRegresará al menú principal",
                    "Registro correcto", JOptionPane.WARNING_MESSAGE);
            registro.nameField.setText("");
            registro.lnameField.setText("");
            registro.emailField.setText("");
            registro.userField.setText("");
            registro.passField.setText("");
            registro.birthday.setSelectedIndex(0);
            registro.birthmonth.setSelectedIndex(0);
            registro.birthyear.setSelectedIndex(0);
            registro.dispose();
            menu.setVisible(true);
         } else if (o1.equals("RegisterTrue")) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario o correo ya existen. \nInténtelo nuevamente por favor",
                    "Registro incorrecto", JOptionPane.WARNING_MESSAGE);
         } else if (o1.equals("LoginTrue")) {

            reproductor.setVisible(true);
            ingreso.dispose();
         } else if (o1.equals("LoginFalse")) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario y/o la contraseña\no son correctos. \nInténtelo nuevamente por favor",
                    "Datos erróneos", JOptionPane.WARNING_MESSAGE);
         } else {
            
            int myIndex = reproductor.myBox.getSelectedIndex();
            reproductor.myBox.removeAllItems();
            reproductor.othersBox.removeAllItems();

            
            if (modelo.getMySongs().size() > 0) {
               reproductor.playBtn.setEnabled(true);
               reproductor.removeBtn.setEnabled(true);
            } else {
               reproductor.playBtn.setEnabled(false);
               reproductor.removeBtn.setEnabled(false);
            }
            if (modelo.getMySongs().size() > 1) {
               reproductor.nextBtn.setEnabled(true);
            } else {
               reproductor.nextBtn.setEnabled(false);
               reproductor.prevBtn.setEnabled(false);
            }
            if (modelo.getOtherSongs().size() > 0) {
               reproductor.addBtn.setEnabled(true);
            } else {
               reproductor.addBtn.setEnabled(false);
            }
             if(modelo.getMySongs().size()==modelo.getCounter()+1){
            	reproductor.nextBtn.setEnabled(false);
                
            }else{
                 
             }
            
            for (int i = 0; i < modelo.getMySongs().size(); i++) {
               reproductor.myBox.addItem(modelo.getMySong(i).getNombre());
            }
            
            reproductor.myBox.setSelectedIndex(modelo.getCounter());
            

            for (int i = 0; i < modelo.getOtherSongs().size(); i++) {
               reproductor.othersBox.addItem(modelo.getOtherSong(i).getNombre());
                

            }
           

           
            reproductor.musicData.setText(modelo.getSongData());
            
         }
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      try {

         if (e.getSource() == menu.exitBtn || e.getSource() == ingreso.exitBtn
                 || e.getSource() == registro.exitBtn) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
               System.exit(0);
            }
         } else if (e.getSource() == reproductor.exitBtn) {
            
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Salir",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
               modelo.EscribirDatos("Exit:");
               System.exit(0);
            }
         } else if (e.getSource() == registro.backBtn || e.getSource() == ingreso.backBtn) {
            menu.setVisible(true);
            registro.dispose();
            ingreso.dispose();
         } else if (e.getSource() == registro.birthmonth) {
            int days = 31;
            System.out.println("months");
            if (registro.birthmonth.getSelectedItem().toString().equals("Enero")) {
               days = 32;
               System.out.println("january");

            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Febrero")) {
               if (Integer.parseInt(registro.birthyear.getSelectedItem().toString()) % 4 == 0) {
                  days = 30;
               } else {
                  days = 29;
               }

            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Marzo")) {
               days = 32;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Abril")) {
               days = 31;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Mayo")) {
               days = 32;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Junio")) {
               days = 31;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Julio")) {
               days = 32;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Agosto")) {
               days = 32;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Septiembre")) {
               days = 31;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Octubre")) {
               days = 32;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Noviembre")) {
               days = 31;
            }
            if (registro.birthmonth.getSelectedItem().toString().equals("Diciembre")) {
               days = 32;
            }
            registro.birthday.removeAllItems();
            for (int i = 1; i < days; i++) {
               registro.birthday.addItem("" + i);
            }
         } else if (e.getSource() == registro.birthyear) {
            int days = registro.birthday.getItemCount() + 1;
            if (registro.birthmonth.getSelectedItem().toString().equals("Febrero")) {
               if (Integer.parseInt(registro.birthyear.getSelectedItem().toString()) % 4 == 0) {
                  days = 30;
               } else {
                  days = 29;
               }

            }
            registro.birthday.removeAllItems();
            for (int i = 1; i < days; i++) {
               registro.birthday.addItem("" + i);
            }
         } else if (e.getSource() == registro.registerBtn) {
            String nombre = registro.nameField.getText();
            String apellido = registro.lnameField.getText();
            String email = registro.emailField.getText();
            String user = registro.userField.getText();
            String password = new String(registro.passField.getPassword());
            String birthdate = registro.birthyear.getSelectedItem().toString() + "-" + registro.birthmonth.getSelectedIndex() + "-" + registro.birthday.getSelectedItem().toString();
            int age = 2019 - Integer.parseInt(registro.birthyear.getSelectedItem().toString());
            Usuario info = new Usuario(nombre, apellido, email, user, password, age);
            List<String> errors = modelo.validate(info);
            String errordisplay = "";
            /*String nombre = msgDiv[1];
                 String apellido = msgDiv[2];
                 String email = msgDiv[3];
                 String user = msgDiv[4];
                 String password = msgDiv[5];
                 String birthday = msgDiv[6];*/
            for (String error : errors) {
               errordisplay = errordisplay + error + "\n";
            }
            if (!errors.isEmpty()) {
               JOptionPane.showMessageDialog(null, errordisplay,
                       "Error de Registro", JOptionPane.WARNING_MESSAGE);
            } else {
               modelo.EscribirDatos("Register:" + nombre + ":" + apellido + ":" + email + ":" + user + ":" + password + ":" + birthdate);
            }
         } else if (e.getSource() == menu.loginBtn) {
            ingreso.setVisible(true);
            menu.dispose();
         } else if (e.getSource() == menu.registerBtn) {
            registro.setVisible(true);
            menu.dispose();
         } else if (e.getSource() == ingreso.loginBtn) {

            modelo.EscribirDatos("Login:" + ingreso.userField.getText() + ":" + new String(ingreso.passField.getPassword()));

         } else if (e.getSource() == reproductor.playBtn) {
            //modelo.play(reproductor.myBox.getSelectedItem().toString());

            if (reproductor.myBox.getItemCount() != 1 || !reproductor.myBox.getItemAt(0).equals("-")) {
               modelo.play(reproductor.myBox.getSelectedItem().toString());
            }
         } else if (e.getSource() == reproductor.nextBtn) {
             modelo.player.stop();
            if (!reproductor.prevBtn.isEnabled()) {
               reproductor.prevBtn.setEnabled(true);
            }
             
            modelo.next();
            System.out.println("COUNTER:" +modelo.getCounter());
            reproductor.musicData.setText(modelo.getSongData());
            reproductor.playBtn.doClick();
            if (modelo.getCounter() == modelo.getMySongs().size() - 1) {
               reproductor.nextBtn.setEnabled(false);
            }
            reproductor.myBox.setSelectedIndex(modelo.getCounter());
         } else if (e.getSource() == reproductor.prevBtn) {
             modelo.player.stop();
            if (!reproductor.nextBtn.isEnabled()) {
               reproductor.nextBtn.setEnabled(true);
            }
            modelo.prev();
            
            System.out.println("COUNTER:"+modelo.getCounter());
            reproductor.musicData.setText(modelo.getSongData());
            reproductor.playBtn.doClick();
            if (modelo.getCounter() == 0) {
               reproductor.prevBtn.setEnabled(false);
            }
            reproductor.myBox.setSelectedIndex(modelo.getCounter());
         } else if (e.getSource() == reproductor.myBox) {
            //System.out.println(reproductor.myBox.getSelectedItem());
            //modelo.EscribirDatos("Login:");

         } else if (e.getSource() == reproductor.addBtn) {
            if (reproductor.myBox.getItemCount() == 1 && reproductor.myBox.getItemAt(0).equals("-")) {
               reproductor.myBox.removeAllItems();
            }
            modelo.addToList(reproductor.othersBox.getSelectedItem().toString());
            
         } else if (e.getSource() == reproductor.removeBtn) {
            //System.err.println(reproductor.othersBox);
            if(reproductor.myBox.getItemCount()-1 == reproductor.myBox.getSelectedIndex()){
                reproductor.nextBtn.setEnabled(false);
            }
            modelo.removeFromList(reproductor.myBox.getSelectedItem().toString());
            reproductor.myBox.removeItemAt(modelo.getCounter());
            
            if (reproductor.myBox.getItemCount() == 1 && reproductor.myBox.getItemAt(0).equals("-")) {
               reproductor.removeBtn.setEnabled(false);
            }
           
         } 
      } catch (IOException ex) {
         Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

}
