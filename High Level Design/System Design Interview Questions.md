

## How to answer a System Design Interview problem ?

System design is a very extensive topic and system design interviews are designed to evaluate your capability to produce technical solutions to abstract problems, as such, they're not designed for a specific answer. The unique aspect of system design interviews is the two-way nature between the candidate and the interviewer.

Expectations are quite different at different engineering levels as well. This is because someone with a lot of practical experience will approach it quite differently from someone who's new in the industry. As a result, it's hard to come up with a single strategy that will help us stay organized during the interview.

Let's look at some common strategies for system design interviews:

### Requirements clarifications

System design interview questions, by nature, are vague or abstract. Asking questions about the exact scope of the problem, and clarifying functional requirements early in the interview is essential. Usually, requirements are divided into three parts:

#### Functional requirements

These are the requirements that the end user specifically demands as basic functionalities that the system should offer. All these functionalities need to be necessarily incorporated into the system as part of the contract.

For example:

- "What are the features that we need to design for this system?"
- "What are the edge cases we need to consider, if any, in our design?"

#### Non-functional requirements

These are the quality constraints that the system must satisfy according to the project contract. The priority or extent to which these factors are implemented varies from one project to another. They are also called non-behavioral requirements. For example, portability, maintainability, reliability, scalability, security, etc.

For example:

- "Each request should be processed with the minimum latency"
- "System should be highly available"

#### Extended requirements

These are basically "nice to have" requirements that might be out of the scope of the system.

For example:

- "Our system should record metrics and analytics"
- "Service health and performance monitoring?"

### Estimation and Constraints

Estimate the scale of the system we're going to design. It is important to ask questions such as:

- "What is the desired scale that this system will need to handle?"
- "What is the read/write ratio of our system?"
- "How many requests per second?"
- "How much storage will be needed?"

These questions will help us scale our design later.

### Data model design

Once we have the estimations, we can start with defining the database schema. Doing so in the early stages of the interview would help us to understand the data flow which is the core of every system. In this step, we basically define all the entities and relationships between them.

- "What are the different entities in the system?"
- "What are the relationships between these entities?"
- "How many tables do we need?"
- "Is NoSQL a better choice here?"

### API design

Next, we can start designing APIs for the system. These APIs will help us define the expectations from the system explicitly. We don't have to write any code, just a simple interface defining the API requirements such as parameters, functions, classes, types, entities, etc.

For example:

```tsx
createUser(name: string, email: string): User
```

It is advised to keep the interface as simple as possible and come back to it later when covering extended requirements.

### High-level component design

Now we have established our data model and API design, it's time to identify system components (such as Load Balancers, API Gateway, etc.) that are needed to solve our problem and draft the first design of our system.

- "Is it best to design a monolithic or a microservices architecture?"
- "What type of database should we use?"

Once we have a basic diagram, we can start discussing with the interviewer how the system will work from the client's perspective.

### Detailed design

Now it's time to go into detail about the major components of the system we designed. As always discuss with the interviewer which component may need further improvements.

Here is a good opportunity to demonstrate your experience in the areas of your expertise. Present different approaches, advantages, and disadvantages. Explain your design decisions, and back them up with examples. This is also a good time to discuss any additional features the system might be able to support, though this is optional.

- "How should we partition our data?"
- "What about load distribution?"
- "Should we use cache?"
- "How will we handle a sudden spike in traffic?"

Also, try not to be too opinionated about certain technologies, statements like "I believe that NoSQL databases are just better, SQL databases are not scalable" reflect poorly. As someone who has interviewed a lot of people over the years, my two cents here would be to be humble about what you know and what you do not. Use your existing knowledge with examples to navigate this part of the interview.

### Identify and resolve bottlenecks

Finally, it's time to discuss bottlenecks and approaches to mitigate them. Here are some important questions to ask:

- "Do we have enough database replicas?"
- "Is there any single point of failure?"
- "Is database sharding required?"
- "How can we make our system more robust?"
- "How to improve the availability of our cache?"

Make sure to read the engineering blog of the company you're interviewing with. This will help you get a sense of what technology stack they're using and which problems are important to them.

**Note** : Additional resource - https://newsletter.ashishps.com/p/how-to-answer-a-system-design-interview-problem

## System Design Interview Problems

### Easy
- [Design URL Shortener like TinyURL](https://www.youtube.com/watch?v=fMZMm_0ZhK4)
- [Design Text Storage Service like Pastebin](https://www.youtube.com/watch?v=josjRSBqEBI)
- [Design Leaderboard](https://systemdesign.one/leaderboard-system-design/)
- [Design Content Delivery Network (CDN)](https://www.youtube.com/watch?v=8zX0rue2Hic)
- [Design Parking Garage](https://www.youtube.com/watch?v=NtMvNh0WFVM)
- [Design Vending Machine](https://www.youtube.com/watch?v=D0kDMUgo27c)
- [Design Distributed Key-Value Store](https://www.youtube.com/watch?v=rnZmdmlR-2M)
- [Design Distributed Cache](https://www.youtube.com/watch?v=iuqZvajTOyA)
- [Design Distributed Job Scheduler](https://towardsdatascience.com/ace-the-system-design-interview-job-scheduling-system-b25693817950)
- [Design Authentication System](https://www.youtube.com/watch?v=uj_4vxm9u90)
- [Design Unified Payments Interface (UPI)](https://www.youtube.com/watch?v=QpLy0_c_RXk)
### Medium
- [Design Instagram](https://www.youtube.com/watch?v=VJpfO6KdyWE)
- [Design Tinder](https://www.youtube.com/watch?v=tndzLznxq40)
- [Design WhatsApp](https://www.youtube.com/watch?v=vvhC64hQZMk)
- [Design Facebook](https://www.youtube.com/watch?v=9-hjBGxuiEs)
- [Design Twitter](https://www.youtube.com/watch?v=wYk0xPP_P_8)
- [Design Reddit](https://www.youtube.com/watch?v=KYExYE_9nIY)
- [Design Netflix](https://www.youtube.com/watch?v=psQzyFfsUGU)
- [Design Youtube](https://www.youtube.com/watch?v=jPKTo1iGQiE)
- [Design Google Search](https://www.youtube.com/watch?v=CeGtqouT8eA)
- [Design E-commerce Store like Amazon](https://www.youtube.com/watch?v=EpASu_1dUdE)
- [Design Spotify](https://www.youtube.com/watch?v=_K-eupuDVEc)
- [Design TikTok](https://www.youtube.com/watch?v=Z-0g_aJL5Fw)
- [Design Shopify](https://www.youtube.com/watch?v=lEL4F_0J3l8)
- [Design Airbnb](https://www.youtube.com/watch?v=YyOXt2MEkv4)
- [Design Autocomplete for Search Engines](https://www.youtube.com/watch?v=us0qySiUsGU)
- [Design Rate Limiter](https://www.youtube.com/watch?v=mhUQe4BKZXs)
- [Design Distributed Message Queue like Kafka](https://www.youtube.com/watch?v=iJLL-KPqBpM)
- [Design Flight Booking System](https://www.youtube.com/watch?v=qsGcfVGvFSs)
- [Design Online Code Editor](https://www.youtube.com/watch?v=07jkn4jUtso)
- [Design Stock Exchange System](https://www.youtube.com/watch?v=dUMWMZmMsVE)
- [Design an Analytics Platform (Metrics & Logging)](https://www.youtube.com/watch?v=kIcq1_pBQSY)
- [Design Notification Service](https://www.youtube.com/watch?v=CUwt9_l0DOg)
- [Design Payment System](https://www.youtube.com/watch?v=olfaBgJrUBI)
- [Design a Digital Wallet](https://www.youtube.com/watch?v=MCKdixWBnco)
### Hard
- [Design Location Based Service like Yelp](https://www.youtube.com/watch?v=M4lR_Va97cQ)
- [Design Uber](https://www.youtube.com/watch?v=umWABit-wbk)
- [Design Food Delivery App like Doordash](https://www.youtube.com/watch?v=iRhSAR3ldTw)
- [Design Google Docs](https://www.youtube.com/watch?v=2auwirNBvGg)
- [Design Google Maps](https://www.youtube.com/watch?v=jk3yvVfNvds)
- [Design Zoom](https://www.youtube.com/watch?v=G32ThJakeHk)
- [Design Distributed Counter](https://systemdesign.one/distributed-counter-system-design/)
- [Design File Sharing System like Dropbox](https://www.youtube.com/watch?v=U0xTu6E2CT8)
- [Design Ticket Booking System like BookMyShow](https://www.youtube.com/watch?v=lBAwJgoO3Ek)
- [Design Distributed Web Crawler](https://www.youtube.com/watch?v=BKZxZwUgL3Y)
- [Design Code Deployment System](https://www.youtube.com/watch?v=q0KGYwNbf-0)
- [Design Distributed Cloud Storage like S3](https://www.youtube.com/watch?v=UmWtcgC96X8)
- [Design Distributed Locking Service](https://www.youtube.com/watch?v=v7x75aN9liM)
- [Design Slack](https://systemdesign.one/slack-architecture/)
- [Design Live Comments](https://systemdesign.one/live-comment-system-design/)

## Must-Read Engineering Articles
- [How Discord stores trillions of messages](https://discord.com/blog/how-discord-stores-trillions-of-messages)
- [Building In-Video Search at Netflix](https://netflixtechblog.com/building-in-video-search-936766f0017c)
- [How Canva scaled Media uploads from Zero to 50 Million per Day](https://www.canva.dev/blog/engineering/from-zero-to-50-million-uploads-per-day-scaling-media-at-canva/)
- [How Airbnb avoids double payments in a Distributed Payments System](https://medium.com/airbnb-engineering/avoiding-double-payments-in-a-distributed-payments-system-2981f6b070bb)
- [Stripe’s payments APIs - The first 10 years](https://stripe.com/blog/payment-api-design)
- [Real time messaging at Slack](https://slack.engineering/real-time-messaging/)

##  Must-Read Distributed Systems Papers
- [Paxos: The Part-Time Parliament](https://lamport.azurewebsites.net/pubs/lamport-paxos.pdf)
- [MapReduce: Simplified Data Processing on Large Clusters](https://research.google.com/archive/mapreduce-osdi04.pdf)
- [The Google File System](https://static.googleusercontent.com/media/research.google.com/en//archive/gfs-sosp2003.pdf)
- [Dynamo: Amazon’s Highly Available Key-value Store](https://www.allthingsdistributed.com/files/amazon-dynamo-sosp2007.pdf)
- [Kafka: a Distributed Messaging System for Log Processing](https://notes.stephenholiday.com/Kafka.pdf)
- [Spanner: Google’s Globally-Distributed Database](https://static.googleusercontent.com/media/research.google.com/en//archive/spanner-osdi2012.pdf)
- [Bigtable: A Distributed Storage System for Structured Data](https://static.googleusercontent.com/media/research.google.com/en//archive/bigtable-osdi06.pdf)
- [ZooKeeper: Wait-free coordination for Internet-scale systems](https://www.usenix.org/legacy/event/usenix10/tech/full_papers/Hunt.pdf)
- [The Log-Structured Merge-Tree (LSM-Tree)](https://www.cs.umb.edu/~poneil/lsmtree.pdf)
- [The Chubby lock service for loosely-coupled distributed systems](https://static.googleusercontent.com/media/research.google.com/en//archive/chubby-osdi06.pdf)

## Books
- [Designing Data-Intensive Applications](https://www.amazon.com/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/B08VL1BLHB/)
- [System Design Interview – An insider's guide](https://www.amazon.com/System-Design-Interview-insiders-Second/dp/B08CMF2CQF/)

## YouTube Channels
- [Arpit Bhayani System Design](https://www.youtube.com/watch?v=g_gKI2HCElk&list=PLsdq-3Z1EPT27BuTnJ_trF7BsaTpYLqst&pp=iAQB)
- [Gaurav Sen](https://www.youtube.com/@gkcs)
- [ByteByteGo](https://www.youtube.com/@ByteByteGo)
- [Concept and Coding](https://www.youtube.com/watch?v=rliSgjoOFTs&list=PL6W8uoQQ2c63W58rpNFDwdrBnq5G3EfT7&pp=iAQB)
- [codeKarle](https://www.youtube.com/@codeKarle)
