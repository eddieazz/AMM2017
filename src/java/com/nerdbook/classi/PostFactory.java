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
public class PostFactory {

    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private String connectionString;
    
    private ArrayList<Post> listaPost = new ArrayList<>();
    
    private PostFactory() {
    }

    public Post getPostById(int id) {
        UserFactory userFactory = UserFactory.getInstance();

        try{
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM posts " + "JOIN tipoDiPost ON posts.tipo = tipoDiPost.id_tipoDiPost "
                    + "WHERE id_post = ?";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Post post = new Post();

                post.setId(result.getInt("id_post"));
                post.setContent(result.getString("content"));
                post.setImagePost(result.getString("imagePost"));
                post.setPostType(this.postTypeFromString(result.getString("nome_tipoDiPost")));

                User autore = UserFactory.getInstance().getUserById(result.getInt("amministratore"));
                post.setUser(autore);

                statement.close();
                connessione.close();
                return post;
            }

            statement.close();
            connessione.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
            
    }



    public List getPostList(User usr) {

        List<Post> listaPost = new ArrayList<>();


        try {
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "SELECT * FROM posts " + "JOIN tipoDiPost ON posts.tipo = tipoDiPost.id_tipoDiPost "
                    + "WHERE autore = ?" + " order by id_post DESC";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setInt(1, usr.getId());

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Post post = new Post();
                post.setId(result.getInt("id_post"));
                post.setContent(result.getString("content"));
                post.setImagePost(result.getString("imagePost"));
                post.setPostType(this.postTypeFromString(result.getString("nome_tipoDiPost")));
                post.setUser(usr);

                listaPost.add(post);
            }

            statement.close();
            connessione.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listaPost;
    }
    
    
    public void addPost(Post post) {

        try {
            Connection connessione = DriverManager.getConnection(connectionString, "edoardo", "edoardo");

            String query = "INSERT INTO posts(id_post, testoPost, immaginePost, tipo, autore)"
                    + " VALUES (default, ?, ?, ?, ?)";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setString(1, post.getContent());
            statement.setString(2, post.getImagePost());
            statement.setInt(3, this.postTypeFromEnum(post.getPostType()));
            statement.setInt(4, post.getUser().getId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void deletePost(int id) {

        try {
            Connection connessione = DriverManager.getConnection(connectionString, "luca", "luca");

            String query = "DELETE FROM posts" + " WHERE id_post = ? ";

            PreparedStatement statement = connessione.prepareStatement(query);

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    private Post.Type postTypeFromString(String tipo) {

        if (tipo.equals("IMAGE")) {
            return Post.Type.IMAGE;
        }
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type) {
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if (type == Post.Type.TEXT) {
            return 1;
        } else {
            return 2;
        }
    }
    
    public void setConnectionString(String s) {
        this.connectionString = s;
    }

    public String getConnectionString() {
        return this.connectionString;
    }
}