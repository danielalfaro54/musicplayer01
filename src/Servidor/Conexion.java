/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import musicstreamer.Playlist;
import musicstreamer.Song;

/**
 *
 * @author Lighthouse
 */
public class Conexion extends Thread {

    Socket cliente = null;
    DataInputStream buffEntrada;
    ObjectOutputStream buffSalida;
    DataInputStream teclado;
    String username = "";
    IDBAdapter posgre = BaseDeDatos.getDBAdapter();
    public static Vector<Conexion> clientesConectados = new Vector();
    Playlist myList = new Playlist();
    Playlist otherList = new Playlist();
    int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Conexion(Socket cliente, DataInputStream buffEntrada, ObjectOutputStream buffSalida) {
        this.cliente = cliente;
        this.buffEntrada = buffEntrada;
        this.buffSalida = buffSalida;
        clientesConectados.add(this);
        otherList.setSongs(getAllSongs());
        myList.setSongs(getSongs(username));
        
    }

    public void run() {
        try {
            Boolean done = true;
            System.out.println("Num: " + clientesConectados.size());
            while (done) {
                String mensaje = buffEntrada.readUTF();
                if (mensaje.contains("Register:")) {
                    String[] msgDiv = mensaje.split(":");
                    String nombre = msgDiv[1];
                    String apellido = msgDiv[2];
                    String email = msgDiv[3];
                    String user = msgDiv[4];
                    String password = msgDiv[5];
                    String birthday = msgDiv[6];
                    if (register(nombre, apellido, email, user, password, birthday)) {
                        this.EnviarMensaje("RegisterTrue");
                    } else {
                        this.EnviarMensaje("RegisterFalse");
                    }

                } else if (mensaje.contains("Login:")) {
                    String[] msgDiv = mensaje.split(":");
                    this.username = msgDiv[1];
                    String password = msgDiv[2];
                    if (login(username, password)) {
                        this.EnviarMensaje("LoginTrue");
                        myList.setSongs(getSongs(username));
                        this.EnviarMiMusica();
                        this.EnviarOtraMusica();
                        
                    } else {
                        this.EnviarMensaje("LoginFalse");
                    }

                } else if (mensaje.contains("Add:")) {
                    String[] msgDiv = mensaje.split(":");
                    String name = msgDiv[1];
                    addToList(name);
                    myList.setSongs(getSongs(username));
                    this.EnviarMiMusica();

                } else if (mensaje.contains("Remove:")) {
                    String[] msgDiv = mensaje.split(":");
                    String name = msgDiv[1];
                    removeFromList(name);
                    myList.setSongs(getSongs(username));
                    this.EnviarMiMusica();
                    
                } else if (mensaje.contains("Exit:")) {
                    clientesConectados.remove(this);
                    
                } else if (mensaje.contains("GetList:")) {
                    String[] msgDiv = mensaje.split(":");
                    otherList.setSongs(getSongs(msgDiv[1]));
                    this.EnviarOtraMusica();

                } else {
                    System.out.println("Invalid: " + mensaje);
                }
                System.out.println("/////");
                done = !mensaje.equals("actually exit");
            }

        } catch (Exception e) {

        };
    }

    public void EnviarMensaje(String mensaje) {
        try {

            buffSalida.writeObject(mensaje);
        } catch (Exception e) {

        };

    }

    public void EnviarMiMusica() {
        try {
            if (myList.getSongs().isEmpty()) {
                myList.getSongs().add(new Song("-", "-", "-", 0, "-", "-"));
            }
            for (Song song : myList.getSongs()) {
                System.out.println(song.getNombre());
            }
            myList.setId('M');
            buffSalida.writeObject(myList);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EnviarOtraMusica() {
        try {
            otherList.setId('O');
            buffSalida.writeObject(otherList);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EnviarUsers() {
        try {
            String userList = "Toda la música,";
            for (int i = 0; i < clientesConectados.size(); i++) {
                userList = userList + clientesConectados.get(i).getUsername() + ",";
            }
            buffSalida.writeObject(userList);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String userId() throws RemoteException {
        String n = null;
        int num = 0;
        Connection conexion = posgre.getConnection();
        String SQL = "SELECT MAX(usuarios.idusuario) FROM usuarios";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                String u = rs.getString(1);
                num = Integer.parseInt(u) + 1;

            }
            n = "" + num;
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return n;

    }

    public String listasId() throws RemoteException {
        String n = null;
        int num = 0;
        Connection conexion = posgre.getConnection();
        String SQL = "SELECT MAX(listas.idrelacion) FROM listas";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                String u = rs.getString(1);
                num = Integer.parseInt(u) + 1;

            }
            n = "" + num;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return n;

    }

    public List<Song> getAllSongs() {
        List<Song> Allsongs = new ArrayList();
        try {
            Connection conexion = posgre.getConnection();
            System.out.println("Conexion exitosa");
            

            String[] datos1 = new String[7];
            Statement st1 = conexion.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM musica");

            try {
                while (rs1.next()) {

                    
                    datos1[1] = rs1.getString(2);
                    datos1[2] = rs1.getString(3);
                    datos1[3] = rs1.getString(4);
                    datos1[4] = rs1.getString(5);
                    datos1[5] = rs1.getString(6);
                    datos1[6] = rs1.getString(7);

                    Song songs = new Song(datos1[1], datos1[2], datos1[3], Integer.parseInt(datos1[4]), datos1[5], datos1[6]);
                    Allsongs.add(songs);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Allsongs;
    }

    public List<Song> getSongs(String usuario) {
        List<Song> listSongs = new ArrayList();
        try {

            Connection conexion = posgre.getConnection();
            System.out.println("Conexion exitosa");

            String[] datos1 = new String[7];
            Statement st1 = conexion.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM usuarios");
            while (rs1.next()) {
                datos1[0] = rs1.getString(1);
                datos1[4] = rs1.getString(5);
                datos1[5] = rs1.getString(6);
                if (usuario.equals(datos1[4])) {

                    String[] datos2 = new String[3];
                    Statement st2 = conexion.createStatement();
                    ResultSet rs2 = st2.executeQuery("SELECT usuarios.username, musica.nombre, listas.idrelacion FROM usuarios "
                            + "INNER JOIN listas ON listas.idusuario = usuarios.idusuario "
                            + "INNER JOIN musica ON musica.idcancion = listas.idcancion WHERE listas.idusuario = " + datos1[0]);
                    
                    String[] datos3 = new String[7];
                    while (rs2.next()) {

                        datos2[0] = rs2.getString(1);
                        datos2[1] = rs2.getString(2);

                        Statement st3 = conexion.createStatement();
                        ResultSet rs3 = st3.executeQuery("SELECT * FROM musica");

                        while (rs3.next()) {

                            datos3[0] = rs3.getString(1);
                            datos3[1] = rs3.getString(2);
                            datos3[2] = rs3.getString(3);
                            datos3[3] = rs3.getString(4);
                            datos3[4] = rs3.getString(5);
                            datos3[5] = rs3.getString(6);
                            datos3[6] = rs3.getString(7);
                            if (datos2[1].equals(datos3[1])) {
                                Song songs = new Song(datos3[1], datos3[2], datos3[3], Integer.parseInt(datos3[4]), datos3[5], datos3[6]);
                                listSongs.add(songs);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSongs;
    }
    
    public boolean login(String user, String password) {
        try {
            Connection conexion = posgre.getConnection();
            System.out.println("Conexion exitosa");

            String[] datos1 = new String[7];
            Statement st1 = conexion.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM usuarios");
            // Este while verifica que el usuario ingresado este en la base de datos y coincida con su contraseña
            while (rs1.next()) {
                datos1[0] = rs1.getString(1);
                datos1[4] = rs1.getString(5);
                datos1[5] = rs1.getString(6);
                if (user.equals(datos1[4]) && datos1[5].equals(password)) {
                    id = Integer.parseInt(datos1[0]);
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean register(String nombre, String apellido, String email, String user, String password, String birthday) {
        boolean exists = false;
        try {
            Connection conexion = posgre.getConnection();
            String SQL = "INSERT INTO usuarios(idusuario,nombre,apellido,fechanacimiento,username,password,email)VALUES(?,?,?,?,?,?,?)";
            System.out.println("Conexion exitosa");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date det = df.parse(birthday);
            java.sql.Date sqdet = new java.sql.Date(det.getTime());

            try {

                String[] datos1 = new String[7];
                Statement st1 = conexion.createStatement();
                ResultSet rs1 = st1.executeQuery("SELECT * FROM usuarios");

                while (rs1.next()) {

                    datos1[4] = rs1.getString(5);
                    datos1[6] = rs1.getString(7);

                    if (user.equals(datos1[4]) || datos1[6].equals(email)) {
                        exists = true;
                        
                    }
                }
                if (exists) {

                    return exists;
                } else {
                    
                    PreparedStatement pst = conexion.prepareStatement(SQL);
                    pst.setInt(1, Integer.parseInt(userId()));
                    pst.setString(2, nombre);
                    pst.setString(3, apellido);
                    pst.setDate(4, sqdet);
                    pst.setString(5, user);
                    pst.setString(6, password);
                    pst.setString(7, email);

                    pst.executeUpdate();
                    return false;
                }

            } catch (SQLException ex) {
                return true;
            } catch (RemoteException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                return true;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
        // return false;
    }

    public void addToList(String name) {
        String SQL = "INSERT INTO listas(idrelacion,idusuario,idcancion)VALUES(?,?,?)";

        try {
            Connection conexion = posgre.getConnection();

            String[] datos1 = new String[7];
            Statement st1 = conexion.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM musica");

            while (rs1.next()) {

                datos1[0] = rs1.getString(1);
                datos1[1] = rs1.getString(2);
                    
                if (name.equals(datos1[1])) {
                    PreparedStatement pst = conexion.prepareStatement(SQL);

                    System.out.println(datos1[0] + " - " + datos1[1]);
                    pst.setInt(1, Integer.parseInt(listasId()));
                    pst.setInt(2, id);
                    pst.setInt(3, Integer.parseInt(datos1[0]));
                    pst.executeUpdate();

                } else {
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }


    public void removeFromList(String name) {
        try {
            Connection conexion = posgre.getConnection();

            
            String[] datos1 = new String[3];
            Statement st1 = conexion.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM listas");

            String[] datos2 = new String[7];

            Statement st2 = conexion.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT * FROM musica");

            while (rs1.next()) {

                datos1[2] = rs1.getString(3);

                while (rs2.next()) {

                    datos2[0] = rs2.getString(1);
                    datos2[1] = rs2.getString(2);

                    if (name.equals(datos2[1])) {
                        String SQL = "DELETE FROM listas WHERE idcancion = " + datos2[0];
                        PreparedStatement pst = conexion.prepareStatement(SQL);
                        pst.execute();
                        //System.out.println(id +" - "+ datos1[2]);


                    } else {
                        
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
