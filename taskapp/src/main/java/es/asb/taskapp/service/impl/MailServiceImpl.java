package es.asb.taskapp.service.impl;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import es.asb.taskapp.service.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
    public JavaMailSender emailSender;
	
	public boolean sendMail(String to,String subject,String msg) {
		 Properties props = System.getProperties();
		    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
		    props.put("mail.smtp.user", "apptask180@gmail.com");
		    props.put("mail.smtp.clave", "1234abcdABCD");    //La clave de la cuenta
		    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
		    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
		    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);

		    try {
		        message.setFrom(new InternetAddress(""));
		        message.addRecipients(MimeMessage.RecipientType.TO,to);  //Se podrían añadir varios de la misma manera
		        message.setSubject(subject);
		        message.setText(msg);
		        Transport transport = session.getTransport("smtp");
		        transport.connect("smtp.gmail.com","apptask180@gmail.com","1234abcdABCD");
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		    }
		    catch (MessagingException me) {
		        me.printStackTrace();   
		    }
		return true;
	}
	
}
