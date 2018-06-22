package com.uade.ejb.services;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import com.uade.ejb.dao.EstablecimientoDAO;
import com.uade.ejb.dao.OfertaHoteleraDAO;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaHoteleraDto;
import com.uade.ejb.entities.EstablecimientoEntity;
import com.uade.ejb.entities.OfertaHoteleraEntity;

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
    	return establecimientosDAO.CreateNewEstablishment(new EstablecimientoEntity(establecimiento));
    }
    
    @Override
    public ArrayList<OfertaHoteleraDto> ListOffers() {
    	ArrayList<OfertaHoteleraDto> ofertas = (ArrayList<OfertaHoteleraDto>) ofertaHoteleraDAO.ListOffers();
        return ofertas;
    }
    
    @Override
    public OfertaHoteleraDto createNewOffer(OfertaHoteleraDto oferta) {
    	return ofertaHoteleraDAO.CreateNewOffer(new OfertaHoteleraEntity(oferta));
    }
}
