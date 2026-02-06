import java.util.*;

class Solution {
    
    private static boolean[] visited;
    private static ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] computers) {  
        int answer = 0;
        
        visited = new boolean[n];
        list = new ArrayList[n];
        for(int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1 && i != j)
                    list[i].add(j);
            }
        }
        
        for(int i = 0; i < list.length; i++) {
            if(visited[i] == false) {
                answer += 1;
                dfs(i);
            }
        }
          
        return answer;
    }
    
    private static void dfs(int now) {
        if(visited[now] == true)
            return;
        
        visited[now] = true;
        for(int next : list[now]) {
            dfs(next);
        }
    }
}