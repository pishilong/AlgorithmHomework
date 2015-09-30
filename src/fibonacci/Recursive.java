package fibonacci;

/**
 * Created by pishilong on 15/9/30.
 */
public class Recursive {
    public static long performance(int n){
        if (n == 1 || n == 2) return 1;
        return performance(n - 1) + performance(n - 2);
    }
}
