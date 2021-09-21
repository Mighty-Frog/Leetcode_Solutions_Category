package Sliding_Window_And_Two_pointer;

import java.util.Random;

/**
 * 0.1 什么时候while里面是（true），什么时候while里面是条件？
 *
 * 0. 有哪些方法，time complexity 最小的是什么， 滑动窗口适用于什么情况。
 *      几乎所有排序都可以，O(n) 滑动窗口+ quicksort
 * 1. solution有几个方法？
 *      3个, 一个使用者方法，返回一个index， 一个partition方法，返回一个确定位置元素的位置index， 一个交换swap，交换特定index位置的数值。
 * 2. 第Kth largest 元素的 index是多少?
 *      nums.length - k
 * 3. sliding window 的左右边界怎么确定
 *      quicksort 的左右边界首次选取是整个数组的头尾，每次迭代会将边界减半(平摊下来），一共迭代len次。最初left = 0，right = len-1（也看自己怎么定义，比如left =-1也可）
 *      第一次迭代后，边界成了 left = index of pivot + 1 或 right = index of pivot - 1
 * 4. partition 方法主要是在干什么
 *      将左右边界内的元素以被选召的一个点为中心（pivot），重排为左小右大。其后pivot的位置将为排列完全的位置，此方法最后返回这个index。由此可知
 *      主调用方法就是不断调整左右边界同时调用partition，直到partition返回值等于Kth largest 的位置。
 * 5. partition 是怎么工作的，双指针有哪些方法
 * @param
 *      @int[] nums original array
 *      @int left,    left bound
 *      @int right   ---
 * @temp_variable
 *      @int pivotIndex    the pivot, various chosen way
 *      @int i              head pointer, move toward @int right(tail) bound  , will exchange position with j
 *                          when nums[i]>pivot && nums[j]<pivot until meeting with j
 *      @int j              tail pointer move toward @int left(head) bound
 * @return
 *      @int    the index of completely sorted pivot
 *  此处采用头尾指针法，一首left一尾right，
 *
 * 5.0 双指针（头尾针）怎么确定位置，双指针移动时时怎么确定停止位置，交换位置发生在什么时候，什么时候停止循环
 *      a. 初始时，若交换pivot到left，则i可以是left + 1， 若不交换，i = left； j = right。
 *      b. i的移动是 nums[i] <= pivot, i++, 遇不大则右移，遇大则停， 然后轮到j
 *      c. j的移动是 nums[j] > pivot, j--, 遇小则左移动，遇不小则停。 问：相等的停下来么？对，相等的都交给i处理，i会放到自己后面
 *      d. i,j 什么时候停下来交换位置？
 *          while内部array的循环条件，如果有index++,一定要对index做出限制，否则未触发value的条件下，会一直走，走到nullpointer。
 *          那么是不是while（i <=right && nums[i] <= pivot)就行了吗？可以的。分为两种情况，一种没到末尾，但是遇值而停，这会触发停止，是通常情况。
 *          二是i一直走到了末尾，值还是没触发，跳出这个小while时，i = right + 1。 此时j会因为nums[j]小于pivot而不进入while循环，j==right，
 *          然后两者在互换之前退出大while循环。partition 方法返回j，pivot跟最后一个数互换。是对的！
 *          如果是j一直走到末尾了呢？那么j会到left-1这里，而i还是在left，即j在pivot位，i后面包括i都是大于pivot的，j和left互换，自己换自己还是一样。是对的！
 *      d. 停下来干什么？
 *      交换i和j位置，这样nums[i]仍然<=pivot, nums[j]>pivot ，注意大小和等于的位置作了交换！
 *      e. 等于号位置可以是其他地方么？
 *      还有三个选择，1.上文知ij交换后等于号是对称关系，所以等于可以在j上，这样等于pivot的数都放到了j后面；
 *                  2.可以没有等于号，这样等于pivot的数会被交换（i到j，或j到i），有三种情况，nums[i] == pivot && nums[j] < pivot,
 *                    nums[i] > pivot && nums[j] == pivot; nums[i]==nums[j]==pivot; 均摊下来等于pivot的数会被均等分到两边，
 *                    不过几乎都被换了位置
 *                  3.可不可以都有等号？可以！ 这样ij在本可以相会的情况下会移动过头（其他情况跟上面差不多，仅两边碰到相等情况下ij都可以继续移动），
 *                    此时下一步就是结束循环，ij不会继续走到已经排好的区域（或者说不要让，令结束判断在i++，和j++前面）。
 *                    关键点是pivot占据的left位和谁交换？此时和i或j都可以，但一般情况是小于pivot的j位，所以是j。考虑到最后换回来的的j位值
 *                    要小于pivot，这里是等于怎么办？ 其实上面已经是 nums[i]<= pivot,所以left位可以等于pivot。那么下一次的partition就会
 *                    选left和右边第一个不是pivot的值，这样其实搜索会稍稍小于logN。（考虑到ij其实跑了一些重叠区域，让每次的pivot划分不是左右一半，
 *                    而是左右各小于一半）
 *
 * 5.1 如果采用nums[pivotIndex]和nums[left]交换，那么首次交换前的left和第二次交换后的left各是什么数？
 *      首次交换前left是原数组的任意数，交换是把此数放到原始的index of pivot里，插入被排大军，等待排序。
 *      排好后，pivot需要插入中间位置（数值排序后的value大小的中间位置），这个中间位置和left交换，
 *      此left是一个小于pivot的数，仅此而已。
 * 5.2 这个中间位置是i还是j？
 *      j ， 因为走到最后，i和j必然错过，j正好在 < pivot 或 <=pivot的位置， i在>= pivot 或 > pivot 的位置，
 *      所以若pivot放在left就是j， pivot放在right 就是 i
 *
 * 6. pivot的选取是在什么时候，有哪些选取方法
 *      pivot选取在partition内部，方法刚刚开始的时候。为什么呢？ pivot是在每次partition时进行的根据，每调用一次变化一次。
 *      随机选取法，左右边界法，中间位置法。

 * 8. partition返回的是i还是j
 *    j, 由5.2可知。
 *
 */

public class Solutuib215_KthLargestElementInAnArray {
//quick sort and sliding window
        private static Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            // index of the kth largest elemnt in the array
            int target = nums.length - k;
            int left = 0;
            int right = nums.length - 1;

            while(true) {
                int g = partition(nums, left, right);
                if(g == target) return nums[g];
                else if(target < g){
                    right = g--;
                }
                else if(g < target){
                    left = g++ ;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            int randomIndex = left + random.nextInt(right- left + 1);

            //证明不换也可以，这样pivot = nums[randomIndex], int i = left， 交换以后，left是pivot，后面排序好后需要换回来
            //pivot在正位，那么最左边是什么呢？最左边的数（即循环完后再跟pivot交换的数）其实j停留的一个数，就是比pivot小的任意可能的整数。
            swap(nums, left, randomIndex);

            //此时pivot不再位于randonmIndex，而是left
            int pivot = nums[left];

            int i = left + 1;
            int j = right;

            while(true)
            {
                //nums[i],nums[j] 若没写等于，则相等的会被等概率划到两边，也可以等，如nums[i]<=pivot,则相等的会被划到左边
                while(i <= right && nums[i] < pivot) {
                    //System.out.println(i);
                    i++;
                }
                while(j >=left && nums[j] > pivot) {
                    j--;
                }
                if(i>j) break;
                swap(nums, i, j);
                i++;
                j--;
            }
            swap(nums, j, left);
            return j;
        }
        private void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
}
