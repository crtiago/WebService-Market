package br.com.crtiago.webservice.market.configuration;

import java.io.InputStream;
import java.util.Properties;

public final class LoadProperties {

    public static Properties getProperties() {
        Properties properties = new Properties();

        try {
            ClassLoader classLoader = LoadProperties.class.getClassLoader();
            InputStream applicationPropertiesStream = classLoader.getResourceAsStream("application.properties");
            properties.load(applicationPropertiesStream);
        } catch (Exception e) {
            System.err.println("Nao foi possivel realizar a leitura do arquivo application.properties");
        }
        return properties;

    }

}
