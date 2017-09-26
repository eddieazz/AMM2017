/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook;

import com.nerdbook.classi.User;
import com.nerdbook.classi.UserFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author edoar
 */
public class Controlli extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    
    public static boolean sessionExist(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        if(session.getAttribute("loggato") != null && session.getAttribute("loggato").equals(true)){
            return true;
        }
        else{
            return false;
        }
    }   
    public static User getUser(HttpServletRequest request){    
    
        HttpSession session = request.getSession(false);
        String user = request.getParameter("user");

        if(user != null){
           return UserFactory.getInstance().getUserById(Integer.parseInt(user));
        }
        else
            return getUserLogged(request);        
    }
   
    public static User getUserLogged(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Integer idLogged = (Integer)session.getAttribute("IdUtenteLoggato");
        
        User loggedUser = UserFactory.getInstance().getUserById(idLogged);
        return loggedUser;
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
