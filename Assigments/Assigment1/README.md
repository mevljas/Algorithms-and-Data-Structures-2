# Homework

Implement a method in Java that for the given list of numbers A and target sum S returns the shortest 
length of the sublist in list A (ie the interval) whose sum of elements reaches or exceeds
the target sum of S. If there is no such sublist, the method should return -1. List A may contain both
positive, zero as negative numbers. 
  
Example 1: for A = {1, 4, 6} and S = 2 the method returns 1.  
Example 2: for A = {1, −4, 6} and S = 7 the method returns -1.  
Example 3: for A = {1, 4, −6, 2, 2, 0, 1} and S = 5 the method returns 2.  

Use the template in the e-classroom for implementation. It is sufficient to implement the method
```
public int smallestSubListWithTargetSum (List <Integer> A, int S) {
  return -1;
}
```
The template already contains a few test cases, one of which is slightly larger. It is expected
that with proper implementation you will achieve linear time complexity, which means that for
a great example of a solution calculated in a few milliseconds. There is a simple, naive implementation
 of quadratic time complexity and in a large case would calculate much longer than a second.  
 
The idea is to use the java.util.Deque <Integer> data structure in the solution.  
