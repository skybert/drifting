package net.skybert.flood;

/**
 * Constants used by the various producers &amp; consumers.
 * 
 * @author <a href="mailto:tkj@conduct.no">Torstein Krause Johansen</a>
 * @version 1.0
 */
public final class Constants {
    public final static String BROKER_URL = "tcp://localhost:61616";
    public final static String TOPIC_FLOOD = "flood-topic";

    private Constants() {
    }
}
