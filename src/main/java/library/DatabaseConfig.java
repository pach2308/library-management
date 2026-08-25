package library;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private Properties properties;
    public DatabaseConfig(){
        properties = new Properties();
        try{
            InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getUrl(){
        return properties.getProperty("db.url");
    }
    public String getUserName(){
        return properties.getProperty("db.username");
    }
    public String getPassWord(){
        return properties.getProperty("db.password");
    }
}

