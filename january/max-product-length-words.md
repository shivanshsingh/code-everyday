#Maximum string lengths product value problem
Given an array of words, find the maximum value of length(s) * length(t), where s and t are words from the array, and s & t shouldn't share any characters.

###Example
Given array = ["ABC", "ABD", "ABCDEF", "WXYZ"]  
Result = length("ABCDEF") * length("WXYZ") = 24

###Approach
We can solve this problem using brute-force:
- Set the max product value to zero.
- For each word in the array, compare it with every other word.
- If the two words do not have common characters, calculate the product of their lengths.
- If the new length is greater than the current max length, make new length the current max length.  
- Here is the code for the [solution](https://github.com/shivanshsingh/code-everyday/blob/master/january/MaxLengthsWord.java).

Time complexity of this approach is: **n^2 * m** ,where n is the no. of words in the array and m is the length of longest non-overlapping word. The way you calculate is something like this - We are comparing every node with every other node, so if we have n words in array, the time complexity become n^2. Also, at every comparison, we are also comparing if the two words have any common character. For which, we are iterating over the length of longer string and adding its characters to hashset, and then iterating over the smaller string and checking if any character of it, already exist in hashset. So, if the length of the longer string is m and in the worst case, 2nd string is also m, then, the time complexity is 2m.  
Therefore, the total time complexity is n^2 * m.
