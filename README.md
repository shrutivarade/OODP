# OODP
CS680: Object Oriented Design and programming

### Singleton Design Pattern
- **Purpose**: Ensures that a class has only one instance and provides a global point of access to it.
- **Implementation**: A private constructor, a static method to get the instance, and a static field to store the single instance.

### Static Factory Method Pattern
- **Purpose**: Uses a static method to create objects, offering more flexibility compared to constructors.
- **Implementation**: Multiple static methods to return different object types.

### JUnit Testing
- **Purpose**: Focuses on testing object behaviors using JUnit framework.
- **Implementation**: Tests Singleton and Factory methods using JUnit assertions.

### State Design Pattern
- **Purpose**: Implements the State pattern to allow an object to change its behavior when its internal state changes.
- **Implementation**: Encapsulates state-related behaviors into separate classes and dynamically switches between these states at runtime.

### Template Method Pattern
- **Purpose**: Uses the Template Method pattern to define the steps of an algorithm while allowing subclasses to override certain steps.
- **Implementation**: Provides a skeleton of the algorithm in a base class, with abstract methods for customization in subclasses.

### Composite Design Pattern
- **Purpose**: Demonstrates the Composite pattern to handle tree structures where individual objects and compositions are treated uniformly.
- **Implementation**: Provides a uniform interface for both composite and leaf nodes, allowing recursive object structures.

### Proxy Design Pattern
- **Purpose**: Implements the Proxy pattern to control access to an object by providing a surrogate or placeholder.
- **Implementation**: The proxy class controls access to the original object, adding an extra level of abstraction to manage access and enhance security or performance.

### Iterator Design Pattern
- **Purpose**: Demonstrates the Iterator pattern to provide a way to sequentially access elements in a collection without exposing the underlying structure.
- **Implementation**: Uses iterator interfaces to traverse collections like arrays or lists.

### Visitor Design Pattern
- **Purpose**: Implements the Visitor pattern to separate algorithms from the objects on which they operate.
- **Implementation**: The visitor class defines operations that can be performed on elements in a collection, without modifying the elements themselves.

### Strategy Design Pattern
- **Purpose**: Uses the Strategy pattern to define a family of algorithms, encapsulate each one, and make them interchangeable.
- **Implementation**: Allows the algorithm to be selected at runtime, promoting flexibility without altering the client code.

### Comparators in Java API and Pareto Comparison
- **Purpose**: Demonstrates the use of Java’s `Comparator` interface and Pareto comparison for sorting and comparing objects.
- **Implementation**: Uses lambda expressions to streamline comparison logic and achieve more concise code.

### Null Object Design Pattern
- **Purpose**: Implements the Null Object pattern to avoid explicit `null` checks and provide a default behavior.
- **Implementation**: Returns a neutral object that adheres to the expected interface but does nothing, improving code cleanliness and reducing `null`-related errors.

Here’s the final breakdown for the last three homework assignments:

### Functional Programming and Lambda Expressions in Java
- **Purpose**: Demonstrates the use of functional programming techniques and lambda expressions for writing cleaner and more concise code.
- **Implementation**: Replaces anonymous classes with lambda expressions and applies functional interfaces to simplify callback methods and other logic.

### Observer and Multicast Design Patterns
- **Purpose**: Implements the Observer pattern to manage state changes and updates across multiple objects, while multicast allows multiple listeners to receive updates.
- **Implementation**: Efficiently handles event propagation and state synchronization between observers.

### Command Design Pattern
- **Purpose**: Uses the Command pattern to encapsulate actions as objects, allowing for flexible command execution.
- **Implementation**: Supports undo/redo functionality by encapsulating operations and separating command execution from requesters.
Here’s the breakdown for the last two homework assignments:

### Callback Methods and Lambda Expressions
- **Purpose**: Focuses on using callback methods and lambda expressions to simplify asynchronous operations.
- **Implementation**: Implements callbacks using functional interfaces and lambda expressions for cleaner, more efficient asynchronous programming.

### Command Pattern with Multicast
- **Purpose**: Builds on the Command pattern by integrating multicast to handle multiple receivers of commands.
- **Implementation**: Demonstrates the command execution across multiple listeners, enabling flexible and dynamic command handling with multicast.


