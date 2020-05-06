package br.inatel.dm112.model;

import java.util.Date;

public class Order {

//	@JsonIgnore
	public static enum STATUS { FILLED, PENDING, CONFIRMED }

	private int number;

	private String cpf;

	private int status;

	private Date orderDate;

	
	public Order() {
	}

	public Order(int number, String cpf, int status, Date orderDate) {
		super();
		this.number = number;
		this.cpf = cpf;
		this.status = status;
		this.orderDate = orderDate;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", cpf=" + cpf + ", status=" + status + ", orderDate=" + orderDate + "]";
	}

}
