import java.util.*;
import java.io.*;


class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            stack.clear();
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt((j + i) % s.length());
                if(c == '[' || c == '{' || c == '(') stack.push(c);
                else if(!stack.isEmpty()) {
                    if(c == ']' && stack.peek() == '[') stack.pop();
                    else if(c == '}' && stack.peek() == '{') stack.pop();
                    else if(c == ')' && stack.peek() == '(') stack.pop();
                }
                else stack.push(c);
            }
            if(stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}