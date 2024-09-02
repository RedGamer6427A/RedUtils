package dev.redgamer6427a.utils.performance;

import dev.redgamer6427a.utils.cli.CLI;
import dev.redgamer6427a.utils.math.MathExt;

import java.util.ArrayList;
import java.util.List;

public class Performance {

    public static long getCompletionMillis(Runnable runnable) {
        // Record the start time in milliseconds
        long startTime = System.currentTimeMillis();

        // Execute the code block
        runnable.run();

        // Record the end time in milliseconds
        long endTime = System.currentTimeMillis();

        // Calculate the time taken
        long duration = endTime - startTime;

        // Cast to int and return (beware of overflow, though unlikely in this context)
        return (long) duration;
    }
    public static long getAverageCompletionMillis(Runnable runnable) {
        return getAverageCompletionMillis(runnable, 500);
    }
    public static long getAverageCompletionMillis(Runnable runnable, int attempts) {
        List<Long> attemptTimes = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            long time = getCompletionMillis(runnable);
            CLI.info("Attempt #" + i + " took " +time +"ms.");
            attemptTimes.add(getCompletionMillis(runnable));
        }
        long average = (long) MathExt.average(attemptTimes.stream().mapToDouble(Long::doubleValue).toArray());
        return average;

    }

}
