# Coin Change Problem
Given a set of coins and amount, write an algorithm to find out how many ways can we make the change of the amount using the coins given. You may assume that the each coin type is infinitely available.

###Example
Amount = 5  
coins[ ] = {1,2,3}  
Ways to make change = 5  
{1,1,1,1,1} {1,1,1,2} {1,2,2} {1,1,3} {2,3}  

###Approach
**Recursive Solution**  
One way to solve this problem is recursion.
- For every coin, we have an option to include it or exclude it.  
- And solution would be, no. of ways you get by including a coin + no. of ways you get by excluding that coin.  
- Here is the code for this [solution](https://github.com/shivanshsingh/code-everyday/blob/master/january/CoinChangeRecursion.java).

Time complexity of this approach is: **2^n** ,where n is the no. of coins. The way you calculate is something like this - for every coin you have 2 options, either exclude(0) it or include(1) it. So for 2 coins, the combinations are 00 01 10 11, which is 2^2. So for n coins, its 2^n.  
In this solution, we are repeatedly solving the same sub-problems, multiple times. We can solve this problem in a more efficient way using dynamic programming.  

**Dynamic programming Solution**  
In this approach, we will store the solutions to the sub-problems. And instead of solving the same sub-problem again, we just use the stored values.  

**Base case**:  
- If the amount is 0, return 1. As we have found 1 combination, to solve the problem.
- If the coin is 0, and amount is still non-zero, then return 0. i.e. we couldn't find the solution with this combination.  

**Rest of the case**:  
- For every coin, we have an option to include or exclude it.  
- Check if the coin value is less than or equal to the amount value. If yes, than we will find the solution by including or excluding the coin. Otherwise, we will find the solution only by excluding it.  
  - **Include coin** - Reduce the amount by coin value and use the sub-problem solution for reduced amount.  
  - **Exclude coin** - Use the solution for the same amount but excluing the coin.  
- Here is the code for this [solution](https://github.com/shivanshsingh/code-everyday/blob/master/january/CoinChangeDP.java).  

###Solution example
Amount = 5  
coins[ ] = {1,2,3}

Solution:  
```
           Amount
          0 1 2 3 4 5
        --------------
      0 | 1 0 0 0 0 0
Coins 1 | 1 1 1 1 1 1
      2 | 1 1 2 2 3 3
      3 | 1 1 2 3 4 5
```
**Solution:** Matrix value with 3 coins and amount 5, which is Matrix[3][5] = 5.
