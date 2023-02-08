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

public class ClientDao implements Dao<Client, Integer> {

	@Override
	public List<Client> findAll() {
		ArrayList<Client> client = null;
		Connection connection = MySqlConnection.getConnection();
		String sql = "SELECT * FROM Client";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			personnes = new ArrayList<>();
			while (result.next()) {
				personnes.add(new Client(result.getInt("num"), result.getString("nom"), result.getString("prenom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personnes;
	}

	@Override
	public Client findById(Integer id) {

		Connection connection = MySqlConnection.getConnection();
		String sql = "SELECT * FROM personne WHERE num = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return new Client(result.getInt("num"), result.getString("nom"), result.getString("prenom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client save(Client objet) {
		Connection connection = MySqlConnection.getConnection();
		String sql = "INSERT INTO personne (nom, prenom) VALUES (?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, objet.getNom());
			statement.setString(2, objet.getPrenom());
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
	public Client update(Client objet) {
		Connection connection = MySqlConnection.getConnection();
		String sql = "UPDATE personne SET nom=?, prenom=? WHERE num =?";
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
		String sql = "DELETE FROM personne WHERE num = ?";
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