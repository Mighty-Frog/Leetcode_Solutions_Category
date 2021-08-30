import java.util.HashMap;

/*
双射
 */

class Solution290 {
    public static void main(String[] args) {
        String pattern= "abba" ;
        String s = "dog dog dog dog" ;
        Solution290 b = new Solution290();
        System.out.println(b.wordPattern(pattern, s));
    }
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String[] a = s.split(" ");

        if(a.length != pattern.length()) return false;

        for(int i = 0; i < pattern.length(); i++){
            if(map1.containsKey(pattern.charAt(i))  && !map1.get(pattern.charAt(i)).equals(a[i]) ){
                return false;
            }
            if(map2.containsKey(a[i]) && map2.get(a[i]) != pattern.charAt(i)){
                return false;
            }
            else{
                map1.put(pattern.charAt(i), a[i]);
                map2.put(a[i],pattern.charAt(i));
                System.out.println(map1);
            }
        }
        return true;

    }
}
