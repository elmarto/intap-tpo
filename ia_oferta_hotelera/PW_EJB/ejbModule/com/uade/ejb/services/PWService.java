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
     * Obtiene todas las ofertas de hoteles vigentes sin detalles
     *
     * @param BusquedaHotel
     *            busquedaHotel
     * @return Response List<Oferta>
     */

    public Response buscarHoteles(BusquedaHotel busquedaHotel);

    /**
     * Obtiene el detalle del hotel
     *
     * @param int
     *            idOferta
     * @return Response DetalleHotel
     */

    public Response getDetallesHotel(int idOferta);

    /**
     * Obtiene todas las ofertas de paquetes vigentes sin detalles
     *
     * @param BusquedaPaquete
     *            busquedaPaquete
     * @return Response List<Oferta>
     */

    public Response buscarPaquetes(BusquedaPaquete busquedaPaquete);

    /**
     * Obtiene el paquete con el detalle incluido
     *
     * @param int
     *            idOferta
     * @return Response DetallePaquete
     */

    public Response getDetallesPaquete(int idOferta);

    /**
     * Reservar hotel
     *
     * @return Response
     */

    public Response reservarHotel(ReservaHotel reserva);

    /**
     * Reservar paquete
     *
     * @return Response
     */

    public Response reservarPaquete(ReservaPaquete reserva);

    /**
     * Obtiene el listado de destinos disponibles
     *
     * @return Response List<String>
     */

    public Response getDestinos();
}
