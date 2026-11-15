package edu.rodlam;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class BrowserLaunch {

public boolean browser(String articleUrl) throws IOException {
    if (Desktop.isDesktopSupported()
        && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
    Desktop.getDesktop().browse(URI.create(articleUrl));
    return Desktop.isDesktopSupported();
    } 
    else {
        System.err.println("Desktop is not supported. Cannot open the browser.");
        return false;
    }

}
public void open(String url){

}
}
   
 

