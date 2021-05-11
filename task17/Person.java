package com.sap.intern.task17;

public class Person implements Comparable<Person> {
	private int age;
	private String firstName;
	private String lastName;
	private String address;

	public Person(final String firstName, final String lastName, final String address,final int age) {
		if(firstName == null || lastName == null) {
			throw new IllegalArgumentException("Names cannot be null!");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "The first name is " + firstName + ", the last name is " + lastName + ", the address is " + address
				+ ",the age is " + age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof Person)) {
			return false;
		}

		Person otherPerson = (Person) object;
		if (!otherPerson.address.equals(address)) {
			return false;
		}
		if (!otherPerson.firstName.equals(firstName)) {
			return false;
		}
		if (!otherPerson.lastName.equals(lastName)) {
			return false;
		}
		if (otherPerson.age != age) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(final Person otherPerson) {
		return firstName.compareTo(otherPerson.firstName);
	}
}
