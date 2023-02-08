package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.MySqlConnection;
import model.Client;

public class ActiviteDao implements Dao<Activite, Integer> {

	@Override
	public List<Activite> findAll() {
		ArrayList<Activite> activite = null;
		Connection connection = MySqlConnection.getConnection();
		String sql = "SELECT * FROM Activite";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			activite = new ArrayList<>();
			while (result.next()) {
				activites.add(new activite(result.getInt("num"), result.getString("nom"), result.getString("prenom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return activites;
	}

	@Override
	public Activite findById(Integer id) {

		Connection connection = MySqlConnection.getConnection();
		String sql = "SELECT * FROM activite WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return new Activite(result.getInt("num"), result.getString("nom"), result.getString("prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Activite save(Activite objet) {
		Connection connection = MySqlConnection.getConnection();
		String sql = "INSERT INTO activite (nom, type) VALUES (?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, objet.getNom());
			statement.setString(2, objet.gettype());
			int nombre = statement.executeUpdate();
			if (nombre > 0) {
				return objet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Activite update(Activite objet) {
		Connection connection = MySqlConnection.getConnection();
		String sql = "UPDATE activite SET nom=?, type=? WHERE id =?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, objet.getNom());
			statement.setString(2, objet.getPrenom());
			statement.setInt(3, objet.getNum());
			int nombre = statement.executeUpdate();
			if (nombre > 0) {
				return objet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	//appel de la methode
	public void remove(Integer id) {
		//appel de la methode connection
		Connection connection = MySqlConnection.getConnection();
		// appel de la requête pour supression
		String sql = "DELETE FROM activite WHERE id = ?";
		//
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}