#### Adapter

* Allows objects with incompatible interfaces to collaborate.
* It allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code.
* Lets you wrap an otherwise incompatible object in an adapter to make it compatible with another class.


* **Classic Example -** The power plug and sockets standards are different in different countries. That’s why the US plug won’t fit a German socket. The problem can be solved by using a power plug adapter that has the American-style socket and the European-style plug.
* **Usage examples :**

      java.util.Arrays#asList()
      java.util.Collections#list()
      java.util.Collections#enumeration()
      java.io.InputStreamReader(InputStream) (returns a Reader object)
      java.io.OutputStreamWriter(OutputStream) (returns a Writer object)

* **Identification:** Adapter is recognizable by a constructor which takes an instance of a different abstract/interface type. When the adapter receives a call to any of its methods, it translates parameters to the appropriate format and then directs the call to one or several methods of the wrapped object.


![structure-object-adapter-2x.png](../../../../../diagrams/structure-object-adapter-2x.png)


- The Client is a class that contains the existing business logic of the program
- The Client Interface describes a protocol that other classes must follow to be able to collaborate with the client code.
- The Service is some useful class (usually 3rd-party or legacy). The client can’t use this class directly because it has an incompatible interface.
- The Adapter is a class that’s able to work with both the client and the service: it implements the client interface, while wrapping the service object. The adapter receives calls from the client via the client interface and translates them into calls to the wrapped service object in a format it can understand.
- The client code doesn’t get coupled to the concrete adapter class as long as it works with the adapter via the client interface. Thanks to this, you can introduce new types of adapters into the program without breaking the existing client code. This can be useful when the interface of the service class gets changed or replaced: you can just create a new adapter class without changing the client code.