import java.io.*;
import java.util.*;

public class Solution {
	static int n, min, cnt;
	static int[][] sList;
	static List<Person> pList;
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());	
			pList = new ArrayList<>();
			sList = new int[2][];
			min = Integer.MAX_VALUE;

			for (int i = 0, k = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int c = Integer.parseInt(st.nextToken());
					if (c == 1) pList.add(new Person(i, j));
					else if (c > 1) sList[k++] = new int[] {i, j, c};
				}
			}
			
			cnt = pList.size();
			selected = new int[cnt];
			
			divide(0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void divide(int index) {
		if(index == cnt) {
			makeList();
			return;
		}
		selected[index] = 0;
		divide(index+1);
		
		selected[index] = 1;
		divide(index+1);
	}

	static void makeList() {
		ArrayList<Person>[] list = new ArrayList[] {new ArrayList<Person>(), new ArrayList<Person>()};	
		
		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			int no = selected[i];
			
			p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);
		}

		int timeA = processDown(list[0], sList[0][2]);
		int timeB = processDown(list[1], sList[1][2]);
		int res = Math.max(timeA, timeB);
		min = Math.min(min, res);
	}
	
	private static int processDown(ArrayList<Person> list, int height) {
		if(list.size() == 0) return 0;
		
		Collections.sort(list);
		
		int size = list.size() + 3;
		int[] D = new int[size];
		
		for (int i = 3; i < size; i++) {
			Person p = list.get(i - 3);
			if(D[i - 3] <= p.arrivalTime+1) D[i] = p.arrivalTime + 1 + height;
			else D[i] = D[i - 3] + height;
		}
		
		return D[size - 1];
	}
}

class Person implements Comparable<Person>{
	int r, c, arrivalTime;

	public Person(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(Person o) {
		return Integer.compare(this.arrivalTime, o.arrivalTime);
	}
}