package com.uade.ejb.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.OfertaHoteleraEntity;
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
		EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
		Object entityFound = entityManager.createQuery("SELECT e FROM "+className+" e WHERE "+campo+"="+id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (entityFound == null) {
            System.out.println("No establishments found.");
        }
        return entityFound;
	}	

    protected List<EstablecimientoEntity> getEstablecimientos() {
    	EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
		List<EstablecimientoEntity> establishmentList = entityManager.createQuery("SELECT e FROM EstablecimientoEntity e").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (establishmentList == null) {
            System.out.println("No establishments found.");
        }
        return establishmentList;
    }
    
    protected EstablecimientoEntity searchEstablishment(String name) {
		return (EstablecimientoEntity) buscar("Establishment", "name", name);    		
    }
  
    
    protected List<OfertaHoteleraEntity> getOffers() {
    	EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
		List<OfertaHoteleraEntity> offerList = entityManager.createQuery("SELECT e FROM OfertaHoteleraEntity e").getResultList();
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
