/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retrieval;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author anirban
 */
public class urlFind extends DefaultHandler {
    
    public String urlFinder(String string) {
        String outString = "";
        Scanner lineScanner = new Scanner(string);
            try {
                while (lineScanner.hasNext()) {
                    String token = lineScanner.next();
                    if (urlcheck(token) == 1) {
                        // It's a valid URL
                        outString += " <a class=\"asynch_link\" href=\"" + token + "\" target=\"_blank\">" + token + "</a>";
                    }
                    else {
                        // It's not a URL
                        outString += " " + token + " ";
                    }
                }
                lineScanner.close();
                return outString;
            } catch (Exception ex) {
                ex.printStackTrace();
                return string;
            }
    }
    
    public int urlcheck(String str) {
        try {
            URL url = new URL(str);
            return 1;
        } catch (MalformedURLException ex) {
            // it wasn't a URL
            ex.printStackTrace();
            return 0;
        }
    }
    
}
