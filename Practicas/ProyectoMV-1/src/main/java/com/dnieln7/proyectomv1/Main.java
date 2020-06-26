package com.dnieln7.proyectomv1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dnieln7
 */
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/testing?user=postgres&password=root";

        try (Connection conn = DriverManager.getConnection(url)) {
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Conexión exitosa");
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "There was an error", e);
        }
    }
}
