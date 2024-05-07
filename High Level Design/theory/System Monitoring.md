<!-- TOC -->
* [Systems Observability](#systems-observability)
  * [Logs](#logs)
  * [Metrics](#metrics)
  * [Traces](#traces)
<!-- TOC -->



# Systems Observability

- Observability is a field of computer science whose primary purpose is to provide better system visibility. 
- In its most complete sense, observability is a system property that indicates how much we can know about its state from its outputs and performance metrics. Thus, observability allows us to test, understand, and debug systems deeply.

Three pillars of observability:

1. **Logs :** Timestamped records of an event or events.
2. **Metrics:** Numeric representation of data measured over a set period.
3. **Traces:** A record of events that occur along the path of a single request.

- In more complex cloud environments, however, observability must encompass more, including metadata, user behavior, topology and network mapping, and access to code-level details.

## Logs

- A log is a time-stamped record of discrete events that have occurred over time in a system. Therefore, a log provides an ordered history of the occurrence of events in a system.
- Event logs generally consist of two parts: a timestamp and a payload. The payload describes the event that occurred. The timestamp is essential for knowing when each event occurred.
- In plain text format, a log record is a message described in free form (easy for humans to understand). In structured logs, each event is usually divided into specific fields and also saved in specific file formats (such as JSON, for instance). Meanwhile, logs in binary format are useful for other systems or tools to consume (MySQL binlogs, systemd journal logs, etc.).

#### **Log levels**

- Logs can easily become massive in complex systems. Therefore, we typically use log levels to filter out relevant information.
- The most common levels are FATAL, ERROR, WARN, DEBUG, INFO, and TRACE. These levels are organized on a scale of criticality. Therefore, events at the FATAL level are the most critical, while events at the TRACE level are merely informative. Note TRACE Log level and tracing are different.

## Metrics

- Observability metrics encompass a range of key performance indicators (KPIs) to get insight into the health and performance of your systems.
- These KPIs:
  - **Quantify performance** - response time of requests, peak load (traffic), requests served, error rates, latency.
  - **Saturation of resources** - CPU capacity, memory usage
  - produce alerts such as when a system is down or load balancers reach capacity
  - monitor events for anomalous activities

## Traces

- Traces are records of a series of causally related distributed events that capture the interaction between the components of a system.
- The structure of a trace is almost the same as that of an event log, in addition to a timestamp and payload, a trace typically contains information about its origin and destination. So, by looking at a trace we can tell which components are communicating and what happened in the interaction.
- Distributed tracing is a method of observing requests as they propagate through distributed cloud environments. It follows an interaction and tags it with a unique identifier. This identifier stays with the transaction as it interacts with microservices, containers, and infrastructure. In turn, this identifier offers real-time visibility into user experience, from the top of the stack to the application layer and the infrastructure beneath.
- **Reduced mean time to detect (MTTD) and mean time to repair (MTTR)** : 
  - Distributed tracing enables teams to get to the bottom of application performance issues faster, often before users notice anything wrong. Upon discovering an issue, they can rapidly identify the root cause and address it.
  - It also provides teams with early warnings when microservices are in poor health and can highlight performance bottlenecks anywhere in the software stack as well as code that should be optimized.





