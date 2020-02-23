package util;

import model.Point;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static String getProperty(String propName){
        String propValue = null;

        Properties properties = new Properties();
        ConfigReader creator = new ConfigReader();

        try(InputStream is = creator.getClass().getClassLoader()
                .getResourceAsStream("./recources/hibernate.properties")){
            properties.load(is);
            propValue = properties.getProperty(propName);
        }catch(IOException e){
            e.printStackTrace();
        }
        return propValue;
    }

    public static Configuration getConfiguration(){
        Configuration config = new Configuration();
        config.addAnnotatedClass(Point.class);

        config.setProperty("hibernate.dialect",getProperty("dialect"));
        config.setProperty("hibernate.connection.driver_class",getProperty("driver.class"));
        config.setProperty("hibernate.connection.url", getProperty("connection.url"));
        config.setProperty("hibernate.connection.username", getProperty("username"));
        config.setProperty("hibernate.connection.password", getProperty("password"));
        config.setProperty("hibernate.show_sql", getProperty("show_sql"));
        config.setProperty("hibernate.hbm2ddl.auto", getProperty("hbm2ddl.auto"));

        return config;
    }
}
