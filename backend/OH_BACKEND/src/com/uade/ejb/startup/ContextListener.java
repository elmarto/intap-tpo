package com.uade.ejb.startup;

import java.sql.Date;

import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.uade.ejb.dao.CiudadDAO;
import com.uade.ejb.dao.EstablecimientoDAO;
import com.uade.ejb.dao.HotelDAO;
import com.uade.ejb.dao.OfertaHoteleraDAO;
import com.uade.ejb.entities.CiudadEntity;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.HotelEntity;
import com.uade.ejb.entities.MapaEntity;
import com.uade.ejb.entities.OfertaHoteleraEntity;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	HotelDAO hotelDao = new HotelDAO();
    	HotelEntity hotel = new HotelEntity("Sheraton");
    	hotelDao.createHotel(hotel);
    	
    	CiudadEntity ciudad = new CiudadDAO().loadCiudades();
    	
    	EstablecimientoDAO establecimientoDao = new EstablecimientoDAO();
    	EstablecimientoEntity establecimiento = new EstablecimientoEntity();
    	establecimiento.setCiudad(ciudad);
    	establecimiento.setDescripcion("La descripcion");
    	establecimiento.setDireccion("Enrique Segoviano 2992");
    	establecimiento.setEstrellas(4);
    	establecimiento.setHotel(hotel);
    	establecimiento.setMapa(new MapaEntity("50", "50"));
    	establecimiento.setNombre("Sheraton Mar del Plata");
    	establecimientoDao.CreateNewEstablishment(establecimiento);
    	
    	OfertaHoteleraDAO ofertaHoteleraDAO = new OfertaHoteleraDAO();
    	OfertaHoteleraEntity ofertaHotelera = new OfertaHoteleraEntity();
    	ofertaHotelera.setCupo(20);
    	ofertaHotelera.setEstablecimiento(establecimiento);
    	ofertaHotelera.setFechaDesde(new Date(3456789));
    	ofertaHotelera.setFechaHasta(new Date(4365777));
    	ofertaHotelera.setMediosDePago("Visa");
    	ofertaHotelera.setNombre("Oferton en la feliz");
    	ofertaHotelera.setPoliticas("Valido solo durante los dias de semana");
    	ofertaHotelera.setPrecio(500);
    	ofertaHotelera.setServicios("['Pileta']");
    	ofertaHotelera.setTipoHabitacion("DOBLE");
    	ofertaHoteleraDAO.CreateNewOffer(ofertaHotelera);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}