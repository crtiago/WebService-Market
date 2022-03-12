package br.com.crtiago.webservice.market.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FirebirdDao {

    private static FirebirdDao instanceFirebird = new FirebirdDao();
    private static final String FIREBIRD_DRIVER = "org.firebirdsql.jdbc.FBDriver";
    public Connection con;

    private FirebirdDao() {
    }

    public static FirebirdDao getInstance() {
        return instanceFirebird;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class.forName(FIREBIRD_DRIVER);
        String url = "jdbc:firebirdsql:localhost/3050:C:/Users/Tiago/Documents/Banco de Dados Mercado/smart.fdb";
        String user = "sysdba";
        String password = "masterkey";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
