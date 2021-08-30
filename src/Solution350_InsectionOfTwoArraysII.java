import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

class Solution350_InsectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = Integer.compare(nums1.length, nums2.length);
        int[] longNums;
        int[] shortNums;
        if(a >= 0) {
            longNums = nums1;
            shortNums = nums2;
        }else{
            longNums = nums2;
            shortNums = nums1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer i: longNums){
            if(map.containsKey(i)){
                map.replace(i, map.get(i)+1);
            }else map.put(i, 1);
        }

        for(Integer i : shortNums){
            if(map.containsKey(i) && map.get(i) > 0){
                list.add(i);
                map.replace(i,map.get(i)-1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}