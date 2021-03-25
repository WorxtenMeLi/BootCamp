package PracticaIntegradora;
import java.util.Comparator;
public class DemorSort {
    public static void main(String[] args) throws Exception {
        Sorter sorter= (Sorter) MiFactory.getInstance("sorter");
        Integer[] arreglo = new Integer[100000];
        for (int i = arreglo.length; i > 0; i--) {
            arreglo[i-1]= i;
        }
        Comparator<Integer> intComp = (a,b)->a-b;
        Timer t = new Timer();
        t.setStartTime((double) System.currentTimeMillis());
        sorter.sort(arreglo, intComp);
        t.setEndTime((double) System.currentTimeMillis());
        System.out.println("Tiempo: "+t.elapsedTime());
    }
}
