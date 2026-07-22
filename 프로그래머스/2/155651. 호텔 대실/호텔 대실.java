import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료시간 빠른순으로 정렬하는 pq
        
        for (String[] book : book_time) {
            String[] s = book[0].split(":");
            String[] e = book[1].split(":");
            
            int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            int end = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]) + 10;
            
            if (pq.isEmpty()) {
                answer++;
                pq.offer(end);
                continue;
            }
            
            int prev = pq.poll();
            if (start >= prev) pq.offer(end);
            else {
                answer++;
                pq.offer(end);
                pq.offer(prev);
            }
        }
        
        return answer;
    }
}