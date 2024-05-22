#### Mediator

- intended to reduce the complexity of communication between multiple objects or classes in a system. It achieves this by providing a centralized mediator class that handles the interactions between different classes, thus reducing their direct dependencies on each other.
- Mediator decouples a set of classes by forcing their communications flow through a mediating object.
- **Usage Example:** `java.util.concurrent.ExecutorService (invokeXXX() and submit() methods)`
- The mediator pattern can be used to create an event or message broker, where each component that sends and receives messages can register with the broker. And as messages are sent to the broker, the broker passes the message onto one or more receivers based on some attribute (e.g., the to field) of the message.


![structure-2x-mediator.png](../../../../../diagrams/structure-2x-mediator.png)


- Components are various classes that contain some business logic. Each component has a reference to a mediator, declared with the type of the mediator interface. The component isn’t aware of the actual class of the mediator, so you can reuse the component in other programs by linking it to a different mediator.
- The Mediator interface declares methods of communication with components, which usually include just a single notification method. Components may pass any context as arguments of this method, including their own objects, but only in such a way that no coupling occurs between a receiving component and the sender’s class.
- Concrete Mediators encapsulate relations between various components. Concrete mediators often keep references to all components they manage and sometimes even manage their lifecycle.
- Components must not be aware of other components. If something important happens within or to a component, it must only notify the mediator. When the mediator receives the notification, it can easily identify the sender, which might be just enough to decide what component should be triggered in return.
- From a component’s perspective, it all looks like a total black box. The sender doesn’t know who’ll end up handling its request, and the receiver doesn’t know who sent the request in the first place.


- Use the Mediator pattern when it’s hard to change some of the classes because they are tightly coupled to a bunch of other classes.
- Use Mediator pattern to Facilitate simple communication between a large number of objects.
