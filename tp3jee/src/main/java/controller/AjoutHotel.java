package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionImp;
import model.Hotel;

/**
 * Servlet implementation class AjoutHotel
 */
public class AjoutHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutHotel() {
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
		 String titreHotel = request.getParameter("titre");
		    String lieuHotel = request.getParameter("lieu");

		    System.out.println(titreHotel);
		    System.out.println(lieuHotel );
		    Hotel nouvelHotel = new Hotel();
		    nouvelHotel.setTitre(titreHotel);
		    nouvelHotel.setLieu(lieuHotel);

		    GestionImp gestionDao = new GestionImp();
		    gestionDao.addHotel(nouvelHotel);
		    response.sendRedirect("index.jsp");
	}

}
