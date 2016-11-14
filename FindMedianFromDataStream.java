/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.
Examples: 
[2,3,4] , the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:
add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
*/
/*
用最大堆和最小堆储存nums的小的部分和大的部分。例子：max: 4,2,1; min: 5,8,9. （↑↓）
两个堆不同尺寸时，max堆尺寸保持较大。
新数来时，如果小于max的最大值，则应该存在max中。如果存新数之前，max尺寸比min大，平衡一下。
*/

class MedianFinder {
    private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (max.size() == 0 || num <= max.peek()) {
            if (max.size() > min.size()) {
                min.add(max.poll());
            }
            max.add(num);
        }
        else if (min.size() == 0 || num > min.peek()) {
            if (min.size() > max.size()) {
                max.add(min.poll());
            }
            min.add(num);
        }
        else {                                              // 如果要加入的数的大小在两个堆的堆顶之间
            if (max.size() <= min.size())
                max.add(num);
            else
                min.add(num);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() > min.size())
            return max.peek();
        else if (max.size() < min.size())
            return min.peek();
        else                                                    
            return (max.peek() + min.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
