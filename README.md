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


**+ Bottom-up (Tabulation)**:
Bottom-up is implemented with iteration and starts at the base cases. Let's use the Fibonacci sequence as an example again. The base cases for the Fibonacci sequence are
F(0)=0F(0) = 0F(0)=0 and F(1)=1F(1) = 1F(1)=1. With bottom-up, we would use these base cases to calculate F(2)F(2)F(2), and then use that result to calculate F(3)F(3)F(3),
and so on all the way up to F(n)F(n)F(n).

**+ Top-down (Memoization)**:
Top-down is implemented with recursion and made efficient with memoization. If we wanted to find the nthn^{th}nth Fibonacci number F(n)F(n)F(n), we try to compute this by
finding F(n−1)F(n - 1)F(n−1) and F(n−2)F(n - 2)F(n−2). This defines a recursive pattern that will continue on until we reach the base cases
F(0)=F(1)=1F(0) = F(1) = 1F(0)=F(1)=1. The problem with just implementing it recursively is that there is a ton of unnecessary repeated computation. Take a look at the
recursion tree if we were to find F(5)F(5)F(5):
![alt text](https://leetcode.com/explore/learn/card/Figures/DP1/C1A2_1.png "Recursion Tree")
------
