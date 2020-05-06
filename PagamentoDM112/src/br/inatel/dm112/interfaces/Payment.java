package br.inatel.dm112.interfaces;

import br.inatel.dm112.model.DeliveryStatus;

public interface Payment {

	DeliveryStatus startPaymentOfOrder(String cpf, int orderNumber);

	DeliveryStatus confirmPaymentOfOrder(String cpf, int orderNumber);

}