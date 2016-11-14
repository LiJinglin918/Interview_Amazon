/*
Given two words, find if second word is the round rotation of first word.
For example: abc, cab
return 1
since cab is round rotation of abc

Example2: ab, aa
return -1
since ab is not round rotation for aa
*/

import java.lang.String;

public class RorateString {
    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        //when s1 s2 are null, return false
        if (s2.length() == len && s1 != null && len > 0) {
            for (int i = 0;i<len;++i) {
                if (s1.charAt(i) != s2.charAt(len-1-i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
