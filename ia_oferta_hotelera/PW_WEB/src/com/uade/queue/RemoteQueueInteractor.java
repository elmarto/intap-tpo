package com.uade.queue;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteQueueInteractor {

    private ConnectionFactory remoteQueueCF;
    private Queue remoteQueue;
    private static Connection remoteQueueConnection;
    private static Session remoteQueueSession;

    public RemoteQueueInteractor() throws NamingException, JMSException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");

        /*
         * The URL below should point to the your instance of Server 1, if no
         * port offset is used for Server 1 the port can remain at 4447
         */
        props.put(Context.PROVIDER_URL, "http-remoting://0.0.0.0:8080");

        /*
         * Please note that the credentials passed in here have no effect on the
         * messaging system as we have disabled the security on the HornetQ
         * messaging subsystem
         */
        props.put(Context.SECURITY_PRINCIPAL, "integrados");
        props.put(Context.SECURITY_CREDENTIALS, "integrados");

        InitialContext ic = new InitialContext(props);

        /*
         * The following two lookups are based on how you configured the
         * RemoteConnectionFactory and the local queue on Server 1. If you have
         * followed the installation that was provided as-is then you can go
         * with the below code
         */
        //No va con el /exported
        remoteQueueCF = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
        //No va si uso directamente jms/ -> jms/queues/colaBack
        remoteQueue = (Queue) ic.lookup("java:/jms/queue/colaBack");

        remoteQueueConnection = remoteQueueCF.createConnection("integrados","integrados");
        remoteQueueConnection.start();
        remoteQueueSession = remoteQueueConnection.createSession(false,Session.AUTO_ACKNOWLEDGE);
    }

    public void sendTextMessage(String msg) throws JMSException {
        TextMessage txtMessage = remoteQueueSession.createTextMessage(msg);
        MessageProducer msgProducer = remoteQueueSession.createProducer(this.remoteQueue);
        msgProducer.send(txtMessage);
        msgProducer.close();
    }

    public String receiveTextMessage() throws JMSException {
        MessageConsumer msgConsumer = remoteQueueSession.createConsumer(this.remoteQueue);
        TextMessage txtMsg = (TextMessage) msgConsumer.receive();
        msgConsumer.close();
        return txtMsg.getText();
        
    }

    @Override
    protected void finalize() throws Throwable {
        remoteQueueSession.close();
        remoteQueueConnection.close();
    }

    public static void main(String agrs[]) throws NamingException, JMSException {
        RemoteQueueInteractor remoteQInteractor = new RemoteQueueInteractor();
       
        remoteQInteractor.sendTextMessage("Hello Puto World!");
        System.out.println("Mensaje Enviado");
        
        System.out.println(remoteQInteractor.receiveTextMessage());
        System.out.println("Mensaje Recibido");
        
        remoteQueueSession.close();
        remoteQueueConnection.close();
        
    }
}