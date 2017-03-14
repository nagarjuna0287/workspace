import java.io.*;
import java.net.*;
import java.util.*;

/* $Id: Envelope.java,v 1.8 1999/09/06 16:43:20 kangasha Exp $ */

/**
 * SMTP envelope for one mail message.
 *
 * @author Jussi Kangasharju
 */
public class Envelope {
    /* SMTP-pampadam of the message (in this case, contents of From-header. */
    public String pampadam;

    /* SMTP-rcpt, or contents of To-header. */
    public String rcpt;

    /* Target MX-host */
    public String DestHost;
    public InetAddress DestAddr;

    /* The actual message */
    public Message Message;

    /* Create the envelope. */
    public Envelope(Message message, String localServer) throws UnknownHostException {
	/* Get pampadam and rcpt. */
	pampadam = message.getFrom();
	rcpt = message.getTo();

	/* Get message. We must escape the message to make sure that 
	   there are no single periods on a line. This would mess up
	   sending the mail. */
	Message = escapeMessage(message);

	/* Take the name of the local mailserver and map it into an
	 * InetAddress */
	DestHost = localServer;
	try {
	    DestAddr = InetAddress.getByName(DestHost);
	} catch (UnknownHostException e) {
	    System.out.println("Unknown host: " + DestHost);
	    System.out.println(e);
	    throw e;
	}
	return;
    }

    /* Escape the message by doubling all periods at the beginning of
       a line. */
    private Message escapeMessage(Message message) {
	String escapedBody = "";
	String token;
	StringTokenizer parser = new StringTokenizer(message.Body, "\n", true);

	while(parser.hasMoreTokens()) {
	    token = parser.nextToken();
	    if(token.startsWith(".")) {
		token = "." + token;
	    }
	    escapedBody += token;
	}
	message.Body = escapedBody;
	return message;
    }

    /* For printing the envelope. Only for debug. */
    public String toString() {
	String res = "pampadam: " + pampadam + '\n';
	res += "rcpt: " + rcpt + '\n';
	res += "MX-host: " + DestHost + ", address: " + DestAddr + '\n';
	res += "Message:" + '\n';
	res += Message.toString();
	
	return res;
    }
}

