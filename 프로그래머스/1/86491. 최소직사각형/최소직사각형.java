class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0;
        for(int[] s : sizes) { 
            x = Math.max(Math.max(s[0], s[1]), x);
            y = Math.max(Math.min(s[0], s[1]), y);
        }
        
        return x * y;
    }
}