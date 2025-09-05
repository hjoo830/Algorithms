import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static ArrayList<Atom> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken())*2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Atom(x, y, d, e));
			}
			sb.append("#").append(tc).append(" ").append(makeBoomPair()).append("\n");
		}
        System.out.println(sb);
	}

	private static int makeBoomPair() {
		Collections.sort(list);
		ArrayList<Pair> boomList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				Atom a = list.get(i);
				Atom b = list.get(j);
				
				if(a.x == b.x) {
					if(a.dir == 0 && b.dir == 1) {
						boomList.add(new Pair(i, j, Math.abs(a.y - b.y) / 2));
					}
				}

				if(a.y == b.y) {
					if(a.dir == 3 && b.dir == 2) {
						boomList.add(new Pair(i, j, Math.abs(a.x - b.x) / 2));
					}
				}

				if(a.x - a.y == b.x - b.y) {
					if(a.dir == 3 && b.dir == 1 || a.dir == 0 && b.dir == 2) {
						boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
					}
				}

				if(a.x + a.y == b.x + b.y) {
					if(a.dir == 1 && b.dir == 2 || a.dir == 3 && b.dir == 0) {
						boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
					}
				}
			}
		}
		
		return getTotalEnergy(boomList);
	}

	private static int getTotalEnergy(ArrayList<Pair> boomList) {
		Collections.sort(boomList);
		int INF = Integer.MAX_VALUE;
		int boomTimes[] = new int[N];
		Arrays.fill(boomTimes, INF);
		int sum = 0;
		
		for (Pair p : boomList) {
			if(boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) continue;
			
			if(boomTimes[p.i] == INF) {
				boomTimes[p.i] = p.time;
				sum += list.get(p.i).e;
			}
			
			if(boomTimes[p.j] == INF) {
				boomTimes[p.j] = p.time;
				sum += list.get(p.j).e;
			}
		}
		
		return sum;
	}

}

class Atom implements Comparable<Atom>{
	int x, y, dir, e;

	public Atom(int x, int y, int dir, int e) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.e = e;
	}

	@Override
	public int compareTo(Atom o) {
		return this.x < o.x ? -1 : (this.x != o.x ? Integer.compare(this.x, o.x) : Integer.compare(this.y, o.y));
	}
}

class Pair implements Comparable<Pair>{
	int i, j, time;

	public Pair(int i, int j, int time) {
		super();
		this.i = i;
		this.j = j;
		this.time = time;
	}
	
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.time, o.time);
	}
}