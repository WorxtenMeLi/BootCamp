import java.util.Scanner;
public class Ejercicio2 {

    public static void main( String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el numero n de multiplos: ");
        int n = scan.nextInt();
        System.out.println("Ingresa el numero m: ");
        int m = scan.nextInt();
        int i = 0,x=1;
        while (i<n){
            if(esMultiplo(x,m)) {
                System.out.println(x);
                i++;
            }
            x++;
        }
        scan.close();
    }
    public static boolean esMultiplo(int x, int m){
        return x%m==0;
    }
}
