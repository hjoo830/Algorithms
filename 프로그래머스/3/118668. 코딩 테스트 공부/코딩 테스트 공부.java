import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = 0;
        int targetCop = 0;

        for (int[] problem : problems) {
            targetAlp = Math.max(targetAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);

        // dp[a][c] = 알고력이 a이고 코딩력이 c가 되기까지 필요한 최소 시간
        int[][] dp = new int[targetAlp + 1][targetCop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        for (int a = alp; a <= targetAlp; a++) {
            for (int c = cop; c <= targetCop; c++) {
                if (dp[a][c] == Integer.MAX_VALUE) continue;

                // 알고력 공부
                if (a < targetAlp)
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);

                // 코딩력 공부
                if (c < targetCop)
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);

                // 풀 수 있는 문제 풀기
                for (int[] p : problems) {
                    if (a >= p[0] && c >= p[1]) {
                        int nextAlp = Math.min(targetAlp, a + p[2]);
                        int nextCop = Math.min(targetCop, c + p[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[a][c] + p[4]);
                    }
                }
            }
        }

        return dp[targetAlp][targetCop];
    }
}