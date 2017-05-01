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
public class GruppoFactory {
    
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private GruppoFactory() {
        
        PostFactory postFactory = PostFactory.getInstance();
        UserFactory userFactory = UserFactory.getInstance();
        
        //Creazione Gruppi
        Gruppo gruppo1 = new Gruppo();
        gruppo1.setName("Castlemaniaci");
        gruppo1.setId(0);
        gruppo1.setPost(postFactory.getPostById(2));
        gruppo1.setUser(userFactory.getUserById(2));
        gruppo1.setAmministratore(userFactory.getUserById(0));
        
        Gruppo gruppo2 = new Gruppo();
        gruppo1.setName("Calistenici");
        gruppo1.setId(1);
        gruppo1.setPost(postFactory.getPostById(0));
        gruppo1.setUser(userFactory.getUserById(1));
        gruppo1.setAmministratore(userFactory.getUserById(0));
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
    }
    
    public Gruppo getGruppoById(int id) {
        for (Gruppo gruppo : this.listaGruppi) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }
    
    
    
}
