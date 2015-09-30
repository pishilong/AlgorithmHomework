package fibonacci;

/**
 * Created by pishilong on 15/9/30.
 */
public class Linear {
    public static long performance(int n){
        long[] result = new long[n + 1];
        result[1] = result[2] = 1;
        for (int i = 3; i < n + 1; i++){
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
