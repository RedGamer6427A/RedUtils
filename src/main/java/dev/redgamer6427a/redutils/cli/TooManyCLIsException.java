package dev.redgamer6427a.redutils.cli;

public class TooManyCLIsException extends RuntimeException {
    /**
     * This Exception Gets Thrown if the CLI has already been defined
     */
    public TooManyCLIsException() {
        super("There already is a CLI object defined. Use CLI.clear() before defining another one or use CLI.CLI to acces the first CLI object.");
    }
}
