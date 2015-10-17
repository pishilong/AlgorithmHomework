package sort;

/**
 * Created by pishilong on 15/10/14.
 */
public class QuickSort extends Algorithm {
    public void sort(long arr[]){
        numbers = arr;
        length = arr.length;
        quickSort(0, length - 1);
        printResult();
    }

    public void quickSort(int left, int right){
        if (left > right) return;

        int index = partition(left, right);

        if (left < index - 1){
            quickSort(left, index - 1);
        }
        if (index < right){
            quickSort(index, right);
        }
    }

    public int partition(int left, int right){
        int i = left, j = right;
        long tmp;
        long pivot = numbers[(left + right) / 2];
        while (i <= j){
            while (numbers[i] < pivot) i ++;
            while (numbers[j] > pivot) j --;
            if (i <= j) {
                tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;
                i ++;
                j --;
            }
        }
        return i;
    }
}
