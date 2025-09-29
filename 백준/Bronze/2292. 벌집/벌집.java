import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cell = 1;
		int depth = 1;
		
		while (n > cell) {
			cell += 6 * depth;
			depth++;
		}
		System.out.println(depth);
	}
}