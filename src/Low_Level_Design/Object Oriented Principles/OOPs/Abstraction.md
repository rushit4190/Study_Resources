# **Abstraction**

Abstraction is the concept of hiding complex implementation details of the program and exposing only the API required to use the implementation.

There are two ways to achieve abstraction in Java
- Abstract class (0 to 100%)
- Interface (100%)

Abstract classes and interfaces are used to define abstract data types, which can then be used to create concrete objects. 

An abstract class is a class that contains at least one abstract method, while an interface is a collection of abstract methods that can be implemented by any class.
For example, java.lang.Number is an abstract class.

**Key points about abstract class**

- abstract is a non-access modifier in java applicable for classes, and methods but not variables.
- An abstract class can be subclassed, but it can’t be instantiated.
- If a class defines one or more abstract methods, then the class itself must be declared abstract.
- An abstract class can declare both abstract and concrete methods.
- A subclass derived from an abstract class must either implement all the base class’s abstract methods or be abstract itself.
- **Abstract classes can have constructors:** 
  - Abstract classes can have constructors, which are used to initialize instance variables and perform other initialization tasks. However, because abstract classes cannot be instantiated directly, their constructors are typically called constructors in concrete subclasses.
- **Abstract classes can contain instance variables:** 
  - Abstract classes can contain instance variables, which can be used by both the abstract class and its subclasses. Subclasses can access these variables directly, just like any other instance variables.
- **Abstract classes can implement interfaces:**
  - the abstract class must provide concrete implementations of all methods defined in the interface.
- The following are various illegal combinations of other modifiers for methods with respect to abstract modifiers:
  - abstract final
    - final is used to prevent inheritance whereas abstract classes depend upon their child classes for complete implementation. In cases of methods, final is used to prevent overriding whereas abstract methods need to be overridden in sub-classes.
  - abstract native
  - abstract synchronized
  - abstract static
  - abstract private
  - abstract strict
- There can be a final method (which is concrete) in abstract class but any abstract method in class(abstract class) can not be declared as final  or in simpler terms final method can not be abstract itself as it will yield an error: “Illegal combination of modifiers: abstract and final”
- can use the abstract keyword for declaring top-level classes (Outer class) as well as inner classes as abstract.
 
```
  abstract class B {
    // declaring inner class as abstract with abstract
    // method
    abstract class C {
      abstract void myAbstractMethod();
    }
  }
  class D extends B {
      class E extends C {
      // implementing the abstract method
      void myAbstractMethod()
      {
        System.out.println(
        "Inside abstract method implementation");
      }
    }
  }
  
  public class Main {
  
      public static void main(String args[])
      {
          // Instantiating the outer class
          D outer = new D();
  
          // Instantiating the inner class
          D.E inner = outer.new E();
          inner.myAbstractMethod();
      }
  }
```

**Key reasons to use abstraction**
- We want to encapsulate some common functionality in one place (code reuse) that multiple, related subclasses will share
- We need to partially define an API that our subclasses can easily extend and refine
- The subclasses need to inherit one or more common methods or fields with protected access modifiers.
- Provides a way to define a common interface that can be used by all subclasses. (Consistency and Maintainability)
- Enables polymorphism

**Key points about Interface in Java**

-In an interface, we’re allowed to use:
  - constants variables
  - abstract methods
  - static methods
  - default methods
```
  public interface Electronic {
  
      // Constant variable
      String LED = "LED";
  
      // Abstract method
      int getElectricityUse();
  
      // Static method
      static boolean isEnergyEfficient(String electtronicType) {
          if (electtronicType.equals(LED)) {
              return true;
          }
          return false;
      }
  
      //Default method
      default void printDescription() {
          System.out.println("Electronic Description");
      }
  }
```

- we can’t instantiate interfaces directly
- an interface can be empty, with no methods or variables in it
- we can’t use the final word in the interface definition, as it will result in a compiler error
- all interface declarations should have the public or default access modifier; the abstract modifier will be added automatically by the compiler
- an interface method can’t be protected or final
- interface variables are public, static, and final by definition; we’re not allowed to change their visibility.
- When an interface extends another interface, it inherits all of that interface’s abstract methods. 
- When an abstract class implements an interface, it inherits all of its abstract and default methods.

**Abstract class vs Interface**

##### _When to use Interface -_
- Consider using the interface when our problem makes the statement “A is capable of [doing this]”. For example, “Clonable is capable of cloning an object”, “Drawable is capable of drawing a shape”, etc.
- If the problem needs to be solved using multiple inheritances and is composed of different class hierarchies
- When unrelated classes implement our interface. For example, Comparable provides the compareTo() method that can be overridden to compare two objects
- When application functionalities have to be defined as a contract, but not concerned about who implements the behavior. i.e., third-party vendors need to implement it fully

##### _When to use Abstract class -_
- Consider using abstract classes and inheritance when our problem makes the evidence “A is a B”. For example, “Dog is an Animal”, “Lamborghini is a Car”, etc.
- When trying to use the inheritance concept in code (share code among many related classes), by providing common base class methods that the subclasses override
- If we have specified requirements and only partial implementation details
- While classes that extend abstract classes have several common fields or methods (that require non-public modifiers)
- If one wants to have non-final or non-static methods to modify the states of an object

```
public abstract class Vehicle {
    
    protected abstract void start();
    protected abstract void stop();
    protected abstract void drive();
    protected abstract void changeGear();
    protected abstract void reverse();
    
    // standard getters and setters
}

public class Car extends Vehicle {

    @Override
    protected void start() {
        // code implementation details on starting a car.
    }

    @Override
    protected void stop() {
        // code implementation details on stopping a car.
    }

    @Override
    protected void drive() {
        // code implementation details on start driving a car.
    }

    @Override
    protected void changeGear() {
        // code implementation details on changing the car gear.
    }

    @Override
    protected void reverse() {
        // code implementation details on reverse driving a car.
    }
}

```
