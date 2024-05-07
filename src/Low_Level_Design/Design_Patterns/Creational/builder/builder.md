#### **Builder**

- lets you construct complex objects step by step.
- The pattern allows you to produce different types and representations of an object using the same construction code.


![structure-2x-builder.png](../../../../../diagrams/structure-2x-builder.png)


- Use the Builder pattern to get rid of a “telescoping constructor” (many constructors with different optional parameters),i.e. when an object has numerous attributes, especially optional ones, the Builder pattern simplifies instantiation.
- The Builder pattern can be applied when construction of various representations of the product involves similar steps that differ only in the details.
  - The base builder interface defines all possible construction steps, and concrete builders implement these steps to construct particular representations of the product.
  - Meanwhile, the director class guides the order of construction.
  - Also, Client can directly call the concrete builder class and create customizable objects.
- Use the Builder to construct Composite trees or other complex objects.
  - The Builder pattern lets you construct products step-by-step.
  - You could defer execution of some steps without breaking the final product. You can even call steps recursively, which comes in handy when you need to build an object tree.
  - A builder doesn’t expose the unfinished product while running construction steps. This prevents the client code from fetching an incomplete result.

