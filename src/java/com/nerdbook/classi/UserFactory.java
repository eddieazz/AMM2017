/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook.classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edoar
 */
public class UserFactory {
    
    private static UserFactory singleton;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }
    
    private String connectionString;
    
    private UserFactory() {
    }
    
      
    public User getUserById(int id) {
        try {

            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM utente" + " WHERE utente_id = ?";

            PreparedStatement statement = connessione.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                User usr = new User();
                usr.setId(result.getInt("utente_id"));
                usr.setNome(result.getString("nome"));
                usr.setCognome(result.getString("cognome"));
                usr.setEmail(result.getString("email"));
                usr.setPassword(result.getString("password"));
                usr.setUrlFotoProfilo(result.getString("urlFotoProfilo"));
                usr.setDataDiNascita(result.getString("dataDiNascita"));
                usr.setFrasePresentazione(result.getString("frasePresentazione"));

                statement.close();
                connessione.close();
                return usr;
            }
            
            statement.close();
            connessione.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public int getIdByUsernameAndPassword(String username, String password){
        try {
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT utente_id FROM utente" + " WHERE email = ? AND password = ?";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int id = result.getInt("utente_id");

                statement.close();
                connessione.close();
                return id;
            }

            statement.close();
            connessione.close();
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    
    
    public List<User> getRegisteredUser() {

        List<User> registeredUserList = new ArrayList<>();
        try {
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM utente";

            PreparedStatement statement = connessione.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User usr = new User();
                usr.setId(result.getInt("utente_id"));
                usr.setNome(result.getString("nome"));
                usr.setCognome(result.getString("cognome"));
                usr.setEmail(result.getString("email"));
                usr.setPassword(result.getString("password"));
                usr.setUrlFotoProfilo(result.getString("urlFotoProfilo"));
                usr.setDataDiNascita(result.getString("dataDiNascita"));
                usr.setFrasePresentazione(result.getString("frasePresentazione"));

                registeredUserList.add(usr);
            }

            statement.close();
            connessione.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return registeredUserList;
    }
    
    public List getUserList(String nome) {
        List<User> listaUtentiRegistrati = new ArrayList<>();

        try {
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM utente" + " WHERE nome LIKE ?";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setString(1, "%" + nome + "%");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User usr = new User();
                usr.setId(result.getInt("utente_id"));
                usr.setNome(result.getString("nome"));
                usr.setCognome(result.getString("cognome"));
                usr.setPassword(result.getString("password"));
                usr.setEmail(result.getString("email"));
                usr.setUrlFotoProfilo(result.getString("urlFotoProfilo"));
                usr.setDataDiNascita(result.getString("dataDiNascita"));
                usr.setFrasePresentazione(result.getString("frasePresentazione"));

                listaUtentiRegistrati.add(usr);
            }

            statement.close();
            connessione.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaUtentiRegistrati;
    }
    
    
    
    public void setDatiProfilo(String nome, String cognome, String dataDiNascita, String password, String frasePresentazione, int id) {

        try {

            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            if (frasePresentazione.length() > 0) {
                String query = "UPDATE utente"
                        + " SET nome = ?, cognome = ?, dataDiNascita = ?, password = ?, frasePresentazione = ?"
                        + " WHERE utente_id = ?";

                PreparedStatement statement = connessione.prepareStatement(query);

                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, dataDiNascita);
                statement.setString(4, password);
                statement.setString(5, frasePresentazione);
                statement.setInt(6, id);

                statement.executeUpdate();
            } else {
                String query = "UPDATE utente"
                        + " SET nome = ?, cognome = ?, dataDiNascita = ?, password = ?"
                        + " WHERE utente_id = ?";

                PreparedStatement statement = connessione.prepareStatement(query);

                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, dataDiNascita);
                statement.setString(4, password);
                statement.setInt(5, id);

                statement.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }   
}  