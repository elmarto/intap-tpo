package com.uade.ejb.startup;

import java.sql.Date;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.dao.CiudadDAO;
import com.uade.ejb.dao.EstablecimientoDAO;
import com.uade.ejb.dao.HotelDAO;
import com.uade.ejb.dao.OfertaHoteleraDAO;
import com.uade.ejb.entities.CiudadEntity;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.HotelEntity;
import com.uade.ejb.entities.MapaEntity;
import com.uade.ejb.entities.OfertaHoteleraEntity;
import com.uade.ejb.mdb.RemoteQueueInteractor;
import com.uade.ejb.services.OHServiceBean;
import com.uade.ejb.tools.ConsoleLogger;

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
    	establecimiento.setFotosEstablecimiento("");
    	establecimiento.setMapa(new MapaEntity("50", "50"));
    	establecimiento.setNombre("Sheraton Mar del Plata");
    	establecimientoDao.CreateNewEstablishment(establecimiento);
    	Backoffice.enviarSolicitudHotelera(establecimiento);
    	
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
    	ofertaHotelera.setServicios("Pileta");
    	ofertaHotelera.setTipoHabitacion("DOBLE");
    	ofertaHoteleraDAO.CreateNewOffer(ofertaHotelera);
    	RemoteQueueInteractor queue;
    	try {
			queue = new RemoteQueueInteractor();
			System.out.println(ofertaHotelera.toString());
			// String mock = "{\"id\":0,\"nombre\":\"Oferton en la feliz\",\"precio\":500.0,\"cupo\":20,\"mediosDePago\":\"Visa\",\"tipoHabitacion\":\"DOBLE\",\"establecimiento\":{\"id\":1,\"nombre\":\"Sheraton Mar del Plata\",\"direccion\":\"Enrique Segoviano 2992\",\"descripcion\":null,\"uid\":null,\"fotosEstablecimiento\":\"\",\"ciudad\":{\"id\":10001,\"city_name\":\"Arauco\"},\"hotel\":{\"id\":1,\"nombre\":\"Sheraton\"},\"mapa\":{\"id\":1,\"lat\":\"50\",\"lon\":\"50\"},\"estrellas\":0},\"fechaDesde\":\"1969-12-30\",\"fechaHasta\":\"1969-12-30\",\"politicas\":\"Valido solo durante los dias de semana\",\"servicios\":\"['Pileta']\"}";
			queue.sendTextMessage(ofertaHotelera.toString());
			// queue.sendTextMessage(mock);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}