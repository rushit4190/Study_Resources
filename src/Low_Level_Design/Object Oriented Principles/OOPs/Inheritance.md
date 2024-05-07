# Inheritance

It is the mechanism in Java by which one class is allowed to inherit the features(fields and methods) of another class.

**Key points about Inheritance in Java**

- At the top of the hierarchy is the "Object" class, which is the superclass of all classes in Java.
- A superclass can have any number of subclasses. But a subclass can have only one superclass. This is because Java does not support multiple inheritances with classes.
- Although classes can inherit only one class, they can implement multiple interfaces.
- Starting with Java 8, interfaces could choose to define default implementations for its methods.
- But, Java disallows inheritance of multiple implementations of the same methods, defined in separate interfaces.

```
public interface Floatable {
    default void repair() {
    	System.out.println("Repairing Floatable object");	
    }
}
public interface Flyable {
    default void repair() {
    	System.out.println("Repairing Flyable object");	
    }
}
public class ArmoredCar extends Car implements Floatable, Flyable {
    // this won't compile 
}
```
- In case both the implemented interfaces contain default methods with the same method signature, the implementing class should explicitly specify which default method is to be used in some method excluding the main() of implementing class using super keyword, 
- or it should override the default method in the implementing class, or it should specify which default method is to be used in the default overridden method of the implementing class.
```
// Java program to demonstrate Multiple Inheritance
// through default methods

// Interface 1
interface PI1 {

	// Default method
	default void show()
	{

		// Print statement if method is called
		// from interface 1
		System.out.println("Default PI1");
	}
}

// Interface 2
interface PI2 {

	// Default method
	default void show()
	{

		// Print statement if method is called
		// from interface 2
		System.out.println("Default PI2");
	}
}

// Main class
// Implementation class code
class TestClass implements PI1, PI2 {

	// Overriding default show method
	@Override
	public void show()
	{

		// Using super keyword to call the show
		// method of PI1 interface
		PI1.super.show();//Should not be used directly in the main method;

		// Using super keyword to call the show
		// method of PI2 interface
		PI2.super.show();//Should not be used directly in the main method;
	}

	//Method for only executing the show() of PI1
	public void showOfPI1() {
		PI1.super.show();//Should not be used directly in the main method;
	}

	//Method for only executing the show() of PI2
	public void showOfPI2() {
		PI2.super.show(); //Should not be used directly in the main method;
	}

	// Mai driver method
	public static void main(String args[])
	{

		// Creating object of this class in main() method
		TestClass d = new TestClass();
		d.show();
		System.out.println("Now Executing showOfPI1() showOfPI2()");
		d.showOfPI1();
		d.showOfPI2();
	}
}

```
- If we remove the implementation of default method from “TestClass”, we get a compiler error.
- f there is a diamond through interfaces, then there is no issue if none of the middle interfaces provide implementation of root interface. If they provide implementation, then implementation can be accessed as above using super keyword.

```
// Java program to demonstrate How Diamond Problem
// Is Handled in case of Default Methods

// Interface 1
interface GPI {

	// Default method
	default void show()
	{

		// Print statement
		System.out.println("Default GPI");
	}
}

// Interface 2
// Extending the above interface
interface PI1 extends GPI {
}

// Interface 3
// Extending the above interface
interface PI2 extends GPI {
}

// Main class
// Implementation class code
class TestClass implements PI1, PI2 {

	// Main driver method
	public static void main(String args[])
	{

		// Creating object of this class
		// in main() method
		TestClass d = new TestClass();

		// Now calling the function defined in interface 1
		// from whom Interface 2and 3 are deriving
		d.show();
	}
}

```




- If the interfaces in the preceding examples define variables with the same name, say duration, we can’t access them without preceding the variable name with the interface name:
```
public interface Floatable {
    int duration = 10;
}
public interface Flyable {
    int duration = 20;
}
public class ArmoredCar extends Car implements Floatable, Flyable {
 
    public void aMethod() {
    	System.out.println(duration); // won't compile
    	System.out.println(Floatable.duration); // outputs 10
    	System.out.println(Flyable.duration); // outputs 20
    }
}
```
- An interface inherits other interfaces by using the keyword 'extends'. Classes use the keyword 'implements' to inherit an interface.
- When a class inherits another class or interfaces, apart from inheriting their members, it also inherits their type. This also applies to an interface that inherits other interfaces.
- A parent class/Interface can reference the child class during instantiation.
- Hidden Instance Members-
  - both the superclass and subclass define a variable or method with the same name.
  ```
  public class ArmoredCar extends Car {
    private String model;
    public String getAValue() {
    	return super.model;   // returns value of model defined in base class Car
    	// return this.model;   // will return value of model defined in ArmoredCar
    	// return model;   // will return value of model defined in ArmoredCar
    }
  }
  ```
- Hidden Static Members - 
  - when our base class and subclasses define static variables and methods with the same name
  ```
  public class Car {
    public static String msg() {
        return "Car";
    }
  }
  public class ArmoredCar extends Car {
    public static String msg() {
        return super.msg(); // this won't compile.
    }
  }
  ```
  - The static members belong to a class and not to instances. So we can’t use the non-static super keyword in msg().
  - static members belong to a class, we can modify the preceding call as follows:
  ```
  return Car.msg();
  ```
  - In following example, both the base class and derived class define a static method msg() with the same signature:
  ```
  public class Car {
    public static String msg() {
        return "Car";
    }
    }
  public class ArmoredCar extends Car {
    public static String msg() {
        return "ArmoredCar";
    }
    }
  
  Car first = new ArmoredCar(); // “Car“ 
  ArmoredCar second = new ArmoredCar(); //  “ArmoredCar”
  ```
  - the static message that is called depends on the type of the variable used to refer to ArmoredCar instance.

- A subclass class inherits the non-static protected and public members from the superclass class. In addition, the members with default (package-private) access are inherited if the two classes are in the same package.
- On the other hand, the private and static members of a class are not inherited.

- Types of Inheritance - 
  - Single Inheritance
  - Multilevel Inheritance
  - Hierarchical Inheritance
  - Multiple Inheritance (Not for classes, only for interface)
  - Hybrid Inheritance

- Inheritance using 'extends' keyword forms a IS-A type relationship.

**Association**

- Association is a relation between two separate classes which is established through their Objects. 
- Association can be one-to-one, one-to-many, many-to-one, many-to-many. 
- In Object-Oriented programming, an Object communicates to another object to use functionality and services provided by that object. 
- **Composition** and **Aggregation** are the two forms of association. 

**Aggregation**

- It is a special form of Association where:

  - It represents Has-A’s relationship.
  - It is a unidirectional association i.e. a one-way relationship. For example, a department can have students but vice versa is not possible and thus unidirectional in nature.
  - In Aggregation, both entries can survive individually which means ending one entity will not affect the other entity.

**Composition**

- Composition is a restricted form of Aggregation in which two entities are highly dependent on each other.

  - It represents part-of relationship.
  - In composition, both entities are dependent on each other.
  - When there is a composition between two entities, the composed object cannot exist without the other entity.

**Aggregation vs Composition**

**Dependency**: Aggregation implies a relationship where the child can exist independently of the parent. For example, Bank and Employee, delete the Bank and the Employee still exist. whereas Composition implies a relationship where the child cannot exist independent of the parent. Example: Human and heart, heart don’t exist separate to a Human

**Type of Relationship**: Aggregation represents “has-a” relationship whereas, Composition represents “part-of” relationship.

**Type of association**: Composition is a strong Association whereas, Aggregation is a weak Association.

