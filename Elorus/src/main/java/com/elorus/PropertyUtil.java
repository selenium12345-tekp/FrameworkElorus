package com.elorus;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {

    public static Properties getProperties() {

        Properties prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

            prop.load(fis);
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }
}