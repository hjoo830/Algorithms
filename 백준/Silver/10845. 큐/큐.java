import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                q.offer(x);
            } else if (command.equals("pop")){
                if (q.isEmpty()) System.out.println(-1);
                else {
                    int c = q.poll();
                    System.out.println(c);
                }
            } else if (command.equals("size")){
                System.out.println(q.size());
            } else if (command.equals("empty")){
                if (q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("front")){
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            } else if (command.equals("back")){
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peekLast());
            }
        }
    }
}