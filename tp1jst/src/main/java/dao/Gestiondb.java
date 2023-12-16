package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Etudiant;

public class Gestiondb implements IGestion {

	Connection connection;
	
	public Gestiondb() {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		 
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp1jstl", "root", "rootroot");
		 
		} catch (Exception e) {
		    e.printStackTrace();
		}


	}

	
	public List<Etudiant> getAllEtudiants() {
        
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		 String query = "SELECT * FROM etudiants";
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int num = resultSet.getInt("num");
                String prenom = resultSet.getString("prenom");
                String nom = resultSet.getString("nom");
                String tel = resultSet.getString("tel");

                Etudiant etudiant = new Etudiant(num, prenom,nom,tel); 
                etudiants.add(etudiant);  
                
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
       
    }


	public void addEtudiant(Etudiant etudiant) {
        try {
            String query = "INSERT INTO etudiants (num,prenom,nom,tel) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, etudiant.getNum());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getNom());
            preparedStatement.setString(4, etudiant.getTel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void deleteEtudiant(int id) {
        try {
            String query = "DELETE FROM etudiants WHERE num=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public boolean verif(String user, String mp) {
		if (connection == null) {
			System.err.println("Erreur de connexion à la base de données.");
			return false;
		}
		
		try {
			String query = "SELECT * FROM comptes WHERE user=? AND mp=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, mp);
			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	}


