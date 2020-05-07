package br.inatel.dm112.interfaces;

import br.inatel.dm112.model.DeliveryStatus;

public interface Delivery {

	DeliveryStatus trackNumber(String cpf, int orderNumber);

	DeliveryStatus deliveryStatus(String cpf, int orderNumber);

}