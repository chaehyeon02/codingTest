import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int idx, answer = 0;
        for(idx = 0; idx < N; idx++) {
            coins[idx] = Integer.parseInt(br.readLine());
            if(coins[idx] > K) break;
        }

        for(int i = idx - 1; i > -1; i--) {
            if(K / coins[i] > 0) {
                answer += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(answer);
    }
}