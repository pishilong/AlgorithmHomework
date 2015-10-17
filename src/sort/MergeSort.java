package sort;

/**
 * Created by pishilong on 15/10/14.
 */
public class MergeSort extends Algorithm {
    private long[] aux;

    public void sort(long arr[]){
        numbers = arr;
        length = arr.length;

        aux = new long[length];

        mergeSort(0, length - 1);
        printResult();
    }

    public void mergeSort(int left, int right){
        if (left >= right) return;

        int middle = (left + right) / 2;

        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, middle, right);
    }

    private void merge(int left, int middle, int right){
        for (int i = left; i <= right; i++){
            aux[i] = numbers[i];
        }

        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right){
            if (aux[i] <= aux[j]){
                numbers[k] = aux[i];
                i ++;
            } else {
                numbers[k] = aux[j];
                j ++;
            }
            k ++;
        }

        while (i <= middle) {
            numbers[k] = aux[i];
            k ++;
            i ++;
        }
    }

}
