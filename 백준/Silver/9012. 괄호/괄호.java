import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String ps = sc.next();
			Stack<Character> stack = new Stack<>();
			boolean flag = true;

			for (int i = 0; i < ps.length(); i++) {
				char p = ps.charAt(i);
				if (stack.isEmpty() && p == ')') {
					flag = false;
				} else {
					if (p == '(') {
						stack.add(p);
					} else {
						stack.pop();
					}
				}
			}
			if (flag && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}