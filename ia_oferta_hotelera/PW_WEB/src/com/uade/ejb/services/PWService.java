package com.uade.ejb.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Local;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.OHResponse;
import com.uade.ejb.dto.OfertaDto;
import com.uade.ejb.dto.ServicioDto;

@Local
public interface PWService {

    public ArrayList<EstablecimientoDto> GetEstablecimientos();
//    public OHResponse Login(String email, String pass);
//    public OHResponse CreateNewEstablishment(EstablecimientoDto establecimiento);
    public ArrayList<OfertaDto> ListOffers();
//    public OfertaDto createNewOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios, int estado);
//    public OHResponse FormNewOffer();
}
