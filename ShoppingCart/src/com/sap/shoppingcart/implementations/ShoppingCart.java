package com.sap.shoppingcart.implementations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class ShoppingCart {
	private Map<Product, Integer> cart;

	public ShoppingCart() {
		cart = new HashMap<>();
	}

	public Map<Product, Integer> getCart() {
		return Collections.unmodifiableMap(cart);
	}

	public void addItem(final Product product) {
		if (product == null) {
			System.out.println("Product cannot be null!");
			return;
		}

		int productQuantity = 1;
		if (cart.containsKey(product)) {
			productQuantity += cart.get(product);
		}

		cart.put(product, productQuantity);

	}

	public void removeItem(final String name) {
		Optional<Product> productToRemove = findProductByName(name);

		if (productToRemove.isPresent()) {
			int removedProductStock = cart.get(productToRemove);
			removedProductStock--;

			if (removedProductStock == 0) {
				cart.remove(productToRemove);
			}

		}

	}

	private Optional<Product> findProductByName(final String name) {
		Set<Product> products = cart.keySet();
		Predicate<Product> isTheSameProductName = product -> product.getName().equals(name);

		Optional<Product> foundProduct = products.stream().filter(isTheSameProductName).findFirst();

		return foundProduct;
	}
}
