import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());
            Map<String, List<String>> clothes = new HashMap<>();

            for (int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();

                if (!clothes.containsKey(category)){
                    clothes.put(category, new ArrayList<>());
                }
                clothes.get(category).add(name);
            }

            int count = 1;
            for (List<String> c : clothes.values()) {
                count *= (c.size() + 1);
            }
            System.out.println(count - 1);
        }
    }
}