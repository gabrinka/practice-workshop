package com.sap.shoppingcart.implementations;


public class Product { 
	private double price;
	private String name;
	private Type productType;

	public Product(double price, final String name, final Type productType) {
		this.price = price;
		this.name = name;
		this.productType = productType;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof Product)) {
			return false;
		}

		Product otherProduct = (Product) object;
		if (!otherProduct.name.equals(name)) {
			return false;
		}
		if (!otherProduct.productType.equals(productType)) {
			return false;
		}
		if (otherProduct.price != price) {
			return false;
		}

		return true;
	}
	
}
