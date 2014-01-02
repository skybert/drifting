package net.skybert.flood;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public final class QueueConsumer extends Consumer {

    public QueueConsumer() {
        super();

        try {
            Destination destination = session
                    .createQueue(Constants.TOPIC_FLOOD);
            createMessageConsumerAndStartConnection(destination, this);

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new QueueConsumer();

        while (true) {
            Thread.sleep(1);
        }
    }
}
