package com.ironhack.homework03.model;

public class Style {
    // ANSI Code
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String REVERSED = "\u001B[7m";  // Invierte los colores

    // RGB COLORS
    public static final String SCHOOL = rgbColor(70, 130, 255);
    public static final String TEACHER = rgbColor(186, 85, 211);
    public static final String COURSE = rgbColor(255, 165, 50);
    public static final String STUDENT = rgbColor(0, 179, 168);
    public static final String HIGHLIGHT = rgbColor(255, 255, 100);
    public static final String ERROR = rgbColor(255, 99, 71);
    public static final String SUCCESS = rgbColor(144, 238, 144);
    public static final String SALARY = rgbColor(179, 173, 0);
    public static final String NOT_FOUND = rgbColor(255, 165, 50);

    // RGB BACKGROUND
//    public static final String SUCCESS_BG = rgbBackground(64, 93, 72);
    public static final String SUCCESS_BG = rgbBackground(58, 58, 58);
    //    public static final String SUCCESS_BG = rgbBackground(30, 30, 30); // CONSOLE COLOR
    public static final String WARNING_BG = rgbBackground(255, 255, 102);
    public static final String ERROR_BG = rgbBackground(255, 69, 69);

    public static String rgbColor(int r, int g, int b) {
        return "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
    }

    public static String rgbBackground(int r, int g, int b) {
        return "\u001B[48;2;" + r + ";" + g + ";" + b + "m";
    }
}