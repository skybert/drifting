import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public final class RemoteJNDILookup {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                "Usage: java " + RemoteJNDILookup.class.getName()
                + " <jndi-name>");
            System.exit(1);
        }

        Hashtable<String, String> props = new Hashtable<>();
        props.put(Context.INITIAL_CONTEXT_FACTORY,
                  "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote://localhost:4447");
        props.put("jboss.naming.client.ejb.context", "true");

        try {
            InitialContext ctx = new InitialContext(props);
            Object cs = (Object) ctx.lookup(args[0]);
            System.out.println("Looking up JNDI key=" + args[0]);
            System.out.println("Received=" + cs + " of type=" + cs.getClass().getName());

        } catch(NamingException e) {
            throw new RuntimeException("Could not create InitialContext", e);
        }

    }


}
