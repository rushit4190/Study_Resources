#### Memento

- lets you save and restore the previous state of an object without revealing the details of its implementation/ without violating encapsulation.
- The Memento pattern delegates creating the state snapshots to the actual owner of that state, the originator object.
- The pattern suggests storing the copy of the object’s state in a special object called memento. The contents of the memento aren’t accessible to any other object except the one that produced it.
- Other objects must communicate with mementos using a limited interface which may allow fetching the snapshot’s metadata (creation time, the name of the performed operation, etc.), but not the original object’s state contained in the snapshot.

##### Implementation based on nested classes


![structure1-2x-memento.png](../../../../../diagrams/structure1-2x-memento.png)

- The Originator class can produce snapshots of its own state, as well as restore its state from snapshots when needed.
- The Memento is a value object that acts as a snapshot of the originator’s state. It’s a common practice to make the memento immutable and pass it the data only once, via the constructor.
- The Caretaker knows not only “when” and “why” to capture the originator’s state, but also when the state should be restored.
- A caretaker can keep track of the originator’s history by storing a stack of mementos. When the originator has to travel back in history, the caretaker fetches the topmost memento from the stack and passes it to the originator’s restoration method.
- In this implementation, the memento class is nested inside the originator. This lets the originator access the fields and methods of the memento, even though they’re declared private. On the other hand, the caretaker has very limited access to the memento’s fields and methods, which lets it store mementos in a stack but not tamper with their state.

##### Implementation based on an intermediate interface

![structure3-2x-memento.png](../../../../../diagrams/structure3-2x-memento.png)

- This implementation allows having multiple types of originators and mementos. Each originator works with a corresponding memento class. Neither originators nor mementos expose their state to anyone.
- Caretakers are now explicitly restricted from changing the state stored in mementos. Moreover, the caretaker class becomes independent from the originator because the restoration method is now defined in the memento class.
- Each memento becomes linked to the originator that produced it. The originator passes itself to the memento’s constructor, along with the values of its state. Thanks to the close relationship between these classes, a memento can restore the state of its originator, given that the latter has defined the appropriate setters.


- Use the Memento pattern when you want to produce snapshots of the object’s state to be able to restore a previous state of the object.
- Use the pattern when direct access to the object’s fields/getters/setters violates its encapsulation.
- Similar to the command pattern, a memento can also be used to undo an operation. When an action is taken, a memento is stored in a caretaker and can be used later to undo the action. To undo the operation, a reference to both the originator and the memento is required. The command pattern can be used to create a command object with a reference to both, thus creating a single, self-contained object that can perform the undo operation.