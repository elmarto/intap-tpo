package com.uade.ejb.services;

import javax.ejb.Local;

import com.uade.ejb.dto.Response;
import com.uade.ejb.dto.busqueda.BusquedaHotel;
import com.uade.ejb.dto.busqueda.BusquedaPaquete;
import com.uade.ejb.dto.reserva.ReservaHotel;
import com.uade.ejb.dto.reserva.ReservaPaquete;

@Local
public interface PWService {

    /**
     * Obtiene todos los establecimientos
     *
     * @param BusquedaHotel
     *            busquedaHotel
     * @return Response List<EstablecimientoDto>
     */

    public Response GetEstablecimientos();
}
