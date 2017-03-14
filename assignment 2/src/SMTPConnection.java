


import java.net.*; 
import java.io.*; 
import java.util.*; 

/** 
* Open an SMTP connection to a mailserver and send one mail. 
* 
*/ 

public class SMTPConnection { 

    /* The socket to the server */ 
    private Socket connection; 

    /* Streams for reading and writing the socket */ 
    private BufferedReader fromServer; 
    private DataOutputStream toServer; 
    private static final int SMTP_PORT = 25; 
    private static final String CRLF = "\r\n"; 
    /* Are we connected? Used in close() to determine what to do. */ 
    private boolean isConnected = false; 

    /* Create an SMTPConnection object. Create the socket and the 
    associated streams. Initialize SMTP connection. */ 
    public SMTPConnection(Envelope envelope) throws IOException { 
        connection = new Socket(envelope.DestHost, SMTP_PORT); 
        fromServer = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
        toServer = new DataOutputStream(connection.getOutputStream());

        
        /* Read a line from server and check that the reply code is 220. 
        If not, throw an IOException. */ 
        String line = fromServer.readLine();
        if(parseReply(line) != 220)
            throw new IOException("Expected response 220, instead got " + parseReply(line));
        else
            System.out.println("Connection established !");
        /* SMTP handshake. We need the name of the local machine. 
        Send the appropriate SMTP handshake command. */ 
        String localhost = "localhost"; 
        sendingCmd( "HELO " + localhost, 250 ); 
        System.out.println("Got hello !");
        isConnected = true; 

     } 

    /* Send the message. Write the correct SMTP-commands in the 
    correct order. No checking for errors, just throw them to the 
    caller. */ 
     public void send(Envelope envelope) throws IOException { 


        /* Send all the necessary commands to send a message. Call 
        sendingCmd() to do the dirty work. Do _not_ catch the 
        exception thrown from sendingCmd(). */ 
        sendingCmd("MAIL FROM: " + "<" + envelope.pampadam + ">", 250 );
         
        sendingCmd("RCPT TO: " + "<" + envelope.Rcpt + ">", 250);
        sendingCmd("DATA", 354);
        
        toServer.write(envelope.Message.Headers.getBytes());
        toServer.write(envelope.Message.Body.getBytes());
        toServer.write(CRLF.getBytes());
        toServer.flush();
        sendingCmd(("."), 250);
        
     } 

    /* Close the connection. First, terminate on SMTP level, then 
   close the socket. */ 
   public void close() { 
       isConnected = false; 
       try{ 
           sendingCmd("QUIT", 221);
           connection.close(); 
       }catch (IOException e) { 
           System.out.println("Unable to close connection: " + e); 
           isConnected = true; 
       } 
    } 

    /* Send an SMTP command to the server. Check that the reply code is 
    what is is supposed to be according to RFC 821. */ 
    private void sendingCmd(String command, int rc) throws IOException { 
        
        /* Write command to server and read reply from server. */ 
        toServer.write((command+CRLF).getBytes());
        toServer.flush();
        /* Check that the server's reply code is the same as the parameter 
        rc. If not, throw an IOException. */ 
        String line = fromServer.readLine();
        System.out.println(">> " + command);
        System.out.println(">> " + line);
        if(parseReply(line) != rc)
            throw new IOException("Expected response 220, instead got " + parseReply(line));

    } 

     /* Parse the reply line from the server. Returns the reply code. */ 
    private int parseReply(String reply) { 
         return Integer.parseInt(reply.substring(0, 3));
     }

     /* Destructor. Closes the connection if something bad happens. */ 
    protected void finalize() throws Throwable { 
        if(isConnected) 
            close(); 
        super.finalize(); 
    } 
    public static void main(String args[]) throws UnknownHostException, IOException{
        Message message = new Message("from@from.com", "to@to.com", "subject", "message here");
        System.out.println(message);
        Envelope envelope = new Envelope(message, "localhost");
        System.out.println(envelope);

        SMTPConnection smtpConnection= new SMTPConnection(envelope);
        smtpConnection.send(envelope);
        System.out.println("Sent !");
        smtpConnection.close();
        System.out.println("Closed !");

    }
}