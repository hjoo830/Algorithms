import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[k];
		for (int i = 0; i < k; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(lan);
		
		System.out.println(binarySearch(lan, n, lan[lan.length - 1]));
	}
	
	static long binarySearch(int[] arr, int n, int maxH) {	
		long l = 1;
		long r = (long) maxH + 1;
		
		while (l < r) {
			long mid = (l + r) / 2;
			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i] / mid;				
			}
			if (sum >= n) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l - 1;
	}
}
