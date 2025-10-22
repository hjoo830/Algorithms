import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int count = 0;
		int sum = 0;

		for(int i = 1; i <= b; i++) {
			for(int j = 1; j <= i; j++) {
				count++;

				if(a <= count && count <= b) {
					sum += i;
				}
			}
		}

		System.out.println(sum);
	}
}
