import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int data = 1;
			
			for (int i = 0; i < b; i++) {
				data *= a;
				data %= 10;
			}
			
			System.out.println((data == 0) ? 10 : data);
		}
	}
}
