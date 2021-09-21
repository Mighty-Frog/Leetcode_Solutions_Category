package Sliding_Window_And_Two_pointer;
/**
 * 0. 这题用前后指针法(int left = 0; int right = len - k + 1)，间隔k个，每次更新减[left -1], + [right]
 * 1. 注意第一项要单独拿出来，因为第一次的sum要一个个加起来，而后面n项不需要。
 * 2. 另外返回数值 需要强制转换
 * @（double） ，否则会即使 double res = sum/k 也会在赋值前被转换为保底的整数
 * 3. 第一次和算出后，left 和right 需要 update 再进入循环
 * while（true） 里面再判断退出 会更容易理解
 */

public class Solution643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = left + k - 1;
        int sum = 0;

        //sum of first subarray
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if(len == k) return (double) sum/k;

        left++;
        right++;
        //set original temp value
        int temp = sum;

        while(true){
            //tempotery varible store the sum of each subarray
            temp = temp - nums[left - 1] + nums[right];
            sum = Math.max(sum,temp);
            //check if the right is the last element of the array
            if(right >= len - 1) break;
            // if not, update, all move forward
            left++;
            right++;
        }

        double res = (double) sum/k;
        return res;
    }

}
