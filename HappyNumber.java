package test4;

import java.util.HashSet;
import java.util.Set;

/*
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」 定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程结果为 1，那么这个数就是快乐数。
如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */
public class HappyNumber {
    //抓住关键:sum会"重复出现"--这使得我们可以考虑用"哈希法"解题
    private int getSum(int n){
        //求取各个位置上数字的平方和
        int sum = 0;
        while (n>0) {
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n!=1 && !record.contains(n)) {
            /*
            跳出循环的条件:
            要么是判断为快乐数
            要么是得到的sum是之前记录过的,这说明已经进入无限循环了,必定不是快乐数
             */
            record.add(n);      //每一次得到的sum都会记录到哈希表里
            n = getSum(n);
        }
        return n==1;
    }
    /*
    其实这个题也可以用快慢指针解决:
    因为sum是否陷入无限循环其实就类似于一个链表是否存在环
    用快指针能否追上慢指针来判断是否有环
     */
}
