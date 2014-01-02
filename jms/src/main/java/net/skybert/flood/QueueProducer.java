package net.skybert.flood;

import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * Class, which sets up (or "creates a producer for" in JMS parlance) a queue
 * and broadcasts a number of messages on this queue, before exiting quietly.
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class QueueProducer extends Producer {
    public QueueProducer() {
        super();

        try {
            Destination destination = session
                    .createQueue(Constants.TOPIC_FLOOD);
            messageProducer = createMessageProducer(destination);

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        spreadTheWordAndExit(new QueueProducer());
    }

}
