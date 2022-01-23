# LeetCode_Ultimate-DP-Study-Plan
------

Dynamic programming is both a mathematical optimization method and a computer programming method. In both contexts it refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner. While some decision problems cannot be taken apart this way, decisions that span several points in time do often break apart recursively.

_[Here]_ is the link to the LeetCode Ultimate DP Study Plan.

[Here]: https://leetcode.com/study-plan/dynamic-programming/?progress=n5biiqs

------
## What is Dynamic Programming?

**_Dynamic Programming_** (**DP**) is a programming paradigm that can systematically and efficiently explore all possible solutions to a problem. As such, it is capable of solving a wide variety of problems that often have the following characteristics:
+ The problem can be broken down into "overlapping subproblems" - smaller versions of the original problem that are re-used multiple times.
+ The problem has an "optimal substructure" - an optimal solution can be formed from optimal solutions to the overlapping subproblems of the original problem.

------
## Top-down and Bottom-up
There are two ways to implement a DP algorithm:
1. **_Bottom-up_**, also known as **tabulation**.
2. **_Top-down_**, also known as **memoization**.


+ **Bottom-up (Tabulation)**:
Bottom-up is implemented with iteration and starts at the base cases. Let's use the Fibonacci sequence as an example again. The base cases for the Fibonacci sequence are
F(0)=0 and F(1)=1. With bottom-up, we would use these base cases to calculate F(2), and then use that result to calculate F(3),
and so on all the way up to F(n).


+ **Top-down (Memoization)**:
Top-down is implemented with recursion and made efficient with memoization. If we wanted to find the nthn^{th}nth Fibonacci number F(n), we try to compute this by
finding F(n−1) and F(n−2). This defines a recursive pattern that will continue on until we reach the base cases
F(0)=F(1)=1. The problem with just implementing it recursively is that there is a ton of unnecessary repeated computation. Take a look at the
recursion tree if we were to find F(5):
![alt text](https://leetcode.com/explore/learn/card/Figures/DP1/C1A2_1.png "Recursion Tree")

Notice that we need to calculate F(2) three times. This might not seem like a big deal, but if we were to calculate F(6), this entire image would be only
one child of the root. Imagine if we wanted to find F(100)F(100)F(100) - the amount of computation is exponential and will quickly explode. The solution to this is to
memoize results.
```
memoizing a result means to store the result of a function call, usually in a hashmap or an array, so that
when the same function call is made again, we can simply return the memoized result instead of
recalculating the result.
```

After we calculate F(2), let's store it somewhere (typically in a hashmap), so in the future, whenever we need to find F(2), we can just refer to the value we already calculated instead of having to go through the entire tree again. Below is an example of what the recursion tree for finding F(6) looks like with memoization:

![alt text][tree]

[tree]: https://github.com/ShubhanshuJha/LeetCode_Ultimate-DP-Study-Plan/blob/main/Recursion%20Tree%20after%20Memoization.png "Recursion Tree with Memoization"

------
## Which is better?

Any DP algorithm can be implemented with either method, and there are reasons for choosing either over the other. However, each method has one main
advantage that stands out:
+ A bottom-up implementation's runtime is usually faster, as iteration does not have the overhead that recursion does.
+ A top-down implementation is usually much easier to write. This is because with recursion, the ordering of subproblems does not matter, whereas with
tabulation, we need to go through a logical ordering of solving subproblems.
------
