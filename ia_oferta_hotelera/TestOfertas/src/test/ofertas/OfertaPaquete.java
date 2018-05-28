package test.ofertas;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class OfertaPaquete {

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

            Destination destination = (Destination) namingContext.lookup("jms/queue/ofertasPaquete");
            System.out.println("Got JMS Endpoint");

            jmsContext = connectionFactory.createContext("hornetq", "hornetq");

            TextMessage message = jmsContext.createTextMessage("{" +
                    "\"codigo_prestador\": 1, " +
                    "\"destino\": \"Miami\", " +
                    "\"fecha_desde\":20170920, " +
                    "\"fecha_hasta\":20170921, " +
                    "\"cantidad_personas_paquete\":4, " +
                    "\"foto_paquete\": \"http://foto_paquete\", " +
                    "\"descripcion_paquete\":\"paquete lindo\", " +
                    "\"servicios_paquete\":[\"WiFi\",\"Sauna\"], " +
                    "\"precio\":250.90, " +
                    "\"latitud\":-33.867, " +
                    "\"longitud\":151.1957, " +
                    "\"politica_cancelacion\": \"politicas\", " +
                    "\"medio_pago_paquete\":[1,2,3,4,5], " +
                    "\"mail_agencia\": \"agencia@gmail.com\", " +
                    "\"cupo_paquete\": 20 " +
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
