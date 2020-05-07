package br.inatel.dm112.services;

import org.springframework.stereotype.Service;

import br.inatel.dm112.client.EmailClient;
import br.inatel.dm112.client.OrderRestClient;
import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.model.Order;
import br.inatel.dm112.model.OrderResponse;
import br.inatel.dm112.model.ResponseStatus;

@Service
public class DeliveryService {

	private String sendToAddress = "higor.silverio@ncc.com.br";
	private String sendFromAddress = "robertorr9@gmail.com";
	private String sendPassAddress = "robertodm112";

	private OrderRestClient clientOrder = new OrderRestClient();
	private EmailClient clientEmail = new EmailClient();

	/**
	 * Lógica de geração do numero de rastreio (1) consulta o pedido pelo número (2)
	 * retira pedido (3) atualiza status do pedido
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public DeliveryService trackNumber(String deliverymanCpf, int orderNumber) {

		if (deliverymanCpf == null || orderNumber < 0) {
			return new DeliveryService();
		}

		Order order = clientOrder.retrieveOrder(orderNumber); // consulta o pedido pelo número

		if (order != null) {
			order.setStatus(Order.STATUS.WITHDRAW.ordinal()); // pedido retirado
			OrderResponse respOrder = clientOrder.updateOrder(order); // atualiza o status do pedido
			System.out.println("Operação de retirada realizada e codigo de rastreio gerado!");
			
			if (respOrder.getStatus() == ResponseStatus.OK.ordinal()) { // OK
				clientEmail.callSendMailService( //envia emailde "saiu para entrega"
						sendFromAddress, sendPassAddress, sendToAddress, "Pedido saiu para entrega!");

			} else {
				System.out.println("Erro no serviço de pedido: update");
			}
		} else {
			System.out.println("Erro no serviço de pedido: get");
		}
		return new DeliveryService();
	}

	/**
	 * Lógica de confirmação de pagamento (1) consulta o pedido pelo número (2)
	 * confirma o pagamento (3) atualiza o status do pedido (4) responde Ok
	 * 
	 * @param cpf
	 * @param orderNumber
	 * @return
	 */
	public DeliveryStatus deliveryStatus(String deliverymanCpf, int orderNumber) {

		if (deliverymanCpf == null || orderNumber < 0) {
			return new DeliveryStatus(ResponseStatus.ERROR.ordinal(), deliverymanCpf, orderNumber);
		}

		Order order = clientOrder.retrieveOrder(orderNumber); // consulta o pedido pelo número

		if (order != null) {
			order.setStatus(Order.STATUS.DELIVERED.ordinal()); // confirma entrega
			OrderResponse respOrder = clientOrder.updateOrder(order); // atualiza o status do pedido
			if (respOrder.getStatus() == ResponseStatus.OK.ordinal()) { // OK
				return new DeliveryStatus(ResponseStatus.OK.ordinal(), deliverymanCpf, orderNumber); // (4) responde Ok
			} else {
				System.out.println("Erro no serviço de pedido ao fazer update.");
			}
		} else {
			System.out.println("Erro no serviço de pedido: order is null.");
		}
		return new DeliveryStatus(ResponseStatus.ERROR.ordinal(), deliverymanCpf, orderNumber);
	}
}