/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.Connexion;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connexion {

    private static Connection cn;

    static {
        try {
            FileInputStream f = new FileInputStream("entreprise.properties");
            Properties p = new Properties();
            p.load(f);
            String url = p.getProperty("jdbc.url");
            String login = p.getProperty("jdbc.username");
            String password = p.getProperty("jdbc.password");
            String driver = p.getProperty("jdbc.driver");
            Class.forName(driver);
            cn = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    public static Connection getCn() {
        return cn;
    }

}
