package com.project.ecommerceapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {

	public static void calculateCartValue() { 
		Scanner scanner = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		ShoppingCart cart = new ShoppingCart();
		// Populate product list
		products.add(new Product("Laptop", 999.99));
		products.add(new Product("Smartphone", 499.99));
		products.add(new Product("Headphones", 49.99));
		products.add(new Product("Tablet", 299.99));

		while (true) {
			System.out.println("Available Products:");
			int productCount = 1;
			for (Product product : products) {
				System.out.println(productCount + ". " + product.getName() + " - $" + product.getPrice());
				productCount++;
			}

			System.out.print("Enter the product number to add to cart (0 to checkout): ");
			int choice = scanner.nextInt();

			if (choice == 0) {
				break;
			}

			if (choice > 0 && choice <= products.size()) {
				Product selectedProduct = products.get(choice - 1);
				cart.addItem(selectedProduct);
				System.out.println(selectedProduct.getName() + " added to the cart.");
			} else {
				System.out.println("Invalid choice. Please select a valid product.");
			}
		}

		double totalAmount = cart.calculateTotal();
		System.out.println("Cart Summary:");
		for (Product product : cart.getItems()) {
			System.out.println(product.getName() + " - $" + product.getPrice());
		}
		System.out.println("Total Amount: $" + totalAmount);

		System.out.println("Thank you for shopping with us!");
		scanner.close();
		System.exit(0);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LoginSystem login = new LoginSystem();
		while (true) {
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				login.registerUser(scanner);
				break;
			case 2:
				if(login.loginUser(scanner)==true)
				calculateCartValue();
				break;
			case 3:
				System.out.println("Goodbye!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}

	}
}
