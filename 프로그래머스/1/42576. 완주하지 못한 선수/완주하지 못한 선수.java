import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String p : participant) hash.put(p, hash.getOrDefault(p, 0) + 1);
        for(String c : completion) hash.put(c, hash.get(c) - 1);
        
        for(String s : hash.keySet())
            if(hash.get(s) != 0) return s;
        
        return "";
    }
}