import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekdays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int day = y;
        for (int i = 0; i < x; i++) {
            day += days[i];
        }

        System.out.println(weekdays[day % 7]);
    }
}