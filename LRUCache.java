/*
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
// 利用hashmapd存储key和value。用doulblyLinkedList数据结构

public class LRUCache {
	
	public int capacity;
	public HashMap<Integer, Node> hm = new HashMap<>();
	public Node head = new Node(-1, -1);
	public Node tail = new Node(-1, -1);
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}
	public int get(int key) {
		if (!hm.containsKey(key)) {
			return -1;
		}
		
		Node current = hm.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		moveToTail(current);
		return hm.get(key).value;
	}
	
	public void set(int key, int value) {
		if (get(key) != -1) {
			hm.get(key).value = value;
			return;
		}
		if (hm.size() == capacity) {
			hm.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
		Node insert = new Node(key, value);
		hm.put(key, insert);
		moveToTail(insert);
	}
  
  // always put the current node into the position just between the tail
	public void moveToTail(Node current) {
		current.prev = tail.prev;
		tail.prev = current;
		current.prev.next = current;
		current.next = tail;
	}
	
	public class Node {
		int key;
		int value;
		Node prev;
		Node next;
		Node (int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
}
