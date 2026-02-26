import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        que.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(que.peekLast() != arr[i]) que.add(arr[i]);
        }
        
        while(!que.isEmpty())
            answer.add(que.pop());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}