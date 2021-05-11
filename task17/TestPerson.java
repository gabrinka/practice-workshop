package com.sap.intern.task17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestPerson {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Gabi","Petrova","Sofiq",23));
		people.add(new Person("Aleks","Ivanov","Varna",24));
		people.add(new Person("Gabi","Petrova","Sofia",23));
		people.add(new Person("Rositsa","Milanova","Plovdiv",23));
		
		Object[] arrayToSort = people.toArray();
		Arrays.sort(arrayToSort);
		
		for (Object person : arrayToSort) {
			System.out.println(person);
		}
		
		Map<Person,Integer> pairs = new HashMap<>();
		Person gabi = new Person("Gabi","Petrova","Sofiq",23);
		Person gabi2 = new Person("Gabi","Petrova","Sofiq",23);
		
		System.out.println(gabi.hashCode() + " " + gabi2.hashCode());
		System.out.println(gabi.equals(gabi2));
		System.out.println(gabi2.equals(gabi));
		
		pairs.put(gabi, 23);
		pairs.put(gabi2, 40);
		pairs.put(new Person("Gabi","Petrova","Sofiq",23), 23);
		pairs.put(new Person("Aleks","Ivanov","Varna",24), 25);
		
		System.out.println(pairs.get(gabi));
		System.out.println(pairs.get(gabi2));
		for (Entry<Person, Integer> entry : pairs.entrySet()) {
			System.out.println("Key is " + entry.getKey());
			System.out.println("Value is " + entry.getValue());
		}
	}
}
