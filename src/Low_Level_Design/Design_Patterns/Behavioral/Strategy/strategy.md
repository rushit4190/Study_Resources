#### Strategy

- lets you define a family of algorithms, put each of them into a separate class,i.e. encapsulate each one, and make their objects interchangeable.
- Strategy pattern lets the algorithm vary independently of the clients that use it and enables choosing the best-suited algorithm at runtime.
- The original class, called context, must have a field for storing a reference to one of the strategies. The context delegates the work to a linked strategy object instead of executing it on its own.
- The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context. In fact, the context doesn’t know much about strategies. 
- **Usage Example:** 
  - `java.util.Comparator#compare()` called from Collections#sort(), Comparator interface represents a strategy interface.
- Strategy pattern can be recognized by a method that lets a nested object do the actual work, as well as a setter that allows replacing that object with a different one.


![structure-2x-strategy.png](../../../../../diagrams/structure-2x-strategy.png)

- The Context maintains a reference to one of the concrete strategies and communicates with this object only via the strategy interface.
- The Strategy interface is common to all concrete strategies. It declares a method the context uses to execute a strategy.
- Concrete Strategies implement different variations of an algorithm the context uses.
- The context calls the execution method on the linked strategy object each time it needs to run the algorithm. The context doesn’t know what type of strategy it works with or how the algorithm is executed.
- The Client creates a specific strategy object and passes it to the context. The context exposes a setter which lets clients replace the strategy associated with the context at runtime.

- Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
- Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.
- Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
- Use the pattern when your class has a massive conditional statement that switches between different variants of the same algorithm.

##### Difference between State and Strategy pattern

- In State pattern, the behavior of whole class keeps changing
- In Strategy pattern, only the particular method or algorithm or behavior keeps changing.
- State is of class-level change while strategy is for method level change.
- State pattern doesn’t restrict dependencies between concrete states, letting them alter the state of the context at will.
- While Strategy pattern makes strategy objects completely independent and unaware of each other. 