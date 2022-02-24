package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date dateMoment = new Date();
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
	}

	public Order(Date dateMoment, OrderStatus status, Client client) {
		this.dateMoment = dateMoment;
		this.status = status;
		this.client = client;
	}

	public Date getDateMoment() {
		return dateMoment;
	}

	public void setDateMoment(Date dateMoment) {
		this.dateMoment = dateMoment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

//retirei os métodos get e set da List<OrderItem> 
//retirar para não dar acesso a lista e para encapsular e proteger a manipulação da lista

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double total = 0;
		for (OrderItem it : items) {
			total += it.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf2.format(dateMoment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));

		return sb.toString();
	}

}
