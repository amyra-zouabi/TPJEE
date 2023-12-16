package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Gestiondb;
import model.Etudiant;

/**
 * Servlet implementation class Verification
 */
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Verification() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Gestiondb gestiondb = new Gestiondb();

        if (gestiondb.verif(username, password)) {
            
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);

           
            List<Etudiant> etudiants = gestiondb.getAllEtudiants();
            System.out.println("Nombre d'étudiants récupérés : " + etudiants.size());
            session.setAttribute("etudiants", etudiants);

     
            RequestDispatcher rd = request.getRequestDispatcher("Liste.jsp");
            rd.forward(request, response);
        } else {
           
        	
            RequestDispatcher rd = request.getRequestDispatcher("Authentification.jsp");
            rd.forward(request, response);
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	

    }
	}


