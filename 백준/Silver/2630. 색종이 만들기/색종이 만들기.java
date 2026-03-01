import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int white;
    static int blue;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        white = 0;
        blue = 0;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void func(int row, int col, int len) {
        //영역이 다 같은 색인지 확인
        int first = paper[row][col];
        boolean same = true;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++)
                if(first != paper[row + i][col + j]) {
                    same = false;
                    break;
                }
            if(!same) break;
        }
        if(same) {
            if(first == 1) blue++;
            else white++;
            return;
        }

        //영역이 다르면 쪼개서 다시 함수 호출
        int nextLen = len / 2;
        func(row, col, nextLen);
        func(row + nextLen, col, nextLen);
        func(row, col + nextLen, nextLen);
        func(row + nextLen, col + nextLen, nextLen);
    }
}