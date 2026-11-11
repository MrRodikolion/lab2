package edu.rodlam;


public class BrowserLaunch {

public String browser(){
    if (Desktop.isDesktopSupported()
        && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
    Desktop.getDesktop().browse(URI.create(articleUrl));
    boolean isDesktopSupported = Desktop.isDesktopSupported();
    return isDesktopSupported;
    } 
    else {
        System.err.println("Desktop is not supported. Cannot open the browser.");
        return false;
    }

}
}
   
 

