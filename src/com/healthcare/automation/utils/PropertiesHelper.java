package com.healthcare.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
	private Properties properties ;
	
	public PropertiesHelper() {
		this.properties= new Properties();
	}

    public Properties loadProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public void setProperty(String key,String value) {
         properties.setProperty(key, value);
    }
}
