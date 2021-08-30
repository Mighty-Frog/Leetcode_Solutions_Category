import java.util.HashSet;
import java.util.Set;

class Solution202_HappyNumber {
    public static void main(String[] args){
        int n = 19;
        Solution202_HappyNumber a = new Solution202_HappyNumber();
        System.out.println(a.isHappy(n));
    }
    public boolean isHappy(int n) {
        Set<Integer> num_set = new HashSet<Integer>();
        while(true){
            //get the sum of each number
            int sum = 0;
            while(n > 0){
                int k = n % 10;
                n = n/10;
                sum += k * k;
                System.out.println(k);
            }
            if(sum == 1) return true;
            if(num_set.contains(sum)){
                return false;
            }else{
                num_set.add(sum);
            }
            n = sum;
        }
    }
}


