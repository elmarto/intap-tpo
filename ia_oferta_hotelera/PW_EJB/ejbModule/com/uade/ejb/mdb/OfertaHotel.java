package com.uade.ejb.mdb;

import javax.annotation.PostConstruct;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.dao.Mensajes;
import com.uade.ejb.mdb.messages.OfertaHotelMessage;

public class OfertaHotel implements MessageListener {

    @PersistenceContext(unitName = "PW")
    private EntityManager em;

    private Mensajes mensajes;
    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        mensajes = new Mensajes(em);
        mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    @Override
    public void onMessage(Message msg) {
        try {
            OfertaHotelMessage ofertaHotelMessage = mapper.readValue(((TextMessage) msg).getText(), OfertaHotelMessage.class);

            System.out.println(((TextMessage) msg).getText());
            System.out.println(ofertaHotelMessage);

            mensajes.procesarMensaje(ofertaHotelMessage);
        } catch (Exception e) {
            e.printStackTrace();
            Backoffice.log("Nueva Oferta Hotel", "ERROR: " + e.getMessage());
        }
    }
}
