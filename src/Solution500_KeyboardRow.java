import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution500_KeyboardRow {

        String o = "qwertyuiopQWERTYUIOP";
        String p = "asdfghjklASDFGHJKL";
        String q ="zxcvbnmZXCVBNM";
        public String[] findWords(String[] words) {
            String[] a = o.split("");
            String[] b = p.split("");
            String[] c = q.split("");

            HashSet<String> set1 = new HashSet<>();
            HashSet<String> set2 = new HashSet<>();
            HashSet<String> set3 = new HashSet<>();

            for(String s : a ) set1.add(s);
            for(String s : b ) set2.add(s);
            for(String s : c ) set3.add(s);


            List<String> res = new ArrayList<>();


            for(String word: words){
                String[] w = word.split("");
                System.out.println();
                int mark =0;
                    for (String s : w) {
                        if (!set1.contains(s)) break;
                        mark++;
                        if(mark == word.length()){
                            res.add(word);
                            mark = 0;
                        }
                    }

                    for (String s : w) {
                        if (!set2.contains(s)) break;
                        mark++;
                        if(mark == word.length()){
                            res.add(word);
                            mark = 0;
                        }
                    }
                    for (String s : w) {
                        if (!set3.contains(s)) break;
                        mark++;
                        if(mark == word.length()){
                            res.add(word);
                            mark = 0;
                        }
                    }
            }
            return res.toArray(new String[res.size()]);
        }

        public static void main(String[] args){
            String[] words ={"Hello","Alaska","Dad","Peace"};
            System.out.println(Arrays.toString(new Solution500_KeyboardRow().findWords(words)));
        }
}
