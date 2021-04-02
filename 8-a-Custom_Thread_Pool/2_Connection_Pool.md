

# Need

    - Constantly opening and closing connections can be expensive.
      Let's assume it takes 5ms to establish a connection and 5ms to execute your query.
      50% of the time is establishing the connection. 
      Extend this to thousands or tens of thousands of requests and there is a lot of wasted network time. 
      Connection pools are essentially a cache of open database connections. 
      Once you open and use a database connection instead of closing it you add it back to the pool. 
      When you go to fetch a new connection if there is one available in the pool it will use that connection instead of establishing another.
 
    - Traffic Spikes : 
      When traffic spikes you can limit the number of connections to the database. 
      This will force code to block until a connection is available. This is especially helpful in distributed environments.
      
    - Split out common operations into multiple pools. 
      For instance you can have 
      A pool designated for OLAP connections (processing queries and 
      A pool for OLTP connections (named transactional queries)  each with different configurations
  
  
  # How 
    
    Hikari
    HikariCP is solid high-performance JDBC connection pool. 
    A connection pool is a cache of database connections maintained so that the connections can be reused when future requests to the database are required. 
    Connection pools may significantly reduce the overall resource usage.
    
    Default : maximumPoolSize = 10
    
    Source : https://github.com/brettwooldridge/HikariCP
    
    
 # Connection-Pool-Size and Thread-Pool-Size 
 
    Max size of web container thread pool: 50
    Max size of connection pool size: 65

    Now 
    If there are 50 concurrent requests coming to our application server, only 50 connections will be consumed by those 50 requests. 
    But we are still left with 15 more connections — a sheer waste of resource. So, 
    
    keeping performance statistics in mind; the connection pool size should be lower than the maximum thread pool size.
