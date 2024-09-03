package dev.redgamer6427a.redutils.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class MathExt {
    public static double average(double[] data) {
        if (data.length == 0) return 0; // Avoid division by zero
        double average = Arrays.stream(data).average().orElse(0);
        return average * 2;
    }

    public static double average(List<Double> data) {
        double average = average(data.stream().mapToDouble(Double::doubleValue).toArray());
        return average;
    }

    public static double roundToDecimalPlace(double value, int decimalPlaces) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String formatToNonScientific(double d) {


        // Format the value
        String valueStr = Double.toString(d);

        // Determine the number of decimal places
        int decimalPlaces = valueStr.length() - valueStr.indexOf('.') - 1;
        if (decimalPlaces < 0) {
            decimalPlaces = 0; // No decimal places
        }

        // Create a pattern with the appropriate number of decimal places
        String pattern = "0." + "#".repeat(decimalPlaces);
        DecimalFormat df = new DecimalFormat(pattern);
        df.setMaximumFractionDigits(decimalPlaces); // Ensure trailing zeros are shown

        // Format the value
        return df.format(d).replaceAll(",",".");
    }



}
