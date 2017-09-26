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
public class GruppoFactory {

    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }
    
    
    private String connectionString;

    private ArrayList<Gruppo> listaGruppi = new ArrayList<>();
    
    private GruppoFactory() {
    }    
    
    public Gruppo getGruppoById(int id){
        try {
            
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");
            
            String query = "SELECT * FROM gruppo " + "WHERE id_gruppo = ?";
        
            PreparedStatement statement = connessione.prepareStatement(query);
        
            statement.setInt(1, id);
        
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                Gruppo gruppo = new Gruppo();
                gruppo.setId(result.getInt("id_gruppo"));
                gruppo.setName(result.getString("nome_gruppo"));
                gruppo.setAmministratore(UserFactory.getInstance().getUserById(result.getInt("amministratore")));
                gruppo.setUserList(GruppoFactory.getInstance().membriGruppo(result.getInt("id_gruppo")));
                
                statement.close();
                connessione.close();
                return gruppo;
            }

            statement.close();
            connessione.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    
    public List<Gruppo> getGruppoUserList(int id) {

        List<Gruppo> listaGruppi = new ArrayList<>();

        try {
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM gruppo_utente" + " JOIN gruppo"
                    + " ON gruppo.id_gruppo = gruppo_utente.id_gruppo "
                    + "WHERE gruppo_utente.utente_id = ? ";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Gruppo gruppo = new Gruppo();
                gruppo.setId(result.getInt("id_gruppo"));
                gruppo.setName(result.getString("nome_gruppo"));
                gruppo.setAmministratore(UserFactory.getInstance().getUserById(result.getInt("amministratore")));
                gruppo.setUserList(GruppoFactory.getInstance().membriGruppo(result.getInt("id_gruppo")));
                listaGruppi.add(gruppo);
            }
            statement.close();
            connessione.close();
            return listaGruppi;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    public List<Gruppo> allGroups() {

        List<Gruppo> listaGruppi = new ArrayList<>();

        try {

            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM gruppo";

            PreparedStatement statement = connessione.prepareStatement(query);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Gruppo gruppo = new Gruppo();
                gruppo.setId(result.getInt("id_gruppo"));
                gruppo.setName(result.getString("nome_gruppo"));
                gruppo.setAmministratore(UserFactory.getInstance().getUserById(result.getInt("fondatore")));
                gruppo.setUserList(GruppoFactory.getInstance().membriGruppo(result.getInt("id_gruppo")));

                listaGruppi.add(gruppo);
            }

            statement.close();
            connessione.close();

            return listaGruppi;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    public List<User> membriGruppo(int gruppo){
    
    List<User> listaMembri = new ArrayList<>();

        try {

            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM gruppo_utente" + " JOIN utente"
                    + " ON utente.utente_id = gruppo_utente.utente_id "
                    + "WHERE gruppo_utente.id_gruppo = ? ";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setInt(1, gruppo);

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

                listaMembri.add(usr);
            }
            statement.close();
            connessione.close();
            return listaMembri;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listaMembri;
    }
    
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
    
}
