import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) 
            wantMap.put(want[i], number[i]);
        
        for(int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discount10Map = new HashMap<>();
            for(int j = i; j < i + 10; j++) {
                discount10Map.put(discount[j], discount10Map.getOrDefault(discount[j], 0) + 1);
            }
            
            if(wantMap.equals(discount10Map)) answer += 1;
        }
        
        return answer;
    }
}