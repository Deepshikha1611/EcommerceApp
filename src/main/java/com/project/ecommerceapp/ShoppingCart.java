package com.project.ecommerceapp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }

	public List<Product> getItems() {
		// TODO Auto-generated method stub
		return items;
	}
}