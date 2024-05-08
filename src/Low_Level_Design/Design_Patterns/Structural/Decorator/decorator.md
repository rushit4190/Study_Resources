#### Decorator

- lets you dynamically attach new behaviors to objects at run time by placing these objects inside special wrapper objects (decorator class) that contain the behaviors.
- Aggregation/composition is the key principle behind Decorator pattern.
- **Identification :** Decorator can be recognized by creation methods or constructors that accept objects of the same class or interface as a current class.
- **Real World analogy :** Wearing clothes is an example of using decorators. When you’re cold, you wrap yourself in a sweater. If you’re still cold with a sweater, you can wear a jacket on top. If it’s raining, you can put on a raincoat. All of these garments “extend” your basic behavior but aren’t part of you, and you can easily take off any piece of clothing whenever you don’t need it.


![structure-2x-decorator.png](../../../../../diagrams/structure-2x-decorator.png)


- The Component declares the common interface for both wrappers and wrapped objects.
- Concrete Component is a class of objects being wrapped. It defines the basic behavior, which can be altered by decorators.
- The Base Decorator class has a field for referencing a wrapped object. The field’s type should be declared as the component interface so it can contain both concrete components and decorators. The base decorator delegates all operations to the wrapped object.
- Concrete Decorators define extra behaviors that can be added to components dynamically. Concrete decorators override methods of the base decorator and execute their behavior either before or after calling the parent method.
- The Client can wrap components in multiple layers of decorators, as long as it works with all objects via the component interface.



- Composite and Decorator have similar structure diagrams. Decorator is designed to let you add responsibilities to objects without subclassing. Composite's focus is not on embellishment but on representation.
- Decorator and Proxy have different purposes but similar structures. Both describe how to provide a level of indirection to another object, and the implementations keep a reference to the object to which they forward requests.
- 

