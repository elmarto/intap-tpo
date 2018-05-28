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
import com.uade.ejb.mdb.messages.OfertaPaqueteMessage;

public class OfertaPaquete implements MessageListener {

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
            OfertaPaqueteMessage ofertaPaqueteMessage = mapper.readValue(((TextMessage) msg).getText(), OfertaPaqueteMessage.class);

            System.out.println(((TextMessage) msg).getText());
            System.out.println(ofertaPaqueteMessage);

            mensajes.procesarMensaje(ofertaPaqueteMessage);
        } catch (Exception e) {
            e.printStackTrace();
            Backoffice.log("Nueva Oferta Paquete", "ERROR: " + e.getMessage());
        }
    }
}
