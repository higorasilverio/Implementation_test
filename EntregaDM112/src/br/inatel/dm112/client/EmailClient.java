package br.inatel.dm112.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.dm112.model.MailRequestData;
import br.inatel.dm112.model.MailStatusResponse;
import reactor.core.publisher.Mono;

public class EmailClient {
	
	// local
	private String restURL = "http://localhost:8080/UtilityDM112/api/";

	private static String sendTo = "higor.silverio@ncc.com.br";

	public MailStatusResponse callSendMailService(String from, String password, String to, String message) {

		String url = restURL + "sendMail";

		MailRequestData mrd = new MailRequestData(from, password, to, message);

		return WebClient.create(url).post().contentType(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(mrd), MailRequestData.class).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(MailStatusResponse.class).log().blockFirst();
	}

	public static void main(String[] args) {

		EmailClient client = new EmailClient();

		MailStatusResponse result = client.callSendMailService("robertorr9@gmail.com", "robertodm112", sendTo,
				"Pedido entregue! Codigo de rastreio gerado!");

		System.out.println("Resposta do email: " + result.getStatus());
	}
}
