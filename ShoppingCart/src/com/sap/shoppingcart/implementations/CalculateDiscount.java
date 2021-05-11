package com.sap.shoppingcart.implementations;
import java.util.Map.Entry;
import java.util.Set;

public class CalculateDiscount {
	private static final int COUNT = 10;
	private static final int TOTAL_SUM_FOR_DISCOUNT = 100000;
	private static final int DISCOUNT_ON_PRODUCTS = 10;
	private static final int DISCOUNT_ON_TOTAL_SUM = 10;

	public double calculateTotal(final ShoppingCart cart) {
		if(cart == null) {
			throw new IllegalArgumentException("Cart cannot be null!");
		}
		double totalPrice = 0;
		Set<Entry<Product,Integer>> products = cart.getCart().entrySet();
		for (Entry<Product,Integer> product : products) {
			totalPrice += getDiscountedPrice(product);	
		}
		
		if(totalPrice > TOTAL_SUM_FOR_DISCOUNT) {
			totalPrice -= (totalPrice * DISCOUNT_ON_TOTAL_SUM / 100);
		}
		
		return totalPrice;
	}

	private double getDiscountedPrice(final Entry<Product, Integer> product) {
		int productQuantity = product.getValue();
		double productPrice = product.getKey().getPrice();
		double totalOriginalPrice = productQuantity * productPrice;
		double totalFinalPrice = totalOriginalPrice;

		if (productQuantity >= COUNT) {
			totalFinalPrice = totalOriginalPrice - (totalOriginalPrice * DISCOUNT_ON_PRODUCTS / 100);
		}

		return totalFinalPrice;
	}

}
