import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[K];

        for(int i = 0; i < K; i++)
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        long left = 1;
        long right = nums[nums.length - 1];
        long answer = 0;

        while(left <= right) {
            long mid = (right + left) / 2;

            long cnt = 0;
            for(int n : nums) cnt += n / mid;

            if(cnt < N)
                right = mid - 1;
            else {
                answer = mid;
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}