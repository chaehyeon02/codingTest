import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        
        for(String r : report) {
            String[] people = r.split(" ");
            
            if(!reportMap.containsKey(people[1])) {
                reportMap.put(people[1], new HashSet<String>());
            }
            reportMap.get(people[1]).add(people[0]);
        }
        
        HashMap<String, Integer> cnt = new HashMap<>();
        for(Map.Entry<String, HashSet<String>> entry : reportMap.entrySet()) {
            if(entry.getValue().size() >= k) {
                for(String reporter : entry.getValue())
                    cnt.put(reporter, cnt.getOrDefault(reporter, 0) + 1);
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            if(cnt.containsKey(id_list[i])) 
                answer[i] = cnt.get(id_list[i]);
        }
        
        return answer;
    }
}