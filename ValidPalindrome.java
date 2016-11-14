// 非递归

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
        
    }
}


/*---------------------------------------------------------------*/


public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left < right && !Character. isLetterOrDigit (s.charAt(left)))
                left++;
            while (left < right && !Character. isLetterOrDigit (s.charAt(right)))
                right--;
            if (Character. toLowerCase (s.charAt(left)) != Character. toLowerCase (s.charAt(right)))
                return false;
            else {
            left++;
            right--;
            }
        }
        return true;
    }
}



/*===============================================================*/


// 递归
public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;
        char[] chars = s.toUpperCase().toCharArray();
        return isPalindrome(chars, 0, chars.length - 1);
    }
    private boolean isPalindrome(char[] chars, int p1, int p2) {
        if (p1 >= p2) return true;
        if (!Character.isLetterOrDigit(chars[p1])) return isPalindrome(chars, p1 + 1, p2);
        if (!Character.isLetterOrDigit(chars[p2])) return isPalindrome(chars, p1, p2 - 1);
        if (chars[p1] != chars[p2]) return false;
        return isPalindrome(chars, p1 + 1, p2 - 1);
    } 
