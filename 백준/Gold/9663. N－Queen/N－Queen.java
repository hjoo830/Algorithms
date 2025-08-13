import java.io.*;

public class Main {
	static int n, answer;
	static boolean[] col, slash, bSlash;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new boolean[n + 1];
		slash = new boolean[2 * n + 1]; // 합이 일정한 성질(2~2n)
		bSlash = new boolean[2 * n]; // 차가 일정한 성질(-n-1~n-1)
		
		answer = 0;
		setQueen(1);
		System.out.println(answer);
		
	}
	
	static void setQueen(int row) { // row: 퀸을 놓아야하는 현재 행
		
		if(row > n) {
			++answer;
			return;
		}
		
		for (int c = 1; c <= n; c++) {
			if (col[c] || slash[row + c] || bSlash[row - c + n]) {
				// 이미 퀸이 놓아져있다
				continue;
			}
			
			// 퀸 배치 내용을 자료구조에 기록
			col[c] = slash[row + c] = bSlash[row - c + n] = true;
			// 다음 퀸 놓기
			setQueen(row + 1);
			col[c] = slash[row + c] = bSlash[row - c + n] = false;
			
		}
	}
}