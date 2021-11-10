package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    // With this util class, We read and get data from "configuration.properties"
    // It is similar to reading/getting from text file with Java

    // 1. Create object from Properties
    private static Properties properties;

    // 2. Create static block to run this method before all methods in this class
    static {

    String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
                //loading the file
                properties.load(fileInputStream); // means loading or reading the file.
                // It also throws exception. So teacher changes the following line ==> catch (Exception e)

                fileInputStream.close();
        } catch (Exception e) {
            System.out.println("The message: "+e.getMessage());
            e.printStackTrace();
        }
    } // this is end of the static block

    public static String getProperty(String key) {
        // This method gets the key and returns the value
        String value = properties.getProperty(key);
        return value;
        // or we can also use one single line
        // return properties.getProperty(key);
    }

}
