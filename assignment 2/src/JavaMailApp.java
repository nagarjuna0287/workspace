
/*

Outgoing Mail (SMTP) Server
requires SSL: smtp.gmail.com (use authentication)
Use Authentication: Yes
Port for SSL: 465; Secure Sockets Layer (SSL)

*/


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailApp extends Frame
{
    /* The stuff for the GUI. */
    private Label serverLabel = new Label("Local mailserver:");
    private TextField serverField = new TextField("", 40);
    
    private Label fromLabel = new Label("From:");
    private TextField fromField = new TextField("", 40);
    
    private Label senderLabel = new Label("Sender:");
    private TextField senderField = new TextField("", 40);
    
    private Label passwordLabel = new Label("Password:");
    private TextField passwordField = new TextField("", 40);
    
    private Label toLabel = new Label("To:"); 
    private TextField toField = new TextField("", 40);
    
    private Label ccLabel = new Label("CC:"); 
    private TextField ccField = new TextField("", 40);
    
    private Label bccLabel = new Label("BCC:"); 
    private TextField bccField = new TextField("", 40);
    
    private Label subjectLabel = new Label("Subject:");
    private TextField subjectField = new TextField("", 40);
    
    private Label messageLabel = new Label("Message:");
    private TextArea messageText = new TextArea(10, 40);
    
    private Label htmlLabel = new Label("HTML:");
    private TextArea htmlText = new TextArea(10, 40);
    
    private Button btSend = new Button("Send");
    private Button btClear = new Button("Clear");
    private Button btQuit = new Button("Quit");
    
    private Label statusBar = new Label("Status bar");
    /**
     * Create a new MailClient window with fields for entering all
     * the relevant information (From, To, Subject, and message).
     */
    public JavaMailApp() {
	super("Java Mailclient (using JavaMail API)");
	
	/* Create panels for holding the fields. To make it look nice,
	   create an extra panel for holding all the child panels. */
        Panel serverPanel = new Panel(new BorderLayout());
	Panel fromPanel = new Panel(new BorderLayout());
        Panel senderPanel = new Panel(new BorderLayout());
        Panel passwordPanel = new Panel(new BorderLayout());
	Panel toPanel = new Panel(new BorderLayout());
        Panel ccPanel = new Panel(new BorderLayout());
        Panel bccPanel = new Panel(new BorderLayout());
	Panel subjectPanel = new Panel(new BorderLayout());
	Panel messagePanel = new Panel(new BorderLayout());
        Panel htmlPanel = new Panel(new BorderLayout());
        
	serverPanel.add(serverLabel, BorderLayout.WEST);
	serverPanel.add(serverField, BorderLayout.EAST);
	fromPanel.add(fromLabel, BorderLayout.WEST);
	fromPanel.add(fromField, BorderLayout.EAST);
        senderPanel.add(senderLabel, BorderLayout.WEST);
        senderPanel.add(senderField, BorderLayout.EAST);
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.EAST);
        toPanel.add(toLabel, BorderLayout.WEST);
	toPanel.add(toField, BorderLayout.EAST);
	ccPanel.add(ccLabel, BorderLayout.WEST);
	ccPanel.add(ccField, BorderLayout.EAST);
        bccPanel.add(bccLabel, BorderLayout.WEST);
	bccPanel.add(bccField, BorderLayout.EAST);
        subjectPanel.add(subjectLabel, BorderLayout.WEST);
	subjectPanel.add(subjectField, BorderLayout.EAST);
	messagePanel.add(messageLabel, BorderLayout.NORTH);	
	messagePanel.add(messageText, BorderLayout.CENTER);
	htmlPanel.add(htmlLabel, BorderLayout.NORTH);	
	htmlPanel.add(htmlText, BorderLayout.CENTER);
        
        Panel fieldPanel = new Panel(new GridLayout(0, 1));
        fieldPanel.add(serverPanel);
        fieldPanel.add(fromPanel);
        fieldPanel.add(senderPanel);
        fieldPanel.add(passwordPanel);
        fieldPanel.add(toPanel);
	fieldPanel.add(ccPanel);
	fieldPanel.add(bccPanel);
	fieldPanel.add(subjectPanel);
        
	/* Create a panel for the buttons and add listeners to the
	   buttons. */
	Panel bottomPanel = new Panel(new BorderLayout());
        Panel buttonPanel = new Panel(new GridLayout(1, 0));
	btSend.addActionListener(new JavaMailApp.SendListener());
	btClear.addActionListener(new JavaMailApp.ClearListener());
	btQuit.addActionListener(new JavaMailApp.QuitListener());
	buttonPanel.add(btSend);
	buttonPanel.add(btClear);
	buttonPanel.add(btQuit);
	bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(statusBar, BorderLayout.SOUTH);
        
	/* Add, pack, and show. */
	add(fieldPanel, BorderLayout.NORTH);
        Panel bodyPanel = new Panel(new BorderLayout());
	bodyPanel.add(messagePanel, BorderLayout.NORTH);
        bodyPanel.add(htmlPanel, BorderLayout.SOUTH);
        add(bodyPanel);

	add(bottomPanel, BorderLayout.SOUTH);
	pack();
	this.setVisible(true);
    }
    public static void main( String[] args )
    {
        new JavaMailApp();
    }
    
    
    private InternetAddress[] toAddresses(String all) throws AddressException{
        all = all.trim();
        if(all.equals(""))   return null;
        String mails[] = all.split("[\\s]*,[\\s]*");
        InternetAddress addresses[] = new InternetAddress[mails.length];
        for(int i=0;i<mails.length;i++)
            addresses[i] = new InternetAddress(mails[i]);
        return addresses;
    }
    private String getServer(){
        return serverField.getText().trim();
    }
    private InternetAddress[] getFrom() throws AddressException{
        return toAddresses( fromField.getText() );
    }
    
    private InternetAddress[] getCC() throws AddressException{
        return toAddresses( ccField.getText() );
    }
    private InternetAddress[] getBCC() throws AddressException{
        return toAddresses( bccField.getText() );
    }
    
    private InternetAddress[] getTo() throws AddressException{
        return toAddresses( toField.getText() );
    }
    private InternetAddress getSender() throws AddressException{
        return new InternetAddress( senderField.getText().trim() );
    }
    private String getPassword(){
        return passwordField.getText().trim();
    }
    private String getSubject(){
        return subjectField.getText();
    }
    private String getTextMessage(){
        return messageText.getText();
    }
    
    private String getHTMLMessage(){
        return htmlText.getText();
    }
    private void setStatus(String status){
        statusBar.setText(status);
        System.out.println(status);
    }
    class AppAuthenticator extends Authenticator{

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderField.getText().trim(), getPassword());
        }
        
    }
    /* Handler for the Send-button. */
    class SendListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    setStatus("Sending mail");
	    
	    /* Check that we have the local mailserver */
	    if ((serverField.getText()).equals("")) {
		setStatus("Need name of local mailserver!");
		return;
	    }
            /* Check that we have who wrote the mail */
	    if((fromField.getText()).equals("")) {
		setStatus("Need 'from' ID!");
		return;
	    }
            /* Check that we have the sender */
            if((senderField.getText()).equals("")) {
		setStatus("Need 'sender' ID!");
		return;
	    }
            try {
                /* Check that we have the recipients */
                if(getTo() == null && getCC() == null && getBCC() == null) {
                    setStatus("Need recipient!");
                    return;
                }
            } catch (AddressException ex) {
                setStatus(ex.toString());
                return;
            }
            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", getServer());
            
            Session session = Session.getInstance(props, new AppAuthenticator());
	    
            Message message = new MimeMessage(session);
                    
            try{
                message.addFrom(getFrom());
                message.setSubject(getSubject());
                if(getTo() != null)
                    message.setRecipients(Message.RecipientType.TO, getTo());
                if(getCC() != null)
                    message.setRecipients(Message.RecipientType.CC, getCC());
                if(getBCC() != null)
                message.setRecipients(Message.RecipientType.BCC, getBCC());


                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setContent(getTextMessage(), "text/plain");

                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(getHTMLMessage(), "text/html");

                MimeMultipart mimeMultipart = new MimeMultipart("alternative");
                mimeMultipart.addBodyPart(textPart);
                mimeMultipart.addBodyPart(htmlPart);
                
                message.setContent(mimeMultipart);
                
                Transport.send(message);

            }catch(MessagingException ex){
                setStatus(ex.toString());
                return;
            }
            
	    statusBar.setText("Mail sent succesfully!");
	}
    }

    /* Clear the fields on the GUI. */
    class ClearListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    System.out.println("Clearing fields");
	    fromField.setText("");
            senderField.setText("");
            passwordField.setText("");
	    toField.setText("");
            ccField.setText("");
            bccField.setText("");
	    subjectField.setText("");
	    messageText.setText("");
            htmlText.setText("");
	}
    }

    /* Quit. */
    class QuitListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    System.exit(0);
	}
    }
}