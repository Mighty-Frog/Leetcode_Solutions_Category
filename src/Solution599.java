import java.util.*;

public class Solution599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Solution599 temp = new Solution599();
        System.out.println(Arrays.toString(temp.findRestaurant(list1, list2)));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Integer[]> list = new ArrayList<>();
        int[][] sumList = null;
        String[] big = null;
        String[] small = null;

        if (Integer.compare(list1.length, list2.length) >= 1) {
            big = list1;
            small = list2;
        } else {
            big = list2;
            small = list1;
        }
//对大的list进行哈希，key是string，value是原序列；循环小数组，没碰到相同的string，加入list中，第一位是map的序列（value），第二位是小list的序列和前一个之和
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < big.length; i++) {
            map.put(big[i], i);
        }
        for (int i = 0; i < small.length; i++) {
            if (map.containsKey(small[i])) {
                list.add(new Integer[]{map.get(small[i]), i + map.get(small[i])}); // list[0] store biglist 's order number
                //of same String, list[1] store smalllist's order number
            }
        }

//        sumList = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            sumList[i] = new int[]{list.get(i)[0] + list.get(i)[1], i}; //每个分数组都是对象要建立新的
        //       }
        //对序列排序，按第二位（和）排序
        Collections.sort(list, new MyComparator());
        int next = 0;
        //对比前几个序列，把最小的一组（一个或多个）都找出来放到res里； 要还原string ，应该是 list.get(next)[1]-list.get(next)[o]得到smalllist的序号
        while(next < list.size() &&(list.get(next)[1] <= list.get(0)[1])){
            res.add(small[list.get(next)[1] - list.get(next)[0]]);

            next++;
        }
        String[] finalRes = new String[res.size()];
        finalRes = res.toArray(finalRes);
        return finalRes;

    }
}

        class MyComparator implements Comparator<Integer[]> {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1[1], o2[1]);
                //return compare(o1[0]+o1[1] > o2[0]+o2[1] ? 1 : (o1[0]+o1[1] == o2[0]+o2[1] ? 0 : - 1)
            }

        }


