package hard;

/**
 * @author zhangjun
 * @date 2021/2/11
 */
public class Solution703 {
    class KthLargest {

        private int [] minHeap;

        public KthLargest(int k, int[] nums) {
            minHeap = new int[k];
            if(nums != null){
                int size = nums.length - 1;
                if(size >= 0){
                    for(int i = size / 2;i >= 0;i--){
                        maxSink(nums,i,size);
                    }
                    int i = k - 1;
                    for(;i >= 0 && size >= 0;i--){
                        minHeap[i] = deleteMaxTop(nums,size--);
                    }
                    for(int min = Integer.MIN_VALUE;i >= 0;i--){
                        minHeap[i] = min;
                    }
                }
            }
        }


        public int add(int val) {
            int key = top();
            if(val > key){
                replaceTop(val);
                key = top();
            }
            return key;
        }

        private int deleteMaxTop(int [] maxHeap,int size){
            int max = maxHeap[0];
            maxHeap[0] = maxHeap[size];
            maxSink(maxHeap,0,size);
            return max;
        }

        private int top(){
            return minHeap[0];
        }
        private void replaceTop(int key){
            minHeap[0] = key;
            minSink(0);
        }

        private void minSink(int parent){
            int parentValue = minHeap[parent];
            int child = parent * 2 + 1;
            int size = minHeap.length - 1;
            while(child <= size){
                int minChild = minHeap[child];
                if(child < size){
                    int otherChild = minHeap[child + 1];
                    if(otherChild < minChild){
                        minChild = otherChild;
                        child += 1;
                    }
                }
                if(minChild >= parentValue){
                    break;
                }
                minHeap[parent] = minChild;
                parent = child;
                child = parent * 2 + 1;
            }
            minHeap[parent] = parentValue;
        }

        private void maxSink(int [] maxHeap,int parent,int size){
            int parentValue = maxHeap[parent];
            int child = parent * 2 + 1;
            while(child <= size){
                int maxChild = maxHeap[child];
                if(child < size){
                    int otherChild = maxHeap[child + 1];
                    if(otherChild > maxChild){
                        maxChild = otherChild;
                        child += 1;
                    }
                }
                if(maxChild <= parentValue){
                    break;
                }
                maxHeap[parent] = maxChild;
                parent = child;
                child = parent * 2 + 1;
            }
            maxHeap[parent] = parentValue;
        }
//
//        private void swim(int child){
//            int childValue = minHeap[child];
//            int parent = (child - 1) / 2;
//            while(child > 0 && childValue < minHeap[parent]){
//                minHeap[child] = minHeap[parent];
//                child = parent;
//                parent = (child - 1) / 2;
//
//            }
//            minHeap[child] = childValue;
//        }
    }


}
