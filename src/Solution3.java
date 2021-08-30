import java.util.HashSet;

//遍历中，一遍查重，一遍记录最长,一旦重复，重新装map
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0;
        int temp =0;
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(set.contains(s.charAt(i))) {
                set.removeAll(set);
                set.add(s.charAt(i));
                temp = 1;
            }else{
                set.add(s.charAt(i));
                temp++;
                longest = Math.max(temp,longest);
            }
        }
        return longest;
    }
}