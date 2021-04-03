package easy;

/**
 * @author zhangjun
 * @date 2021/3/5
 */
public class Solution232 {
    class MyQueue {
        private int [] push;
        private int [] pop;
        private int topPush;
        private int topPop;
        /** Initialize your data structure here. */
        public MyQueue() {
            pop = new int[100];
            push = new int[100];
            topPop = -1;
            topPush = -1;
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            //uncheck index;
            push[++topPush] = x;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int result = peek();
            topPop--;
            return result;
        }

        /** Get the front element. */
        public int peek() {
            //uncheck index;
            if(topPop == -1){
                while(topPush != -1){
                    pop[++topPop] = push[topPush--];
                }
            }
            //pop my be empty
            return pop[topPop];
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return topPop == -1 && topPush == -1;
        }

    }

}
