#### Proxy

- Lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.
- **Identification:** Proxies delegate all of the real work to some other object. Each proxy method should, in the end, refer to a service object unless the proxy is a subclass of a service.
- **Usage Examples :** 
  - Lazy initialization (virtual proxy). This is when you have a heavyweight service object that wastes system resources by being always up, even though you only need it from time to time.
  - Access control (protection proxy). This is when you want only specific clients to be able to use the service object; for instance, when your objects are crucial parts of an operating system and clients are various launched applications (including malicious ones).
  - Local execution of a remote service (remote proxy). This is when the service object is located on a remote server and a proxy does all the necessary boilerplate stuff like creating and maintaining the connection, encoding, decoding, etc., while the client accesses it as it was present in their local address space.
  - Logging requests (logging proxy). his is when you want to keep a history of requests to the service object and The proxy can log each request before passing it to the service.
  - Caching request results (caching proxy). This is when you need to cache results of client requests and manage the life cycle of this cache, especially if results are quite large.
  - Smart reference. This is when you need to be able to dismiss a heavyweight object once there are no clients that use it.


![structure-2x-proxy.png](../../../../../diagrams/structure-2x-proxy.png)


- The Service Interface declares the interface of the Service. The proxy must follow this interface to be able to disguise itself as a service object.
- The Service is a class that provides some useful business logic.
- The Proxy class has a reference field that points to a service object. After the proxy finishes its processing (e.g., lazy initialization, logging, access control, caching, etc.), it passes the request to the service object. Usually, proxies manage the full lifecycle of their service objects.
- The Client should work with both services and proxies via the same interface. This way you can pass a proxy into any code that expects a service object.


