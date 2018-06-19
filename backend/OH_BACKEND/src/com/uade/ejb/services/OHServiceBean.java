package com.uade.ejb.services;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import com.uade.ejb.dao.EstablecimientosDAO;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaDto;
import com.uade.ejb.entities.EstablishmentEntity;

@Stateless
public class OHServiceBean implements OHService {

    private EstablecimientosDAO establecimientosDAO;
//    private HotelDAO hotelDAO;
//    private OfertasDAO ofertasDAO;
//    private ServiciosDAO serviciosDAO; 

    @PostConstruct
    public void init() {
        establecimientosDAO = new EstablecimientosDAO();
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
    	return establecimientosDAO.CreateNewEstablishment(new EstablishmentEntity(establecimiento));
    }
    
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
