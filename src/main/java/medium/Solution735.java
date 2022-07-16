package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2022/7/13 12:37
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0;
        while(i < asteroids.length && asteroids[i] < 0){
            offset(asteroids[i++]);
        }
        while(i < asteroids.length){
            if(asteroids[i] > 0){
                push(asteroids[i]);
            }else{
                while(isNotEmpty() && peek() < -asteroids[i]){
                    pop();
                }
                if(isNotEmpty()){
                    if(peek() == -asteroids[i]){
                        pop();
                    }
                }else{
                    offset(asteroids[i]);
                }
            }
            i++;
        }
        return trim();
    }

    private int [] stack = new int[16];
    private int index = -1;
    private int offset = -1;
    public void push(int element){
        grow(index);
        stack[++index] = element;
    }

    public boolean isNotEmpty(){
        return index > offset;
    }

    public int peek(){
        return stack[index];
    }

    public int pop(){
        int result = peek();
        index--;
        return result;
    }

    public void offset(int element){
        grow(offset);
        stack[++offset] = element;
        ++index;
    }

    private void grow(int size){
        if(size == stack.length - 1){
            int [] temp = new int[size << 1];
            System.arraycopy(stack,0,temp,0,size + 1);
            stack = temp;
        }
    }

    private int [] trim(){
        return Arrays.copyOf(stack,index + 1);
    }
}
