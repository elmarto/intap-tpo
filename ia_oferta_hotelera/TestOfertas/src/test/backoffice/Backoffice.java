package test.backoffice;

import javax.xml.ws.BindingProvider;

import com.uade.ejb.soap.PrestadorAutorizadoService;
import com.uade.ejb.soap.ServiciosBO_002fPrestadorAutorizado;
import com.uade.ejb.soap.SolicitudDTO;

public class Backoffice {

    public static void main(String[] args) {
        PrestadorAutorizadoService service = new PrestadorAutorizadoService();
        ServiciosBO_002fPrestadorAutorizado port = service.getServiciosBO_002fPrestadorAutorizadoPort();
        ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://192.168.0.107:8080/TPO_BO_EJB/ServiciosBO/PrestadorAutorizado");
        SolicitudDTO solicitud = port.getPrestadorAutorizado(2);
        System.out.println(solicitud.getEstado());
    }
}
