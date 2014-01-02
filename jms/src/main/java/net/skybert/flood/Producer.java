package net.skybert.flood;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Common code for both topic and queue producers.
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public abstract class Producer {
    private Connection connection;
    protected MessageProducer messageProducer;
    protected Session session;

    public Producer() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(
                    Constants.BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    protected MessageProducer createMessageProducer(Destination destination)
            throws JMSException {
        messageProducer = session.createProducer(destination);
        messageProducer.setPriority(1);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

        return messageProducer;
    }

    protected void spreadTheWord(String word) {
        try {
            TextMessage message = session.createTextMessage(word);
            messageProducer.send(message);
            System.out.println("Just spread the word that: " + word);
        } catch (JMSException je) {
            je.printStackTrace();
        }
    }

    protected static void spreadTheWordAndExit(Producer producer)
            throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            producer.spreadTheWord("#" + i + " Time since epoch is "
                    + new Date(System.currentTimeMillis()));
            // sleep a second to not flood the server too much
            Thread.sleep(1000);
        }

        System.exit(0);
    }

}
