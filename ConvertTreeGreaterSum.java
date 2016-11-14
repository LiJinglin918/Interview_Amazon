/* 
Given a Binary Search Tree (BST), convert it to a Binary Tree such that every key of the original BST is changed to key plus sum of all greater keys in BST.

Examples:

Input: Root of following BST
              5
            /   \
           2     13

Output: The given BST is converted to following Binary Tree
              18
            /   \
          20     13
		  
*/

public class CovertTreeSumGreaterKeys {
	
	public class BinaryTree {
		Node root;
	    Sum summ = new Sum();
	 
	    // A recursive function that traverses the given BST in reverse inorder and
	    // for every key, adds all greater keys to it
	    void addGreaterUtil(Node node, Sum sum_ptr) {
	 
	        // Base Case
	        if (node == null) {
	            return;
	        }
	 
	        // Recur for right subtree first so that sum of all greater
	        // nodes is stored at sum_ptr
	        addGreaterUtil(node.right, sum_ptr);
	 
	        // Update the value at sum_ptr
	        sum_ptr.sum += node.data;
	 
	        // Update key of this node
	        node.data = sum_ptr.sum;
	 
	        // Recur for left subtree so that the updated sum is added
	        // to smaller nodes
	        addGreaterUtil(node.left, sum_ptr);
	    }
	 
	    // A wrapper over addGreaterUtil().  It initializes sum and calls
	    // addGreaterUtil() to recursivel upodate and use value of sum
	    Node addGreater(Node node) {
	        addGreaterUtil(node, summ);
	        return node;
	    }
	 
	    // A utility function to print inorder traversal of Binary Tree
	    void printInorder(Node node) {
	        if (node == null) {
	            return;
	        }
	        printInorder(node.left);
	        System.out.print(node.data + " ");
	        printInorder(node.right);
	    }
	}
	
	public class Node {
		int data;
		Node left;
		Node right;
		Node (int d) {
			data = d;
			left = right = null;
		}
	}
	public class Sum {
		int sum = 0;
	}
}
