import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int newA = Integer.parseInt(new StringBuilder(a).reverse().toString());
        int newB = Integer.parseInt(new StringBuilder(b).reverse().toString());

        System.out.println(Math.max(newA, newB));
    }
}