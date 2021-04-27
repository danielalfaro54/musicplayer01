package Servidor;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class ConfigLoader {

    private static Properties props;

    static {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("resources/META-INF/dbconfig.properties");
            ConfigLoader.props = new Properties();
            props.load(stream);
        } catch (Exception e) {
            throw new RuntimeException("Fallo al cargar la configuracion");
        }
    }
    
    public static String getDBType(){
        return props.getProperty("dbtype");
    }
    
    public static String getPropery(String propName){
        return props.getProperty(propName);
    }
    
    
}
