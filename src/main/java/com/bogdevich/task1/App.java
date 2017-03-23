package com.bogdevich.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static String STRING_PATTERN = "x=[0-9]+ +y=[0-9]+ +z=[0-9]+";

    public static void main( String[] args )
    {
        Pattern pattern = Pattern.compile(STRING_PATTERN);
        Matcher matcher = pattern.matcher("");
        boolean isEquals = matcher.matches();
        System.out.println(isEquals);
    }
}
