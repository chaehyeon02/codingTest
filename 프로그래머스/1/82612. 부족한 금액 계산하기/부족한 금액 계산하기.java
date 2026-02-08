class Solution {
    public long solution(int price, int money, int count) {
        long usedMoney = 0;
        for(int i = 1; i <= count; i++) 
            usedMoney += i * price;

        return usedMoney > money ? usedMoney - money : 0;
    }
}