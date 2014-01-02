package net.skybert.flood;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public final class Consumer implements MessageListener {
    private static final long serialVersionUID = 1L;
    private MessageConsumer messageConsumer;

    public Consumer() {
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(
                    Constants.BROKER_URL);
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue(Constants.TOPIC_FLOOD);

            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(this);

            connection.start();

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }

    }

    @Override
    public void onMessage(Message message) {
        try {
            // System.out.println("Received message=" + message);
            System.out
                    .print("text=" + ((TextMessage) message).getText() + "\n");

        } catch (JMSException je) {
            je.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Consumer consumer = new Consumer();

        while (true) {
            Thread.sleep(1);
        }
    }
}
