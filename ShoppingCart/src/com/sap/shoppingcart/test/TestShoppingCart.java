package com.sap.shoppingcart.test;
import com.sap.shoppingcart.implementations.CalculateDiscount;
import com.sap.shoppingcart.implementations.Product;
import com.sap.shoppingcart.implementations.ShoppingCart;
import com.sap.shoppingcart.implementations.Type;

public class TestShoppingCart {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE)); 
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(12.12, "Premium coconut", Type.PRODUCE));
		cart.addItem(new Product(2, "Whole grain bread", Type.BREAD));
		cart.addItem(new Product(100000, " Glenfiddich 1936", Type.BEVARAGE));
		
		CalculateDiscount checkout = new CalculateDiscount();
		double total = checkout.calculateTotal(cart);
		System.out.println("Total sum of products is " + total);

	}
}
