package br.inatel.dm112.client;

import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.services.DeliveryService;

public class DeliveryClient {

	public static void main(String[] args) {
		DeliveryService service = new DeliveryService();
		DeliveryStatus result = service.trackNumber("111.111.111-11", 456);
		System.out.println("Resultado de trackNumber: " + result);
		result = service.deliveryStatus("111.111.111-11", 456);
		System.out.println("Resultado de deliveryStatus: " + result);
	}

}