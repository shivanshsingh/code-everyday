#Duplicate sub-tree problem
Given a binary tree, find out if tree contains duplicate sub-trees.  
Single nodes are not considered sub-tree. Duplicate trees must have at least 1 edge. What it means is, if there are two duplicate nodes, but no matching left or right child, then its not considered as duplicate sub-trees.

###Example
Tree = 
```
1
|\
3 3
|\ \
4 2 2
```
Result = True  
Duplicate subtrees are =
```
3
 \
  2
```

###Approach
We can solve this problem using inOrder tree traversal.
- Traverse the tree using in-order tree traversal algorithm.
- Use a list to keep all the seen nodes, so far.
- While traversing, for every node (i.e. when visiting the node in visit() method), check if a node already exist in the seen list, similar to the current one, i.e. of the same node value.
- If yes, you found a duplicate node. Compare the left(or right) child of current node, with the left(or right) child of duplicate node. If they have same node values, it means a duplicate edge is found. And hence, the duplicate sub-trees is found. Therefore, return true.
- Here is the code for the [solution](https://github.com/shivanshsingh/code-everyday/blob/master/january/DuplicateTree.java).

**Note** - Important thing to note in the code is that, the in-order traversal is a recursive function. The function execution will finish only when all the nodes have been visited, even though the duplicate subtrees are found, as shown in the inOrder() method. But, there is no point in traversing the tree further, if duplicate subtree has already been found. To avoid it, we have implemented a check in inOrderModified() method - if any of the branches(left-subtree, current node or right-subtree) of the in-order traversal algorithm returns true, then we just return it back to the stack.

Time complexity of this approach is: **n^2** ,where n is the no. of nodes in the tree. The way you calculate is something like this - There are n nodes in the tree and for every node, you are checking against each node in the visited list. For example, for 2nd node you could have 1 node in the list. For 3rd node, you could have 2 nodes. So for the nth node, you could have n-1 nodes in the list. Therefore, worst case time complexity is n^2.  
