import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> category = new HashMap<>();
        
        for (String[] c : clothes) {
            category.put(c[1], category.getOrDefault(c[1], 0) + 1);
        }
                 
        for (String k : category.keySet()) {
            answer *= category.get(k) + 1;
        }
        
        return answer - 1;
    }
}