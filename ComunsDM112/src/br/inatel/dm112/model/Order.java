package br.inatel.dm112.model;

import java.util.Date;

public class Order {

//	@JsonIgnore
	public static enum STATUS { FILLED, WITHDRAW, DELIVERED }

	private int number;

	private String deliverymanCpf;

	private int status;

	private Date orderCreationDate;
	
	private String receiverCpf;
	
	private Date orderDeliveredDate;

	
	public Order() {
	}

	public Order(int number, String deliverymanCpf, int status, Date orderCreationDate, String receiverCpf, Date orderDeliveredDate) {
		super();
		this.number = number;
		this.deliverymanCpf = deliverymanCpf;
		this.status = status;
		this.orderCreationDate = orderCreationDate;
		this.receiverCpf = receiverCpf;
		this.orderDeliveredDate = orderDeliveredDate;
		}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getReceiverCpf() {
		return receiverCpf;
	}

	public void setReceiverCpf(String receiverCpf) {
		this.receiverCpf = receiverCpf;
	}
	
	public Date getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(Date orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public Date getOrderDeliveredDate() {
		return orderDeliveredDate;
	}

	public void setOrderDeliveredDate(Date orderDeliveredDate) {
		this.orderDeliveredDate = orderDeliveredDate;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", deliverymanCpf=" + deliverymanCpf + ", status=" + status
				+ ", orderCreationDate=" + orderCreationDate + ", receiverCpf=" + receiverCpf + ", orderDeliveredDate="
				+ orderDeliveredDate + "]";
	}

}
