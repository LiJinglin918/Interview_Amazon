/*
Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/

class MyQueue {
    Stack<Integer> stack = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> temp = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            temp.push(stack.pop());
        }
        temp.pop();
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty())
            temp.push(stack.pop());
        int res = temp.peek();
        while (!temp.isEmpty())
            stack.push(temp.pop());
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
