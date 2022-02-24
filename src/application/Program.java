package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		String date = sc.nextLine();
		
		Client c1 = new Client(name, email, sdf.parse(date));
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		
		//Utilizando o ValueOf para ler e já converter o String para o tipo enumerado;
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, c1);
		
		System.out.print("How many items to this order? ");
		int items = sc.nextInt() +1;
		for(int i = 1; i < items; i++) {
			System.out.println("Enter #" + i + " item data:");
			
			System.out.print("Product name: ");
			// usar o "sc.nextLine();" 
			//para consumir a quebra de linha que ficou pendente na leitura do número inteiro;
			sc.nextLine();
			String nameProduct = sc.nextLine();
			
			
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product p = new Product(nameProduct, priceProduct);
			
			OrderItem orderItem = new OrderItem(quantity, priceProduct, p );
			
			 order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");		
		System.out.println(order);
		

		
		sc.close();
	}

}
