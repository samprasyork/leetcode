public class Solution {
    
    public class MaxStack {
        int[] mStack;
        int[] extraStack;
        int count;
        int last;
        public MaxStack(int max) {
            mStack = new int[max];
            extraStack = new int[max];
            count = 0;
            last = 0;
        }
        
        public void push(int val) {
            count++;
            mStack[count-1] = val;
            
            if (last == 0 || extraStack[last-1] <= val ) {
                last++;
                extraStack[last-1] = val;          
            }
        }
        
        public boolean empty() {
            return count == 0;    
        }
        
        public int pop() {
            int tmp = mStack[count-1];
            count--;
            if (tmp == extraStack[last-1]) {
                last--;
            }
            return tmp;
        }
        
        public int max() {
            if (count == 0) {
                return -10000;
            }
            return extraStack[last-1];
        }
    }
    
    public class MaxQueue {
        private int mSize;
        private int count;
        private MaxStack stack1;
        private MaxStack stack2;
        
        public MaxQueue(int capacity) {
            mSize = capacity;
            stack1 = new MaxStack(capacity);
            stack2 = new MaxStack(capacity);
            count = 0;
        }
        
        public void add(int val) {
            if (count >= mSize) {
                if (stack2.empty()) {
                    while(!stack1.empty()) {
                       stack2.push(stack1.pop()); 
                    }
                }
                stack2.pop();
            } else {
                count++;
            }
            stack1.push(val);
        }
        
        public int max() {
            int result  = stack1.max();
            if (stack2.max() > result)
                result = stack2.max();
            return result; 
        }
        
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        MaxQueue queue = new MaxQueue(k);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k-1; i++) {
            queue.add(nums[i]);
        }
        int index = 0;
        for (int i = k-1; i < nums.length; i++) {
            queue.add(nums[i]);
            result[index++] = queue.max();
        }
        return result;
    }
}