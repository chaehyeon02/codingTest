import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = in.nextInt();

        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1, idx = 0;

        while(idx < n) {
            if(!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                answer.append("-\n");
                idx += 1;
            }
            else {
                if(num > n) {
                    System.out.println("NO");
                    return;
                }
                stack.push(num++);
                answer.append("+\n");
            }
        }

        System.out.println(answer);
    }
}