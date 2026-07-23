class Solution {
    public int[] solution(int[][] edges) {
        int n = 0;
        int[] inD = new int[1000001];
        int[] outD = new int[1000001];

        for(int[] edge : edges) {
            outD[edge[0]]++;
            inD[edge[1]]++;
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }

        int total = 0;
        int stick = 0;
        int donut = 0;
        int eight = 0;
        int created = 0;
        
        for (int i = 1; i <= n; i++) {
            if (inD[i] >= 2 && outD[i] >= 2) eight++;
            else if (outD[i] == 0 && inD[i] > 0) stick++;
            else if (outD[i] >= 2 && inD[i] == 0) {
                created = i;
                total = outD[i];
            }
        }
        
        donut = total - (eight + stick);
        int[] answer = {created, donut, stick, eight};
        return answer;
    }
}

// 생성한 정점은 inD가 0, outD가 그래프 개수 (그래프 개수 >= 2)
// 막대 그래프에는 outD가 0, inD가 양수인 점이 하나 있음 -> 그런 정점의 개수 = 막대 그래프의 개수
// 8자 그래프에는 inD가 2, outD가 2인 중앙 정점이 하나 있음 -> 그런 정점의 개수 = 8자 그래프의 개수
// 도넛 그래프는 전체 개수에서 나머지 빼기