import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int numResult = a + b - c;
        String str = "" + a;
        str += b;
        int strResult = Integer.parseInt(str) - c;
        
        System.out.println(numResult);
        System.out.println(strResult);
        
        br.close();
	}
}
