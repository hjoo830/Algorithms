import java.io.*;
import java.util.*;

public class Main {
	static int[] nums;
	static boolean flag;
	static List<Integer> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		nums = new int[9];
		for(int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0, new ArrayList<>(), 0);
		
		for(int i = 0; i < 7; i++) {
			System.out.println(answer.get(i));
		}
	}
	
	static void dfs(int s, List<Integer> path, int sum) {
		if (flag) {
			return;
		}
		
		if(path.size() == 7) {
			if(sum == 100) {
				flag = true;
				answer = new ArrayList<>(path);
			}
			return;	
		}
		
		for(int i = s; i < 9; i++) {
			path.add(nums[i]);
			dfs(i + 1, path, sum + nums[i]);
			path.remove(path.size() - 1);
		}
	}
}