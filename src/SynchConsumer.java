import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

public class SynchConsumer {
	private static ConnectionFactory connectionFactory;
	private static Queue queue;
	private static Topic topic;	
	
	public SynchConsumer(String queueName, String topicName) {
	}
	
	public void CreateConsumer(String destType) {
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination dest = null;
			try { 
			    if (destType.equals("queue")) { 
			        dest = (Destination) queue; 
			    } else { 
			        dest = (Destination) topic; 
			    }
			} 
			catch (Exception e) {
			    System.err.println("Error setting destination: " + e.toString()); 
			    e.printStackTrace(); 
			    System.exit(1);
			}
			
			MessageConsumer consumer = session.createConsumer(dest);
			
			connection.start();
			
			while (true) {
			    Message m = consumer.receive(1); 
			    if (m != null) { 
			        if (m instanceof TextMessage) { 
			        	TextMessage message = (TextMessage) m; 
			            System.out.println("Reading message: " + message.getText()); 
			        } else { 
			            break; 
			        } 
			    }
			}
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	}
}
