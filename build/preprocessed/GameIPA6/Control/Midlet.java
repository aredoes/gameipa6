/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Control;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author user
 */
public class Midlet extends MIDlet {

    private Display tampilan;
    private Canvas canvas;
    private Thread t;

    public Midlet() {
        tampilan = Display.getDisplay(this);
        canvas = new Canvas(this);
        t = new Thread(canvas);
    }

    public void startApp() {
        tampilan.setCurrent(canvas);
        t.run();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
}
