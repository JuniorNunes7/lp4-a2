package db;

import java.sql.*;
import java.util.ArrayList;

import models.Geladeira;

public class Conexao {

	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public Conexao () throws Exception {
    	try {
    		// Setup the connection with the DB
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        connect = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/lp4-a2", "root", "root");
    	} catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Geladeira> getAll() throws Exception {
		try {
            // Statements allow to issue SQL queries to the database
            statement = this.connect.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from geladeiras");
            
            ArrayList<Geladeira> result = new ArrayList<Geladeira>();
            
            while (resultSet.next()) {
            	String modelo = resultSet.getString("modelo");
        		Integer volume = resultSet.getInt("volume");
        		Integer numero_portas = resultSet.getInt("numero_portas");
        		Boolean faz_gelo = resultSet.getBoolean("faz_gelo");
        		
        		Geladeira geladeira = new Geladeira(modelo, volume,numero_portas, faz_gelo);
            	
                result.add(geladeira);
            }
            
            return result;
		} catch (Exception e) {
            throw e;
        }
    }
    
    public void insert (Geladeira geladeira) throws Exception {
    	try {
            // Statements allow to issue SQL queries to the database
    		preparedStatement = this.connect.prepareStatement("INSERT INTO geladeiras (modelo, volume, numero_portas, faz_gelo) VALUES (?,?,?,?)");

    		preparedStatement.setString(1, geladeira.getModelo());
    		preparedStatement.setInt(2, geladeira.getVolume());
    		preparedStatement.setInt(3, geladeira.getNumero_portas());
    		preparedStatement.setBoolean(4, geladeira.getFaz_gelo());
    		
    		preparedStatement.execute();

		} catch (Exception e) {
            throw e;
        }
    }

    // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}
