/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook.classi;

/**
 *
 * @author edoar
 */
public class Gruppo {
        
    //Attributi
    private String name;
    private int id;
    private Post post;
    private User user;
    private User amministratore;
    private String descrizione;
    
    //Costruttore
    public Gruppo() {
        name = "";
        id = 0;
        post = null;
        user = null;
        amministratore = null;
        descrizione = "";
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
    public Post getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
        if (altroGruppo instanceof Gruppo)
            if (this.getId() == ((Gruppo)altroGruppo).getId()) return true;
        return false;
    }
}
