package util;

import java.text.DecimalFormat;
import java.util.DoubleSummaryStatistics;
import java.util.Random;

/**
 * Created by pishilong on 15/9/30.
 */
public class DecimalHandler {
    public static double getFormattedRandomDouble(int bound, int precision){
        Random random = new Random();
        String format = "#.";
        while (precision > 0){
            format += "0";
            precision --;
        }
        DecimalFormat df = new DecimalFormat(format);
        double originDouble = random.nextDouble()*bound;
        String formattedString = df.format(originDouble);
        return Double.valueOf(formattedString);
    }
}
