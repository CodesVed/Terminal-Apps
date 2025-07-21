public final class ConsoleColors {
    private static boolean colorsEnabled = true;

    private ConsoleColors() {}

    public static void setEnabled(boolean enabled) {
        colorsEnabled = enabled;
    }

    public static String RESET()           { return colorsEnabled ? "\033[0m" : ""; }
    public static String RED()             { return colorsEnabled ? "\033[0;31m" : ""; }
    public static String GREEN()           { return colorsEnabled ? "\033[0;32m" : ""; }
    public static String YELLOW()          { return colorsEnabled ? "\033[0;33m" : ""; }
    public static String WHITE()           { return colorsEnabled ? "\033[0;37m" : ""; }
    public static String GOLDEN()          { return colorsEnabled ? "\033[38;5;220m" : ""; }

    public static String RED_BOLD()        { return colorsEnabled ? "\033[1;31m" : ""; }
    public static String BLUE_BOLD()       { return colorsEnabled ? "\033[1;34m" : ""; }
    public static String PURPLE_BOLD()     { return colorsEnabled ? "\033[1;35m" : ""; }
    public static String WHITE_BOLD()      { return colorsEnabled ? "\033[1;37m" : ""; }
    public static String SILVER_BOLD()     { return colorsEnabled ? "\033[1;38;5;250m" : ""; }
}
