package Servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import org.postgresql.Driver;

public class PosgreSQLAdapter implements IDBAdapter {
    
    static{
        try {
            new org.postgresql.Driver();
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar driver");
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String user = ConfigLoader.getPropery("Postgre.user");
            String password = ConfigLoader.getPropery("Postgre.password");
            String host = ConfigLoader.getPropery("Postgre.host");
            String port = ConfigLoader.getPropery("Postgre.port");
            String db = ConfigLoader.getPropery("Postgre.db");
//String URL="jdbc:postgresql://"+HOSTNAME+":5432/"+DBNAME;
            String url = "jdbc:postgresql://${host}:${port}/${db}"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); //connection to MySQL
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("Postgrest" + e.getMessage());
        }
    }
    
}
