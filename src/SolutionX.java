import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionX {
    public static Integer[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int i =0; i < nums.length; i++){
            maps.put(nums[i], (Integer) i);
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int temp = nums[left] + nums[right];
            System.out.println(temp+ "" + left +""+ right);
            System.out.println(temp+ "" + maps.get(nums[left]) +""+ maps.get(nums[right]));
            if(temp == target){
                return new Integer[]{maps.get(nums[left]), maps.get(nums[right])};
            }
            if(temp < target) {
                left++;
            }
            if(temp > target){
                right--;
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums = new int[]{
                3,3
        };
        int target = 6;
        System.out.println(Arrays.deepToString(twoSum(nums, target)));

    }


}

