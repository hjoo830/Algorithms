import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();
        for (int[] c : commands) {
            int i = c[0] - 1;
            int j = c[1];
            int k = c[2] - 1;
            
            int[] sliceArr = Arrays.copyOfRange(array, i, j);
            Arrays.sort(sliceArr);
            answerList.add(sliceArr[k]);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}