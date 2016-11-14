public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i : nums){
            if(q.size() < k){
                q.offer(i);
            }
            else{
                if(i > q.peek()){
                    q.remove();
                    q.offer(i);
                }
            }
        }
        return q.peek();
    }
}
