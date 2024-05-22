#### Observer

- lets you define a subscription mechanism to notify multiple objects about any events(changes) that happen to the object they’re observing.
- Intent is to define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- The object whose state changes, and it’s also going to notify other objects about the changes to its state, is a publisher.
- All other objects that want to track changes to the publisher’s state are subscribers
- **Usage Example:**
  - All implementations of `java.util.EventListener` 

![structure-2x-observer.png](../../../../../diagrams/structure-2x-observer.png)


- The Publisher issues events of interest to other objects. These events occur when the publisher changes its state or executes some behaviors. Publishers contain a subscription infrastructure that lets new subscribers join and current subscribers leave the list.
- When a new event happens, the publisher goes over the subscription list and calls the notification method declared in the subscriber interface on each subscriber object.
- The Subscriber interface declares the notification interface. In most cases, it consists of a single update method. The method may have several parameters that let the publisher pass some event details along with the update.
- Concrete Subscribers perform some actions in response to notifications issued by the publisher. All of these classes must implement the same interface so the publisher isn’t coupled to concrete classes.
- Usually, subscribers need some contextual information to handle the update correctly. For this reason, publishers often pass some context data as arguments of the notification method. The publisher can pass itself as an argument, letting subscriber fetch any required data directly.
- The Client creates publisher and subscriber objects separately and then registers subscribers for publisher updates.


- Use the Observer pattern when changes to the state of one object may require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.
- Use the pattern when some objects in your app must observe others, but only for a limited time or in specific cases.
