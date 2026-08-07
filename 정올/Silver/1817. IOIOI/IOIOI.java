import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;
        int count = 0;
        int i = 0;
        while (i < m - 2) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                count++;
                if (count == n) {
                    answer++;
                    count--;
                }
                i += 2;
            } else {
                count = 0;
                i++;
            }
        }

        System.out.println(answer);
    }
}