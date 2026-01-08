import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            cnt[x]++;
        }

        for (int i = 1; i <= 10000; i++) {
            int c = cnt[i];
            while (c-- > 0) {
                sb.append(i).append('\n');

                if (sb.length() >= 1 << 16) {
                    System.out.print(sb);
                    sb.setLength(0);
                }
            }
        }

        System.out.print(sb);
    }
}
