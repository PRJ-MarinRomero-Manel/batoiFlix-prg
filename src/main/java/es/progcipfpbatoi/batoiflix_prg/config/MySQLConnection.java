package es.progcipfpbatoi.batoiflix_prg.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MySQLConnection {
    
    private static Connection connection;
    private String ip;
    private String database;
    private String userName;
    private String password;

    public MySQLConnection() {
        this.ip = "localhost:3306";
        this.database = "batoiFlix";
        this.userName = "manelsql";
        this.password = "akirakurosawa";
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()){
                String dbURL = "jdbc:mysql://" + ip + "/" + database;
                connection = DriverManager.getConnection(dbURL, userName, password);
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Error al conectar a la base de datos: " + exception.getMessage());
        }
        return connection;
    }
}

