/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nerdbook;

import com.nerdbook.classi.UserFactory;
import com.nerdbook.classi.User;
import com.nerdbook.classi.PostFactory;
import com.nerdbook.classi.GruppoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edoar
 */
@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    
    @Override
    public void init() {
        
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
 
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex){

            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        UserFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
        GruppoFactory.getInstance().setConnectionString(dbConnection);
    }
    
    
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
        
        doLogout(request, response);

        if (doLogin(request)) {
            postLogin(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    public boolean doLogin(HttpServletRequest request)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean sessioneEsistente;
        sessioneEsistente = Controlli.sessionExist(request);
        if (sessioneEsistente == true) {
            return true;
        } else {
            if (username == null || password == null) {
                return false;
            }
            
            int id = UserFactory.getInstance().getIdByUsernameAndPassword(username, password);
            if (id > -1) {

                HttpSession session = request.getSession();
                session.setAttribute("loggato", true);
                session.setAttribute("IdUtenteLoggato", id);
                return true;
            } else {
                request.setAttribute("errori", true);
                return false;
            }
        }
    }
    
    
     private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String decisioneLogout = request.getParameter("decisione");
        if (decisioneLogout != null && decisioneLogout.equals("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void postLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Profilo").forward(request, response);
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
