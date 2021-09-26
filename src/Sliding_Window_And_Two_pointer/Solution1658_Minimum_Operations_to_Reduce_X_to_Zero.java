
package Sliding_Window_And_Two_pointer;

/**
 *
 * 
 * 同向快慢指针，循环体以右指针扩张为一步， 每步里面窗口开始滑动，窗口滑动是极小规模滑动，一般是两三格的滑动，因为在相等区间游走，所以退一步就小，进一步就大。
 * 
 *
 *
 */

class Solution1658_Minimum_Operations_to_Reduce_X_to_Zero {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int oper_num = -1;
        int current_num= 0;
        
        int sum_current = 0;
        int sum_all = 0;
        
        //total sum, and test toal sum is larger than x,if not ,while loop will generate error
        for(int num : nums) {
            sum_all+= num;
        }
        
       // System.out.println("count " + (sum_all - x));
        
        if (sum_all < x) return -1;
        
        int o = 1;
        while(right < len){
            sum_current += nums[right];
            //System.out.println("Round "+ o++ + "  right " + right + " sum_current "+ sum_current);
            //the sum_cuurent should not contain left
            while(sum_current > sum_all - x  && left <= right) {
                sum_current -= nums[left];
               // System.out.println(" left " + left + " sum_current " + sum_current + " count " + (sum_all - x));
                left++;
                
            }
            
            if(sum_current == sum_all - x) { current_num = right - left  + 1;
            //System.out.println(sum_current == sum_all - x);
            oper_num = Math.max(current_num, oper_num);
                                           }
            right++;
        }
        return oper_num == -1? -1 : len - oper_num ;

    }
}
