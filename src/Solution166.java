import java.util.HashMap;
import java.util.Map;

public class Solution166 {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder sb = new StringBuilder();
            long a = numerator, b = denominator;

            if(a > 0 && b < 0 || a < 0 && b > 0) sb.append("-");

            a = Math.abs(a);
            b = Math.abs(b);

            sb.append(a / b); //整数部分
            if(a % b == 0) return sb.toString();  //被整除了

            sb.append(".");  // 加小数点
            Map<Long, Integer> map = new HashMap<>();
            while( (a = (a % b) * 10) > 0  && !map.containsKey(a) ) {       //循环，取余的10倍再除以b，即是小数点后一位数字，，
                // 将key-当前数字，value-当前数字的位数，放到map里，每次循环检查当前数是否在map的key里面，
                // 如果key里有怎么办？一定会循环，因为余数一旦重复，就会循环。
                map.put(a, sb.length());  //sb,length 是值包含整数部分在内的小数位数
                System.out.println(map);
                sb.append(a / b);
            }
            if(a==0) return sb.toString();
            return sb.insert(map.get(a).intValue(), '(' ).append( ')' ).toString();
        }
    }

