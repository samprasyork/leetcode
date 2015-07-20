public class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*if (nums == null )
            return null;
        
        
        if (len == 1) {
            result[0] =  nums[0];
            return result;
        }*/
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i-1]*nums[i-1];
        }
        
        int temp = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        
        return result;
    }
}