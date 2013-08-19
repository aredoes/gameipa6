/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author user
 */
public class StateSplash implements State {

    private Canvas c;
    private Image[] splash;
    private int timeout;
    private int page;
    
    public StateSplash(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        page = 0;
        timeout = 30;
        try {
            Image[] splash = new Image[4];
            splash[0] = Image.createImage("/Image/splash/ub.png");
            splash[1] = Image.createImage("/Image/splash/ptiik.png");
            splash[2] = Image.createImage("/Image/splash/labgame.png");
            splash[3] = Image.createImage("/Image/splash/present.png");
            this.splash = splash;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        timeout--;
        
        if(timeout < 0) {
            page++;
            timeout = 30;
        }
        
        if(page > 3) {
            c.pindahState(c.stateMenu);
        }
    }

    public void updateGambar(Graphics g) {
        g.drawImage(splash[page], 0, 0, 0);
    }

    public void hapusResource() {
        splash = null;
    }

    public void tapEvent(int x, int y) {
    }
}
