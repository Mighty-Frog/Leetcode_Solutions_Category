/**
 * 左右交叉向中间移动，横向能确定是最大，遇到纵向比原来大的才重新计算，小的直接跳过。
 *
 * time: O(n)
 * space: O(1)
 *
 *
 */
class Solution11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxArea = ( right - left + 1 ) * Math.min( height[left], height[right]) ;

        int sideTemp = 0;
        while ( right > left) {

            if ( height[left] > height[right] ) {
                right--;
                if( height[right] > height[right + 1] ) {
                    sideTemp = height[right];
                    int minHeight = Math.min( height[right], height[left] );
                    maxArea = Math.max( maxArea, minHeight * (right - left + 1));
                }
            }
            if ( height[left] <= height[right] ) {
                left++;
                if( height[left] > height[left - 1] ) {
                    sideTemp = height[left];
                    int minHeight = Math.min( height[right], height[left] );
                    maxArea = Math.max( maxArea, minHeight * (right - left + 1));
                }

            }

        }
        return maxArea;
    }
}
