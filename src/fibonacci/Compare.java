package fibonacci;

/**
 * Created by pishilong on 15/9/30.
 */
public class Compare {
    public static void main(String args[]){
        int numbers[] = {10, 20, 30, 40, 50};
        for (int number : numbers){
            long startTime = System.currentTimeMillis();
            System.out.println("Fibonacci(" + number + ") = " + Linear.performance(number));
            long endTime = System.currentTimeMillis();
            System.out.println("Linear计算时间: " + (endTime - startTime) + "ms");
            startTime = System.currentTimeMillis();
            System.out.println("Fibonacci(" + number + ") = " + Recursive.performance(number));
            endTime = System.currentTimeMillis();
            System.out.println("Recursive计算时间: " + (endTime - startTime) + "ms");
        }
    }
}
