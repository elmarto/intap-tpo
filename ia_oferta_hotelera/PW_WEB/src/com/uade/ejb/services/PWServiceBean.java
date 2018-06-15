package com.uade.ejb.services;

import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.uade.ejb.dao.Destinos;
import com.uade.ejb.dao.EstablecimientosDAO;
import com.uade.ejb.dao.HotelDAO;
import com.uade.ejb.dao.OfertasDAO;
import com.uade.ejb.dao.OfertasHoteles;
import com.uade.ejb.dao.OfertasPaquetes;
import com.uade.ejb.dao.Reservas;
import com.uade.ejb.dao.ServiciosDAO;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.EstablecimientoServicioDto;
import com.uade.ejb.dto.HotelDto;
import com.uade.ejb.dto.OfertaDto;
import com.uade.ejb.dto.OHResponse;
import com.uade.ejb.dto.ServicioDto;
import com.uade.ejb.dto.busqueda.BusquedaHotel;
import com.uade.ejb.dto.busqueda.BusquedaPaquete;
import com.uade.ejb.dto.reserva.ReservaHotel;
import com.uade.ejb.dto.reserva.ReservaPaquete;

@Stateless
public class PWServiceBean implements PWService {
	@PersistenceContext(unitName ="PW")
    private EntityManager em;

    private EstablecimientosDAO establecimientosDAO;
//    private HotelDAO hotelDAO;
//    private OfertasDAO ofertasDAO;
//    private ServiciosDAO serviciosDAO; 

    @PostConstruct
    public void init() {
        establecimientosDAO = new EstablecimientosDAO(em);
//        hotelDAO = new HotelDAO(em);
//        ofertasDAO = new OfertasDAO(em);
        
    }

//    @Override
//    public Response Login(String email, String pass) {
//    	HotelDto hotel = hotelDAO.Login(email, pass);
//    	return new Response(true, hotel);
//    }
//    
    @Override
    public ArrayList<EstablecimientoDto> GetEstablecimientos() {
//    	ArrayList<EstablecimientoDto> establecimientos = new ArrayList<EstablecimientoDto>();
//    	EstablecimientoDto e = new EstablecimientoDto();
//    	e.nombre = "Mi nuevo Hotel";
//    	establecimientos.add(e);

		ArrayList<EstablecimientoDto> establecimientos = (ArrayList<EstablecimientoDto>) establecimientosDAO.GetEstablecimientos();
        return establecimientos;
    }
//    
//    @Override
//    public Response CreateNewEstablishment(EstablecimientoDto establecimiento) {
//    	return establecimientosDAO.CreateNewEstablishment(establecimiento.nombre, establecimiento.direccion, establecimiento.fotosEstablecimiento);
//    }
//    
    @Override
    public ArrayList<OfertaDto> ListOffers() {
    	// Collection<OfertaDto> ofertas = ofertasDAO.GetAllOffers();
    	ArrayList<OfertaDto> ofertas = new ArrayList<OfertaDto>();
    	OfertaDto e = new OfertaDto();
    	e.nombre = "Oferta nueva!";
    	ofertas.add(e);
        return ofertas;
    }
    
//    @Override
//    public OfertaDto createNewOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios, int estado) {
//    	// return ofertasDAO.CreateNewOffer(nombre_establecimiento, nombre, fechaDesde, fechaHasta, cuota, canitdad, servicios, estado);
//    	OfertaDto o = new OfertaDto();
//    	o.nombre = "Oferta recien creada!";
//    	return o;
//    }
//    
//    @Override 
//    public Response FormNewOffer() {
//    	Collection<EstablecimientoDto> establecimientos = establecimientosDAO.GetEstablecimientos();
//    	Collection<ServicioDto> servicios = serviciosDAO.getServices();
//    	return new Response(true, new EstablecimientoServicioDto(establecimientos, servicios));
//    }
}
