import java.util.*;

public class Solution {
    public int[] solution(int []arr) {        
        Stack<Integer> s = new Stack<>();
        for (int n : arr){
            if (!s.isEmpty()){
                int c = s.pop();
                if(c != n) {
                    s.add(c);
                }
            } 
            s.add(n);
        }
        
        int[] answer = new int[s.size()];
        int stackSize = s.size();
        for (int i = stackSize - 1; i >= 0; i--) {
            int c = s.pop();
            answer[i] = c;
        }

        return answer;
    }
}