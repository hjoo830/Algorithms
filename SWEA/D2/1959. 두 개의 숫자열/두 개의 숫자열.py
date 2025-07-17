import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                a.add(num);
            }
            for (int i = 0; i < m; i++) {
                int num = sc.nextInt();
                b.add(num);
            }
                        
            int maxSum = 0;
            if (n < m){
	            for (int i = 0; i <= m - n; i++) {
                	int s = 0;
                    for (int j = 0; j < n; j++) {
                        s += a.get(j) * b.get(i+j);
                    }
                    maxSum = Math.max(maxSum, s);
                }
            } else {
                for (int i = 0; i <= n - m; i++) {
                	int s = 0;
                    for (int j = 0; j < m; j++) {
                        s += a.get(i+j) * b.get(j);
                    }
                    maxSum = Math.max(maxSum, s);
                }
            }
            System.out.printf("#%d %d\n", test_case, maxSum);
		}
	}
}