import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] names = str.split("-");
		
		for (String name : names) {
			System.out.print(name.charAt(0));
		}
	}
}
