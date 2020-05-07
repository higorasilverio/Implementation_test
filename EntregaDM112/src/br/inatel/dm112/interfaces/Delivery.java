package br.inatel.dm112.interfaces;

import br.inatel.dm112.model.DeliveryStatus;
import br.inatel.dm112.services.DeliveryService;

public interface Delivery {

	DeliveryService trackNumber(String cpf, int orderNumber);

	DeliveryStatus deliveryStatus(String cpf, int orderNumber);

}