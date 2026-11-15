package edu.rodlam;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.awt.Desktop;
import java.net.URISyntaxException;


public class BrowserLaunch {

    public boolean browser() throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported()
                && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            return Desktop.isDesktopSupported();
        } else {
            System.err.println("Desktop is not supported. Cannot open the browser.");
            return false;
        }
    }

    public void open(String url) {

        try {
            if (browser()) {
                Desktop.getDesktop().browse(URI.create(url));
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}

   
 

