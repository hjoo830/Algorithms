import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			int count = upperBound(card, x) - lowerBound(card, x);
			sb.append(count).append(" ");
		}
		System.out.println(sb);
	}
	
	static int lowerBound(int[] arr, int x) {
	    int left = 0, right = arr.length;
	    while (left < right) {
	        int mid = (left + right) / 2;
	        if (arr[mid] < x) left = mid + 1;
	        else right = mid;
	    }
	    return left;
	}
	
	static int upperBound(int[] arr, int x) {
	    int left = 0, right = arr.length;
	    while (left < right) {
	        int mid = (left + right) / 2;
	        if (arr[mid] <= x) left = mid + 1;
	        else right = mid;
	    }
	    return left;
	}
}