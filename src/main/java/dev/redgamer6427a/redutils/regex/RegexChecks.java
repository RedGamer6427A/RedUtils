package dev.redgamer6427a.redutils.regex;

import java.util.regex.Pattern;

public class RegexChecks {

    /**
     * Checks if a single character is a digit.
     * @param c the character to check.
     * @return true if it matches.
     */
    public static boolean isDigit(char c){
        return Pattern.matches("\\d",c+"");
    }
    /**
     * Checks if all the characters in a string are digits.
     * @param s the String to check.
     * @return true if it matches.
     */
    public static boolean isDigit(String s){
        for(char c:s.toCharArray()){
            if(!isDigit(c)){
                return false;
            }
        }
        return true;
    }

}
