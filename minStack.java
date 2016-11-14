class MinStack {
    class ListNode{ //use ListNode to complete the function of the stack
        int val;
        int min; //store the min value
        ListNode next;
        ListNode(int x){
            val = x;
            min = x;
        }
    }
    ListNode head;
    public void push(int x) {
        if(head == null) {
            head = new ListNode(x);
            return;
        }
        ListNode temp = new ListNode(x);
        if(x > head.min) temp.min = head.min;
        temp.next = head;
        head = temp;
    }

    public void pop() {
        if(head == null)  return;
        head = head.next;
    }

    public int top() {
        if(head == null)  return Integer.MAX_VALUE;
        return head.val;
    }

    public int getMin() {
        if(head == null)  return Integer.MAX_VALUE;
        return head.min;
    }
}
