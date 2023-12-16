package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionImp;
import model.Chambre;

/**
 * Servlet implementation class AjouterChambre
 */
public class AjouterChambre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterChambre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String titre = request.getParameter("titre");
	        int nblits = Integer.parseInt(request.getParameter("nblits"));
	        int idHotel = Integer.parseInt(request.getParameter("idHotel"));

	  
	        GestionImp gestionDao = new GestionImp();

	        
	        Chambre nouvChambre = new Chambre();
	        nouvChambre.setTitre(titre);
	        nouvChambre.setNblits(nblits);

	        
	        nouvChambre.setHotel(gestionDao.getHotelById(idHotel));

	       
	        gestionDao.addChambre(nouvChambre);

	 
	        response.sendRedirect("ServPrinc");	}

}
