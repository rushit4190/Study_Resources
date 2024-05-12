#### Facade

- Provides a simplified interface to a library, a framework, or any other complex set of classes, creating a single point of entry for clients to access the subsystem's functionality.
- Facade can be recognized in a class that has a simple interface, but delegates most of the work to other classes. Usually, facades manage the full life cycle of objects they use.
- It decouples a client implementation from the complex subsystem.
- There is a need to layer your subsystems. Use a facade to define an entry point to each subsystem level.


![structure-2x-facade.png](../../../../../diagrams/structure-2x-facade.png)


- The Facade provides convenient access to a particular part of the subsystem’s functionality. It knows where to direct the client’s request and how to operate all the moving parts.
- An Additional Facade class can be created to prevent polluting a single facade with unrelated features that might make it yet another complex structure. Additional facades can be used by both clients and other facades.
- The Complex Subsystem consists of dozens of various objects. To make them all do something meaningful, you have to dive deep into the subsystem’s implementation details, such as initializing objects in the correct order and supplying them with data in the proper format.
- Subsystem classes aren’t aware of the facade’s existence. They operate within the system and work with each other directly.
- The Client uses the facade instead of calling the subsystem objects directly.

