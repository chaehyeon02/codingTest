import java.util.*;

class Solution {
    
    private static class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        boolean[][] visited = new boolean[N][M];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] dist = new int[N][M];
        for(int i = 0; i < dist.length; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!queue.isEmpty()) {
            Pair now = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                
                if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    if(dist[nx][ny] > dist[now.x][now.y] + 1)
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
        }
        
        if(dist[N - 1][M - 1] < Integer.MAX_VALUE)
            return dist[N - 1][M - 1];
        return -1;
    }
}