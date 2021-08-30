/*
遍历每个字符，遇到哪个都是加5，10，100, 处理三种情况外（检查n+1是否为大一级，是则 减去1，10，
 1000) 特别注意 运算符的有限顺序。 && || 都在时， 要先检查i+1 是否越界（在&&前），
且||两头要用括c  // 号包进去
 */
public class Solution13_Roman_To_Integer {
    public static void main(String[] args){
        String  str = "III";
        Solution13_Roman_To_Integer a = new Solution13_Roman_To_Integer();
        System.out.println(a.romanToInt(str));
    }
        public int romanToInt(String str) {
            int num = 0;
            for(int i = 0 ;i < str.length() ; i++){
                if(str.charAt(i) == 'I' ){
                    if( i+1 < str.length() && (str.charAt(i+1) == 'V'|| str.charAt(i+1) == 'X')){
                        num -= 1;
                    }else{
                        num +=1;
                    }
                }

                if(str.charAt(i) == 'V' ){
                    num += 5;
                }

                if(str.charAt(i) == 'X'){
                    if(  i+1 < str.length() && (str.charAt(i+1) == 'L'||str.charAt(i+1) =='C')){
                        num -= 10;
                    }else{
                        num += 10;
                    }
                }

                if(str.charAt(i) == 'L'){
                    num += 50;
                }

                if(str.charAt(i) == 'C'){
                    if( i+1 < str.length() && (str.charAt(i+1) == 'D'||str.charAt(i+1) =='M')){
                        num -= 100;
                    }else{
                        num += 100;
                    }
                }

                if(str.charAt(i) == 'D'){
                    num += 500;
                }

                if(str.charAt(i) == 'M'){
                    num += 1000;
                }
            }
            return num;
        }
}
