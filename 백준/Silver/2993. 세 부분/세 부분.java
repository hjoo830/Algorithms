import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String min = "z";
        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String tmp = reverse(word.substring(0, i)) + reverse(word.substring(i, j)) + reverse(word.substring(j));
                if (min.compareTo(tmp) > 0) min = tmp;
            }
        }
        System.out.println(min);
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}