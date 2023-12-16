package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionImp;
import model.Chambre;

/**
 * Servlet implementation class ListeChambres
 */
public class ListeChambres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeChambres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 GestionImp gestion = new GestionImp();
		
		 
		 String idHotelParameter = request.getParameter("id");
		 int idhotel = 0; 
		 if (idHotelParameter != null && !idHotelParameter.isEmpty()) {
		     idhotel = Integer.parseInt(idHotelParameter);
		 }
         
		
		 List<Chambre> lc = gestion.getAllChambreByIdHotel(idhotel);

         request.setAttribute("idhotel", idhotel);
         request.setAttribute("lc", lc);

         request.getRequestDispatcher("chambres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
