package br.inatel.dm112.adapter;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailAdapter {

	public void sendMail(final String from, final String password, String to) {

		System.out.println("Enviando email para: " + to);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Confirmação");

			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPartText = new MimeBodyPart(); // texto
			messageBodyPartText.setText("Confirmação de entrega do pedido");
			multipart.addBodyPart(messageBodyPartText);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("Sent confirmation successfully....");
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
