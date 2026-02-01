import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> set = new HashSet<>();
        
        boolean endCnt = false;
        int i;
        for(i = 0; i < words.length; i++) {
            if(set.contains(words[i])
              || (i != 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) {
                endCnt = true;
                break;
            }
            // else if (i != 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) break;
            set.add(words[i]);
        }

        System.out.println(i);
        if(endCnt) {
            answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
            answer[1] = (i + 1) % n == 0 ? (i + 1) / n: (i + 1) / n + 1;
        }

        return answer;
    }
}