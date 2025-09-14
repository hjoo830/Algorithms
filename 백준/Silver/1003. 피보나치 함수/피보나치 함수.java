import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] zero = new int[41];
			int[] one = new int[41];

			zero[0] = 1;
			one[1] = 1;
			
			for (int i = 2; i <= 40; i++) {
				zero[i] = zero[i - 1] + zero[i - 2];
				one[i] = one[i - 1] + one[i - 2];
			}
			
			System.out.println(zero[n] + " " + one[n]);
		}
	}
}