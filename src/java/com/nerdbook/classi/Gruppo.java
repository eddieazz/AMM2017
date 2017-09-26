/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edoar
 */
public class Gruppo {
        
    //Attributi
    private String name;
    private int id;
    private List<Post> postList;
    private List<User> members;
    private User amministratore;
    private String descrizione;
    
    //Costruttore
    public Gruppo() {
        this.name = "";
        this.id = 0;
        postList = new ArrayList<>();
        members = new ArrayList<>();
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the post
     */
    public List getPostList() {
        return postList;
    }

    
    public void setPostList(Post newPost) {
        postList.add(newPost);
    }

    
    public void addUser(User newUser) {
        members.add(newUser);
    }
    
    /**
     * @return the user
     */
    public List<User> getUserList() {
        return members;
    }


    public void setUserList(List<User> newUser) {
        members = newUser;
    }

    /**
     * @return the amministratore
     */
    public User getAmministratore() {
        return amministratore;
    }

    /**
     * @param amministratore the amministratore to set
     */
    public void setAmministratore(User amministratore) {
        this.amministratore = amministratore;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    @Override
    public boolean equals (Object altroGruppo) {
        if(altroGruppo != null)
            if (altroGruppo instanceof Gruppo)
                if (this.getId() == ((Gruppo)altroGruppo).getId()) 
                    return true;
        return false;
    }
}
