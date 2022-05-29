package org.uok.dscc;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private final String FILENAME = "./src/main/resources/config.properties";  // locate app property file
    private static final AppProperties properties_file = new AppProperties();
    private Properties prop = new Properties();

    private AppProperties(){ //read app property file
        InputStream input =null;
        try {
            input = new FileInputStream(FILENAME);
            prop.load(input);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(input!=null){
                try {
                    input.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProperty(String key){ //get information from read file

        return prop.getProperty(key);
    }

    public static AppProperties getInstance(){
        return properties_file;
    }




}
