package dev.redgamer6427a.redutils.clipboard;

import dev.redgamer6427a.redutils.cli.CLI;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ClipboardHelper {

    public static String get(){

        try {
            // Get the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Get the clipboard content
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
                return text;
            } else {
                return "";
            }
        } catch (Exception e) {
            CLI.severe(e.getMessage());
            return "";
        }

    }
    public static void put(String text){

        // Create a StringSelection with the text
        StringSelection stringSelection = new StringSelection(text);

        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Set the content to the clipboard
        clipboard.setContents(stringSelection, null);


    }


}
