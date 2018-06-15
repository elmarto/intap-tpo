package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uade.ejb.dto.OHResponse;

public class Destinos extends DAOBase {

    public Destinos(EntityManager em) {
        super(em);
    }

    public OHResponse getDestinos() {
        OHResponse response = null;
        try {
            Query query = em.createQuery("from DestinoEntity d");
            List<String> destinos = new ArrayList<>();
//            for (DestinoEntity destinoEntity : (List<DestinoEntity>) query.getResultList()) {
//                destinos.add(destinoEntity.getDescripcion());
//            }
            response = new OHResponse(true, destinos);
        } catch (Exception e) {
            e.printStackTrace();
            response = new OHResponse(false, e.getMessage());
        }
        return response;
    }
}
