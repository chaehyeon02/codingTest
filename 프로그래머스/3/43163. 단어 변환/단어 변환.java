import java.util.*;

class Solution {
    class Node {
        String word;
        int depth;
        
        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        q.add(new Node(begin, 0));
        while(!q.isEmpty()) {
            Node cur = q.poll();
            String curWord = cur.word;
            
            if(curWord.equals(target)) return cur.depth;
            
            for(int i = 0; i < words.length; i++) {
                int diffCnt = 0;
                for(int j = 0; j < curWord.length(); j++) {
                    if(curWord.charAt(j) != words[i].charAt(j)) diffCnt++;
                }
                if(!visited[i] && diffCnt == 1) {
                    q.add(new Node(words[i], cur.depth + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}