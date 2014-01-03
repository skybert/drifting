package net.skybert.flood;

import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * A topic consumer which only gets messages broadcasted while it's online.
 *
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public class NonDurableTopicConsumer extends Consumer {

    public NonDurableTopicConsumer() {
        super();

        try {
            Destination destination = session
                    .createTopic(Constants.TOPIC_FLOOD);
            createMessageConsumerAndStartConnection(destination, this);

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NonDurableTopicConsumer();

        while (true) {
            Thread.sleep(1);
        }
    }

}
