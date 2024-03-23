package test4;

import java.util.HashSet;
import java.util.Set;

//给定两个数组 nums1 和 nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
public class ArrayIntersection {
    //由于数据之间可能会相当分散,此时选用数组作为哈希法的结构会造成极大的空间浪费,因此这里选择set比较合适
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums1.length==0 || nums2==null || nums2.length==0) {
            return new int[0];
        }
        //选用set这个数据结构时就完成了去重,因为set不允许重复元素
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1,生成哈希表
        for(int i : nums1){
            set1.add(i);       //注意这是新循环写法,i是元素值,而非元素下标
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for(int i : nums2){
            if (set1.contains(i)) {
                resSet.add(i);    //resSet集合中存放的是交集元素
            }
        }
        int index = 0;
        int[] arr = new int[resSet.size()];
        for(int i : resSet){
            arr[index++] = i;
        }
        return arr;

        //这里其实也可以调用方法来将set转换成数组
        //return resSet.stream().mapToInt(x -> x).toArray();
    }
}
