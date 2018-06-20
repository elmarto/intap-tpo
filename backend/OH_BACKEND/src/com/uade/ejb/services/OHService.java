package com.uade.ejb.services;

import java.util.ArrayList;
import javax.ejb.Local;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OfertaHoteleraDto;

@Local
public interface OHService {
	
	// THIS METHODS ARE IMPLEMENTED IN OHServiceBean

    public ArrayList<EstablecimientoDto> GetEstablecimientos();
    public EstablecimientoDto CreateNewEstablishment(EstablecimientoDto establecimiento);
    public ArrayList<OfertaHoteleraDto> ListOffers();
//    public OfertaDto createNewOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios, int estado);
//    public OHResponse FormNewOffer();
}
