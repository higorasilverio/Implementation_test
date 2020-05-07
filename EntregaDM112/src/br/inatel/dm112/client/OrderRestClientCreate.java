package br.inatel.dm112.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.inatel.dm112.model.Order;
import br.inatel.dm112.model.OrderResponse;

public class OrderRestClientCreate {

	public static int orderNumber = 789;
	public static String deliverymanCpf = "111.111.111-11";
	public static String receiverCpf = "222.222.222-22";
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
		
		OrderRestClient client = new OrderRestClient();

		Order order = new Order();
		order.setDeliverymanCpf(deliverymanCpf);
		order.setNumber(orderNumber);
		order.setOrderCreationDate(new Date());
		order.setStatus(1);
		order.setReceiverCpf(receiverCpf);
		try {
			order.setOrderDeliveredDate(sdf.parse("07/05/2021 08:21:32"));
		} catch (ParseException e) {
			System.out.println("Error generating fake delivery date :" + e.getMessage());
		}

		OrderResponse resposta = client.createOrder(order);

		System.out.println("Status do update do pedido " + order.getNumber() + ":  " + resposta.getStatus());
	}

}
