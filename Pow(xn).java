public class Solution {
    public double myPow(double x, int n) {
        
        if (n == 0)
            return 1.0;
            
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
        
        if (n == 2)                                       // Note this condition, n % 2 == 1, but cause infinite loop if ignoring
            return x * x;
            
        if (n % 2 == 0) 
            return myPow(myPow(x, n / 2), 2);
       
        else if (n % 2 == 1) 
            return myPow(myPow(x, n / 2), 2) * x;
        
        return -1.0;
    }
}
