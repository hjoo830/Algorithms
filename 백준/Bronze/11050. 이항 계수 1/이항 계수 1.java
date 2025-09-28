import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 1;
		
		for (int i = n; i > n - k; i--) {
			ans *= i;
		}
		for (int i = k; i > 0; i--) {
			ans /= i;
		}
		System.out.println(ans);
	}
}