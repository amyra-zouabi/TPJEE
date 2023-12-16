package model;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.*;
@Entity
public class Chambre {

		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 
	private int idc;
	private String titre;
	private int nblits;


	@ManyToOne
	@JoinColumn(name="idh")
	private Hotel hotel;


	public Chambre(int idc, String titre, int nblits, Hotel hotel) {
		super();
		this.idc = idc;
		this.titre = titre;
		this.nblits = nblits;
		this.hotel = hotel;
	}


	public int getIdc() {
		return idc;
	}


	public void setIdc(int idc) {
		this.idc = idc;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getNblits() {
		return nblits;
	}


	public void setNblits(int nblits) {
		this.nblits = nblits;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Chambre() {
		super();
	}



	}


