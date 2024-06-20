import java.util.Scanner;

public class Somatoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();
        scanner.close();

        System.out.println(somatoria(n1,n2));
    }

    public static double somatoria (double n1, double n2){
        return n1+n2;
    }
}