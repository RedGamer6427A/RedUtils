package dev.redgamer6427a.redutils.cli;



import org.jetbrains.annotations.Nullable;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;

public class CLI {

    /**
     * The Cli to work with in the static methods.
     */
    private static CLI CLI;

    /**
     * The logger of the instance.
     */
    private final Logger logger;

    /**
     * The CLI constructor. Best initialized in the Main thread on entry. Puts the Instance into {@link dev.redgamer6427a.redutils.cli.CLI#CLI}
     * @param loggerName the name of the logger. If null, it creates an anonymous logger
     */
    public CLI(@Nullable String loggerName) {
        if(CLI == null){
            CLI = this;
            if(loggerName != null){
                this.logger = Logger.getLogger(loggerName);
            } else {
                this.logger = Logger.getAnonymousLogger();
            }
            ConsoleHandler consoleHandler = new ConsoleHandler();

            // Set the custom formatter
            consoleHandler.setFormatter(new DefaultCLIFormatter());

            // Apply handler to logger
            logger.addHandler(consoleHandler);

            // Remove default handler
            logger.setUseParentHandlers(false);

        } else {
            throw new TooManyCLIsException();
        }
    }
    /**
     * The CLI constructor. Best initialized in the Main thread on entry. Puts the Instance into {@link dev.redgamer6427a.redutils.cli.CLI#CLI}. This constructor is used if you want to use your own Formatter
     * @param loggerName the name of the logger. If null, it creates an anonymous logger.
     * @param formatter the formatter you want to use.
     */
    public CLI(@Nullable String loggerName, Formatter formatter) {
        if(CLI == null){
            CLI = this;
            if(loggerName != null){
                this.logger = Logger.getLogger(loggerName);
            } else {
                this.logger = Logger.getAnonymousLogger();
            }
            ConsoleHandler consoleHandler = new ConsoleHandler();

            // Set the custom formatter
            consoleHandler.setFormatter(formatter);

            // Apply handler to logger
            logger.addHandler(consoleHandler);

            // Remove default handler
            logger.setUseParentHandlers(false);

        } else {
            throw new TooManyCLIsException();
        }
    }

    /**
     * Gets the CLI instance in {@link dev.redgamer6427a.redutils.cli.CLI#CLI}.
     * @return the CLI instance in {@link dev.redgamer6427a.redutils.cli.CLI#CLI}.
     */
    public static CLI get(){
        return CLI;
    }

    /**
     * Log an info message.
     * @param message the Text to log
     */
    public static void info(String message){
        if(CLI == null){
            throw new NullPointerException("CLI is null. Use new CLI.CLI()");
        }
        CLI.logger.info(message);
    }
    /**
     * Log a warning message.
     * @param message the Text to log
     */
    public static void warn(String message){
        if(CLI == null){
            throw new NullPointerException("CLI is null. Use new CLI.CLI()");
        }
        CLI.logger.warning(message);
    }
    /**
     * Log an severe error message.
     * @param message the Text to log
     */
    public static void severe(String message){
        if(CLI == null){
            throw new NullPointerException("CLI is null. Use new CLI.CLI()");
        }
        CLI.logger.severe(message);
    }
    /**
     * Print a Custom Message using {@link PrintComponent}.
     * @param messages the {@link PrintComponent}s to log.
     */
    public static void custom(PrintComponent... messages){
        for(PrintComponent msg : messages){
            System.out.printf(msg.toString());
        }
    }

    /**
     * Ask for a user input in the CLI
     * @param prompt the Prompt.
     * @return the text the user inputted
     */
    public static String input(PrintComponent... prompt){
        for(PrintComponent msg : prompt){
            System.out.printf(msg.toString());
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
