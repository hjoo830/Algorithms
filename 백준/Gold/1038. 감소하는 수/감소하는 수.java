import java.io.*;
import java.util.*;

public class Main {
	static List<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n < 10) {
			System.out.println(n);
			return; 
		}
		
		for(int i = 0; i < 10; i++) {			
			bt(i, i);
		}
		
		Collections.sort(list);
		
		if (n < list.size()) {			
			System.out.println(list.get(n));
		} else {
			System.out.println(-1);
		}
		
	}
	
	static void bt(long num, int last) {	
		list.add(num);
		
		for (int i = 0; i < last; i++) {
			bt(num * 10 + i, i);
		}
	}
}
