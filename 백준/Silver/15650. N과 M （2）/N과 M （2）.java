import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dfs(new ArrayList<>(), 1);
	}
	
	static void dfs(List<Integer> path, int s) {
		if(path.size() == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(path.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = s; i <= n; i++) {
			path.add(i);
			dfs(path, i + 1);
			path.remove(path.size() - 1);
		}
	}
}
