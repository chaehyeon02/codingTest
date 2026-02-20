import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        int maxNum = 2;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0 || n == 1) {
                sb.append(zero[n]).append(" ").append(one[n]).append("\n");
                continue;
            }
            for(int j = maxNum; j <= n; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }
            sb.append(zero[n]).append(" ").append(one[n]).append("\n");
            maxNum = n;
        }

        System.out.println(sb);
    }
}