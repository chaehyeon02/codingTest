import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            queue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!queue.isEmpty()) {
            int release = queue.poll();
            int ans = 1;
            while(!queue.isEmpty() && release >= queue.peek()) {
                queue.poll();
                ans += 1;
            }
            answer.add(ans);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}