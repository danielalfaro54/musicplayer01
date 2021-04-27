/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public abstract class DataBase {
    
    Connection connection;
    public String HOSTNAME = "localhost";
    public String DBNAME   = "Streamer";
    public String USERNAME = "Sebastian";
    public String PASSWORD = "sebas1699";
    
    public void Init(String HOSTNAME, String DBNAME, String USERNAME, String PASSWORD){
    this.HOSTNAME   = HOSTNAME;
    this.DBNAME     = DBNAME;
    this.USERNAME   = USERNAME;
    this.PASSWORD   = PASSWORD ;
    }
    
    public abstract boolean ConnectDB();
    public ResultSet Query(String commandSQL)throws SQLException{
        
        PreparedStatement ps;
        ResultSet res;
        
        ps = connection.prepareStatement(commandSQL);
        res = ps.executeQuery();
        return res;
    };
    //public boolean Close();
    public int CreateTable(String commandSQL)throws SQLException{
     
        PreparedStatement ps;
        ps = connection.prepareStatement(commandSQL);
        int res =ps.executeUpdate();
        ps.close();
        return res;
    }
      public int Insert(String queryString) throws SQLException{
    
        PreparedStatement ps;
        ps = connection.prepareStatement(queryString);
        int res =ps.executeUpdate();
        ps.close();
        return res;
        
    }
    
}
