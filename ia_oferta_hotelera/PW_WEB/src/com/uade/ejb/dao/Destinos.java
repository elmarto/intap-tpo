package com.uade.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uade.ejb.dto.Response;

public class Destinos extends DAOBase {

    public Destinos(EntityManager em) {
        super(em);
    }

    public Response getDestinos() {
        Response response = null;
        try {
            Query query = em.createQuery("from DestinoEntity d");
            List<String> destinos = new ArrayList<>();
//            for (DestinoEntity destinoEntity : (List<DestinoEntity>) query.getResultList()) {
//                destinos.add(destinoEntity.getDescripcion());
//            }
            response = new Response(true, destinos);
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(false, e.getMessage());
        }
        return response;
    }
}
