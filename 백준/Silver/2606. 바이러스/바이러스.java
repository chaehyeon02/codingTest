import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) edges[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        dfs(1);
        for(int i = 2; i < n + 1; i++)
            if(visited[i]) answer += 1;

        System.out.print(answer);
    }

    static void dfs(int node) {
        visited[node] = true;

        for(int e : edges[node])
            if(!visited[e]) dfs(e);
    }
}