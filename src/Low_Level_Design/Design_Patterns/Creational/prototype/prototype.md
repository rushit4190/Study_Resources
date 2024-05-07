#### Prototype

- Lets you copy existing objects without making your code dependent on their classes.
- Since you have to know the object’s class to create a duplicate, your code becomes dependent on that class.
- Sometimes you only know the interface that the object follows, but not its concrete class, when, for example, a parameter in a method accepts any objects that follow some interface.
- It allows you to create a copy of an existing object and modify it to your needs, instead of going through the trouble of creating an object from scratch and setting it up.

![structure-prototype-cache-2x.png](../../../../../diagrams/structure-prototype-cache-2x.png)


- Use the Prototype pattern when your code shouldn’t depend on the concrete classes of objects that you need to copy. (Accessing 3rd party classes)
- Use the pattern when you want to reduce the number of subclasses that only differ in the way they initialize their respective objects.
- For objects that require costly or time-consuming initialization processes.