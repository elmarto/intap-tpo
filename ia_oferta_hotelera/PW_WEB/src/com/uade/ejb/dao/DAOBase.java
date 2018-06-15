package com.uade.ejb.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.entities.HotelEntity;
import com.uade.ejb.entities.OfferEntity;

import com.uade.ejb.hibernate.HibernateUtil;

public class DAOBase {
	protected static SessionFactory sf = null;
	protected Session s;

	public DAOBase() {
		sf = HibernateUtil.getSessionFactory();
    }
	
	public Session getSession() {
		if (s == null || s.isOpen() == false) {
			s = sf.openSession();
		}
		return s;
	}
	
	public void guardar(Object obj) {
		s = getSession();
		s.beginTransaction();
		s.persist(obj);
		s.getTransaction().commit();
		s.flush();
		s.close();
	}

	public void saveOrUpdate(Object obj) {
		Session s = getSession();
		s.saveOrUpdate(obj);
		s.close();
	}
	
	public Object buscar(String className, String campo, String id) {
		try {
			Session s = getSession();
			return s.createQuery(
					"from " + className + " s where s." + campo + " = ?")
					.setString(0, id).list().get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return null;
	}	

    protected List<EstablishmentEntity> getEstablecimientos() {
        org.hibernate.Query query = s.createQuery("from EstablishmentEntity");
        try {
        	List<EstablishmentEntity> establishments = (List<EstablishmentEntity>) query.list();
        	return establishments;
        }
        catch(NoResultException e) {
        	return null;
        }
    }
    
    protected EstablishmentEntity searchEstablishment(String name) {
		return (EstablishmentEntity) buscar("Establishment", "name", name);    		
    }
    
    protected HotelEntity searchUserHotel(String email, String pass) {
    	Query query = s.createQuery("FROM HOTEL h where h.email = :email and h.pass = :pass");
    	query.setParameter("email", email);
    	query.setParameter("pass", pass);
    	try {
    		HotelEntity hotel = (HotelEntity) query.uniqueResult();
    		
    		if(hotel.userVerification(email, pass)) {
    			return hotel;
    		}
    		
    		return null;
    	}
    	catch(NoResultException e) {
    		return null;
    	}
    }
    
    protected List<OfferEntity> getOffers() {
        Query query = s.createQuery("FROM Offer");
        try {
        	List<OfferEntity> offers = query.list();
        	return offers;
        }
        catch(NoResultException e) {
        	return null;
        }
    }
/*
    protected ServicioEntity getServicio(String descripcion) {
        String codigoServicio = getCodigo(PREFIJO_SERVICIO, descripcion);
        ServicioEntity servicioEntity = em.find(ServicioEntity.class, codigoServicio);
        if (servicioEntity == null) {
            servicioEntity = new ServicioEntity();
            servicioEntity.setCodigo(codigoServicio);
            servicioEntity.setDescripcion(descripcion.trim());
            em.persist(servicioEntity);
        }
        return servicioEntity;
    }

    protected MedioPagoEntity getMedioPago(int codigo) {
        MedioPagoEntity medioPagoEntity = em.find(MedioPagoEntity.class, codigo);
        if (medioPagoEntity == null) {
            medioPagoEntity = new MedioPagoEntity();
            medioPagoEntity.setCodigo(codigo);
            medioPagoEntity.setDescripcion(MEDIOS_PAGO[codigo]);
            em.persist(medioPagoEntity);
        }
        return medioPagoEntity;
    }

    protected OfertaEntity getOfertaHotel(int codigo) {
        Query query = em.createQuery("from OfertaEntity o"
                + " where o.tipo = 'HOTEL'"
                + " and o.codigo = :codigo");
        query.setParameter("codigo", codigo);
        try {
            return (OfertaEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected OfertaEntity getOfertaPaquete(int codigo) {
        Query query = em.createQuery("from OfertaEntity o"
                + " where o.tipo = 'PAQUETE'"
                + " and o.codigo = :codigo");
        query.setParameter("codigo", codigo);
        try {
            return (OfertaEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    protected String getCodigo(String prefijo, String descripcion) {
        return prefijo + "-" + descripcion.toUpperCase().trim().replace(' ', '-');
    }  
*/
    
}
