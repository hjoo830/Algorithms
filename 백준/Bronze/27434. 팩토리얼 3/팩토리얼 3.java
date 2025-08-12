import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(f(1, n));
    }
    
    static BigInteger f(int a, int n) {
    	BigInteger num = BigInteger.valueOf(a);
		if (a < n) {
			int b = (a + n) / 2;
			num = f(a, b).multiply(f(b + 1, n));
		}
		return num;

    }
}