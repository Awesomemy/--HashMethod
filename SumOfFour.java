package test4;

import java.util.HashMap;
import java.util.Map;

public class SumOfFour {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /*
        如果直接暴力破解的话,时间复杂度是o(n^4)
        若将(a+b),(c+d)分别视为一组,则问题变成了类似两数之和的形式
        时间复杂度也降为了o(n^2)
        另外此题不需要去重,也相对简单了一些
        */
        int count = 0; //用来记录四元组的个数
        //由于不但要存储a+b的和,还要存储这个和出现的次数,所以选用map结构
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : nums1){
            for(int b : nums2){
                int sum = a+b;
                map.put(sum,map.getOrDefault(sum, 0)+1);
            }
        }
        for(int c : nums3){
            for(int d : nums4){
                //要在map中查找的目标是-(c+d),不必加if判断,没找到次数+0即可
                count += map.getOrDefault(0-(c+d), 0);
            }
        }
        return count;
    }
}
