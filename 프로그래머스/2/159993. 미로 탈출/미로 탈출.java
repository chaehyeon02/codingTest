import java.util.*;

class Solution {
    private class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        //1. 원하는 지점 찾기
        Node start = findPosition(maps, 'S');
        Node lever = findPosition(maps, 'L');
        Node end = findPosition(maps, 'E');
        
        int distLever = bfs(maps, start, lever);
        if(distLever == -1) return -1;
        
        int distEnd = bfs(maps, lever, end);
        if(distEnd == -1) return -1;
        
        return distLever + distEnd;
    }
    
    private int bfs(String[] maps, Node start, Node target) {
        int n = maps.length;
        int m = maps[0].length();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int[][] dist = new int[n][m]; //거리 저장하는 배열
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(start);
        dist[start.x][start.y] = 0;
        
        while(!dq.isEmpty()) {
            Node cur = dq.poll();
            if(cur.x == target.x && cur.y == target.y) //목표지점
                return dist[cur.x][cur.y];
            
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) //배열 범위 나감
                    continue;
                
                if(dist[nx][ny] == -1 && maps[nx].charAt(ny) != 'X') { //이동할 수 있는 칸
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    dq.add(new Node(nx, ny));
                }
            }
        }
        return -1;
    }
    
    //원하는 문자의 위치를 찾는 메서드
    private Node findPosition(String[] maps, char target) {
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == target) {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }
}