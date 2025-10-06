import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] arr2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }
        
        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i] == arr2[j]){
                    System.out.print(j + " ");
                    arr2[j]--;
                    break;
                }
            }
        }
    }
}