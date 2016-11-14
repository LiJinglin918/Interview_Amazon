public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0){
            return 0;
        }
        if(len2 > len1){
            return -1;
        }
        for(int i = 0; i <= len1 - len2; i++){
            if(haystack.substring(i, i + len2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
