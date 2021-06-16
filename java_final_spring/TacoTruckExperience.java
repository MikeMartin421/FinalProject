package java_final_spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import java_final_spring.TacoImpl.Protien;
import java_final_spring.interfaces.IPayment;
import java_final_spring.interfaces.IPayment.PaymentMethod;

public class TacoTruckExperience {
	private static final Scanner keyboard = new Scanner(System.in);
	private static TacoMenu menu = new TacoMenu();
	private static Orders tacoTruck = new OrdersMapImpl();
	private static List<String> orderList = new ArrayList<>(); 
	private static Map<String, Double> register = new HashMap<>(); 
	private static Map<PaymentMethod, IPayment> paymentMethods = new LinkedHashMap<>();
	public static void CreatePaymentMethods() {
		paymentMethods.put(PaymentMethod.CREDITCARD, new CreditCard());
		paymentMethods.put(PaymentMethod.DEBITCARD, new DebitCard());
		paymentMethods.put(PaymentMethod.CASH, new Cash());
	}
	public static void main(String[]args) throws OrderDoesNotExistException {
		TodaysMenu();
		CreatePaymentMethods();
		while (true) {
			//Loop for asking customers about the menu
			System.out.println("Welcome to the Taco Truck");
			System.out.println("Would you like to see the menu? (Y/N)");
			String input = keyboard.next();
			if(!input.toLowerCase().equals("y")) {
				System.out.println("Goodbye, come back soon!");
				break;
			}
			System.out.println("Here is the menu");
			for(MenuItem item: menu.getMenu()) {
				System.out.println(item);
			}
			System.out.println("What is your name?");
			String OrderName = keyboard.next();
			tacoTruck.createOrder(OrderName);
			orderList.add(OrderName);
			double cost = 0.00;
			while (true) {
				//Loop for protein selection
				System.out.println("Please enter a number for the menu item you would like");
				System.out.println("Enter 0 when you have finished your order");
				int itemNumber = keyboard.nextInt();
				if(itemNumber == 0) {
					System.out.println("Proccessing your order");
					System.out.println("The cost of your order is: $" + cost);
					register.put(OrderName, cost);
					break;
				}
				//Selecting the protein number and if they would like cheese.
				else if(itemNumber <= menu.getMenu().size()) {
					System.out.println(menu.getMenuItem(itemNumber-1));
					System.out.println("Would like to add cheese? (Y/N)");
					input = keyboard.next();
					TacoImpl taco; 
					if(!input.toLowerCase().equals("y")) {
						taco = new TacoImpl(menu.getMenuItem(itemNumber-1).getName(), false);
					}
					else {
						taco = new TacoImpl(menu.getMenuItem(itemNumber-1).getName(), true);
					}
					tacoTruck.addTacoToOrder(OrderName, taco);
					cost += menu.getMenuItem(itemNumber-1).getPrice();
				
				}
		
			}
			System.out.println("Do you want to start processing the order? (Y/N)");
			input = keyboard.next();
			if(input.toLowerCase().equals("y")) {
				break;
			}
			
		}
		for(String name: orderList) {
			//Payment methods for the customers
			System.out.println("Printing order for: " + name);
			System.out.println("Following payment methods are available: ");
			for(Map.Entry<PaymentMethod, IPayment> e: paymentMethods.entrySet()) {
				System.out.println("Choose: " + e.getValue().getPaymentMethod().ordinal() + " for " + e.getValue().getPaymentName() );
			}
			String input = keyboard.next();
			switch(input) {
				case "0":
					paymentMethods.get(PaymentMethod.CREDITCARD).pay(register.get(name));
					break;
				case "1":
					paymentMethods.get(PaymentMethod.DEBITCARD).pay(register.get(name));
					break;
				case "2":
					paymentMethods.get(PaymentMethod.CASH).pay(register.get(name));
					break;
			}
			
			List<TacoImpl> tacoList = tacoTruck.getListOfOrders(name);
			for(TacoImpl taco: tacoList) {
				System.out.println(taco);
			}
		}
		System.out.println("number of orders = " + tacoTruck.howManyOrders());
		int orderIndex = 0;
		while(tacoTruck.hasNext()) {
			//Process confirmation and record of how many orders
			System.out.println("Your order has been processed " + orderList.get(orderIndex));
			tacoTruck.closeOrder(orderList.get(orderIndex));
			orderIndex++;
		}
		System.out.println("Everything has been processed");
	}
	public static void TodaysMenu() {
		//Menu for today. TRUE indicates special. See TacoImpl to create/add more menu items.
		menu.addToMenu(1, Protien.CHICKEN, 13.00, false);
		menu.addToMenu(2, Protien.BEEF, 12.00, false);
		menu.addToMenu(3, Protien.PORK, 11.00, false);
		menu.addToMenu(4, Protien.BEAN, 7.00, true);
		menu.addToMenu(5, Protien.FISH, 16.00, false);
		menu.addToMenu(6, Protien.LOBSTER, 17.00, false);
		menu.addToMenu(7, Protien.SHRIMP, 18.00, false);
	}
}
