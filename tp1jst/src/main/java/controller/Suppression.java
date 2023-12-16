package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Gestiondb;
import model.Etudiant;
import java.util.List;

/**
 * Servlet implementation class Suppression
 */
public class Suppression extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Suppression() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            int studentId = Integer.parseInt(request.getParameter("num"));

            Gestiondb gestiondb = new Gestiondb();
            gestiondb.deleteEtudiant(studentId);

            
            List<Etudiant> etudiants = gestiondb.getAllEtudiants();

         
            session.setAttribute("etudiants", etudiants);

            response.sendRedirect("Liste.jsp");
         
        }
       
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
