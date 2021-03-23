public class SortUtil{
    public static void ordenar(Precedable arr[]){
        int i, j,temp;
        Precedable aux;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                temp=arr[j].precedeA((Precedable) arr[j+1]);
                if (temp>0) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }
}
