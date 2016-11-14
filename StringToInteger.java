public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int flag = 1;
        double result = 0;
        int i = 0;
        if(str.charAt(0) == '-'){
            flag = -1;
            i++;
        }
        else if(str.charAt(0) == '+'){
            i++;
        }
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(flag == -1){
            result = -result;
        }
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
