package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.*;

@Entity
public class Hotel {
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idh;
		private String titre;
		private String lieu;
		
		@OneToMany
		
		List<Chambre> Hotel;

		public Hotel(String titre, String lieu) {
			super();
			this.titre = titre;
			this.lieu = lieu;
		}

		public Hotel(int idh, String titre, String lieu, List<Chambre> hotel) {
			super();
			this.idh = idh;
			this.titre = titre;
			this.lieu = lieu;
			Hotel = hotel;
		}

		public Hotel() {
			super();
		}

		public int getIdh() {
			return idh;
		}

		public void setIdh(int idh) {
			this.idh = idh;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getLieu() {
			return lieu;
		}

		public void setLieu(String lieu) {
			this.lieu = lieu;
		}

		public List<Chambre> getHotel() {
			return Hotel;
		}

		public void setHotel(List<Chambre> hotel) {
			Hotel = hotel;
		}
		
		
	}


