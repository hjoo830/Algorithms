import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade =  br.readLine();
        double answer = 0;

        if (grade.charAt(0) == 'A') answer = 4.0;
        else if (grade.charAt(0) == 'B') answer = 3.0;
        else if (grade.charAt(0) == 'C') answer = 2.0;
        else if (grade.charAt(0) == 'D') answer = 1.0;
        else answer = 0;

        if (answer != 0){
            if (grade.charAt(1) == '+') answer += 0.3;
            else if (grade.charAt(1) == '-') answer -= 0.3;
        }

        System.out.println(answer);
    }
}