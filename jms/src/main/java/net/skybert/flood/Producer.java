package net.skybert.flood;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.Date;

public final class Producer {
    private static final long serialVersionUID = 1L;
    private Connection connection;
    private MessageProducer messageProducer;
    private Session session;

    public Producer() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(
                    Constants.BROKER_URL);
            connection = factory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session
                    .createQueue(Constants.TOPIC_FLOOD);
            messageProducer = session.createProducer(destination);
            messageProducer.setPriority(1);
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    private void spreadTheWord(String word) {
        try {
            TextMessage message = session.createTextMessage(word);
            messageProducer.send(message);
            System.out.println("Just spread the word that: " + word);
        } catch (JMSException je) {
            je.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();

        for (int i = 0; i < 100; i++) {
            producer.spreadTheWord("Time since epoch is "
                    + new Date(System.currentTimeMillis()));
            // sleep a second to not flood the server too much
            Thread.sleep(1000);
        }
    }
}
