import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dfs(new ArrayList<>(), 1);
		System.out.println(sb);
	}
	
	static void dfs(List<Integer> path, int s) {
		if(path.size() == m) {
			for(int i = 0; i < m; i++) {
				sb.append(path.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = s; i <= n; i++) {
			path.add(i);
			dfs(path, i);
			path.remove(path.size() - 1);
		}
	}
}