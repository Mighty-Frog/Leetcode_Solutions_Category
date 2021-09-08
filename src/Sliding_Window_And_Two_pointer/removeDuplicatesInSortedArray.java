package Sliding_Window_And_Two_pointer;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/sliding-window-and-two-pointers/owkrrm/
 * 来源：力扣（LeetCode）
 */

public class removeDuplicatesInSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        //特例，只有一个
        if(nums.length < 2) return nums.length;

        //initialize new range
        int j = 0;

        //filter 快指针从1开始，慢从0开始，一旦不等，慢指针进1位然后更新，
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        //finish
        return j+1;
    }
}

/**
 * 时间复杂度O(n + m) ,n是元素数量，m是不重复元素数量
 * space complexity O(1)
 */
