package sda.capstone;

import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties props;
    @Step ("Loading configuration properties")
    public static void readPropertyFile(String configPath) {
        props = new Properties();
        try {
            // Load properties from the classpath
            props.load(new FileInputStream(configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
