
 - The SOLID principles provide a blueprint for writing code that’s easy to adjust, extend, and maintain over time.

**Benefits of using SOLID principles**

* **Clean:** SOLID principles make code clean and standard code.
* **Maintainable:** with the help of SOLID principles our code becomes more manageable and easy to maintain.
* **Scalable:** Easy to refactor or change code.
* **Redundancy:** SOLID principles avoid redundant code.
* **Testable:** can be easily unit tested.
* **Readable:** SOLID principles make the code easy and readable.
* **Independent:** code becomes independent by reducing dependencies.
* **Reusable:** code becomes reusable.

**1. S: Single Responsibility Principle (SRP)**

    "A class should have one and only one reason to change"

- This means that each class should be responsible for a single part or functionality of the system
- When a class performs just one task, it contains a small number of methods and member variables making them more usable and easier to maintain.
- If a class has multiple responsibilities, it becomes harder to understand, maintain, and modify and increases the potential for bugs because changes to one responsibility could affect the others.

    ```java
    public class EmployeeService {
       public void updateByName(String employeeName) {}
       public void getEmployeeByAddress() {}
       public void sendEmailNotification() {}
    }
    ```
- In the above example, update employee, get employee, and send email is included in one class, this class should not include the sending notification method because it is not related to employee behaviour. Hence, this class violates the single responsibility principle.
- The easiest way to fix this problem is to create separate classes for managing employees and sending email notifications, each having only one responsibility.

    ```java
    //Employee class should handle employee related responsibilities 
    public class EmployeeService {
       public void updateByName(String customerName) {}
       public void getEmployeeByAddress() {}
    }
    //Notification class should handle notification related responsibilities
    public class NotificatonService {
       public void sendEmailNotification() {}
    }
    ```
  
- Benefits of SRP:
  1. Testing – A class with one responsibility will have far fewer test cases.
  2. Lower coupling – Less functionality in a single class will have fewer dependencies.
  3. Organization – Smaller, well-organized classes are easier to search than monolithic ones.


**2. O: Open/Closed Principle (OCP)**

    "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."

- This means the design of a software entity should be such that you can introduce new functionality or behavior without modifying the existing code since changing the existing code might introduce bugs.

  ```java 
      public class SpeedCalculator {
        public BigDecimal calculateSpeed(Vehicle vehicle) {
          if (vehicle instanceof Car) {
            // Calculate Speed here…
          } else if (vehicle instanceof Airplane) {
            //Calculate Speed here…
          } else if (vehicle instanceof Bicycle) {
            //Calculate Speed here…
          }
        }
      }
  ```

- There is a problem with the above code, what if there is a new requirement to calculate the speed of trucks and other vehicles, you have to add lots of if conditions in the calculateSpeed method. There may be a chance that you will introduce some new bugs while adding the changes. This type of code change leads to poor code readability and is very hard to maintain.
- Rewrite the above code to ensure code extensibility and reusability using OCP:

  ```java
  public interface Vehicle{
     public BigDecimal calculateSpeed();
  }
  public class Car implements Vehicle {
     public BigDecimal calculateSpeed() {
       //calculate speed to car
     }
  }
  public class Airplane implements Vehicle {
     public BigDecimal calculateSpeed() {
        //calculate speed to car
     }
  }

  ```

- With the new implementation, we can calculate the speed of any vehicle by implementing the Vehicle interface, without modifying the underlying logic.
- Calling procedure:
```
  Vehicle car = new Car();
  car.calculateSpeed();
  
  Vehicle airplane = new Airplane();
  airplane.calculateSpeed();
```
- The use of interfaces is recommended to add abstraction and hence loose coupling.


**3. L: Liskov Substitution Principle (LSP)**

    "Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program."

- If class A is a subtype of class B, we should be able to replace B with A without affecting the behavior of our program.
- This means that objects of the subclass should behave in the same way as the superclass. 
- Following this principle during development can lead to code reusability, reduced coupling, and easier maintenance.

```java
    public class Rectangle {
    private double height;
    private double width;
    public void setHeight(double h) { height = h; }
    public void setWidht(double w) { width = w; }
      //
  }
  public class Square extends Rectangle {
    public void setHeight(double h) {
      super.setHeight(h);
      super.setWidth(h);
    }
    public void setWidth(double w) {
      super.setHeight(w);
      super.setWidth(w);
    }
  }   
```
- The above classes do not obey LSP because you cannot replace the Rectangle base class with its derived class Square. The Square class has extra constraints, i.e., the height and width must be the same. Therefore, substituting the Rectangle with the Square class may result in unexpected behavior.
- The solution to the above example is to create a separate abstract Shape class and then have the Square and Rectangle classes inherit from it.

```java
    abstract class Shape {
    public abstract double getArea();
  }
  
  class Rectangle extends Shape {
    private double height;
    private double width;
  
    public Rectangle(double height, double width) {
      this.height = height;
      this.width = width;
    }
  
    @Override
    public double getArea() {
      return height * width;
    }
  }
  
  class Square extends Shape {
    private double side;
  
    public Square(double side) {
      this.side = side;
    }
  
    @Override
    public double getArea() {
      return side * side;
    }
  }
  
  public class Main {
    public static void main(String[] args) {
      Shape rectangle = new Rectangle(7.0, 5.0);
      Shape square = new Square(3.0);
  
      System.out.println("Rectangle Area: " + rectangle.getArea());
      System.out.println("Square Area: " + square.getArea());
    }
  }
```

- Preserve Behavior: Ensure that the behavior of derived classes remains consistent with their base classes, particularly for methods defined in the base class.
- Avoid Overriding: Be cautious when overriding methods in subclasses. If overriding changes the intended behavior, LSP might be violated.
- Refactor If Necessary: If a subclass cannot fully inherit the behavior of its base class, consider refactoring to maintain LSP compliance.


**4. I: Interface Segregation Principle (ISP)**

    "No client should be forced to depend on interfaces they don't use."

- The main idea behind ISP is to prevent the creation of "fat" or "bloated" interfaces that include methods that are not required by all clients.
- By segregating interfaces into smaller, more specific ones, clients only depend on the methods they actually need, promoting loose coupling and better code organization.

```java
    interface Document {
    void create();
    void edit();
    void save();
    void print();
  }
  
  class TextDocument implements Document {
    // ...implement all methods
  }
  
  class PDFDocument implements Document {
    // ...implement all methods except edit()
  }
  
```

- In this case, the PDFDocument class doesn't require an edit() method, so it's forced to implement a method it doesn't need. To follow ISP, we can segregate the interface:

```java
  interface EditableDocument {
    void edit();
  }
  
  interface PrintableDocument {
    void print();
  }
  
  interface Document {
    void create();
    void save();
  }
  
  class TextDocument implements EditableDocument, PrintableDocument, Document {
    // ...implement relevant methods
  }
  
  class PDFDocument implements PrintableDocument, Document {
    // ...implement relevant methods
  }
```


**5. D: Dependency Inversion Principle (DIP)**

    "High-level modules should not depend on low-level modules, both should depend on abstractions."

- The Dependency Inversion Principle (DIP) states that we should depend on abstractions (interfaces and abstract classes) instead of concrete implementations (classes). The abstractions should not depend on details; instead, the details should depend on abstractions.

```java
    public class Engine {
        public void start() {}
    }
    public class Car {
        private Engine engine;
        public Car(Engine e) {
          engine = e;
        }
      public void start() {
        engine.start();
      }
  }

```

- Car class directly depends on Engine clas violating DIP, because high level Car class depends on low level Engine class, and induces tight coupling.
- If the same Car wants to run a different Engine type , say PetrolEngine, we will have to refactor the whole code.
- To solve this using DIP - 

```java
    // Abstraction for Engine
  interface Engine {
    void start();
  }
  
  // Class for PetrolEngine
  class PetrolEngine implements Engine {
    public void start() {
      System.out.println("Petrol engine started.");
    }
  }
  
  // Class for PetrolEngine
  class DieselEngine implements Engine {
    public void start() {
      System.out.println("Diesel engine started.");
    }
  }
  
  // Car class depends on Engine abstraction
  class Car {
    private Engine engine;
  
    public Car(Engine e) {
      this.engine = e;
    }
  
    public void startCar() {
      engine.start();
    }
  }
  
  public class Main {
    public static void main(String[] args) {
      Engine petrolEngine = new PetrolEngine();
      Engine dieselEngine = new DieselEngine();
  
      Car petrolCar = new Car(petrolEngine);
      Car dieselCar = new Car(dieselEngine);
  
      petrolCar.startCar();
      dieselCar.startCar();
    }
  }
```

- DIP allows you to change the implementation of lower-level modules without affecting higher-level modules.
- By depending on abstractions, you create code that is more reusable and adaptable to changes.
- Decoupled modules are easier to test in isolation, promoting better unit testing practices.
