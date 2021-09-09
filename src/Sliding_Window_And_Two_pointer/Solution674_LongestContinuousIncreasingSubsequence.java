package Sliding_Window_And_Two_pointer;

public class Solution674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;

        //初始化res 和窗口i,j
        int res = 1;
        int i = 0;
        int j = 1;

        //用了窗口，就不是简单地遍历所有nums元素，而是让快指针一直走到末尾
        while(j < len) {
            //每次第j个元素都和第j-1个元素比较
            if(nums[j] <= nums[j-1]){
                i = j;
            }
            j++;
            //更新result
            res = Math.max(res, j - i);
        }
        return res;
    }
}
