package dev.redgamer6427a.utils.cli;

import dev.redgamer6427a.utils.array.ArrayTool;

import java.util.ArrayList;
import java.util.List;

public class PrintComponent {

    private String text = "";
    private CLIStyle[] styles = {};
    private String rgbColor = null; // To store RGB color code

    private PrintComponent() {}

    public static PrintComponent text(String text) {
        PrintComponent component = new PrintComponent();
        component.text = text;
        return component;
    }

    public PrintComponent style(CLIStyle style) {
        styles = (CLIStyle[]) new ArrayTool<>(styles)
                .addElement(style)
                .array();
        return this;
    }

    public PrintComponent rgbColor(String rgb) {
        if (rgb.length() == 6) {
            this.rgbColor = rgb;
        } else {
            throw new IllegalArgumentException("RGB color must be a 6-digit hexadecimal string.");
        }
        return this;
    }

    @Override
    public String toString() {
        List<CLIStyle> appliedStyles = new ArrayList<>();
        CLIStyle[] reversedStyles = (CLIStyle[]) new ArrayTool<>(styles)
                .reverse()
                .array();
        List<Integer> clashes = new ArrayList<>();
        for (CLIStyle style : reversedStyles) {
            if (!clashes.contains(style.clashGroup())) {
                clashes.add(style.clashGroup());
                appliedStyles.add(style);
            }
        }

        StringBuilder sb = new StringBuilder();

        // Add RGB color if present
        if (rgbColor != null) {
            sb.append(String.format("\u001B[38;2;%d;%d;%dm",
                    Integer.parseInt(rgbColor.substring(0, 2), 16),
                    Integer.parseInt(rgbColor.substring(2, 4), 16),
                    Integer.parseInt(rgbColor.substring(4, 6), 16)));
        }

        // Apply CLI styles
        for (CLIStyle appliedStyle : appliedStyles) {
            sb.append(appliedStyle.representation());
        }

        // Append text and reset
        sb.append(text);
        sb.append("\u001B[0m"); // Reset to default color and style

        return sb.toString();
    }

    public static PrintComponent newLine() {
        return text("\n");
    }
}

