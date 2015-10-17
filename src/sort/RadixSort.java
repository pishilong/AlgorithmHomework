package sort;

import util.DecimalHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pishilong on 15/10/14.
 */
public class RadixSort extends Algorithm {

    final int SHIFTNUMBER = 255;
    final int RADIX = SHIFTNUMBER + 1;
    final int SHIFTWIDTH = 8;

    public void sort(long arr[]){
        numbers = arr;
        length = arr.length;

        radixSort(RADIX);

        printResult();
    }

    public void radixSort(int radix){
        long[] tmp = new long[length];
        int[] buckets =  new int[radix];

        boolean flag = true;

        int shiftLoc = 0;

        while(flag){
            flag = false;
            Arrays.fill(buckets, 0);
            System.arraycopy(numbers, 0, tmp, 0, length);

            for (int j = 0; j < length; j ++){
                int bucketIndex = (int)(tmp[j] >> shiftLoc & SHIFTNUMBER);
                if (bucketIndex > 0){
                    flag = true;
                }
                buckets[bucketIndex] ++ ;
            }

            for (int j = 1; j < radix; j++){
                buckets[j] += buckets[j - 1];
            }

            for (int m = length - 1; m >= 0; m --){
                int bucketIndex = (int)(tmp[m] >> shiftLoc & SHIFTNUMBER);
                numbers[--buckets[bucketIndex]] = tmp[m];
            }

            shiftLoc += SHIFTWIDTH;
        }

    }

    public static void main(String args[]){
        long numbers[] = DecimalHandler.generateUnsignInt((int) Math.pow(10, 7));
        long startTime = System.currentTimeMillis();
        (new RadixSort()).sort(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("基数排序耗时: " + (endTime - startTime) + "ms");
    }
}
