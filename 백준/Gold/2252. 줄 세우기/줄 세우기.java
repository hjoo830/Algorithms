import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 정점, 간선
	static ArrayList<Integer>[] graph;
	static int[] inD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		inD = new int[N + 1]; // 진입 차수

		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int from, to;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			inD[to]++;
		}

		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(inD[i] == 0) { // 진입 차수가 0인 정점을 큐에 삽입
				q.offer(i);
			}
		}

		// 큐사이즈가 0이면 위상정렬 불가
		ArrayList<Integer> result = new ArrayList<>();

		while(!q.isEmpty()) {
			int node = q.poll();
			result.add(node);

			for(int i : graph[node]) {
				inD[i]--; // 인접한 정점(i)의 진입차수를 1 감소시켜 간선 제거
				if(inD[i] == 0) {
					q.offer(i); // 간선 제거 후 진입차수가 0이 되었으면 큐에 넣기
				}
			}
		}

		for(int ans : result) {
			System.out.print(ans + " ");
		}
		System.out.println();
	}
}