import java.util.*;

class Solution {
    private class Node {
        int dist, cost;
        
        Node(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int start = 1;
        ArrayList<Node>[] list = new ArrayList[N + 1]; //간선 저장
        for(int i = 0; i < N + 1; i++)
            list[i] = new ArrayList<>();
        
        for(int[] edge : road) {
            list[edge[0]].add(new Node(edge[1], edge[2]));
            list[edge[1]].add(new Node(edge[0], edge[2]));
        }
        
        int[] dist = new int[N + 1]; //최단거리를 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) 
            -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(start, 0)); //시작점
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(dist[now.dist] < now.cost)
                continue;
            
            for(Node next : list[now.dist]) {
                if(dist[next.dist] > now.cost + next.cost) {
                    dist[next.dist] = now.cost + next.cost;
                    pq.add(new Node(next.dist, now.cost + next.cost));
                }
            }
        }
        
        int answer = 0;
        for(int i : dist)
            if(i <= K) answer += 1;
        
        return answer;
    }
}

//다익스트라: 우선순위큐
/*
노드1, 각 노드의 최단거리를 구함
구한 최단거리dist 중 K보다 작은 것만 확인
*/