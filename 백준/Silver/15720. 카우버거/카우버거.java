import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] burger = new int[b];
        int[] side = new int[c];
        int[] drink = new int[d];
        int price = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
            price += burger[i];
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            price += side[i];
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
            price += drink[i];
        }

        Arrays.sort(burger);
        Arrays.sort(side);
        Arrays.sort(drink);

        int sale = 0;
        int set = Math.min(b, Math.min(c, d));

        for (int i = 0; i < set; i++) {
            int sum = burger[b - 1 - i] + side[c - 1 - i] + drink[d - 1 - i];
            sale += (int)(sum * 0.9);
        }

        for (int i = 0; i < b - set; i++) sale += burger[i];
        for (int i = 0; i < c - set; i++) sale += side[i];
        for (int i = 0; i < d - set; i++) sale += drink[i];

        System.out.println(price);
        System.out.println(sale);
    }
}
