import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;

            while (l < r) {
                if (i == l) {
                    l++;
                    continue;
                } else if (i == r) {
                    r--;
                    continue;
                }

                if (nums[l] + nums[r] > nums[i]) r--;
                else if (nums[l] + nums[r] < nums[i]) l++;
                else {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}