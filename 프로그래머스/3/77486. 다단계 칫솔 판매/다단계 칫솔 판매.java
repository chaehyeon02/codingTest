import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> bossMap = new HashMap<>(); //<자식, 부모>
        HashMap<String, Integer> moneyMap = new HashMap<>(); //<사람, 돈>
            
        for(int i = 0; i < enroll.length; i++) {
            bossMap.put(enroll[i], referral[i]);
        }
        
        //돈계산
        for(int i = 0; i < seller.length; i++) {
            String curPerson = seller[i];
            int curMoney = amount[i] * 100;
            
            while(!curPerson.equals("-") && curMoney > 0) { //사람, 돈 넣기                
                moneyMap.put(curPerson, moneyMap.getOrDefault(curPerson, 0) + curMoney - (int)(curMoney * 0.1));
                curPerson = bossMap.get(curPerson);
                curMoney = (int)(curMoney * 0.1);
            }
        }
        
        int[] answer = new int[enroll.length];        
        for(int i = 0; i < enroll.length; i++) {
            if(moneyMap.get(enroll[i]) == null) continue;
            answer[i] = moneyMap.get(enroll[i]);
        }

        return answer;
    }
}