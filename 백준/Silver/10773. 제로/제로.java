import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}
		
		int sum = 0;
		for (int n : stack) {
			sum += n;
		}
		
		System.out.println(sum);
	}
}
