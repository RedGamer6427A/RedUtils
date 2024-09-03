package dev.redgamer6427a.redutils.cli;

public enum CLIStyle {

    RESET("\u001B[0m",0),

    // Regular Colors
    FORE_BLACK("\u001B[30m",1),
    FORE_RED("\u001B[31m",1),
    FORE_GREEN("\u001B[32m",1),
    FORE_YELLOW("\u001B[33m",1),
    FORE_BLUE("\u001B[34m",1),
    FORE_PURPLE("\u001B[35m",1),
    FORE_CYAN("\u001B[36m",1),
    FORE_WHITE("\u001B[37m",1),

    // Bright Colors
    FORE_BRIGHT_BLACK("\u001B[90m",1),
    FORE_BRIGHT_RED("\u001B[91m",1),
    FORE_BRIGHT_GREEN("\u001B[92m",1),
    FORE_BRIGHT_YELLOW("\u001B[93m",1),
    FORE_BRIGHT_BLUE("\u001B[94m",1),
    FORE_BRIGHT_PURPLE("\u001B[95m",1),
    FORE_BRIGHT_CYAN("\u001B[96m",1),
    FORE_BRIGHT_WHITE("\u001B[97m",1),

    // Regular Background Colors
    BACK_BLACK("\u001B[40m",2),
    BACK_RED("\u001B[41m",2),
    BACK_GREEN("\u001B[42m",2),
    BACK_YELLOW("\u001B[43m",2),
    BACK_BLUE("\u001B[44m",2),
    BACK_PURPLE("\u001B[45m",2),
    BACK_CYAN("\u001B[46m",2),
    BACK_WHITE("\u001B[47m",2),

    // Bright Background Colors
    BACK_BRIGHT_BLACK("\u001B[100m",2),
    BACK_BRIGHT_RED("\u001B[101m",2),
    BACK_BRIGHT_GREEN("\u001B[102m",2),
    BACK_BRIGHT_YELLOW("\u001B[103m",2),
    BACK_BRIGHT_BLUE("\u001B[104m",2),
    BACK_BRIGHT_PURPLE("\u001B[105m",2),
    BACK_BRIGHT_CYAN("\u001B[106m",2),
    BACK_BRIGHT_WHITE("\u001B[107m",2),

    STYLE_BOLD("\u001B[1m",3),
    STYLE_BOLD_OFF("\u001B[22m",3),

    // Italic
    STYLE_ITALIC("\u001B[3m",4),
    STYLE_ITALIC_OFF("\u001B[23m",4),

    // Underlined
    STYLE_UNDERLINED("\u001B[4m",5),
    STYLE_UNDERLINED_OFF("\u001B[24m",5),

    // Blink
    STYLE_BLINK("\u001B[5m",6),
    STYLE_BLINK_OFF("\u001B[25m",6),

    // Inverse (swap foreground and background)
    STYLE_INVERSE("\u001B[7m",7),
    STYLE_INVERSE_OFF("\u001B[27m",7),

    // Hidden (conceal)
    STYLE_HIDDEN("\u001B[8m",8),
    STYLE_HIDDEN_OFF("\u001B[28m",8),

    // Strikethrough
    STYLE_STRIKETHROUGH("\u001B[9m",9),
    STYLE_STRIKETHROUGH_OFF("\u001B[29m",9);

    /**
     * The ANSI Escape Code
     */
    private final String representation;
    /**
     * The clash group. This defines which Styles override others.
     */
    private final int clashGroup;

    /**
     * The Constructor.
     * @param representation The ANSI Escape Code.
     * @param clashGroup The clash group.
     */
    CLIStyle(String representation, int clashGroup){
        this.representation = representation;
        this.clashGroup = clashGroup;
    }

    /**
     * @return the ANSI Escape Code
     */
    public String representation(){
        return representation;
    }

    /**
     * @return the clash group.
     */
    public int clashGroup() {
        return clashGroup;
    }
}
