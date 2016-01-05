/*
* This code finds out if there is a duplicate tree within a given binary tree.
* Single nodes are not considered as trees. There has to be atleast an edge.
*/

import java.util.ArrayList;

public class DuplicateTree {
	public static void isDuplicate(TreeNode node) {
		ArrayList<TreeNode> visited = new ArrayList<TreeNode>();
		// Uncomment below, if you want to just print the result. Inefficient.
		//inOrder(node, visited);

		// Uncomment below, if you want to return the result. Efficient.
		System.out.println(inOrderModified(node, visited));
	}
	
	// This method is an inOrder traversal of the tree. But, as soon as it finds out
	// that there is a duplicate subtree, it just returns back, w/o executing further.
	// Hence, it is more efficient in terms of time complexity.
	public static boolean inOrderModified(TreeNode node, ArrayList<TreeNode> visited) {
		if(node == null)
			return false;
		if(inOrderModified(node.left,visited))
			return true;
		if(visit(node, visited))
			return true;
		if(inOrderModified(node.right,visited))
			return true;
		return false;
	}
	
	// This method is an inOrder traversal of the tree. But, it traverses all the nodes,
	// even if the duplicate subtree is found. Hence, it is less efficient in terms of
	// time complexity.
	public static void inOrder(TreeNode node, ArrayList<TreeNode> visited) {
		if(node == null)
			return;
		inOrder(node.left,visited);
		if(visit(node, visited))
			System.out.println(true); 
		inOrder(node.right,visited);
	}

	// This is visit method of inorder traversal, whwere we are performing the 
	// duplicate check.
	public static boolean visit(TreeNode node, ArrayList<TreeNode> visited) {
		for(TreeNode visitedNode : visited) {
			if(visitedNode.data == node.data) {
				//duplicate node found. check for duplicate tree.
				if(visitedNode.left != null && node.left != null)
					if(visitedNode.left.data == node.left.data)
						return true;
				if(visitedNode.right != null && node.right != null)
					if(visitedNode.right.data == node.right.data)
						return true;
			}
		}
		visited.add(node);
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode atwo = new TreeNode(2);
		TreeNode athree = new TreeNode(3);
		
		one.left = two;
		two.left = three;
		three.left = atwo;
		atwo.left  = athree;
		
		isDuplicate(one);
	}
}