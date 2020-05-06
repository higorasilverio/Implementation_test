package br.inatel.dm112.client;

import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.services.PaymentService;

public class PaymentClient {

	public static void main(String[] args) {
		PaymentService service = new PaymentService();
		DeliveryStatus result = service.startPaymentOfOrder("111.111.111-11", 456);
		System.out.println("Resultado de startPaymentOfOrder: " + result);
	}

}