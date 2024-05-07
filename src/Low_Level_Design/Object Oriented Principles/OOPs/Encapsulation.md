# Encapsulation

Encapsulation is hiding the state or internal representation of an object from the consumer of an API and providing publicly accessible methods bound to the object for read-write access.

It is a process of data hiding, and can be achieved by declaring variables in the class as private and declaring public methods for getting and setting the values of variables.

Encapsulation allows classes to have total control over what is stored in their fields. It also increases flexibility as we can decide which variables have read/write privileges. Omit getter or setter methods.

A good example of encapsulation would be implementing authorization. The username and password fields would be declared as private. To those data, public methods would be implemented.

```
// Java program to demonstrate 
// Java encapsulation

class Encapsulate {
	// private variables declared
	// these can only be accessed by
	// public methods of class
	private String geekName;
	private int geekRoll;
	private int geekAge;

	// get method for age to access
	// private variable geekAge
	public int getAge() { return geekAge; }

	// get method for name to access
	// private variable geekName
	public String getName() { return geekName; }

	// get method for roll to access
	// private variable geekRoll
	public int getRoll() { return geekRoll; }

	// set method for age to access
	// private variable geekage
	public void setAge(int newAge) { geekAge = newAge; }

	// set method for name to access
	// private variable geekName
	public void setName(String newName)
	{
		geekName = newName;
	}

	// set method for roll to access
	// private variable geekRoll
	public void setRoll(int newRoll) { geekRoll = newRoll; }
}

public class TestEncapsulation {
	public static void main(String[] args)
	{
		Encapsulate obj = new Encapsulate();

		// setting values of the variables
		obj.setName("Harsh");
		obj.setAge(19);
		obj.setRoll(51);

		// Displaying values of the variables
		System.out.println("Geek's name: " + obj.getName());
		System.out.println("Geek's age: " + obj.getAge());
		System.out.println("Geek's roll: " + obj.getRoll());

		// Direct access of geekRoll is not possible
		// due to encapsulation
		// System.out.println("Geek's roll: " +
		// obj.geekName);
	}
}

```

The table below summarises the available access modifiers. We can see that a class, regardless of the access modifiers used, always has access to its members:

| Modifier  | Class | Package | Subclass | World |
|-----------|-------|---------|----------|-------|
| public    | Y     | Y       | Y        | Y     |
| protected | Y     | Y       | Y        | N     |
| default   | Y     | Y       | N        | N     |
| private   | Y     | N       | N        | N     |
