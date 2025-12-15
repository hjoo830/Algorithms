import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (Math.pow(n, 2) <= Math.pow(10, 8)) System.out.println("Accepted");
        else System.out.println("Time limit exceeded");
    }
}