import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;

        String[] listMinus = s.split("-");

        for(int i = 0; i < listMinus.length; i++) {
            String[] listPlus = listMinus[i].split("\\+");
            int sum = 0;
            for(String p : listPlus)
                sum += Integer.parseInt(p);
            if(i == 0) answer += sum;
            else answer -= sum;
        }
        System.out.print(answer);
    }
}