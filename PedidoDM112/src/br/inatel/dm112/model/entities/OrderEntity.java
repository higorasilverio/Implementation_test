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

	private String deliverymanCpf;

	private int status;

	@Column(name = "dataCriacaoPedido", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderCreationDate;
	
	private String receiverCpf;
	
	@Column(name = "dataEntregaPedido", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderDeliveredDate;

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

	public Date getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(Date orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
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

	public Date getOrderDeliveredDate() {
		return orderDeliveredDate;
	}

	public void setOrderDeliveredDate(Date orderDeliveredDate) {
		this.orderDeliveredDate = orderDeliveredDate;
	}

	@Override
	public String toString() {
		return "OrderEntity [number=" + number + ", deliverymanCpf=" + deliverymanCpf + ", status=" + status
				+ ", orderCreationDate=" + orderCreationDate + ", receiverCpf=" + receiverCpf + ", orderDeliveredDate="
				+ orderDeliveredDate + "]";
	}

}
