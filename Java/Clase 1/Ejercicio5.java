import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa n: ");
        int n = scan.nextInt();
        System.out.println("Ingresa m: ");
        int m = scan.nextInt();
        System.out.println("Ingresa d: ");
        int d = scan.nextInt();
        exercise5(n, m, d);
        scan.close();
    }

    //Aux function
    public static int countOfRepetitiveNumber(int n, int d) {
        int count = 0;

        while (n > 0) {
            count = (n % 10 == d) ? count + 1 : count;
            n = n / 10;
        }

        return count;
    }

    public static void exercise5(int n, int m, int d) {
        int aux = 0;
        int count;
        for (int i = 0; aux != n; i++) {
            count = countOfRepetitiveNumber(i, d);
            if (count >= m) {
                aux++;
                System.out.println(i);
            }
        }
    }
}
