import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        StringBuffer sb = new StringBuffer();
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}