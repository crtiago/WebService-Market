package br.com.crtiago.webservice.market.dao;

import br.com.crtiago.webservice.market.configuration.PropertiesUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirebirdDao {

    private static FirebirdDao instanceFirebird = new FirebirdDao();

    private FirebirdDao() {
    }

    public static FirebirdDao getInstance() {
        return instanceFirebird;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class.forName(PropertiesUtils.getDriver());
        String url = PropertiesUtils.getUrl();
        String user = PropertiesUtils.getUsername();
        String password = PropertiesUtils.getPassword();
        return DriverManager.getConnection(url, user, password);
    }
}
