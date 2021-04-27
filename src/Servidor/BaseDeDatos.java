/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.sql.Connection;
import java.sql.DriverManager;

/**Postgre
 *
 * @author sebas
 */
public class BaseDeDatos {
    
     public static IDBAdapter getDBAdapter(){
        String dbType = ConfigLoader.getDBType();
        System.out.println("DBType => " + dbType);
        switch(dbType){
            case "MySQL":
                return new MySQLDBAdapter();
            case "Postgre":
                return new PosgreSQLAdapter();
            case "SQLServer":
                return new SQLServerAdapter();
            default:
                throw new RuntimeException("No soporta esta base de datos");
        }
    }
    
    
    
}
