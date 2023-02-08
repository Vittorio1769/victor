package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    private static Connection connexion = null;
    static {
        try {
            String url = "jdbc:mysql://localhost:3306/cours_jdbc";
            String utilisateur = "root";
            String motDePasse = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MySqlConnection() {
    }

    public static Connection getConnection() {
        return connexion;
    }

}