/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class PostgreSql extends DataBase {
    
    
    @Override
    public boolean ConnectDB(){
        
        String URL="jdbc:postgresql://"+HOSTNAME+":5432/"+DBNAME;
        
        try {
             Class.forName("org.postgresql.Driver");
             connection = (Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
             System.out.println("Hola entro");
             return true;
        }    catch(Exception e){
             System.out.println(e);
        }
        return false;
    }
    
    public boolean Close(){
        return true;
    }
    public static void main(String[] args) throws SQLException {
        
        String HOSTNAME = "localhost";
        String DBNAME   = "Streamer";
        String USERNAME = "postgres";
        String PASSWORD = "sebas1699";  
        
        /*String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS GrupoDS4 (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    calificaion real, \n"
                + "    capacity real\n"
                + ");";
        
        String INSERT_SQL = "INSERT INTO GrupoDS4 " + "VALUES (2, 'Gabriel','100',100)";
         */
        DataBase db = new PostgreSql();
        db.Init(HOSTNAME, DBNAME, USERNAME, PASSWORD);
        if(db.ConnectDB()) {
            System.out.println("Conexion exitosa");
          /*db.CreateTable(CREATE_TABLE_SQL);
          db.Insert(INSERT_SQL);*/
        }
        else{
            System.out.println("No se conecto");
        }
 }
}