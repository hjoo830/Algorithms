import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String term : terms) {
            String[] list = term.split(" ");
            map.put(list[0], Integer.parseInt(list[1]));
        }
        
        String[] tDate = today.split("\\.");
        int tYear = Integer.parseInt(tDate[0]);
        int tMonth = Integer.parseInt(tDate[1]);
        int tDay = Integer.parseInt(tDate[2]);
        
        int tValue = tYear * 12 * 28 + tMonth * 28 + tDay;
        
        for (int i = 0; i < privacies.length; i++) {
            String[] list = privacies[i].split(" ");
            String date = list[0];
            String term = list[1];
            
            String[] pDate = date.split("\\.");
            int pYear = Integer.parseInt(pDate[0]);
            int pMonth = Integer.parseInt(pDate[1]);
            int pDay = Integer.parseInt(pDate[2]);
            
            pMonth += map.get(term);
            pYear += (pMonth - 1) / 12;
            pMonth = (pMonth - 1) % 12 + 1;
            
            pDay -= 1;
            if (pDay == 0) {
                pDay = 28;
                pMonth -= 1;
                if (pMonth == 0) {
                    pMonth = 12;
                    pYear -= 1;
                }
            }
            
            int pValue = pYear * 12 * 28 + pMonth * 28 + pDay;
            
            if (pValue < tValue) {
                answer.add(i + 1);
            }
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}