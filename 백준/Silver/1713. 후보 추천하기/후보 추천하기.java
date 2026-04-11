import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Candidate[] photo = new Candidate[n];
        int t = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int candi = Integer.parseInt(st.nextToken());
            boolean flag = false;

            for (int j = 0; j < n; j++) {
                if (photo[j] != null && photo[j].num == candi) {
                    photo[j].count++;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                t++;
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (photo[j] == null) {
                    photo[j] = new Candidate(candi, 1, t);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                t++;
                continue;
            }

            int target = 0;
            for (int j = 1; j < n; j++) {
                if (photo[j].count < photo[target].count) {
                    target = j;
                } else if (photo[j].count == photo[target].count) {
                    if (photo[j].time < photo[target].time) {
                        target = j;
                    }
                }
            }

            photo[target] = new Candidate(candi, 1, t);
            t++;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (photo[i] != null) {
                answer.add(photo[i].num);
            }
        }

        Collections.sort(answer);

        for (int num : answer) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }
}

class Candidate {
    int num, count, time;

    Candidate(int num, int count, int time) {
        this.num = num;
        this.count = count;
        this.time = time;
    }
}