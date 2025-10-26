import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] divisor = new int[n];
        for (int i = 0; i < n; i++) {
            divisor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(divisor);

        int answer = divisor[0] * divisor[n - 1];
        System.out.println(answer);
    }
}