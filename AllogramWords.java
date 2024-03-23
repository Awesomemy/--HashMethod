package test4;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
public class AllogramWords {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];//与26个字母一一映射
        for(int i=0 ; i<s.length() ; i++){
            hash[s.charAt(i)-'a']++;
        }
        for(int i=0 ; i<t.length() ; i++){
            hash[t.charAt(i)-'a']--;
        }
        for(int i=0 ; i<hash.length ;i++){ //如果哈希数组不全为0,说明s或t中存在对方没有的字母
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
