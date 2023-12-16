package dao;

import java.util.List;

import model.Chambre;
import model.Hotel;



public interface IGestion {
		Hotel getHotelById(int id);
		List<Hotel>getAllHotel();
		List<Chambre> getAllChambreByIdHotel(int idh); 
		void addChambre(Chambre c);
	     void addHotel(Hotel hotel);
	

}
