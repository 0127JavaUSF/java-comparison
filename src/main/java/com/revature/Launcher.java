package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Useful Keyboard Shortcuts:
 * 
 * ctrl+shift+o - Autoimport
 * ctrl+shift+f - autoformat
 * ctrl+s - save
 * alt+shift+s - Source/Generation Menu
 * ctrl+[+] - zoom in, (or - for out)
 * 
 * 
 */

/**
 * When a collection is ordered, it means the items within it are in sequence
 * given some definition of how order can be evaluated.
 * 
 * [1, 2, 3, 4] -> Natural integer value order [2, 3, 1, 5] -> Unordered [921,
 * 37, 4] -> Alternative ordering - Descending order
 *
 */
public class Launcher {
	static List<Person> people = new ArrayList<>();
	
	public static void main(String[] args) {
		people.add(new Person("Abby", "Adams"));
		people.add(new Person("Cindy", "Cinders"));
		people.add(new Person("Billy", "Barker"));
		
		System.out.println(people);
		Collections.sort(people);
		System.out.println(people);
		
	}
	
}

/**
 * 
 * How could people be ordered?
 * 
 * Natural ordered by Ascending last name, ascending first name. Natural order
 * is defined using the Comparable. Comparable is implemented on the class whose
 * order is being defined. Classes implementing Comparable<T> must define the compareTo(T)
 * method.
 * 
 * Alternative order - By firstName then lastName The Comparator interface is
 * used to define alternative ordering schemes. Comparator is often defined
 * outside of the class it compares.
 * 
 */
class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int compareTo(Person o) {
		if (this.lastName.compareTo(o.getLastName()) == 0) {
			return this.firstName.compareTo(o.getFirstName());
		}
		return this.lastName.compareTo(o.getLastName());
	}

}
