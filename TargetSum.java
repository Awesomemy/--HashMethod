package test4;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class TargetSum {
    /**
     * 本体需要"查找""出现过的"互补元素,故而想到用哈希法
     */
    public int[] twoSum(int[] nums, int target) {
        //遍历的同时,如果出现过互补值,则一起作为结果返回,否则记载进map以便后续元素遍历时进行查找
        Map<Integer,Integer> hashtable = new HashMap<Integer,Integer>();  //map是用来存放遍历过的元素的
        for(int i=0;i<nums.length;i++){
            if(hashtable.containsKey(target-nums[i])){
                //因为要查找到是数组中的元素而不是下标是否出现过,所以要以num[i]作为key值
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}
