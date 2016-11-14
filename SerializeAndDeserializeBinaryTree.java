/*
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string 
and this string can be deserialized to the original tree structure.
For example, you may serialize the following tree
    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.
*/
// 此题的变形： Serialize and deserialized Tree into LinkedList







/**
 * Serialize and de-serialize Tree into LinkedList
 * 1. Use class Pair, which have two elements: head and tail
 * 2. Initialize a class which is like the ListNode to store the string
 * 3. use helper method to serialize and de-serialize.
 * 4. find the left and right subtree by recursive
 * 5. de-serialize is the opposite way. 
 * @author Administrator
 *
 */
public class SerializeAndDeserializeTreeIntoLinkedList {
	// serialize part
	public ListNodeStr serialized(TreeNode root) {
		ListNodeStr head = helper(root).head;
		return head;
	}
	public Pair helper(TreeNode root) {
		if (root == null) {
			ListNodeStr node = new ListNodeStr("#");
			return new Pair(node, node);
		}
		ListNodeStr head = new ListNodeStr(Integer.toString(root.val));
		ListNodeStr tail = head;
		
		Pair left = helper(root.left);					// recursive
		tail.next = left.head;
		tail = left.tail; 
		
		Pair right = helper(root.right);
		tail.next = right.head;
		tail = right.tail;
		
		return new Pair(head, tail);
	}
	
	// de-serialize part
	public ListNodeStr mover;
	public TreeNode deserialized(ListNodeStr head) {
		ListNodeStr dummyHead = new ListNodeStr(":)");
		dummyHead.next = head;
		mover = dummyHead;
		return helper();
	}
	public TreeNode helper() {
		mover = mover.next;
		if (mover.val == "#") {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(mover.val));
		root.left = helper();
		root.right = helper();
		return root;
	}
	
	public class ListNodeStr {
		String val;
		ListNodeStr next;
		ListNodeStr(String s) {
			val = s;
		}
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
	public class Pair {
		ListNodeStr head;
		ListNodeStr tail;
		public Pair(ListNodeStr h, ListNodeStr t) {
			head = h;
			tail = t;
		}
	}
}




/*===========================================================*/


public class Codec {

   // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("N")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
