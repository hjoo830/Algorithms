import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[9][9];
        int max = 0;
        int r = 1;
        int c = 1;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    r = i + 1;
                    c = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(r + " " + c);
    }
}