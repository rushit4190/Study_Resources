
## Static Keyword - 

- In the Java programming language, the keyword static means that the particular member belongs to a type itself, rather than to an instance of that type.

- This means we’ll create only one instance of that static member that’s shared across all instances of the class.

- From the memory perspective, **static variables are stored in the heap memory.**

### The static Fields (Or Class Variables)
when we declare a field static, exactly a single copy of that field is created and shared among all instances of that class.
**Reasons to use -**
- when the value of the variable is independent of objects
- when the value is supposed to be shared across all objects

```
public class Car {
private String name;
private String engine;

    public static int numberOfCars;
    
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    // getters and setters
}
```

Now for every object of this class that we instantiate, the same copy of the numberOfCars variable is incremented.

Below will be true - 
```
@Test
public void whenNumberOfCarObjectsInitialized_thenStaticCounterIncreases() {
    new Car("Jaguar", "V8");
    new Car("Bugatti", "W16");
 
    assertEquals(2, Car.numberOfCars);
}
```

### The static Methods (Or Class Methods)

We can call static methods without creating the object of the class in which they reside.
**Reasons to use -**
- to access/manipulate static variables and other static methods that don’t depend upon objects.
- static methods are widely used in utility and helper classes.
- Examples : Collections or Math utility classes from JDK, or CollectionUtils from Spring framework and notice that all their utility methods are static.

**Few points to remember**
- static methods in Java are resolved at compile time. Since method overriding is part of Runtime Polymorphism, static methods can’t be overridden.
- Abstract methods can’t be static.
- static methods can’t use this or super keywords.

```
static void setNumberOfCars(int numberOfCars) {
    Car.numberOfCars = numberOfCars;
}
```

The following combinations of the instance, class methods, and variables are valid:

- instance methods can directly access both instance methods and instance variables
- instance methods can also access static variables and static methods directly
- static methods can access all static variables and other static methods
- static methods can’t access instance variables and instance methods directly. They need some object reference to do so.

Example of last point- 
```
public String getName() {
    return name;
}

public String getEngine() {
    return engine;
}

public static String getCarsInformation(Car car) {
    return car.getName() + "-" + car.getEngine();
}
```
This is only possible because we use an instance of the Car object to access these methods. Otherwise, we’d get this error message “Non-static method ‘getName()’ cannot be referenced from a static context“.

### A static Block

few reasons for using static blocks:
- if the initialization of static variables needs some additional logic apart from the assignment
- if the initialization of static variables is error-prone and needs exception handling

### A static Class

In general, the nested class architecture is divided into two types:
- nested classes that we declare static are called static nested classes
- nested classes that are non-static are called inner classes

The main difference between these two is that the inner classes have access to all members of the enclosing class (including private ones), whereas the static nested classes only have access to static members of the outer class.
In fact, static nested classes behave exactly like any other top-level class, but are enclosed in the only class that will access it, to provide better packaging convenience.

**Key points to remember**
- Basically, a static nested class doesn’t have access to any instance members of the enclosing outer class. It can only access them through an object’s reference.
- static nested classes can access all static members of the enclosing class, including private ones.
- Java programming specification doesn’t allow us to declare the top-level class as static. Only classes within the classes (nested classes) can be made as static.

**Reasons to use**
- grouping classes that will be used only in one place increases encapsulation
- we bring the code closer to the only place that will use it. This increases readability, and the code is more maintainable.
- if a nested class doesn’t require any access to its enclosing class instance members, it’s better to declare it as static. This way, it won’t be coupled to the outer class and is therefore more optimal, as they won’t require any heap or stack memory.

```
public class Pizza {

    private static String cookedCount;
    private boolean isThinCrust;

    public static class PizzaSalesCounter {

        private static String orderedCount;
        public static String deliveredCount;

        PizzaSalesCounter() {
            System.out.println("Static field of enclosing class is "
              + Pizza.cookedCount);
            System.out.println("Non-static field of enclosing class is "
              + new Pizza().isThinCrust);
        }
    }

    Pizza() {
        System.out.println("Non private static field of static class is "
          + PizzaSalesCounter.deliveredCount);
        System.out.println("Private static field of static class is "
          + PizzaSalesCounter.orderedCount);
    }

    public static void main(String[] a) {
           new Pizza.PizzaSalesCounter();
    }
}
```

Result - 
Note order of print statements execution!
```
Static field of enclosing class is null
Non private static field of static class is null
Private static field of static class is null
Non-static field of enclosing class is false
```