package net.skybert.flood;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Common code for both topic (durable &amp; non-durable) and queue consumers..
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public abstract class Consumer implements MessageListener {
    protected MessageConsumer messageConsumer;
    protected Session session;
    protected Connection connection;

    public Consumer() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(
                    Constants.BROKER_URL);
            connection = factory.createConnection();
            connection.setClientID(getClass().getSimpleName());
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    protected void createMessageConsumerAndStartConnection(final Destination destination,
                                                           final Consumer consumer)
            throws JMSException {
        messageConsumer = session.createConsumer(destination);
        messageConsumer.setMessageListener(consumer);
        connection.start();
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out
                    .print("text=" + ((TextMessage) message).getText() + "\n");

        } catch (JMSException je) {
            je.printStackTrace();
        }
    }
}
