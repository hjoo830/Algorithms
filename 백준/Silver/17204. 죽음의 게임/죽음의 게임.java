import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());

        int[] next = new int[n];
        for (int i = 0; i < n; i++) next[i] = Integer.parseInt(br.readLine());
        boolean[] v = new boolean[n];
        int cur = 0;
        int answer = 0;

        while (!v[cur]) {
            if (cur == k) {
                System.out.println(answer);
                return;
            }
            v[cur] = true;
            cur = next[cur];
            answer++;
        }

        System.out.println(-1);
    }
}