import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        int start = 0;
        int end = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(end < arr[i]) end = arr[i];
        }

        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for(int a : arr)
                sum += Math.max(a - mid, 0);

            if(sum >= M) {
                answer = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        System.out.print(answer);
    }
}