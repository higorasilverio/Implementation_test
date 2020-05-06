package br.inatel.dm112.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.inatel.dm112.model.Order.STATUS;

@Entity
@Table(name = "Pedido")
public class OrderEntity {
	
	@Id
	@Column(name = "numero")
	private int number;

	private String cpf;

	private int status;

	@Column(name = "dataPedido", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	public OrderEntity() {
		this.status = STATUS.FILLED.ordinal();
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
		return "OrderEntity [number=" + number + ", cpf=" + cpf + ", status=" + status + ", orderDate=" + orderDate
				+ "]";
	}

}
