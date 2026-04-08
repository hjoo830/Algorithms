import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] burger = new int[3];
        int[] drink = new int[2];

        for (int i = 0; i < 3; i++) {
            burger[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(burger);
        Arrays.sort(drink);

        System.out.println(burger[0] + drink[0] - 50);
    }
}