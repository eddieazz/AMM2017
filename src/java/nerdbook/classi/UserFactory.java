/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

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
        user1.setId(1);
        user1.setNome("Adrian Fahrenheit");
        user1.setCognome ("Ţepeş");
        user1.setEmail("alucard.sonofdracula@gmail.com");
        user1.setUrlFotoProfilo("images/alucard.jpg");
        user1.setDataDiNascita ("04/11/1413");
        user1.setPassword("123");
        user1.setFrasePresentazione("Figlio di Dracula, sostenitore dell'umanità!");
        
        //Richter
        User user3 = new User();
        user1.setId(2);
        user1.setNome("Richter");
        user1.setCognome ("Belmont");
        user1.setEmail("richter.belmont@gmail.com");
        user1.setUrlFotoProfilo("images/richter.jpg");
        user1.setDataDiNascita ("13/09/1773");
        user1.setPassword("123");
        user1.setFrasePresentazione("Cacciatore di vampiri per professione!");
        
        listaUsers.add(user1);
        listaUsers.add(user2);
        listaUsers.add(user3);
    
      }
      
      public User getUserById(int id) {
        for (User user : this.listaUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public int getIdByNameAndPassword(String name, String password){
        for(User user : this.listaUsers){
            if(user.getNome().equals(name) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return -1;
    }
}

    