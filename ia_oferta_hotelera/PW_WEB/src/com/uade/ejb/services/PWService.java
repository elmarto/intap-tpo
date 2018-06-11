package com.uade.ejb.services;

import java.sql.Date;
import java.util.Collection;
import javax.ejb.Local;
import com.uade.ejb.dto.EstablecimientoDto;
import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.ServicioDto;

@Local
public interface PWService {

    public Response GetEstablecimientos();
//    public Response Login(String email, String pass);
//    public Response CreateNewEstablishment(EstablecimientoDto establecimiento);
//    public Response ListOffers();
//    public Response FormNewOffer();
//    public Response createNewOffer(String nombre_establecimiento, String nombre, Date fechaDesde, Date fechaHasta, int cuota, int canitdad, Collection<ServicioDto> servicios, int estado);
}
