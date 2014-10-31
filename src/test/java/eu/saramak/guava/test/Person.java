package eu.saramak.guava.test;

import static com.google.common.base.Objects.*;

import com.google.common.base.Objects;

public class Person {
	public String name;
	public String surname;
	public int age;

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	// Shift+Alt+S
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age
				+ "]";
	}

	public String toStringG() {
		return toStringHelper(this).add("name", name).add("surname", surname)
				.add("age", age).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	
	public int hashCodeG() {
		return Objects.hashCode(name, surname, age);
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
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
 
	public boolean equalsG(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equal(name, other.name)
				&& Objects.equal(surname, other.surname)
				&& Objects.equal(age, other.age);
	}

}
