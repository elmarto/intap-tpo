package com.uade.ejb.services;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import com.uade.ejb.dao.EstablecimientoDAO;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaHoteleraDto;
import com.uade.ejb.entities.EstablecimientoEntity;

@Stateless
public class OHServiceBean implements OHService {

    private EstablecimientoDAO establecimientosDAO;
//    private HotelDAO hotelDAO;
//    private OfertasDAO ofertasDAO;
//    private ServiciosDAO serviciosDAO; 

    @PostConstruct
    public void init() {
        establecimientosDAO = new EstablecimientoDAO();
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
		ArrayList<EstablecimientoDto> establecimientos = (ArrayList<EstablecimientoDto>) establecimientosDAO.GetEstablecimientos();
        return establecimientos;
    }
    
    @Override
    public EstablecimientoDto CreateNewEstablishment(EstablecimientoDto establecimiento) {
    	return establecimientosDAO.CreateNewEstablishment(new EstablecimientoEntity(establecimiento));
    }
    
    @Override
    public ArrayList<OfertaHoteleraDto> ListOffers() {
    	// Collection<OfertaDto> ofertas = ofertasDAO.GetAllOffers();
    	ArrayList<OfertaHoteleraDto> ofertas = new ArrayList<OfertaHoteleraDto>();
    	OfertaHoteleraDto e = new OfertaHoteleraDto();
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
