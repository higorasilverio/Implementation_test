package br.inatel.dm112.interfaces;

import java.util.List;

import br.inatel.dm112.model.Order;
import br.inatel.dm112.model.OrderResponse;

public interface OrderInterface {

	public Order getOrder(int orderNumber);

	public List<Order> searchOrders(String cpf);

	public OrderResponse updateOrder(Order order);

	public List<Order> getAllOrders();
}