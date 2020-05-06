package br.inatel.dm112.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.inatel.dm112.client.BilletClient;
import br.inatel.dm112.client.EmailClient;
import br.inatel.dm112.client.OrderRestClient;
import br.inatel.dm112.model.BilletGenResponse;
import br.inatel.dm112.model.MailStatusResponse;
import br.inatel.dm112.model.Order;
import br.inatel.dm112.model.OrderResponse;
import br.inatel.dm112.model.PaymentStatus;
import br.inatel.dm112.model.ResponseStatus;

@Service
public class PaymentService {

	//TODO: Fique à vontade para alterar estes atributos
	//TODO: Para enviar um email através do gmail, é necessário habilitar o SMTP da conta de envio.
	private String sendToAddress = "higor.silverio@ncc.com.br";
	private String sendFromAddress = "robertorr9@gmail.com";
	private String sendPassAddress = "robertodm112";

	private OrderRestClient clientOrder = new OrderRestClient();
	private BilletClient clientBillet = new BilletClient();
	private EmailClient clientEmail = new EmailClient();

	/**
	 * Lógica de geração de pendência de pagamento
	 * (1) consulta o pedido pelo número
	 * (2) atualiza o status do pedido
	 * (3) gera o boleto
	 * (4) envia email com o pdf
	 * (5) retorna sucesso
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public PaymentStatus startPaymentOfOrder(String cpf, int orderNumber) {
		
		if (cpf == null || orderNumber < 0) {
			return new PaymentStatus(ResponseStatus.ERROR.ordinal(), cpf, orderNumber);
		}

		Order order = clientOrder.retrieveOrder(orderNumber); //(1) consulta o pedido pelo número

		if(order != null) { //TODO: alguma hora será preciso verificar o status do pedido aqui
			order.setStatus(Order.STATUS.PENDING.ordinal()); //pendente de pagamento
			OrderResponse respOrder = clientOrder.updateOrder(order); //(2) atualiza o status do pedido

			if(respOrder.getStatus() == ResponseStatus.OK.ordinal()) { //OK
				BilletGenResponse respBillet = clientBillet.callGenerateBilletService(orderNumber, cpf); //(3) gera o boleto
			
				if(respBillet.getStatus() == ResponseStatus.OK.ordinal()) {//OK
					System.out.println("Operações para gerar um boleto, projeto antigo, ocorreram normalmente");
					
				} else {
					System.out.println("Erro no serviço de boleto");
				}
			} else {
				System.out.println("Erro no serviço de pedido: update");
			}
		} else {
			System.out.println("Erro no serviço de pedido: get");
		}
		return new PaymentStatus(ResponseStatus.ERROR.ordinal(), cpf, orderNumber); //retorna ERRO
	}

	/**
	 * Lógica de confirmação de pagamento
	 * (1) consulta o pedido pelo número
	 * (2) confirma o pagamento
	 * (3) atualiza o status do pedido
	 * (4) responde Ok
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public PaymentStatus confirmPaymentOfOrder(String cpf, int orderNumber) {
		
		if (cpf == null || orderNumber < 0) {
			return new PaymentStatus(ResponseStatus.ERROR.ordinal(), cpf, orderNumber);
		}
		
		Order order = clientOrder.retrieveOrder(orderNumber); //(1) consulta o pedido pelo número

		if(order != null) { //alguma hora vai ser preciso verificar o status do pedido aqui
			order.setStatus(Order.STATUS.CONFIRMED.ordinal()); //(2) confirma o pagamento
			OrderResponse respOrder = clientOrder.updateOrder(order); //(3) atualiza o status do pedido

			if(respOrder.getStatus() == ResponseStatus.OK.ordinal()) { //OK
				return new PaymentStatus(ResponseStatus.OK.ordinal(), cpf, orderNumber); //(4) responde Ok
			} else {
				System.out.println("Erro no serviço de pedido ao fazer update.");
			}
		} else {
			System.out.println("Erro no serviço de pedido: order is null.");
		}
		return new PaymentStatus(ResponseStatus.ERROR.ordinal(), cpf, orderNumber);
	}
}