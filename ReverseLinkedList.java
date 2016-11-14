// 非递归

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode temp = null,beforehead = null;
        while(head != null){
            temp = head.next;
            head.next = beforehead;
            beforehead = head;
            head = temp;
        }
        return beforehead;
        
    }
	
/*==========================================================*/	
// 递归
	
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
