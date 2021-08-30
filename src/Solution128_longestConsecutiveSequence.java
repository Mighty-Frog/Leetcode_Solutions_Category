/*  此法有重复，如2，3，4 算了一遍， 3，4 又算一遍
class Solution {
public int longestConsecutive(int[] nums) {

    Set<Integer> num_set = new HashSet<Integer>();
    for(int num : nums){
        num_set.add(num);           //o(n)
    }

    int longestStreak = 0;

    for(int num :nums){               // o(n)
        int currentNum = num;
        int currentStreak = 1;

        while(num_set.contains(currentNum + 1)) {       // o(1 * l),worst o(n)
            currentNum ++;
            currentStreak ++;
        }

        longestStreak = Math.max(longestStreak, currentStreak);

    }
    return longestStreak;

}
}
*/

import java.util.HashSet;
import java.util.Set;

//此法修正了上述重复， 如2，3，4 算了一遍， 到3因为存在2就跳过。
    public class Solution128_longestConsecutiveSequence {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for(int num: nums){
                num_set.add(num);
            }

            int longestStreak = 0;


            for(int num : num_set) { //(o(n))
                if(!num_set.contains(num-1)) {//如果数据集里没有比当前数小1的数，更新为当前计数的初始
                    int currentNum = num;
                    int currentStreak = 1;

                    while(num_set.contains(currentNum +1)) {//o(1) loop，但凡set包含比当前数大1，则更新此数，+1
                        currentNum ++;
                        currentStreak ++;
                    }
                    longestStreak = Math.max(currentStreak, longestStreak); //在
                }
                //如果存在比当前数（7）小1的数（7，100，6，200），则进行下一个（100）,就是只看最小的连续那个。
            }
            return longestStreak;
        }
    }


