/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook.classi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edoar
 */
public class PostFactory {

    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory() {
        
        UserFactory userFactory = UserFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Proviamo questo nuovo social!");
        post1.setId(0);
        post1.setUser(userFactory.getUserById(0));

        Post post2 = new Post();
        post2.setContent("img/trueblood.jpg");
        post2.setId(1);
        post2.setUser(userFactory.getUserById(1));
        post2.setPostType(Post.Type.IMAGE);

        Post post3 = new Post();
        post3.setContent("http://fantasyanime.com/valhalla/castlevaniasotn/images/castlevsotnMap-Castle1_25x.jpg");
        post3.setId(2);
        post3.setUser(userFactory.getUserById(2));
        post3.setPostType(Post.Type.IMAGE);
        
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }
    
    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(User usr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(usr)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    List<Post> getPostList(Gruppo grp) {
        
        List<Post> listaPost = new ArrayList<Post>();
        
        for (Post post : this.listaPost) {
            if (post.getUser().equals(grp)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
