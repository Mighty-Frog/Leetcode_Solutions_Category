//// 2 sets, with a for loop to check each duplicate,  then turn list into array;
////time coplextity (On + Om + O1), space complxity (Om+On)
////最后的数组，是先建个大的，一个个元素加进去，再复制有元素的部分
import java.util.ArrayList;

import java.util.HashSet;

public class Solution349 {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();
            int[] array = null;

            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }

            for (Integer i : set1) {
                if (set2.contains(i)) {
                    list.add(i);
                }
            }
            array = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                array[i] = list.get(i);
            }
        return array;

}}
