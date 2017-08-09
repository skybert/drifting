package net.skybert.flood;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;

/**
 * A client which picks messages off a queue (or "consumes a queue" in JMS
 * parlance).
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
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
