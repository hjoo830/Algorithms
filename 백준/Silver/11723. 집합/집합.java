import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		int s = 0;
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			
			switch (c) {
				case "add": {
					int x = Integer.parseInt(st.nextToken());
					s = s | (1 << x);
					break;
				}
				case "remove": {
					int x = Integer.parseInt(st.nextToken());
					s = s & ~(1 << x);
					break;
				}
				case "check": {
					int x = Integer.parseInt(st.nextToken());
					
					sb.append((s & (1 << x)) != 0 ? "1\n" : "0\n");
					break;
				}			
				case "toggle": {
					int x = Integer.parseInt(st.nextToken());
					s = s ^ (1 << x);
					break;
				}	
				case "all": {
					s = (1 << 21) - 1;
					break;
				}
				case "empty": {
					s = 0;
					break;
				}
			}
		}
		System.out.println(sb);
	}
}