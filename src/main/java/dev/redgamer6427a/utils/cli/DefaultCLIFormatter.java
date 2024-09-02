package dev.redgamer6427a.utils.cli;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * The default Formatter that comes with RedUtils
 */
public class DefaultCLIFormatter extends Formatter {

    /**
     * The time and Date pattern
     */
    private static final String PATTERN = "HH:mm:ss - dd-MM-yyyy";

    /**
     * @param record the log record to be formatted.
     * @return the message for the CLI
     */
    @Override
    public String format(LogRecord record) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        String date = dateFormat.format(new Date(record.getMillis()));
        String style = "";

        if(record.getLevel().equals(Level.INFO)){
            style = CLIStyle.FORE_BRIGHT_GREEN.representation();
        } else if(record.getLevel().equals(Level.WARNING)) {
            String rgbColor = "ff4d00";
            style = String.format("\u001B[38;2;%d;%d;%dm",
                    Integer.parseInt(rgbColor.substring(0, 2), 16),
                    Integer.parseInt(rgbColor.substring(2, 4), 16),
                    Integer.parseInt(rgbColor.substring(4, 6), 16));
        } else if(record.getLevel().equals(Level.SEVERE)) {
            style = CLIStyle.FORE_BRIGHT_RED.representation();
        }

        return String.format("[%s] [%s] [%s%s%s"+CLIStyle.RESET.representation()+"] %s%s%n"+CLIStyle.RESET.representation(),
                record.getLoggerName(),
                date,
                style,
                record.getLevel().getName(),
                style,

                style,
                record.getMessage());

    }
}
