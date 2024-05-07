#### Composite

- Lets you compose objects into tree structures and then work with these structures as if they were individual objects.
- The composite pattern describes that a group of objects is to be treated in the same way as a single instance of an object.
- Popular solutions for problems that require tree structure
- Composite’s great feature is the ability to run methods recursively over the whole tree structure and sum up the results.
- **Usage examples :** When you need to represent objects in a tree-like structure with parent-child relationships, the Composite pattern simplifies the creation and management of these hierarchical structures. Examples-  menus, file systems, or organizational charts.
- **Identification :** If you have an object tree, and each object of a tree is a part of the same class hierarchy, this is most likely a composite. If methods of these classes delegate the work to child objects of the tree and do it via the base class/interface of the hierarchy, this is definitely a composite.



![structure-en-2x-composite.png](../../../../../diagrams/structure-en-2x-composite.png)


- The Component interface describes operations that are common to both simple and complex elements of the tree.
- The Leaf is a basic element of a tree that doesn’t have sub-elements. Usually, leaf components end up doing most of the real work, since they don’t have anyone to delegate the work to.
- The Container (aka composite) is an element that has sub-elements: leaves or other containers. A container doesn’t know the concrete classes of its children. It works with all sub-elements only via the component interface. Upon receiving a request, a container delegates the work to its sub-elements, processes intermediate results and then returns the final result to the client.
- The Client works with all elements through the component interface. As a result, the client can work in the same way with both simple or complex elements of the tree.

