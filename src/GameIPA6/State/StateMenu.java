/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.MediaException;

/**
 *
 * @author user
 */
public class StateMenu implements State {

    private Canvas c;
    private Image imgMenu;

    public StateMenu(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            if (c.s.getSilent() == true) {
                imgMenu = Image.createImage("/Image/homemute.png");
            } else {
                imgMenu = Image.createImage("/Image/home.png");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void updateLogika() {
        c.s.play(c.s.backsound1);
    }

    public void updateGambar(Graphics g) {
        g.drawImage(imgMenu, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
    }

    public void hapusResource() {
        imgMenu = null;
    }

    public void tapEvent(int x, int y) {
        if (x > 46 && y > 167 && x < 118 && y < 253) {
            c.s.play(c.s.beep);
            c.pindahState(c.stateLoading);
        }
        if (x > 129 && y > 167 && x < 204 && y < 253) {
            c.setIsGameJalan(false);
        }
        if (x > 89 && y > 304 && x < 149 && y < 350) {
            try {
                if (c.s.getSilent() == true) {
                    c.s.setSilent(false);
                    imgMenu = Image.createImage("/Image/home.png");
                } else {
                    c.s.setSilent(true);
                    imgMenu = Image.createImage("/Image/homemute.png");
                    c.s.stop();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
