package easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangjun
 * @version 2020/09/27  20:55
 */
public class Interview03_04 {

    Deque<Integer> stackForPush;
    Deque<Integer> stackForPop;

    /** Initialize your data structure here. */
    public void MyQueue() {
        stackForPush = new LinkedList<>();
        stackForPop = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackForPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackForPop.isEmpty()){
            while(!stackForPush.isEmpty()){
                stackForPop.push(stackForPush.pop());
            }
        }
        return stackForPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackForPop.isEmpty()){
            while(!stackForPush.isEmpty()){
                stackForPop.push(stackForPush.pop());
            }
        }
        return stackForPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackForPop.isEmpty()&&stackForPush.isEmpty();
    }
}
