import java.util.*; 

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int citation = citations[n - 1 - i];
            if (i + 1 <= citation) h = i + 1;
            else break;
        }
        
        return h;
    }
}