/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook;

import com.nerdbook.classi.Post;
import com.nerdbook.classi.PostFactory;
import com.nerdbook.classi.User;
import com.nerdbook.classi.UserFactory;
import com.nerdbook.classi.Gruppo;
import com.nerdbook.classi.GruppoFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edoar
 */
public class Bacheca extends HttpServlet {
    Post post;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        if (Controlli.sessionExist(request)) {
            //restituisco l'utente da visualizzare
            User user = Controlli.getUser(request);

            List<User> friends = UserFactory.getInstance().getRegisteredUser();
            if (user != null) {
                request.setAttribute("utente", user);
                request.setAttribute("amiciUtente", friends);
                request.setAttribute("UtenteLoggato", Controlli.getUserLogged(request));

                List<Gruppo> gruppi = GruppoFactory.getInstance().allGroups();
                request.setAttribute("gruppiUtente", gruppi);

                if (request.getParameter("pubblicaPost") != null) {
                    publicPost(request);

                }
                erasePost(request);

                List<Post> elencoPost = PostFactory.getInstance().getPostList(user);
                request.setAttribute("posts", elencoPost);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            request.getRequestDispatcher("Login").forward(request, response);
        }
    }

    
    public void publicPost(HttpServletRequest request) {

        User user = Controlli.getUser(request);

        String testPost = request.getParameter("postDiTesto");
        String imagePost = request.getParameter("postImmagine");

        if (testPost.length() != 0 || imagePost.length() != 0) {
            Post post = new Post();
            post.setContent(testPost);
            post.setImagePost(imagePost);
            if (imagePost == null || imagePost.length() == 0) {
                post.setPostType(Post.Type.TEXT);
            } else {
                post.setPostType(Post.Type.IMAGE);
            }
            post.setUser(user);
            PostFactory.getInstance().addPost(post);
            request.setAttribute("postPubblicatoConSuccesso", true);
        } else {
            String postvuoto = "Post Vuoto";
            request.setAttribute("postVuoto", postvuoto);
        }
    }

    public void erasePost(HttpServletRequest request) {

        String erasingPost = request.getParameter("cancellaPost");

        if (erasingPost != null) {
            int delete = Integer.parseInt(erasingPost);
            PostFactory.getInstance().deletePost(delete);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
