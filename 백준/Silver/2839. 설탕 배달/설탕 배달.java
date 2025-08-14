import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int order = scanner.nextInt();
        int num = 0;

        while (true) {
            if ( order%5 == 0 ) {
                System.out.println( order/5 + num );
                break;
            }
            else if ( order < 0 ){
                System.out.println("-1");
                break;
            }
            order -= 3;
            num++;
        }
    }
}