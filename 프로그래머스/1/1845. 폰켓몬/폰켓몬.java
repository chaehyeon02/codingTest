import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) 
            map.put(nums[i], i);
        
        return (map.size() > nums.length / 2) ? nums.length / 2 : map.size();
    }
}