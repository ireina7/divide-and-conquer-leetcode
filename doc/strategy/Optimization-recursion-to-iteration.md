# Make recursions practical by converting to iterations
*All recursions in computer codes can be converted to corresponding iterative form.*

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

For example, a function call foo(a, b+c, d);, the caller would
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

#### Getting "*parameters*" from the stack






