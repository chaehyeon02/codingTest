import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ans = 0;
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = in.nextInt();
        }

        if(arr[0] < 0) {
            arr[0] *= -1;
            ans = arr[0] * arr[2] + arr[1] * arr[4] + arr[3];
        }
        else {
            ans = (arr[1] - arr[0]) * arr[4];
        }
        System.out.println(ans);
    }
}
