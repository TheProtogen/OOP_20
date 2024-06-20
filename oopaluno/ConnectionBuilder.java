package oopaluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBuilder {
    private final static String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static String DB_URL = "jdbc:mariadb://localhost:3306/AlunoDB?allowMultiQueries=true";
    private static String USER = "root";
    private static String PASS = "hdsuperchaos589chaos";

    private Connection con = null;
    private static ConnectionBuilder conBuilder;

    private ConnectionBuilder() throws ClassNotFoundException {     
        Class.forName(DB_CLASS);
    }

    public static ConnectionBuilder getInstance() throws Exception { 
        if (conBuilder == null){ 
            conBuilder = new ConnectionBuilder();
        }
        return conBuilder;
    }

    public Connection getConnection() throws SQLException { 
        if (con == null) { 
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        return this.con;       
    }
}
