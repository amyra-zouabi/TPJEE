package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Gestiondb;
import model.Etudiant;

/**
 * Servlet implementation class Ajouter
 */
public class Ajouter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Ajouter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	 
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String tel = request.getParameter("tel");

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            int num = Integer.parseInt(request.getParameter("num"));

            Etudiant etudiant = new Etudiant(num, prenom, nom, tel);

            Gestiondb gestiondb = new Gestiondb();
            gestiondb.addEtudiant(etudiant);

           
            List<Etudiant> etudiants = gestiondb.getAllEtudiants();

            
            session.setAttribute("etudiants", etudiants);

            response.sendRedirect("Liste.jsp");
            
           
    

            
        }
       
    }
}
