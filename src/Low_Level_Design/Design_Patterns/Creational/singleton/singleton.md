#### Singleton

- lets you ensure that a class has only one instance, while providing a global access point to this instance.
- Use the Singleton pattern when a class in your program should have just a single instance available to all clients; for example, a single database object shared by different parts of the program.


- Singleton's global state can complicate unit testing. Ensure that your tests don't become tightly coupled to Singleton instances.
- Any change to the global state in one place could affect in the other areas and it could become pretty difficult to debug.
- In multithreaded environment, Singleton might introduce some performance overhead , so overuse of the same should be avoided.

**Various ways to implement Singleton**

- Below implementations are Lazy-loading:

1. [Single-threaded Singleton](SingleThreadSingleton.java) 
2. [Thread-Safe Singleton](ThreadSafeSingleton.java)

