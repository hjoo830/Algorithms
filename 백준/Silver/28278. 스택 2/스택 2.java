import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1){
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (command == 2){
                if (stack.isEmpty()) System.out.println(-1);
                else {
                    int c = stack.pop();
                    System.out.println(c);
                }
            } else if (command == 3){
                System.out.println(stack.size());
            } else if (command == 4){
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (command == 5){
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}