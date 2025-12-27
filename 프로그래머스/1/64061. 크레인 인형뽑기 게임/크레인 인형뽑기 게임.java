import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for(int i = 0; i < moves.length; i++) {
            int crane = 0;
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] != 0) {
                    crane = board[j][moves[i] - 1];
                    board[j][moves[i] - 1] = 0;
                    
                    if(basket.isEmpty()) basket.push(crane);
                    else if(crane != basket.peek()) basket.push(crane);
                    else {
                        basket.pop();
                        answer++;
                    }
                    break;
                }
            }
        }
        
        return answer * 2;
    }
}