import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

public class Producer {
	private static ConnectionFactory connectionFactory;
	private static Queue queue;
	private static Topic topic;	

	public static void main(String[] args) {
		final int NUM_MSGS;
		String destType = args[0];
		System.out.println("Destination type is " + destType);
		if ( ! ( destType.equals("queue") || destType.equals("topic") ) ) { 
		    System.err.println("Argument must be 'queue' or 'topic'");
		    System.exit(1);
		}
		if (args.length == 2){ 
		    NUM_MSGS = Integer.parseInt(args[1]);
		} 
		else { 
		    NUM_MSGS = 1;
		}
		
		
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
		
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			javax.jms.MessageProducer producer = session.createProducer(dest);
			TextMessage message = session.createTextMessage();
			
			for (int i = 0; i < NUM_MSGS; i++) { 
			    message.setText("This is message " + (i + 1) + " from producer"); 
			    System.out.println("Sending message: " + message.getText()); 
			    producer.send(message);
			}
			
			try {
				producer.send(session.createMessage());
			} finally { 
			    if (connection != null) { 
			        try { connection.close(); } 
			        catch (JMSException e) { } 
			    }
			}
						
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void MessageProducer() {
		
	}

}
