package sort;

/**
 * Created by pishilong on 15/10/14.
 */
public class InsertSort extends Algorithm {
    public void sort(long arr[]) {
        numbers = arr;
        length = arr.length;
        int i, j;
        long v;
        for (i = 1; i < length; i++) {
            v = numbers[i];
            j = i;
            while (j > 0 && numbers[j - 1] > v) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = v;

        }
        printResult();
    }
}
