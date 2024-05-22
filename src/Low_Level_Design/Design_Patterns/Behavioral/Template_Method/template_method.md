#### Template Method

- defines the skeleton of an algorithm in the superclass (usually an abstract class) but lets subclasses override specific steps of the algorithm without changing its structure.
- The Template Method pattern suggests that you break down an algorithm into a series of steps, turn these steps into methods, and put a series of calls to these methods inside a single template method. 
- The steps (methods) may either be abstract, or have some default implementation. To use the algorithm, the client is supposed to provide its own subclass, implement all abstract steps, and override some of the optional ones if needed (but not the template method itself).
- **Usage Example:**
  - All non-abstract methods of `java.io.InputStream`, `java.io.OutputStream`, `java.io.Reader` and `java.io.Writer`.
  - In `javax.servlet.http.HttpServlet` class, all the `doXXX()` methods send the HTTP 405 “Method Not Allowed” error by default. However, you can override any of those methods to send a different response.

![structure-2x-template-method.png](../../../../../diagrams/structure-2x-template-method.png)

- The Abstract Class declares methods that act as steps of an algorithm, as well as the actual template method which calls these methods in a specific order. The steps may either be declared abstract or have some default implementation.
- Concrete Classes can override all of the steps, but not the template method itself.

- Use the Template Method pattern when you want to let clients extend only particular steps of an algorithm, but not the whole algorithm or its structure.
- Use the pattern when you have several classes that contain almost identical algorithms with some minor differences. As a result, you might need to modify all classes when the algorithm changes.

