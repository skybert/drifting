package net.skybert.flood;

import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * Class, which sets up (or "creates a producer for" in JMS parlance) a topic on
 * which it broadcasts a number of messages on this topic, before it quietly
 * exits.
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class TopicProducer extends Producer {
    public TopicProducer() {
        super();

        try {
            Destination destination = session
                    .createTopic(Constants.TOPIC_FLOOD);
            messageProducer = createMessageProducer(destination);

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        spreadTheWordAndExit(new TopicProducer());
    }
}
