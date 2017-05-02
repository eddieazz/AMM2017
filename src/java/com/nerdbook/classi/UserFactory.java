/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook.classi;

import java.util.ArrayList;

/**
 *
 * @author edoar
 */
public class UserFactory {
    
    //Pattern Design Singleton
    private static UserFactory singleton;

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    private ArrayList<User> listaUsers = new ArrayList<User>();
    
      private UserFactory() {
        //Creazione utenti

        //Edoardo
        User user1 = new User();
        user1.setId(0);
        user1.setNome("Edoardo");
        user1.setCognome ("Azzaro");
        user1.setEmail("edoardo.azzaro@gmail.com");
        user1.setUrlFotoProfilo("images/edoardo.jpg");
        user1.setDataDiNascita ("16/03/1988");
        user1.setPassword("123");
        user1.setFrasePresentazione("Nerd, studente di Informatica e membro della Giocomix Crew");
        
        //Alucard
        User user2 = new User();
        user2.setId(1);
        user2.setNome("Adrian Fahrenheit");
        user2.setCognome ("Ţepeş");
        user2.setEmail("alucard.sonofdracula@gmail.com");
        user2.setUrlFotoProfilo("images/alucard.jpg");
        user2.setDataDiNascita ("04/11/1413");
        user2.setPassword("123");
        user2.setFrasePresentazione("Figlio di Dracula, sostenitore dell'umanità!");
        
        //Richter
        User user3 = new User();
        user3.setId(2);
        user3.setNome("Richter");
        user3.setCognome ("Belmont");
        user3.setEmail("richter.belmont@gmail.com");
        user3.setUrlFotoProfilo("images/richter.jpg");
        user3.setDataDiNascita ("13/09/1773");
        user3.setPassword("123");
        user3.setFrasePresentazione("Cacciatore di vampiri per professione!");
        
        //Utente incompleto
        User user4 = new User();
        user4.setId(3);
        user4.setNome(null);
        user4.setCognome (null);
        user4.setEmail(null);
        user4.setUrlFotoProfilo(null);
        user4.setDataDiNascita (null);
        user4.setPassword(null);
        user4.setFrasePresentazione(null);
        
        listaUsers.add(user1);
        listaUsers.add(user2);
        listaUsers.add(user3);
        listaUsers.add(user4);
    
      }
      
      public User getUserById(int id) {
        for (User user : this.listaUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public int getIdByUsernameAndPassword(String username, String password){
        for(User user : this.listaUsers){
            if(user.getNome().equals(username) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return -1;
    }
}

    