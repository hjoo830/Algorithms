import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			long n = Long.parseLong(br.readLine());
			int answer = 0;
			while (n != 2) {
                long sqrt = (long) Math.sqrt(n);

                if (sqrt * sqrt == n) {
					n = sqrt;
					answer++;
				} else {
					long nextSquare = (sqrt + 1) * (sqrt + 1);
                    long diff = nextSquare - n;
                    n = nextSquare;
                    answer += diff;
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
		}
	}
}
