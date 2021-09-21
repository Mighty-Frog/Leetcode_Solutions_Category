package Sliding_Window_And_Two_pointer;

/**
 * 0. 除了考虑遍历总和外，还要考虑 minutes的时间内也要优化，minutes时间内的优化与solution643一致，窗口法，否则时间会大大延长（从n到 n square）
 * 1. 每一步写完要考虑是否符合思路之初的想法
 * 3. 更改部分代码块最好重新设计，直接再原代码改往往会搭在错误的结构上， 比如之前用的遍历sum而非窗口，循环体是while里面加for， 改成窗口其实for就没有了
 * 4. 非循环体的变量为了容易阅读的理解，多设几个没问题，只增加个位数的变量空间，但是给代码检查提供巨大的遍历！
 *
 *
 */

class Solution1052_Grumpy_Bookstore_Owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int lenC = customers.length;
        int lenG = grumpy.length;

        int left = 0;
        int right = left + minutes - 1;

        //如果没有停止生气区间的总顾客数 total_sum
        int total_sum = 0;
        for(int i= 0; i < lenC; i++) {
            if(grumpy[i] == 1) continue;
            total_sum +=  customers[i];

        }

        //停止生气区间最多可以多获得的顾客数量sum_ungrumpy
        int sum_ungrumpy = 0;
        int temp_ungrumpy = 0;
        //第一区间的多获得的顾客数量 first_ungrumpy
        int first_ungrumpy = 0;
        for(int i = 0; i < minutes; i++){
            first_ungrumpy += grumpy[i] * customers[i];
        }
        if(lenC == minutes) return total_sum + first_ungrumpy;

        //System.out.println(" first_ungrumpy " + first_ungrumpy);
        //System.out.println();

        //update temp_ungrumpy and left & right
        temp_ungrumpy = first_ungrumpy;
        sum_ungrumpy = first_ungrumpy;
        left++;
        right++;

        //int o = 0;
        while(true) {

            //for(int i = left; i <= right; i++) {
            temp_ungrumpy = temp_ungrumpy
                    - grumpy[left-1]*customers[left-1]
                    + grumpy[right]*customers[right]
            ;
            //}

            //System.out.println("Round " + o++ + " temp_ungrumpy " + temp_ungrumpy);
            //System.out.println(" grumpy[left-1] " + grumpy[left-1]);
            //System.out.println(" customers[left-1] " + customers[left-1]);
            //System.out.println(" grumpy[right] " + grumpy[right]);
            //System.out.println(" customers[right] " + customers[right]);

            sum_ungrumpy = Math.max(sum_ungrumpy, temp_ungrumpy);
            //System.out.println(" sum_ungrumpy " + sum_ungrumpy);
            //System.out.println();

            if(right >= lenC - 1) break;
            left++;
            right++;
        }

        return total_sum + sum_ungrumpy;




        //
        /*

        int temp_sum = 0;
        int temp_minus = 0;
        int sum = 0;

        int u = 0;
        while(true) {

            temp_sum = 0;
            temp_minus = 0;

            for(int i = left; i <= right; i++){
                temp_minus += grumpy[i] * customers[i];
            }
            temp_sum = total_sum + temp_minus;

            sum = Math.max(sum, temp_sum);

            if(right >= lenG -1) break;
            left++;
            right++;
        }

        return total_sum + ungrumpy;
        */
    }
}
