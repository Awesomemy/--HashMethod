package test4;

public class RansomLetter {
    //赎金信问题和异位字符串的思考方式完全相同
    public boolean canConstruct(String ransomNote, String magazine) {
        //由于只有26个小写字母,所以可以使用数组作为哈希法的结构
        int[] arr = new int[26];
        for(int i=0 ; i<magazine.length() ; i++){
            arr[magazine.charAt(i)-'a']++;
        }
        for(int j=0 ; j<ransomNote.length() ; j++){
            arr[ransomNote.charAt(j)-'a']--;
        }
        for(int a : arr){
            if (a<0) {
                return false;
            }
        }
        return true;
    }
}
