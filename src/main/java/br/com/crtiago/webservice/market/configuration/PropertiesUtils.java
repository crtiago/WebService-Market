package br.com.crtiago.webservice.market.configuration;

import br.com.crtiago.webservice.market.enums.PropertiesTagEnum;

import java.util.Properties;

public class PropertiesUtils {

    private String url;
    private String username;
    private String password;
    private String drive;

    private static Properties properties = LoadProperties.getProperties();

    public static String getUrl() {
        return properties.getProperty(PropertiesTagEnum.URL.getTag());
    }

    public static String getUsername() {
        return properties.getProperty(PropertiesTagEnum.USERNAME.getTag());
    }

    public static String getPassword() {
        return properties.getProperty(PropertiesTagEnum.PASSWORD.getTag());
    }

    public static String getDriver() {
        return properties.getProperty(PropertiesTagEnum.DRIVER.getTag());
    }

}
