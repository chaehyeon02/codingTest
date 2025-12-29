import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        HashMap<String, String> users = new HashMap<>();
        for(String r : record) {
            if(r.charAt(0) != 'L') {
                users.put(r.split(" ")[1], r.split(" ")[2]);
            }
        }
        
        for(String r : record) {
            if(r.charAt(0) == 'E') 
                answer.add(users.get(r.split(" ")[1]) + "님이 들어왔습니다.");
            else if(r.charAt(0) == 'L')
                answer.add(users.get(r.split(" ")[1]) + "님이 나갔습니다.");
        }
        
        return answer.toArray(new String[0]);
    }
}