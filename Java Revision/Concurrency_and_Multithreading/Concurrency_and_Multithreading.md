https://www.youtube.com/watch?v=TpYIcJN9EV8&t=29s
https://jenkov.com/tutorials/java-concurrency/index.html
https://github.com/bharadwaj221/edu.io/tree/master/Java%20Multithreading%20for%20Senior%20Engineering%20Interviews%20-%20Learn%20Interactively
https://www.youtube.com/watch?v=WldMTtUWqTg&t=5563s


# Introduction to Concurrency

## Program vs Process vs Thread

- A program is a set of instructions and associated data that resides on the disk and is loaded by the operating system to perform some task. An executable file or a python script file are examples of programs. In order to run a program, the operating system's kernel is first asked to create a new process, which is an environment in which a program executes.
- A process is a program in execution. A process is an execution environment that consists of instructions, user-data, and system-data segments, as well as lots of other resources such as CPU, memory, addressspace, disk and network I/O acquired at runtime. A program can have several copies of it running at the same time but a process necessarily belongs to only one program.
- Thread is the smallest unit of execution in a process. A thread simply executes instructions serially. A process can have multiple threads running as part of it. Usually, there would be some state associated with the process that is shared among all the threads and in turn each thread would have some state private to itself. The globally shared state among the threads of a process is visible and accessible to all the threads, and special attention needs to be paid when any thread tries to read or write to this global shared state.

## Concurrency vs Parallelism

- **Serial Execution:** When programs are serially executed, they are scheduled one at a time on the CPU. Once a task gets completed, the next one gets a chance to run. Each task is run from the beginning to the end without interruption.
- **Concurrency:** 
  - A concurrent program is one that can be decomposed into constituent parts and each part can be executed out of order or in partial order without affecting the final outcome.
  - A system capable of running several distinct programs or more than one independent unit of the same program in overlapping time intervals is called a concurrent system. The execution of two programs or units of the same program may not happen simultaneously.
  - A concurrent system can have two programs in progress at the same time where progress doesn't imply execution. One program can be suspended while the other executes. Both programs are able to make progress as their execution is interleaved.
  - Concurrency is achieved through the interleaving operation of processes on the central processing unit(CPU) or in other words by the context switching.
  - In concurrent systems, the goal is to maximize throughput and minimize latency. While the current thread or process is waiting for input-output operations, database transactions, or launching an external program, another process or thread receives the CPU allocation. On the kernel side, the OS sends an interrupt to the active task to stop it:


  ![concurrency_-1024x593-1.png](../../diagrams/concurrency_-1024x593-1.png)

  - Concurrent systems achieve lower latency and higher throughput when programs running on the system require frequent network or disk I/O.
  - The classic example of a concurrent system is that of an operating system running on a single core machine. Such an operating system is concurrent but not parallel.
  - It can only process one task at any given point in time but all the tasks being managed by the operating system appear to make progress because the operating system is designed for concurrency. Each task gets a slice of the CPU time to execute and move forward.

- **Parallelism:** 
  - A parallel system is one which necessarily has the ability to execute multiple programs at the same time. Usually, this capability is aided by hardware in the form of multicore processors on individual machines or as computing clusters where several machines are hooked up to solve independent pieces of a problem simultaneously.
  - Note, an individual problem has to be concurrent in nature, that is portions of it can be worked on independently without affecting the final outcome before it can be executed in parallel.
  - In parallel systems the emphasis is on increasing throughput and optimizing usage of hardware resources. The goal is to extract out as much computation speedup as possible.


**Concurrency vs Parallelism**

- A concurrent system need not be parallel, whereas a parallel system is indeed concurrent.
- A system can be both concurrent and parallel e.g. a multitasking operating system running on a multicore machine.
- Concurrency is as a property of a program or a system whereas parallelism as a runtime behaviour of executing multiple tasks.
- **Example :**
  - There are two cores and two tasks. In a concurrent approach, each core is executing both tasks by switching among them over time. In contrast, the parallel approach doesn’t switch among tasks, but instead executes them in parallel over time:


![Concurrency-vs-parallelism.webp](../../diagrams/Concurrency-vs-parallelism.webp)

- Issues while designing concurrent systems : deadlocks, race conditions, or starvation.
- Issues while designing parallel systems : memory corruption, leaks, or errors.

## Preemptive multitasking vs Cooperative multitasking

- Computer multitasking means that a computer system enables multiple (and generally different) tasks to execute concurrently over a certain period. Processes and threads are execution instances of these tasks.
- A multitasking operating system can schedule threads of a process (kernel threads) or schedule a process that, in turn, manages the execution of its own threads (user threads). In the latter case, the scheduler is unaware of user threads, and the process must employ a thread library to coordinate their execution.
- A system can achieve concurrency by employing one of the following multitasking models: **1. Preemptive Multitasking** or **2. Cooperative Multitasking**

**Preemptive multitasking**

- In preemptive multitasking, the operating system preempts a program to allow another waiting task to run on the CPU. 
- Programs or threads can't decide how long for or when they can use the CPU. The operating system’s scheduler decides which thread or program gets to use the CPU next and for how much time. 
- Furthermore, scheduling of programs or threads on the CPU isn’t predictable. A thread or program once taken off of the CPU by the scheduler can't determine when it will get on the CPU next. 
- As a consequence, if a malicious program initiates an infinite loop, it only hurts itself without affecting other programs or threads. Lastly, the programmer isn't burdened to decide when to give up control back to the CPU in code.
- Preemptive multitasking has always been a core feature of Unix based systems.

**Cooperative multitasking**

- Cooperative Multitasking involves well-behaved programs to voluntarily give up control back to the scheduler so that another program can run. 
- A program or thread may give up control after a period of time has expired or if it becomes idle or logically blocked. 
- The operating system’s scheduler has no say in how long a program or thread runs for.
- A malicious program can bring the entire system to a halt by busy waiting or running an infinite loop and not giving up control. 
- The process scheduler for an operating system implementing cooperative multitasking is called a cooperative scheduler. As the name implies, the participating programs or threads are required to cooperate to make the scheduling scheme work.


## Synchronous vs Asynchronous execution

**Synchronous Execution**

- Synchronous execution refers to line-by-line execution of code. If a function is invoked, the program execution waits until the function call is completed. 
- Synchronous execution blocks at each method call before proceeding to the next line of code. 
- A program executes in the same sequence as the code in the source code file. 
- Synchronous execution is synonymous to serial execution.

**Asynchronous Execution**

- Asynchronous programming is a means of parallel programming in which a unit of work runs separately from the main application thread and notifies the calling thread of its completion, failure or progress. 
- An asynchronous program doesn’t wait for a task to complete and can move on to the next task.
- In contrast to synchronous execution, asynchronous execution doesn't necessarily execute code line by line, that is instructions may not run in the sequence they appear in the code. 
- Async execution can invoke a method and move onto the next line of code without waiting for the invoked function to complete or receive its result. 
- Usually, such methods return an entity sometimes called a future or promise that is a representation of an in-progress computation. The program can query for the status of the computation via the returned future or promise and retrieve the result once completed.
- Another pattern is to pass a callback function to the asynchronous function call which is invoked with the results when the asynchronous function is done processing. Asynchronous programming is an excellent choice for applications that do extensive network or disk I/O and spend most of their time waiting.
- In non-threaded environments, asynchronous programming provides an alternative to threads in order to achieve concurrency and fall under the cooperative multitasking model.

## CPU Bound vs I/O Bound Programs

- Programs utilize various resources of the computer systems on which they run. For instance a program running on your machine will broadly require:
  - CPU Time
  - Memory
  - Networking Resources, Disk Storage
- Depending on what a program does, it can require heavier use of one or more resources. 
- For instance, a program that loads gigabytes of data from storage into main memory would hog the main memory of the machine it runs on. 
- Another can be writing several gigabytes to permanent storage, requiring abnormally high disk i/o.


**CPU Bound**

- Programs which are compute-intensive i.e. program execution requires very high utilization of the CPU (close to 100%) are called CPU bound programs. Such programs primarily depend on improving CPU speed to decrease program completion time. 
- This could include programs such as data crunching, image processing, matrix multiplication etc.
- If a CPU bound program is provided a more powerful CPU it can potentially complete faster. Eventually, there is a limit on how powerful a single CPU can be. 
- At this point, the recourse is to harness the computing power of multiple CPUs and structure your program code in a way that can take advantage of the multiple CPU units available.
- Example : Sum of natural numbers from 1 to 1000000.
- A single-threaded program would sum in a single loop from 1 to 1000000. To cut down on execution time, we can create two threads and divide the range into two halves. The first thread sums the numbers from 1 to 500000 and the second sums the numbers from 500001 to 1000000.
- If there are two processors available on the machine, then each thread can independently run on a single CPU in parallel. In the end, we sum the results from the two threads to get the final result. 
- Theoretically, the multithreaded program should finish in half the time that it takes for the single-threaded program. However, there will be a slight overhead of creating the two threads and merging the results from the two threads.


**I/O Bound**

- I/O bound programs are the opposite of CPU bound programs. Such programs spend most of their time waiting for input or output operations to complete while the CPU sits idle. 
- I/O operations can consist of operations that write or read from main memory or network interfaces. Because the CPU and main memory are physically separate a data bus exists between the two to transfer bits to and fro. Similarly, data needs to be moved between network interfaces and CPU/memory. 
- Even though the physical distances are tiny, the time taken to move the data across is big enough for several thousand CPU cycles to go waste. This is why I/O bound programs would show relatively lower CPU utilization than CPU bound programs.

**Some key points**

- Both types of programs can benefit from concurrent architectures. 
- If a program is CPU bound we can increase the number of processors and structure our program to spawn multiple threads that individually run on a dedicated or shared CPU. 
- For I/O bound programs, it makes sense to have a thread give up CPU control if it is waiting for an I/O operation to complete so that another thread can get scheduled on the CPU and utilize CPU cycles. 
- Different programming languages come with varying support for multithreading. For instance, Javascript is single-threaded, Java provides full-blown multithreading and Python is sort of multithreaded as it can only have a single thread in running state because of its global interpreter lock (GIL) limitation. 
- However, all three languages support asynchronous programming models which is another way for programs to be concurrent (but not parallel). 
- There are also memory-bound programs that depend on the amount of memory available to speed up execution.


## Throughput and Latency

- Throughput is defined as the rate of doing work or how much work gets done per unit of time.
- Latency is defined as the time required to complete a task or produce a result. Latency is also referred to as response time.
- In the context of concurrency, throughput can be thought of as time taken to execute a program or computation. 
- For example, imagine a program that is given hundreds of files containing integers and asked to sum up all the numbers. Since addition is commutative each file can be worked on in parallel. 
- In a single-threaded environment, each file will be sequentially processed but in a concurrent system, several threads can work in parallel on distinct files. Of course, there will be some overhead to manage the state including already processed files. However, such a program will complete the task much faster than a single thread. 
- The performance difference will become more and more apparent as the number of input files increases. 
- The throughput in this example can be defined as the number of files processed by the program in a minute.
- And latency can be defined as the total time taken to completely process all the files. 
- As one can observe in a multithreaded implementation throughput will go up and latency will go down. More work gets done in less amount of time. In general, the two have an inverse relationship.


## Context Switching

- Context switch is a system event in which the operating system or the OS removes the executing job (thread) from the CPU and allocates it to another task. It involves saving the context (local data, program pointers, etc. of the thread) of the switched-out process (or thread) and loading the context of the one taking over. 
- The OS ensures a switch is seamless, fast, and free from conflicts or dependency. Thus, context switching is vital for multitasking and user responsiveness.
- Context switching is always an overhead, and it is not cheap. It is a resource and CPU intensive process, as the OS has to allocate memory for the thread stack and CPU time for context switches.


## Multithreading : Definition, Benefits and Cost

- Multithreading is a CPU (central processing unit) feature that allows two or more instruction threads to execute independently while sharing the same process resources. A thread is a self-contained sequence of instructions that can execute in parallel with other threads that are part of the same root process.
- Multithreading can improve the performance and efficiency of a program by utilizing the available CPU resources more effectively. Executing multiple threads concurrently, it can take advantage of parallelism and reduce overall execution time.
- Multithreading can enhance responsiveness in applications that involve user interaction. By separating time-consuming tasks from the main thread, the user interface can remain responsive and not freeze or become unresponsive.
- Multithreading can facilitate better code organization and modularity by dividing complex tasks into smaller, manageable units of execution. Each thread can handle a specific part of the task, making the code easier to understand and maintain.
- Some costs/drawbacks of multithreading:
  - **Debugging:** Multithreaded code can be complex and difficult to debug and maintain, especially with more threads.
  - **Context Switching overhead:** Context switching can become a memory/resource intensive operation for OS if more than necessary threads are spawned from the main thread.
  - **Resource Contention:** If many threads try to access the same data, then there is a chance that the situation of thread starvation may arise.
  - **System Load:** Creating threads can put a load on the system in terms of memory and CPU resources.
  - **Concurrency Issues:** Multithreading can lead to concurrency issues like deadlocks, race conditions, and thread interference if threads aren't properly synchronized. These issues can cause system failure.


## Concurrency Models

- A concurrency model specifies how threads in the system collaborate to complete the tasks they are given along with proper synchronization to prevent partial reading or writing of the final value in the program which is running in the system. Different concurrency models split the tasks in different ways, and the threads may communicate and collaborate in different ways.
- Shared-state model means that the different threads in the system will share some state among them. By state is meant some data, typically one or more objects or even primitives. In a shared state model, some issues that may arise are race conditions and dead locks due to synchronization. As more threads increase in the system, it becomes more complex to manage the state/object access control, debugging, etc.
- Independent-state model means that the different threads in the system do not share any state among them. This is a preferred approach, as threads work on independent copies of data. In case the different threads need to communicate, they do so either by exchanging immutable objects among them, or by sending copies of objects (or data) among them. Thus, no two threads write to the same object (data / state).

- Broadly they are categorised into :
  - **Parallel workers model** (also called shared memory model, as concurrent modules interact by reading and writing shared objects in memory.)
  - **Assembly Line model** (also called message passing model, or reactive model or event driven model, as concurrent modules interact by sending messages to each other through a communication channel. Modules send off messages, and incoming messages to each module are queued up for handling. No shared states in this type of model)
- In the parallel workers concurrency model a delegator distributes the incoming jobs to different workers. Each worker completes the full job. The workers work in parallel, running in different threads, and possibly on different CPUs. The parallel workers concurrency model can be designed to use both shared state or separate state, meaning the workers either has access to some shared state (shared objects or data), or they have no shared state.
- Advantages Of Parallel Workers Model: 
  - It is easy to implement and easy to understand.
  - If the amount of work is high or more then to decrease the time complexity or to decrease the execution time more workers can be added to increase the work parallelly.
- Disadvantages Of Parallel Workers Model:
  - Shared State Can Get Complex - part of the parallelization is lost when threads are waiting for each other when accessing the shared data structures.
  - Stateless Workers - Workers need to re-read the shared state data to make sure they are working on the latest copy. Re-reading data every time can get slow, especially if the state is stored in an external database.
  - Another disadvantage of the parallel worker model is that the job execution order is nondeterministic. There is no way to guarantee which jobs are executed first or last. Job A may be given to a worker before job B, yet job B may be executed before job A. The nondeterministic nature of the parallel worker model makes it hard to reason about the state of the system at any given point in time.
- In assembly line concurrency model, the workers are organized like workers at an assembly line in a factory. Each worker only performs a part of the full job. When that part is finished the worker forwards the job to the next worker.
- Systems using the assembly line concurrency model are usually designed to use non-blocking IO. Non-blocking IO means that when a worker starts an IO operation (e.g. reading a file or data from a network connection) the worker does not wait for the IO call to finish. A worker does as much as it can until it has to start an IO operation. Then it gives up control over the job. When the IO operation finishes the result of the IO operation ( e.g. data read or status of data written) is passed on to the next worker in the assembly line who continues working on the job, until that too has to start an IO operation etc.
- In reality hybrid of above models are followed.
- Reactive , Event driven systems use assembly line model. Actors vs channels are another sub-types in it.


## Same-Threading, Single-Threaded Concurrency

- Single-threaded systems do not share any state (objects / data) with other threads. This enables the single thread to use non-concurrent data structures, and utilize the CPU and CPU caches better. Unfortunately, single-threaded systems do not fully utilize modern CPUs (all the cores).
- Same-threading is Single-threading Scaled Out. In order to utilize all the cores in the CPU, a single-threaded system can be scaled out to utilize the whole computer. Same-threaded systems usually has 1 thread running per CPU in the computer.
- The difference between a same-threaded and a traditional multi-threaded system is that the threads in a same-threaded system do not share state. Same-threaded basically means that data processing stays within the same thread, and that no threads in a same-threaded system share data concurrently.
- A same-threaded system needs to share the work load between the single-threaded instances running on each CPU of the system.
- If the threads in a same-threaded system need to communicate, they do so by message passing via queues, pipes, unix sockets, TCP sockets etc. If Thread A wants to send a message to Thread B, Thread A can do so by generating a message (a byte sequence). Thread B can then copy that message (byte sequence) and read it.

More about Single thread concurrency design - https://jenkov.com/tutorials/java-concurrency/single-threaded-concurrency.html

## Mutex vs Semaphore vs Monitor

**Mutex**

- Mutex as the name hints implies mutual exclusion. A mutex is used to guard shared data such as a linked-list, an array or any primitive type. A mutex allows only a single thread to access a resource or critical section.
- Once a thread acquires a mutex, all other threads attempting to acquire the same mutex are blocked until the first thread releases the mutex. Once released, most implementations arbitrarily chose one of the waiting threads to acquire the mutex and make progress.
- A mutex is owned by the thread acquiring it till the point the owning-thread releases it

![Mutex.png](../../diagrams/Mutex.png)


**Semaphore**

- Semaphore is used for limiting access to a collection of resources. Think of semaphore as having a limited number of permits to give out. If a semaphore has given out all the permits it has, then any new thread that comes along requesting for a permit will be blocked, till an earlier thread with a permit returns it to the semaphore. A typical example would be a pool of database connections that can be handed out to requesting threads.
- Semaphores can also be used for signaling among threads, allowing threads to cooperatively work towards completing the task.
- Semaphore has no concept of ownership.

![Semaphore.png](../../diagrams/Semaphore.png)

**Monitor**

- Monitors are generally language level constructs whereas mutex and semaphore are lower-level or OS provided constructs.
- A monitor is made up of a mutex and one or more condition variables. 
- A single monitor can have multiple condition variables but not vice versa. 
- Theoretically, another way to think about a monitor is to consider it as an entity having two queues or sets where threads can be placed. One is the entry set and the other is the wait set.
- When a thread A enters a monitor it is placed into the entry set. If no other thread owns the monitor, which is equivalent of saying no thread is actively executing within the monitor section, then thread A will acquire the monitor and is said to own it too. Thread A will continue to execute within the monitor section till it exits the monitor or calls wait() on an associated condition variable and be placed into the wait set.
- Another thread B comes along and gets placed in the entry set, while thread A sits in the wait set. Since no other thread owns the monitor, thread B successfully acquires the monitor and continues execution. If thread B exits the monitor section without calling notify() on the condition variable, then thread A will remain waiting in the wait set. Thread B can also invoke wait() and be placed in the wait set along with thread A. This then would require a third thread to come along and call notify() on the condition variable on which both threads A and B are waiting.
- In Java each object is a monitor and implicitly has a lock and is a condition variable too. You can think of a monitor as a mutex with a wait set. Monitors allow threads to exercise mutual exclusion as well as cooperation by allowing them to wait and signal on conditions.

![Monitor-1.png](../../diagrams/Monitor-1.png)
![Monitor-2.png](../../diagrams/Monitor-2.png)

- In Java every object is a condition variable and has an associated lock that is hidden from the developer. Each java object exposes wait() and notify() methods.
- wait() and notify() can only be called on an object once the calling thread becomes the owner of the monitor, which is done implicitly through the `synchronized` keyword.
- Any attempt to call wait() or notify() outside of a synchronized block, an `IllegalMonitorStateException` would occur.
- The ownership of the monitor can be achieved in the following ways:
  - the method the thread is executing has synchronized in its signature
  - the thread is executing a block that is synchronized on the object on which wait or notify will be called
  - in case of a class, the thread is executing a static method which is synchronized.
- 

## Amdahls law and Moores Law

**Amdahl's Law**

- Blindly adding threads to speed up program execution may not always be a good idea. The law specifies the cap on the maximum speedup that can be achieved when parallelizing the execution of a program.
- Amdahl's law describes the theoretical speedup a program can achieve at best by using additional computing resources.

      S(n) = 1 / ((1-P) + P/n)

where 
- S(n) is the speed-up achieved by using n cores or threads.
- P is the fraction of the program that is parallelizable
- (1 - P) is the fraction of the program that must be executed serially.

Example - program has a parallelizable portion of P = 90% = 0.9.

- Now for n = 1, S(1) = 1
- for n = 2, S(2) = 1.81
- for n = 10, S(10) = 5.26
- for n = 1000, S(1000) = 9.91
- for n = infinity, S(infinity) = 10

- The speed-up steadily increases with increase in the number of processors or threads. However, the theoretical maximum speed-up for the above program with 10% serial execution will be 10. To achieve greater speed-ups than 10, program must optimize or parallelize the serially executed portion of the code.
- Another import aspect to realize is the utilization which is defined as speedup divided by the number of processors.

**Moore's Law**

- It states that the number of transistors per square inch on a chip will double every two years, and in turn the processing power of computers doubles and the cost halves.
- However, the promise of exponential growth by Moore’s law came to an end more than a decade ago with respect to clock speeds (processors).
- Since processors aren't getting faster as quickly as they use to, to achieve performance gains, usage of multicore processors is increasing.
- To exploit this processing power, programs must be written as multi- threaded applications. A single-threaded application running on an octa- core processor will only use 1/8th of the total throughput of that machine, which is unacceptable in most scenarios.


# Java Memory Model for Threads
- Kernel is central component of an operating system that manages operations of computer and hardware. Kernel loads first into memory when an operating system is loaded and remains into memory until operating system is shut down again. It is responsible for various tasks such as disk management, task management, and memory management. Kernel acts as a bridge between applications and data processing performed at hardware level using inter-process communication and system calls.


![Java-Thread-Process_Memory.png](../../diagrams/Java-Thread-Process_Memory.png)

**Few points to remember about process and thread memory:**

- Each new process instantiates a new JVM instance. The heap memory of the process will vary as per the requirements.
- Objects created at runtime with "new" keyword are allocated in the heap. Each process has its own heap memory and all threads within the same process share the heap data and can read and modify it. Hence, synchronization is required between multiple threads.
- Each process has its code segment and data segment.
- Code segment is the compiled BYTECODE (Machine code) of the program. It is read only and shared between all the threads of the process.
- Data segment contains the global and static variables of the program. It is shared by all the threads of the process and they can read and modify it. Hence synchronization is necessary between the threads.
- Each thread has its own stack to store and manage method calls, local variables.
- Each thread has a register which is a temporary memory location that stores data (includes the address of the next instruction to be executed, the current instruction being decoded) and processing (intermediate) results from the thread. When JIT compiler converts BYTECODE into native machine code, it uses register to optimize the generated machine code (reshuffling of instructions). Thread register play a crucial part in context switching.
- Each thread has a program counter, which is a pointer to the current instruction in code segment which is being executed on the thread. Increments its counter after the instruction is executed successfully.
- All these 3 components are managed by JVM.

**Example to understand complete flow :**

- There is main function, and in it, there are two threads T1 and T2 being spawned in it and doing some task.
- As soon as the code is compiled, process is created and JIT compiler starts interpreting the code. While doing so, it will understand that, 3 threads are required in this process and stored the machine code in code segment. Counters of each thread in process points to the respective start line in code segment.
- OS scheduler schedules the main thread and process starts executing. As it encounters the start of T1 thread, Main thread may get paused or T1 may get scheduled on other CPU core. During scheduling, information on thread register and PC is loaded into CPU core register.
- If CPU core is not available, the intermediate results of the execution of Main thread, along with counter will be shifted from CPU register to thread register, thus saving the state of Main thread, and then T1 may get scheduled on that CPU core.
- Similarly, T2 will also get scheduled. After execution of T1 and T2 , the Main thread will get again rescheduled on CPU core, and start from right it was stopped. The Main thread register will load the saved intermediate results back to CPU register. Thus register help in context switching. 
- Note the order of Main, T1 and T2 execution depends on OS scheduler. It is possible that, if any core is available while T1 is running , Main thread may get scheduled and complete its execution before T2 and even T1. This is parallelism. 
- If there is just one core, then it will be concurrency.


## User Thread vs Kernel Thread

- User-level threads are managed entirely by the application, without any involvement from the operating system kernel and stored in its process's address space. The application manages the creation, scheduling, and synchronization of threads.
- The kernel does not know anything about the user-level threads. It treats them as if they are single-threaded processes.
  - **Benefits:**
    - User-level threads are generally faster to create and switch between than kernel-level threads, as there is no need to switch to kernel mode or perform costly context switches.
    - User-level threads are generic and can run on any Operating System.
    - 
  - **Disadvantages:**
    - OS is unaware of user-level threads, so the scheduler cannot schedule them properly.
    - The entire process will get blocked if one user-level thread performs a blocking operation (eg: I/O operation).
    - Regardless of whether a process contains one thread or multiple threads, it receives a single time slice during the scheduling. Hence, user-level threads cannot take advantage of multiple CPUs or CPU cores, as only one user-level thread can be executing at a time.
    - Non-blocking systems calls are necessary. Otherwise, even if the process still has runnable threads, it will be halted in the kernel.
    - User-level threads are less fault-tolerant than kernel-level threads. If a user-level thread crashes, it can bring down the entire process. Kernel threads can be managed independently.
    - User level threads don’t have direct access to the system-level features like I/O operations

- Kernel-level threads are managed by the operating system kernel. Each thread is a separate entity with its own stack, register set, and execution context. The kernel handles thread scheduling, synchronization, and management, allowing multiple threads to execute simultaneously on different CPUs or cores.
- No runtime system is required in the case of this type of thread. The kernel has a thread table that keeps track of all threads in the system, rather than having a thread table in each process. In addition to that, the kernel keeps track of processes using a traditional process table. The kernel includes system calls for creating and managing threads.
  - **Benefits:**
    - For the same process, the kernel can still schedule another thread for execution if one thread is performing blocking operation (independent System calls for each thread).
    - Scheduling multiple threads that belong to the same process on different processors is possible in kernel-level threads (Multithreading).
    - In kernel-level threads have their own stacks and their own separate address spaces, so they are better isolated from each other. User-level threads have same address space.
    - Kernel threads have direct access to system resources.

  - **Disadvantages:**
    - Transferring control within a process from one thread to another necessitates a mode switch to kernel mode. Hence, Kernel-level level threads take more time to create and manage and are heavy-weight compared to user-level threads.
    - Kernel-level threads are not generic and are specific to the Operating System.

- User threads must be mapped to kernel threads because the kernel plans the thread for execution on the CPU and has to be aware of the thread it’s scheduling.
- All the user threads of a process get executed by the kernel thread assigned to the process. The kernel thread of the chosen process gets scheduled onto the CPU whenever its turn is to run on the processor.
- If any of the other user threads in the process are to be executed, they must all be mapped one by one onto the kernel thread designated to the generating process.
- There are different multithreading models based user to kernel thread mapping:
  - **Many-to-many** multiple user threads corresponds to same or lesser number of kernel level threads. System doesn’t block if a particular thread is blocked.
  - **Many-to-one** multiple user threads mapped to one kernel thread. A blocking system call makes entire process blocked.
  - **One-to-one** creating a user thread requires the corresponding kernel thread. multiple thread can run on multiple processor. if any user thread makes a blocking system call, the other user threads won’t be blocked.


## The "happens before relationship" model

- The (JIT) compiler in the spirit of optimization is free to reorder statements however it must make sure that the outcome of the program is the same as without reordering.
- Some sources of reordering include:
  - If two fields X and Y are being assigned but don't depend on each other, then the compiler is free to reorder them
  - Processors may execute instructions out of order under some circumstances.
  - Data may be juggled around in the registers, processor cache or the main memory in an order not specified by the program e.g. Y can be flushed to main memory before X.
- For single threaded-programs, these re-orderings have no ill-effects as Java Memory Model guarantees that the outcome of the program would be the same as if these reorderings never happened.
- However, when multiple threads are involved, without proper synchronization, these same optimizations can wreak havoc and program output would be unpredictable.
- The JMM defines actions as :
  - read and writes of variables
  - locks and unlocks of monitors
  - starting and joining of threads
- The JMM enforces a happens-before ordering on these actions. When an action A happens-before an action B, it implies that A is guaranteed to be ordered before B and visible to B.

**Example to illustrate happens-before relationship model**

```java
public class ReorderingExample {
    int x = 3;
    int y = 7;
    int a = 4;
    int b = 9;
    Object lock1 = new Object();
    Object lock2 = new Object();
    
    public void writerThread() {
        // BLOCK #1
        // The statements in block#1 and block#2 aren't dependent
        // on eachother and the two blocks can be reordered by the
        // compiler
        x = a;
        
        // BLOCK#2
        // These two writes within block#2 can't be reordered, as
        // they are dependent on eachother. Though this block can
        // be ordered before block#1
        y += y;
        y *= y;
        
        // BLOCK #3
        // Because this block uses x and y, it can't be placed before
        // the assignments to the two variables, i.e. block#1 and block#2

        synchronized (lock1) {
          x *= x;
          y *= y; 
        }

    }

    public void readerThread() {
      a *= 10;
      
      // BLOCK#4
      // Closely check the monitor and then check the flow of variable a
      // and how it will affect the x
      // here happens-before-relationship is violated due to different monitors
      synchronized (lock2) {
        a *= a;
        b *= b; }
    }
}
```

- despite reordering between block 1, block 2 and block 3 , final outcome will remain the same.
- block#1 will appear to happen-before block#2 even if block#2 gets executed before.
- there's no partial ordering between block#1 and block#2 but there's a partial ordering between block#1 and block#3 where block#3 must come after block#1.
- Say if the `readerThread` runs to completion, it is possible for the writerThread to never see the updated value of the variable a as it may never have been flushed out to the main memory, where the `writerThread` would attempt to read from. There's no happens before relationship between the two code snippets executed in two different threads!
- To make sure that the changes done by one thread to shared data are visible immediately to the next thread accessing those same variables, a a happens-before relationship between the execution of the two threads must be established in following ways:
  - Each action in a thread happens-before every action in that thread that comes later in the program's order. However, for a single- threaded program, instructions can be reordered but the semantics of the program order is still preserved.
  - An unlock on a monitor happens-before every subsequent lock on that same monitor. The synchronization block is equivalent of a monitor.
  - A write to a volatile field happens-before every subsequent read of that same volatile.
  - A call to start() on a thread happens-before any actions in the started thread.
  - All actions in a thread happen-before any other thread successfully returns from a join() on that thread.
  - The constructor for an object happens-before the start of the finalizer for that object.
  - A thread interrupting another thread happens-before the interrupted thread detects it has been interrupted.
- This implies that any memory operations on shared objects which were visible to a thread before exiting a synchronized block are visible to any thread after it enters a synchronized block protected by the same monitor, since all the memory operations happen before the release, and the release happens before the acquire.
- Exiting a synchronized block causes the cache to be flushed to the main memory so that the writes made by the exiting thread are visible to other threads. Similarly, entering a synchronized block has the effect of invalidating the local processor cache and reloading of variables from the main memory so that the entering thread is able to see the latest values.
- In `readerThread` if synchronization is on the same lock object as the one in the `writerThread` then happens-before relationship between the two threads could be established.
- It means that when readerThread releases the monitor, up till that point, whatever shared variables it has manipulated will have their latest values visible to the writerThread as soon as it acquires the same monitor. If it acquires a different monitor then there's no happens-before relationship and it may or may not see the latest values for the shared variables



# Basics of Java Multithreading

## Thread Creation

- To execute a thread , start() method of Thread class is called, which in turn invokes run() method in Thread class.
- The run() method will execute as if executed by a different CPU.
- Notice, run() method has a return value of void, so thread doesnt return anything. `Callable` interface is used to get the result of thread execution, which is known as `Future`.
- Threads can be created by using two mechanisms :
  1. Extending the Thread class:
    - The first way to specify what code a thread is to run, is to create a subclass of Thread and override the run() method.
```java
  // Java code for thread creation by extending
  // the Thread class
  class MultithreadingDemo extends Thread {
    public void run()
    {
      try {
      // Displaying the thread that is running
        System.out.println(
        "Thread " + Thread.currentThread().getId()
        + " is running");
        }
      catch (Exception e) {
      // Throwing an exception
        System.out.println("Exception is caught");
      }
    }
  }
  
  // Main Class
  public class Multithread {
    public static void main(String[] args)
    {
      int n = 8; // Number of threads
      for (int i = 0; i < n; i++) {
      MultithreadingDemo object = new MultithreadingDemo();
      object.start();
    }
    }
  }

```

  2. Implementing the Runnable Interface and create a Thread class object:
     - The second way to specify what code a thread should run is by creating a class that implements the java.lang.Runnable interface (a functional interface). A Java object that implements the Runnable interface can be executed by a Java Thread.
  
  ```
public class MyRunnable implements Runnable {

  public void run(){
    System.out.println("MyRunnable running");
  }
}

//using Lambdas

Runnable runnable = () -> { System.out.println("Lambda Runnable running"); };

//pass runnable object to thread object.

Thread thread = new Thread(runnable);
thread.start();

```

**Runnable vs Subclass of Thread**

- Implementing Runnable interface allows class to be extensible as compared to extending Thread class, due to no multiple inheritance allowance in Java.
- Creating an implementation of Runnable and passing it to the Thread class utilizes composition and not inheritance – which is more flexible.
- Runnables can be represented as lambda expressions.
- Basic functionality of a thread can be achieved by extending Thread class because it provides some inbuilt methods like yield(), interrupt() etc. that are not available in Runnable interface.

**Calling run() instead of start()**

```
  Thread newThread = new Thread(MyRunnable());
  newThread.run();  //should be start();
```
- Here run() method is not executed by the newThread.
- Instead, the run() method is executed by the thread that created the thread (in this case main thread). In other words, the thread that executed the above two lines of code.
- To have the run() method of the MyRunnable instance called by the new created thread, newThread, newThread.start() method must be called.


## Thread Lifecycle and States

![thread-states-lifecycle.png](../../diagrams/thread-states-lifecycle.png)

- **New Thread:** 
  - When a new thread is created, it is in the new state. The thread has not yet started to run when the thread is in this state. When a thread lies in the new state, its code is yet to be run and hasn’t started to execute.
- **Runnable State:** 
  - A thread that is ready to run is moved to a runnable state. In this state, a thread might actually be running or it might be ready to run at any instant of time. It is the responsibility of the thread scheduler(part of JVM) to give the thread, time to run. A multi-threaded program allocates a fixed amount of time to each individual thread. Each and every thread runs for a short while and then pauses and relinquishes the CPU to another thread so that other threads can get a chance to run. When this happens, all such threads that are ready to run, waiting for the CPU and the currently running thread lie in a runnable state.
- **Blocked:** 
  - The thread will be in blocked state when it is trying to acquire a monitor lock to enter or re-enter a synchronized block/method but currently the lock is acquired by the other thread. The thread will move from the blocked state to runnable state when it acquires the lock.
- **Waiting state:** 
  - The thread will be in waiting state when it calls wait() method or join() method. It will move to the runnable state when other thread will notify or that thread will be terminated. waiting for some other thread to perform a particular action without any time limit.
  -  According to JavaDocs, any thread can enter this state by calling any one of the following three methods:
      - object.wait()
      - thread.join()
      - LockSupport.park()

```java
  public class WaitingState implements Runnable {
      public static Thread t1;
  
      public static void main(String[] args) {
          t1 = new Thread(new WaitingState());
          t1.start();
      }
  
      public void run() {
          Thread t2 = new Thread(new DemoWaitingStateRunnable());
          t2.start();
  
          try {
              t2.join();
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              e.printStackTrace();
          }
      }
  }
  
  class DemoWaitingStateRunnable implements Runnable {
      public void run() {
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              e.printStackTrace();
          }
          
          System.out.println(WaitingState.t1.getState());
      }
  }
  /*
          We’ve created and started the t1
          t1 creates a t2 and starts it
          While the processing of t2 continues, we call t2.join(), this puts t1 in WAITING state until t2 has finished execution
          Since t1 is waiting for t2 to complete, we’re calling t1.getState() from t2
          
          Output of the program:
          WAITING

   */
```

- **Timed Waiting:** 
  - A thread lies in a timed waiting state when it calls a method with a time-out parameter. A thread lies in this state until the timeout is completed or until a notification is received. For example, when a thread calls sleep or a conditional wait, it is moved to a timed waiting state. waiting for some other thread to perform a specific action for a specified period.
  - According to JavaDocs, there are five ways to put a thread on TIMED_WAITING state:
    - thread.sleep(long millis)
    - wait(int timeout) or wait(int timeout, int nanos)
    - thread.join(long millis)
    - LockSupport.parkNanos
    - LockSupport.parkUntil

```java
  public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {
      DemoTimeWaitingRunnable runnable= new DemoTimeWaitingRunnable();
      Thread t1 = new Thread(runnable);
      t1.start();
  
      // The following sleep will give enough time for ThreadScheduler
      // to start processing of thread t1
      Thread.sleep(1000);
      System.out.println(t1.getState());
    }
  }
  
  class DemoTimeWaitingRunnable implements Runnable {
    @Override
    public void run() {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    }
  }
  
  /*
          we’ve created and started a thread t1 which is entered into the sleep state with a timeout period of 5 seconds; 
          the output will be: TIMED_WAITING
   */
```

- **Terminated State:** A thread terminates because of either of the following reasons:
  - Because it exits normally. This happens when the code of the thread has been entirely executed by the program.
  - Because there occurred some unusual erroneous event, like a segmentation fault or an unhandled exception.


## InterThread Communication

- Inter-Thread Communication (Cooperation) is a mechanism that enables threads of a process to exchange information or coordinate their execution, thus work together to solve a common problem or to share resources.
- Polling is the process of continually testing a condition until it becomes true, usually done with the use of multiple loops which determines whether a condition is true or false. However, because this method uses numerous CPU cycles, it is wasteful, and hence ITC is imp.
- To avoid polling, Java provides three methods. These are the wait(), notify(), and notifyAll methods(). Because these methods are in the object class and are marked as final, they can be used in any class. They can only be utilized inside a synchronized block.

**1. wait()** 

- The `wait()` method causes the current thread to wait indefinitely until another thread either invokes notify() for the same object or notifyAll().
- For this, the current thread must own the object’s monitor. According to Javadocs, this can happen in the following ways:
  - when we’ve executed synchronized instance method for the given object
  - when we’ve executed the body of a synchronized block on the given object
  - by executing synchronized static methods for objects of type Class

- `wait(long timeout)` Using this method, we can specify a timeout after which a thread will be woken up automatically. A thread can be woken up before reaching the timeout using notify() or notifyAll().
- `wait(long timeout, int nanos)` is just a alternate version of previous method to provide higher precision. The total timeout period (in nanoseconds) is calculated as 1_000_000*timeout + nanos.

**2. notify() and notifyAll()**

- For all threads waiting on this object’s monitor (by using any one of the wait() methods), the method `notify()` notifies any one of them to wake up arbitrarily.
- The choice of exactly which thread to wake is nondeterministic and depends upon the implementation.
- Since notify() wakes up a single random thread, we can use it to implement mutually exclusive locking where threads are doing similar tasks. But in most cases, it would be more viable to implement notifyAll().
- `notifyAll()` method simply wakes all threads that are waiting on this object’s monitor. 

**Difference between sleep() and wait()**

**wait() :**

- wait() is an instance method that’s used for thread synchronization.
- It can be called on any object, as it’s defined right on java.lang.Object, but it can only be called from a synchronized block.
- It releases the lock on the object so that another thread can jump in and acquire a lock.
- Thread using wait() method can be woken up by other threads calling notify() or notifyAll() in the same synchronised context.

**sleep() :**

- Thread.sleep() is a static method that can be called from any context.
- Thread.sleep() pauses the current thread and does not release any locks.
- Thread using sleep() method gets woken up after the specified amount of time, unless its interrupted.


**How to kill a thread**

- https://www.baeldung.com/java-thread-stop



Synchronization in Java
Volatile keyword
CPU Cache coherence
Java Virtual Threads
Race Conditions and Critical Sections
Thread Safety and shared resources

# Advanced Multithreading and Java Concurrency Utilities

Thread Pools
Callable and Future Interface
Fork/Join Framework
ThreadLocal
Executors and ExecutorService
CompletableFuture
ScheduledExecutorService
CountDownLatch, CyclicBarrier, Phaser, and Exchanger

# Concurrent Collections

ConcurrentHashMap
* ConcurrentLinkedQueue and ConcurrentLinkedDeque
* CopyOnWriteArrayList
* BlockingQueue Interface
* ArrayBlockingQueue
* LinkedBlockingQueue
* PriorityBlockingQueue
* COncurrent Modification Exception

#  Atomic Variables
 * AtomicInteger, AtomicLong, and AtomicBoolean
 * AtomicReference and AtomicReferenceArray
 * Compare-and-Swap Operations

## Locks and Semaphores

 * ReentrantLock
 * ReadWriteLock
 * StampedLock
 * Semaphores
 * Lock and Condition Interface

## Best Practices and Patterns
* Thread Safety Best Practices
* Immutable Objects
* ThreadLocal Usage
* Double-Checked Locking and its Issues
* Concurrency Design Patterns
* Parallel Streams

## Common Concurrency Issues and Solutions
* Deadlocks
* Starvation
* Livelocks
* Race Conditions
* False Sharing
* Thread Congestion
* Strategies for Avoiding Concurrency Issues

## Java 9+ features

Reactive Programming with Flow API
* CompletableFuture Enhancements
* Process API Updates
* Local-Variable Type Inference (var keyword)
    * Enhancements in Optional class
    * New Methods in the String class relevant to concurrency



