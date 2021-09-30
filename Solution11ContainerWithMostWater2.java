/**
*与解法1基本一样，左右见小则往中间移。这里注意left ，height[left] 和right 在不同步骤里的实际值.
*同时注意  = ? : 的用法
*以及left right 严格交替的思想。也可不严格交替，参考解法1.
*/

class Solution11ContainerWithMostWater2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0 ;

        while ( right > left) {
            int minSide = height[left] < height[right] ? height[left++] : height[right--];
            maxArea =  Math.max( maxArea, minSide * (right - left + 1));
        }
        return maxArea;
    }
}
