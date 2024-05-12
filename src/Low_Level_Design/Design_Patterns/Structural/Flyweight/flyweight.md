### Flyweight

- Lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
- **To implement flyweight :**
  - Divide fields of a class that will become a flyweight into two parts:
    - **the intrinsic state:** the fields that contain unchanging data duplicated across many objects
    - **the extrinsic state:** the fields that contain contextual data unique to each object
  - Leave the fields that represent the intrinsic state in the class, but make sure they’re immutable. They should take their initial values only inside the constructor. Dnt expose any setters or public fields to other objects.
  - Go over methods that use fields of the extrinsic state. For each field used in the method, introduce a new parameter and use it instead of the field.

- Flyweight can be recognized by a creation method that returns cached objects instead of creating new.
- Examples of Flyweight in core Java libraries:

      java.lang.Integer#valueOf(int) (also Boolean, Byte, Character, Short, Long and BigDecimal)


![structure-2x-flyweight.png](../../../../../diagrams/structure-2x-flyweight.png)


- The Flyweight class contains the portion of the original object’s state that can be shared between multiple objects. The same flyweight object can be used in many different contexts. The state stored inside a flyweight is called intrinsic. The state passed to the flyweight’s methods is called extrinsic.
- The Context class contains the extrinsic state, unique across all original objects. When a context is paired with one of the flyweight objects, it represents the full state of the original object.
- Usually, the behavior of the original object remains in the flyweight class. In this case, whoever calls a flyweight’s method must also pass appropriate bits of the extrinsic state into the method’s parameters. On the other hand, the behavior can be moved to the context class, which would use the linked flyweight merely as a data object.
- The Flyweight Factory manages a pool of existing flyweights. With the factory, clients don’t create flyweights directly. Instead, they call the factory, passing it bits of the intrinsic state of the desired flyweight. The factory looks over previously created flyweights and either returns an existing one that matches search criteria or creates a new one if nothing is found.

