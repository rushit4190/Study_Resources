# Polymorphism

- Polymorphism refers to the same object exhibiting different forms and behaviors.
- Polymorphism is an OOP feature that allows for differentiation between entities with the same name. It allows us to perform a single action in different ways. 
- Polymorphism is used in Java because it helps us reuse code.
- Two types - 
  - Static or Compile-time Polymorphism
  - Dynamic or Runtime Polymorphism

**Compile-time Polymorphism**

- This type of polymorphism is achieved by function overloading or operator overloading. 
- But Java doesn’t support the Operator Overloading. It is a feature in C++ where the operators such as +, -, *, etc. can be given additional meanings when applied to user-defined data types.
- **Method Overloading**
  - When there are multiple functions with the same name but different parameters then these functions are said to be overloaded. 
  - Functions can be overloaded by changes in the number of arguments or/and a change in the type of arguments but not the return type.
  - During code compilation, the compiler verifies that all invocations of the concerned method correspond to at least one of the methods defined in Class.

- **Method overriding**
- Java Virtual Machine (JVM) handles the detection of the appropriate method to execute when a subclass is assigned to its parent form. This is necessary because the subclass may override some or all of the methods defined in the parent class.
- It involves redefining a parent class’s method in a subclass.
- When an overridden method is called through a superclass reference, Java determines which version(superclass/subclasses) of that method is to be executed based upon the type of the object being referred to at the time the call occurs. Thus, this determination is made at run time.
- At run-time, it depends on the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed
- A superclass reference variable can refer to a subclass object. This is also known as upcasting. Java uses this fact to resolve calls to overridden methods at run time.

- In Java, we can override methods only, not the variables(data members), so **runtime polymorphism cannot be achieved by data members.**
```
// Java program to illustrate the fact that 
// runtime polymorphism cannot be achieved 
// by data members 

// class A 
class A 
{ 
	int x = 10; 
} 

// class B 
class B extends A 
{ 
	int x = 20; 
} 

// Driver class 
public class Test 
{ 
	public static void main(String args[]) 
	{ 
		A a = new B(); // object of type B 

		// Data member of class A will be accessed 
		System.out.println(a.x); 
	} 
} 

```
- In above program, both the class A(super class) and B(sub class) have a common variable ‘x’. Now we make object of class B, referred by ‘a’ which is of type of class A. Since variables are not overridden, so the statement “a.x” will always refer to data member of super class.
- When we declare a variable in a Child class which has the same name e.g. x as an instance variable in a Parent class then

  - Child class's object contains both variables (one inherited from Parent class and other declared in Child itself) but the child class variable hides the parent class's variable.
  - Because the declaration of x in class Child hides the definition of x in class Parent, within the declaration of class Child, the simple name x always refers to the field declared within class Child. And if the code in methods of Child class wants to refer to the variable x of Parent class then this can be done as super.x.

  - If we are trying to access the variable outside of Parent and Child class, then the instance variable is chosen from the reference type. Thus, the expression a.x in the following code gives the variable value which belongs to parent class even if it is holding the object of the Child but ((B) a).x accesses the value from the Child class because we cast the same reference to Child.

- Static binding is done during compile-time while dynamic binding is done during run-time.
- private, final and static methods and variables uses static binding and bonded by compiler while overridden methods are bonded during runtime based upon type of runtime object.