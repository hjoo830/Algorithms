import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
           int n = Integer.parseInt(br.readLine());
            System.out.println(n * (n+1) / 2 + " " + (int)Math.pow(n, 2) + " " + (int)(Math.pow(n, 2) + n));
        }
    }
}