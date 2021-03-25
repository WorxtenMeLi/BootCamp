package PracticaIntegradora;
import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quickSort(arr,0,arr.length-1,c);
    }
    private <T> void quickSort(T[] A, int low, int high,Comparator<T> c) {
        if (low < high+1) {
            int p = partition(A, low, high,c);
            quickSort(A, low, p-1,c);
            quickSort(A, p+1, high,c);
        }
    }
    private void swap(Object[] A, int index1, int index2) {
        Object temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
    // returns random pivot index between low and high inclusive.
    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }
    // moves all n < pivot to left of pivot and all n > pivot
    // to right of pivot, then returns pivot index.
    private <T> int partition(T[] A, int low, int high, Comparator<T> c) {
        swap(A, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (c.compare(A[i],A[low])<0) {
                swap(A, i, border++);
            }
        }
        swap(A, low, border-1);
        return border-1;
    }
}
