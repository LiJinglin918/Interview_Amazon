
import java.util.LinkedList;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class NthNode {
	public static ListNode nthnode(ListNode head, int n){
		if(head == null || n < 0){
			return null;
		}
		ListNode temp = head;
		Queue<ListNode> q = new LinkedList<ListNode>();
		while(temp != null){
			if(q.size() < n){
				q.offer(temp);
			}
			else{
				q.offer(temp);
				q.poll();
			}
			temp = temp.next;
		}
		return q.poll();
	}
	public static void main(String[] args){
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		for(int i = 0; i < 20; i++){
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		ListNode p = nthnode(head, 3);
		System.out.println(p.val);
	}
}
