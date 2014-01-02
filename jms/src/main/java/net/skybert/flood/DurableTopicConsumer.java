package net.skybert.flood;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

/**
 * A topic consumer/subscriber, which (also) receives messages sent while the
 * consumer was offline.
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class DurableTopicConsumer extends Consumer {

    public DurableTopicConsumer() {
        super();

        try {
            Topic topic = session.createTopic(Constants.TOPIC_FLOOD);
            TopicSubscriber subscriber = session.createDurableSubscriber(topic,
                    getClass().getSimpleName());
            subscriber.setMessageListener(this);
            connection.start();

        } catch (JMSException je) {
            throw new RuntimeException("Couldn't set up JMS", je);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new DurableTopicConsumer();

        while (true) {
            Thread.sleep(1);
        }
    }
}
