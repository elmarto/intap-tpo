package com.uade.ejb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.entities.DestinoEntity;
import com.uade.ejb.entities.EstablishmentEntity;

public class DAOBase {
    public static final String PREFIJO_DESTINO = "DST";
    public static final String PREFIJO_SERVICIO = "SRV";

    public static final String[] MEDIOS_PAGO = new String[] {
            "", "Tarjeta de credito", "Cheque", "Pago en destino", "MercadoPago", "PayPal"
    };

    protected EntityManager em;

    public DAOBase(EntityManager em) {
        this.em = em;
    }

    protected List<EstablishmentEntity> getEstablecimientos() {
        Query query = em.createQuery("FROM Establishment");
        try {
        	List<EstablishmentEntity> establishments = query.getResultList();
        	return establishments;
        }
        catch(NoResultException e) {
        	return null;
        }
    }

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
    

}
