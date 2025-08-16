import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(tree);
		
		System.out.println(binarySearch(tree, m, tree[tree.length - 1]));
	}
	
	static int binarySearch(int[] arr, int m, int maxH) {	
		int l = 0;
		int r = maxH;
		int answer = 0;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;					
				}
			}
			if (sum >= m) {
				answer = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return answer;
	}
}
