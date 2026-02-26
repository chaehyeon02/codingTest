import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int first = commands[i][0];
            int second = commands[i][1];
            int[] arr = new int[second - first + 1];
            
            for(int j = 0; j < second - first + 1; j++)
                arr[j] = array[j + first - 1];
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        
        return answer;
    }
}