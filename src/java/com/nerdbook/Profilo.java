/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook;

import com.nerdbook.classi.Gruppo;
import com.nerdbook.classi.GruppoFactory;
import com.nerdbook.classi.User;
import com.nerdbook.classi.UserFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author edoar
 */
public class Profilo extends HttpServlet {

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

            User user = Controlli.getUserLogged(request);

            List<User> friends = UserFactory.getInstance().getRegisteredUser();
            if (user != null) {
                request.setAttribute("utenteLoggato", user);
                request.setAttribute("amiciUtente", friends);

                List<Gruppo> groups = GruppoFactory.getInstance().allGroups();
                request.setAttribute("gruppitUente", groups);

                if (request.getParameter("confermaDati") != null) {
                    if (getDatiProfilo(request) == true) {
                        request.setAttribute("risultatoProfilo", "dati inseriti con successo");
                    } else {
                        request.setAttribute("risultatoProfilo", "le password non coincidono!");
                    }
                }

                request.getRequestDispatcher("profilo.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            request.getRequestDispatcher("Login").forward(request, response);
        }
    }

    
    public boolean getDatiProfilo(HttpServletRequest request) {

        String nomeUtente = request.getParameter("nomeUtente");
        String cognomeUtente = request.getParameter("cognomeUtente");
        String dataDiNascita = request.getParameter("dataDiNascita");
        String frasePresentazione = request.getParameter("frasePresentazione");
        String password = request.getParameter("password");
        String confermaPassword = request.getParameter("confermaPassword");

        User user = Controlli.getUserLogged(request);

        if (password.equals(confermaPassword)){      
            UserFactory.getInstance().setDatiProfilo(nomeUtente, cognomeUtente, dataDiNascita, password, frasePresentazione, user.getId());
            return true;
        } else {
            return false;
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
