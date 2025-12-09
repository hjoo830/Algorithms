import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());

        int[][] sizes = new int[n][2];
        int[] rank =  new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sizes[i][0] = Integer.parseInt(st.nextToken());
            sizes[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sizes[i][0] < sizes[j][0] && sizes[i][1] < sizes[j][1]) rank[i]++;
            }
        }

        for (int r : rank) {
            System.out.print(r + 1 + " ");
        }
    }
}
