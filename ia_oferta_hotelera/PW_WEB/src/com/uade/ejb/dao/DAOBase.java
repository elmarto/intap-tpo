package com.uade.ejb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.entities.HotelEntity;
import com.uade.ejb.entities.OfferEntity;

public class DAOBase {
    protected EntityManager em;

	public DAOBase(EntityManager em) {
        this.em = em;
    }

    protected List<EstablishmentEntity> getEstablecimientos() {
        Query query = em.createQuery("from EstablishmentEntity");
        try {
			List<EstablishmentEntity> establishments = (List<EstablishmentEntity>) query.getResultList();
        	return establishments;
        }
        catch(NoResultException e) {
        	return null;
        }
    }
    
    protected EstablishmentEntity searchEstablishment(String name) {
    	Query query = em.createQuery("FROM Establishment h where h.name = :name");
    	query.setParameter("name", name);
    	try {
    		return (EstablishmentEntity) query.getSingleResult();    		
    	}
    	catch(NoResultException e) {
    		return null;
    	}
    }
    
    protected HotelEntity searchUserHotel(String email, String pass) {
    	Query query = em.createQuery("FROM HOTEL h where h.email = :email and h.pass = :pass");
    	query.setParameter("email", email);
    	query.setParameter("pass", pass);
    	try {
    		HotelEntity hotel = (HotelEntity) query.getSingleResult();
    		
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
        Query query = em.createQuery("FROM Offer");
        try {
        	List<OfferEntity> offers = query.getResultList();
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
