// not recursive
/*
 * 1. use a hashmap to map the col index to the integer value of root
 * 2. another hashmap to map the node to its col index. root's col index = 0; left branch is negative, right is positive
 * 3. use a queue to store the node
 * 4. use the mostLeft to store the smallest col index
 * 5. from the smallest col index, print all node.value
 */

import java.util.*;
public class PrintBinaryTreeVertical {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		
		// One hashmap to map the col index to the integer value
		HashMap<Integer, List<Integer>> colToValue = new HashMap<>();
		
		// One hashmap to map the treenode to the col index
		HashMap<TreeNode, Integer> nodeToCol = new HashMap<>();
		
		// Queue used to iterate nodes
		Queue<TreeNode> level = new LinkedList<>();
		
		// mostLeft is a pointer, pointing to the smallest col index
		int mostLeft = 0;
	
		level.add(root);
		nodeToCol.put(root, 0);
		
		// traverse the queue, put the values at same level into hashmap
		while (!level.isEmpty()) {
			TreeNode node = level.poll();
			int curCol = nodeToCol.get(node);
			
			// use mostLeft to calculate (count) the most negative col index
			mostLeft = Math.min(mostLeft, curCol);
			
			// put the value with the same col index together
			if (!colToValue.containsKey(curCol)) {
				colToValue.put(curCol, new ArrayList<Integer>());
			}
			colToValue.get(curCol).add(node.val);
			
			// add the left branch with the negative col index. i.e. -1, -2, -3...
			if(node.left != null) {
				level.add(node.left);
				nodeToCol.put(node.left, curCol - 1);
			}
			
			// add the left branch with the negative col index. i.e. 1, 2, 3...
			if (node.right != null) {
				level.add(node.right);
				nodeToCol.put(node.right, curCol + 1);
			}
		}
		
		// print the node.value according to the col index
		while (colToValue.containsKey(mostLeft)) {
			res.add(colToValue.get(mostLeft++));
		}
		return res;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
}


/*=========================================================================================================*/
// recursive



class TreeNode{
	int data;
	TreeNode left, right;
	TreeNode(int item) {
        data = item;
        left = right = null;
    }
} 

// 每一行的最小和最大的index
class Values {
    int max, min;
}
public class PrintNodeVertical {
    static TreeNode root;
    Values val = new Values();
    public void findMinMax(TreeNode node, Values min, Values max, int hd) {
        if (node == null) 
	        return;
        if (hd < min.min) 
            min.min = hd;
        else if (hd > max.max) 
            max.max = hd;
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }
    public void printVerticalLine(TreeNode node, int line_no, int hd) {
        if (node == null) 
            return;
        if (hd == line_no) 
            System.out.print(node.data + " ");        
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);
    }
    public void verticalOrder(TreeNode node) {
        findMinMax(node, val, val, 0);
        for (int line_no = val.min; line_no <= val.max; line_no++) {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }
    }
}
