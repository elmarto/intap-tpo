package com.uade.ejb.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uade.ejb.entities.EstablishmentEntity;
import com.uade.ejb.entities.HotelEntity;
import com.uade.ejb.entities.OfferEntity;
import com.uade.ejb.hibernate.LocalEntityManagerFactory;

@Stateful
public class DAOBase {
	
	public void guardar(Object obj) {
		EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();	
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void saveOrUpdate(Object obj) {
		
	}
	
	public Object buscar(String className, String campo, String id) {
//		try {
//			Session s = getSession();
//			return s.createQuery(
//					"from " + className + " s where s." + campo + " = ?")
//					.setString(0, id).list().get(0);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			s.close();
//		}
		return null;
	}	

    protected List<EstablishmentEntity> getEstablecimientos() {
    	EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
        List<EstablishmentEntity> establishmentList = entityManager.createQuery("SELECT e FROM EstablishmentEntity e").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (establishmentList == null) {
            System.out.println("No establishments found.");
        }
        return establishmentList;
    }
    
    protected EstablishmentEntity searchEstablishment(String name) {
		return (EstablishmentEntity) buscar("Establishment", "name", name);    		
    }
  
    
    protected List<OfferEntity> getOffers() {
    	EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
        List<OfferEntity> offerList = entityManager.createQuery("SELECT e FROM OfferEntity e").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (offerList == null) {
            System.out.println("No offers found.");
        }
        return offerList;
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
