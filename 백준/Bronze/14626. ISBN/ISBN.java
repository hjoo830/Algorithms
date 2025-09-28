import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String isbn = br.readLine();
		int[] arr = new int[13];
		int idx = 0;
		
		for (int i = 0; i < 13; i++) {
			if (isbn.charAt(i) != '*') arr[i] = isbn.charAt(i) - '0';
			else idx = i;
		}
		
		int sum = 0;
		for (int i = 0; i < 12; i += 2) {
			sum += arr[i];
		}
		for (int i = 1; i < 12; i += 2) {
			sum += arr[i] * 3;
		}
		
		if (idx % 2 == 0) {
			for (int i = 0; i < 10; i++) {
				if ((sum + i + arr[12]) % 10 == 0) {
					System.out.println(i);
				}
			}
		} else {
			for (int i = 0; i < 10; i++) {
				if ((sum + i * 3 + arr[12]) % 10 == 0) {
					System.out.println(i);
				}
			}
		}
		
	}
}