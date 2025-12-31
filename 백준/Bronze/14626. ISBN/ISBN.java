import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ISBN = br.readLine();

        int sum = 0;
        int starPosition = -1;

        // 앞 12자리만 계산
        for (int i = 0; i < 12; i++) {
            char c = ISBN.charAt(i);
            if (c == '*') {
                starPosition = i;
            } else {
                int num = c - '0';
                sum += (i % 2 == 0) ? num : num * 3;
            }
        }

        int checkDigit = ISBN.charAt(12) - '0';

        for (int i = 0; i <= 9; i++) {
            int tempSum = sum;
            tempSum += (starPosition % 2 == 0) ? i : i * 3;

            if ((tempSum + checkDigit) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
