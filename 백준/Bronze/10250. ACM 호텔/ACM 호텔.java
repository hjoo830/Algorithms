import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int floor = (n % h == 0) ? h : (n % h);
            int ho = (n % h == 0) ? (n / h) : (n / h + 1);
            if (ho < 10) {
                System.out.println(floor + "0" + ho);
            } else {
                System.out.println(floor + "" + ho);
            }
        }
        br.close();
	}
}
