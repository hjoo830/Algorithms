import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int size = Integer.parseInt(st.nextToken(" "));
        int num = Integer.parseInt(st.nextToken(" "));
        int change = 0;

        List<Integer> use = Arrays.asList(br.readLine().split("\\s+")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> using = new ArrayList<>();
        for (int i=0; i < num;i++){
            int now = use.get(i);
            if (!using.contains(now)){
                if (using.size() == size) {
                    change++;
                    int farthestIndex = -1, replaceIndex = -1; // 가장 오랜 시간 동안 사용되지 않을 것 같은 페이지의 인덱스
                    for (int frame : using) {
                        List<Integer> subList = use.subList(i+1, use.size());
                        int nextIndex = subList.contains(frame) ? subList.indexOf(frame) : Integer.MAX_VALUE;
                        if (nextIndex > farthestIndex) {
                            farthestIndex = nextIndex;
                            replaceIndex = using.indexOf(frame);
                        }
                    }
                    if (replaceIndex == -1) replaceIndex = 0;
                    using.set(replaceIndex, now);
                } else {
                    using.add(now);
                }
            }
        }
        System.out.println(change);
    }
}