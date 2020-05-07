package br.inatel.dm112.rest;

import java.nio.charset.Charset;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.dm112.interfaces.Delivery;
import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.services.DeliveryService;

@RestController
@RequestMapping("/api")
public class DeliveryRest implements Delivery {
	

	@Autowired
	private DeliveryService service;

	@Override
	@GetMapping("/trackNumber/{deliverymanCpf:.+}/{orderNumber}")
	public DeliveryStatus trackNumber(
			@PathVariable("deliverymanCpf")String deliverymanCpf, 
			@PathVariable("orderNumber") int orderNumber) {
		
		String trackNumber;
		
		if (orderNumber < 100) {
			trackNumber = "A000";
		}
		else {
			String orderNumberString = String.format("%d", orderNumber);
			trackNumber = "A" + orderNumberString.substring(0, 3);
		}
		
		trackNumber += deliverymanCpf.substring(0, 3);
		
		byte[] array = new byte[4];
		new Random().nextBytes(array);
		String RandomTrackNumber = new String(array, Charset.forName("UTF-8"));
		RandomTrackNumber = RandomTrackNumber.toUpperCase();
		trackNumber += RandomTrackNumber + "BR";
		
		System.out.println("DeliveryRest - trackNumber" + trackNumber);
		return service.trackNumber(deliverymanCpf, orderNumber);
	}

	@Override
	@GetMapping("/deliveryStatus/{deliverymanCpf:.+}/{orderNumber}")
	public DeliveryStatus deliveryStatus(
			@PathVariable("deliverymanCpf") String deliverymanCpf, 
			@PathVariable("orderNumber") int orderNumber) {
		
		System.out.println("DeliveryRest - confirmDeliveryStatusOfOrder");
		return service.deliveryStatus(deliverymanCpf, orderNumber);
	}

}