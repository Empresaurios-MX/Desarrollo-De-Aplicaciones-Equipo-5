package com.dnieln7.proyectomv1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost/testing?user=postgres&password=211215";
        try(Connection conn = DriverManager.getConnection(url)){
            Logger.getLogger(Main.class.getName()).log(Level.INFO, conn.getCatalog());
        }catch(SQLException e){
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "There was an error");
        }
    }
}
