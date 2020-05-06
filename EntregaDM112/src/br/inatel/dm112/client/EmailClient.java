package br.inatel.dm112.client;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.dm112.model.MailRequestData;
import br.inatel.dm112.model.MailStatusResponse;
import reactor.core.publisher.Mono;

public class EmailClient {

	// local
	private String restURL = "http://localhost:8080/UtilityDM112/api/";

	//TODO: modificar este email para enviar para outro endereço
	private static String sendTo = "higor.silverio@ncc.com.br";
	
	public MailStatusResponse callSendMailService(String from, String password, String to) {

		String url = restURL + "sendMail";
		
		MailRequestData mrd = new MailRequestData(from, password, to);
		
		return WebClient
				.create(url)
		        .post()
		        .contentType(MediaType.APPLICATION_JSON)
		        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		        .body(Mono.just(mrd), MailRequestData.class)
		        .accept(MediaType.APPLICATION_JSON)
		        .retrieve()
		        .bodyToFlux(MailStatusResponse.class)
		        .log()
		        .blockFirst();
	}

	public static void main(String[] args) {
		try {
			// le o conteúdo do arquivo pdf de teste
			FileInputStream fis = new FileInputStream("boleto.pdf");
			byte[] buffer = new byte[1 * 1024 * 1024]; // 1 MB
			int size = fis.read(buffer);
			byte[] bytes = new byte[size];
			System.arraycopy(buffer, 0, bytes, 0, size);
			fis.close();

			EmailClient client = new EmailClient();
			
			MailStatusResponse result = client.callSendMailService(
					"robertorr9@gmail.com", "robertodm112", sendTo);
			
			System.out.println("Resposta do email: " + result.getStatus());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
