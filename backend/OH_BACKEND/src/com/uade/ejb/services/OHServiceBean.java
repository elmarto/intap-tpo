package com.uade.ejb.services;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

import com.uade.ejb.backoffice.Backoffice;
import com.uade.ejb.dao.EstablecimientoDAO;
import com.uade.ejb.dao.OfertaHoteleraDAO;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaHoteleraDto;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.OfertaHoteleraEntity;
import com.uade.ejb.mdb.RemoteQueueInteractor;

@Stateless
public class OHServiceBean implements OHService {

    private EstablecimientoDAO establecimientosDAO;
    private OfertaHoteleraDAO ofertaHoteleraDAO;
//    private ServiciosDAO serviciosDAO; 

    @PostConstruct
    public void init() {
        establecimientosDAO = new EstablecimientoDAO();
        ofertaHoteleraDAO = new OfertaHoteleraDAO();   
    }
    
    @Override
    public ArrayList<EstablecimientoDto> GetEstablecimientos() {
		ArrayList<EstablecimientoDto> establecimientos = (ArrayList<EstablecimientoDto>) establecimientosDAO.GetEstablecimientos();
        return establecimientos;
    }
    
    @Override
    public EstablecimientoDto CreateNewEstablishment(EstablecimientoDto establecimiento) {
    	EstablecimientoEntity establecimientoEntity = new EstablecimientoEntity(establecimiento);
    	establecimientosDAO.CreateNewEstablishment(establecimientoEntity);
    	Backoffice.enviarSolicitudHotelera(establecimientoEntity);
    	return establecimiento;
    }
    
    @Override
    public ArrayList<OfertaHoteleraDto> ListOffers() {
    	ArrayList<OfertaHoteleraDto> ofertas = (ArrayList<OfertaHoteleraDto>) ofertaHoteleraDAO.ListOffers();
        return ofertas;
    }
    
    @Override
    public OfertaHoteleraDto createNewOffer(OfertaHoteleraDto oferta) {
    	OfertaHoteleraEntity ofertaEntity = new OfertaHoteleraEntity(oferta);
    	RemoteQueueInteractor queue;
		try {
			queue = new RemoteQueueInteractor();
			System.out.println(oferta.toString());
			// String mock = "{\"id\":0,\"nombre\":\"Oferton en la feliz\",\"precio\":500.0,\"cupo\":20,\"mediosDePago\":\"Visa\",\"tipoHabitacion\":\"DOBLE\",\"establecimiento\":{\"id\":1,\"nombre\":\"Sheraton Mar del Plata\",\"direccion\":\"Enrique Segoviano 2992\",\"descripcion\":null,\"uid\":null,\"fotosEstablecimiento\":\"\",\"ciudad\":{\"id\":10001,\"city_name\":\"Arauco\"},\"hotel\":{\"id\":1,\"nombre\":\"Sheraton\"},\"mapa\":{\"id\":1,\"lat\":\"50\",\"lon\":\"50\"},\"estrellas\":0},\"fechaDesde\":\"1969-12-30\",\"fechaHasta\":\"1969-12-30\",\"politicas\":\"Valido solo durante los dias de semana\",\"servicios\":\"['Pileta']\"}";
			queue.sendTextMessage(oferta.toString());
			// queue.sendTextMessage(mock);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ofertaHoteleraDAO.CreateNewOffer(ofertaEntity);
    }
}
