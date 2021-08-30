/*


 map.containsKey(i) ? map.replace(i, map.get(i) + 1) : map.put(i, 1);
 */
import java.util.HashMap;

public class Solution549_LongestHarmony {

    public int findLHS(int[] nums) {
        int longest = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //fill the map
        for (Integer i : nums) {
            //map.containsKey(i) ? map.replace(i, map.get(i) + 1) : map.put(i, 1);
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer i : nums) {
            if (map.containsKey(i + 1)) {
                longest = Math.max(longest, map.get(i) + map.get(i + 1));
            }
        }
        if (map != null) {
            map.remove(2);
        }
        return longest;

    }
}
