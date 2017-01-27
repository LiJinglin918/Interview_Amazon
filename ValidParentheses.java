public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i <  s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')){
                return false;
            }
            else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')){
                return false;
            }
            else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')){
                return false;
            }
        }
        return stack.isEmpty();
    }
}


/* 给你一个str,里面只有 '('和‘)’,让你数valid pairs一共有多少,如果不是valid就返回-1. 
(判断是不是valid的parenthesis string，不是的话返回-1，是的话返回valid pair个数，即String.length() / 2 )
*/

import java.util.Stack;

public class isValid {
    public boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0)   return true;
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty())  stack.push(s.charAt(i));
            else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2)    stack.pop();
            else    stack.push(s.charAt(i));
        }
        
        return stack.empty();
    }
}
