package br.inatel.dm112.model;

public class DeliveryStatus {

	private String deliverymanCpf;
	private int orderNumber;
	private int status;

	public DeliveryStatus() {

	}

	public DeliveryStatus(int status, String deliverymanCpf, int orderNumber) {
		super();
		this.status = status;
		this.deliverymanCpf = deliverymanCpf;
		this.orderNumber = orderNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDeliverymanCpf() {
		return deliverymanCpf;
	}

	public void setDeliverymanCpf(String deliverymanCpf) {
		this.deliverymanCpf = deliverymanCpf;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "DeliveryStatus [deliverymanCpf=" + deliverymanCpf + ", orderNumber=" + orderNumber + ", status="
				+ status + "]";
	}

	
}
