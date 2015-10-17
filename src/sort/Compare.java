package sort;

import util.DecimalHandler;

/**
 * Created by pishilong on 15/10/14.
 */
public class Compare {
    public static void main(String args[]){
        double counts[] = {
                Math.pow(10, 1), Math.pow(10, 2),
                Math.pow(10, 3), Math.pow(10, 4),
                Math.pow(10, 5), Math.pow(10, 6),
                Math.pow(10, 7), Math.pow(10, 8),
                2 * Math.pow(10, 8)//Math.pow(10, 9)
        };

        for (double count : counts){
            long numbers[] = DecimalHandler.generateUnsignInt((int)count);

            System.out.println("---------------开始排序" + (int)count + "个32位无符号整数----------");
            /*
            String s = "生成的随机数为：";
            for (long number : numbers){
                s += number + ",";
            }
            System.out.println(s);
            */
            long startTime = System.currentTimeMillis();
            if (numbers.length < 10000000) {
                InsertSort is = new InsertSort();
                is.sort(numbers);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("插入排序耗时: " + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            QuickSort qs = new QuickSort();
            qs.sort(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("快速排序耗时: " + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            MergeSort ms = new MergeSort();
            ms.sort(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("归并排序耗时: " + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            RadixSort rs = new RadixSort();
            rs.sort(numbers);
            endTime = System.currentTimeMillis();
            System.out.println("基数排序耗时: " + (endTime - startTime) + "ms");
        }


    }
}
