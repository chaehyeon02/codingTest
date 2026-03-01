import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(!pq.isEmpty()) answer.append(pq.poll()).append("\n");
                else answer.append("0").append("\n");
            }
            else pq.add(x);
        }

        System.out.print(answer);
    }
}