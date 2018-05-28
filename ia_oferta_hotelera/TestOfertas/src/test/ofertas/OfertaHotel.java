package test.ofertas;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class OfertaHotel {

    public static void main(String[] args) throws Exception {
        Context namingContext = null;
        JMSContext jmsContext = null;
        try {
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080"); // Cambiar por IP remota aca
            env.put(Context.SECURITY_PRINCIPAL, "hornetq");
            env.put(Context.SECURITY_CREDENTIALS, "hornetq");
            namingContext = new InitialContext(env);

            ConnectionFactory connectionFactory = (ConnectionFactory) namingContext.lookup("jms/RemoteConnectionFactory");
            System.out.println("Got ConnectionFactory");

            Destination destination = (Destination) namingContext.lookup("jms/queue/ofertasHotel");
            System.out.println("Got JMS Endpoint");

            jmsContext = connectionFactory.createContext("hornetq", "hornetq");

            TextMessage message = jmsContext.createTextMessage("{" +
                    "\"codigo_prestador\": 2, " +
                    "\"nombre\": \"Dazzler\", " +
                    "\"destino\": \"Miami\", " +
                    "\"fecha_desde\": \"20170920\", " +
                    "\"fecha_hasta\": \"20170920\", " +
                    "\"cantidad_personas\": 1, " +
                    "\"foto_hotel\": \"http://www3.hilton.com/resources/media/hi/MLAHITW/en_US/img/shared/full_page_image_gallery/main/HL_exterior01_1270x560_FitToBoxSmallDimension_Center.jpg\", " +
                    "\"descripcion_hotel\": \"Descripcion Hotel\", " +
                    "\"lista_servicios\": [\"Wifi\", \"Frigo Bar\"], " +
                    "\"precio_habitacion\": 10.5, " +
                    "\"foto_habitacion\": \"http://www3.hilton.com/resources/media/hi/MLAHITW/en_US/img/shared/full_page_image_gallery/main/HL_exterior01_1270x560_FitToBoxSmallDimension_Center.jpg\", " +
                    "\"descripcion_habitacion\": \"Descripcion\", " +
                    "\"lista_servicios_habitacion\": [\"Wifi\", \"Frigo Bar\"], " +
                    "\"latitud\": -34.606299, " +
                    "\"longitud\": -58.364667, " +
                    "\"politica_cancelacion\": \"Politica de cancelacion\", " +
                    "\"medio_pago_hotel\": [1,2,3], " +
                    "\"email_hotel\": \"email@hotel.com\", " +
                    "\"cupo\": 10 " +
                    "}");

            jmsContext.createProducer().send(destination, message);
            System.out.println("Sent message");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (namingContext != null) {
                namingContext.close();
            }
            if (jmsContext != null) {
                jmsContext.close();
            }
        }
    }
}
