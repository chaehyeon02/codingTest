import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(1L, 1L, 1L, 2L, 2L));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for(int j = list.size(); j < n; j++) {
                list.add(list.get(j - 2) + list.get(j - 3));
            }
            System.out.println(list.get(n - 1));
        }
    }
}