package dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Chambre;
import model.Hotel;

public class GestionImp implements IGestion {
	
	
	Session session;
	 SessionFactory sessionFactory;

	public GestionImp() {
        try {
           

            ServiceRegistry reg1 = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(reg1).getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();

            this.session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Override
	public Hotel getHotelById(int id) {
		
		String sql = "Select h from Hotel h Where h.idh = :id";
		Query<Hotel> query = this.session.createQuery(sql);
		query.setParameter("id", id);
		Hotel hot=query.getSingleResult();
		
		return hot;
		
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		
		    Query<Hotel> query = session.createQuery("Select e from Hotel e ");
		    List<Hotel> hotls = query.getResultList();
		    return hotls;
	

						
	}

	@Override
	public List<Chambre> getAllChambreByIdHotel(int idh) {
	   
	    String sql = "Select c from Chambre c Where c.hotel.idh = :idh";
	    Query<Chambre> query = this.session.createQuery(sql);
	    query.setParameter("idh", idh); 
	    List<Chambre> chambres = query.getResultList();
	   
	    return chambres;
	}


	@Override
	public void addChambre(Chambre c) {
		// TODO Auto-generated method stub
		this.session.getTransaction().begin();
		this.session.save(c);
		this.session.getTransaction().commit();

	}
	 @Override
	    public void addHotel(Hotel hotel) {
	        try {
	            this.session.getTransaction().begin();
	            this.session.save(hotel);
	            this.session.getTransaction().commit();
	        } catch (Exception e) {
	            if (this.session.getTransaction() != null) {
	                this.session.getTransaction().rollback();
	            }
	            e.printStackTrace();
	        }
	    }
}
