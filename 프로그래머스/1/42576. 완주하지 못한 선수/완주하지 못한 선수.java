import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String p : participant) {
            if(hash.containsKey(p)) hash.put(p, hash.get(p) + 1);
            else hash.put(p, 1);
        }
        
        for(String c : completion) {
            if(hash.containsKey(c)) {
                if(hash.get(c) == 1) hash.remove(c);
                else hash.put(c, hash.get(c) - 1);
            }
        }
        
        return hash.keySet().iterator().next();
    }
}