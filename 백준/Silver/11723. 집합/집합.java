import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[21];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("all")) {
                for(int j = 1; j < 21; j++) arr[j] = true;
                continue;
            }

            if(cmd.equals("empty")) {
                for(int j = 1; j < 21; j++) arr[j] = false;
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if(cmd.equals("add")) arr[num] = true;
            else if(cmd.equals("remove")) arr[num] = false;
            else if(cmd.equals("check")) sb.append(arr[num] ? 1 : 0).append('\n');
            else if(cmd.equals("toggle")) arr[num] = !arr[num];
        }

        System.out.print(sb);
    }
}

