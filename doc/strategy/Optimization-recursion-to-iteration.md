# Make recursions practical by converting to iterations
*All recursions in computer code can be converted to corresponding iterative form.*

## Machine level view
In a sense, all recursion is an illusion. 
At the machine level, you have an iterative process for fetching and executing instructions. 
All function calls (including the recursive ones) are implemented via a runtime stack.
Each function call actually results in pushing an activation record containing that 
information onto the stack. 
Returning from a function is accomplished by getting and 
saving the return address out of the top record on the stack, 
popping the stack once, and jumping to the saved address.

The actual structure of activation stacks is machine and compiler dependent. 
A typical one is shown here.

- Typical contents of the saved state area would include
  + the return address - where to go when returning from the call, and
  + contents of critical machine registers at the start of the call

- Contents of the params area would be
  + the values fo the actual parameters being passed to the function
  + space for the return value that the call will eventually send back to the caller

For example, a function call `foo(a, b+c, d);`, the caller would
1. Push state information, 
   including a return address and the current values of the top-of-stack and top-frame pointers.
2. Evaluate each of the three parameter expressions, 
   pushing their values onto the stack. 
   If foo has a non-void return type, the caller would also push enough space for the return value.
3. The caller would then jump to the starting address of foo’s function body.

## Converting Recursive Algorithms to Iteration
### Tail Recursion
Tail recursion is the simplest form to convert to iterations.
Tail recursive routines have an immediate, and simple pattern of conversion.
Consider the following code:
```java
class Example {
    R f(A a, B b) {
        if(check(a, b)) return pure(a, b);
        else {
            // some codes...
            return f(c, d);
        }
    }
}
```
becomes
```java
class Example {
    R f(A a, B b) {
        while(!check(a, b)) {
            // some code...
            c = a;
            d = b;
        }
        return pure(a, b);
    }
}
```

#### A real example: Binary search
An example of tail-recursion is the binary search, 
which converts by the pattern just shown from the recursive form shown here:
```java
```

### Conversion Using Stacks
As noted earlier, 
CPU’s execute recursive code by storing information about each recursive call in a *stack*.
If we wanted to convert an algorithm from a recursive form to an iterative form, 
we could simulate this process with our own stacks.

**Any** recursive algorithm can be converted to an iterative form by using a stack to capture the “history” of
- actual parameters
- local variables

The general idea is:

- recursive calls get replaced by push
  + depending on details, may push new values, old values, or both
- returns from recursive calls get replaced by pop
- main calculation of recursive routine gets put inside a loop
  + at start of loop, set variables from stack top and pop the stack

#### Basic format
We can think of a recursive function as being divided into several pieces, 
separated by the recursive calls (codes below). 
(This is a bit of an oversimplification, 
since we aren’t considering what happens if the recursive calls are inside if or loop statements, 
but those can be dealt with once you get the basic idea.)
```java
class RecursiveExample<Result, A, B> {
    Result recursiveFoo (A param1, B param2) {
        A local1;
        B local2 = pure(param1, param2);
        // code block 1
        recursiveFoo(local1, local2);
        // code block 2
        recursiveFoo(param1, local2);
        // code block 3
        recursiveFoo(local1, param2);
        // code block 4
    }
}
```
We can simulate calls to the recursive routine by saving, on a stack, 
all parameters and local variables. In addition, 
just as a “real” function call needs to know its return address, 
we may need to save a “location” indicator to let us know which block of code 
we’re supposed to execute upon a simulated return from a simulated recursive call.

It helps, then, to have a convenient structure to 
hold each set of information to go on the stack:
```java
import java.util.List;

class StateInfo {
    A param1;
    B param2;
    A local1;
    B local2;
    int location;
}

class Stack {
    java.util.Stack<List<StateInfo>> stack;
}
```

#### Getting "*parameters*" from the stack
#### Simplifying
#### Example: QuickSort

## Epilogue
Sometimes it’s really not worth converting algorithms from recursive to iterative. 
Some elegant, simple recursive algorithms become horrendously complicated in iterative form. 
On the other hand, as noted earlier, there are times when we have little choice (e.g., embedded systems).

In these kinds of situations, 
conversion from recursion to iteration may be the only way to get a system running.





