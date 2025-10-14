import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		String[] str = new String[n];
		
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 0; i < str[0].length(); i++) {
			char c = str[0].charAt(i);
			boolean same = true;
			
			for (int j = 0; j < n; j++) {
				if (str[j].charAt(i) != c) {
					same = false;
				}
			}
			
			if (same) {
				sb.append(c);
			} else {
				sb.append("?");				
			}
		}
		
		System.out.println(sb);
	}
}
