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
public class StatePause implements State {

    private Canvas c;
    private Image imgPause;

    public StatePause(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            if (c.s.getSilent() == true) {
                imgPause = Image.createImage("/Image/pausemute.png");
            } else {
                imgPause = Image.createImage("/Image/pause.png");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        
    }

    public void updateGambar(Graphics g) {
        g.drawImage(imgPause, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
    }

    public void hapusResource() {
        imgPause = null;
    }

    public void tapEvent(int x, int y) {
        if (x > 34 && y > 234 && x < 84 && y < 258) {
            c.pindahState(c.stateLevel);
            c.s.play(c.s.cling);
        } else if (x > 92 && y > 234 && x < 146 && y < 258) {
            try {
                if (c.s.getSilent() == true) {
                    c.s.setSilent(false);
                    imgPause = Image.createImage("/Image/pause.png");
                } else {
                    c.s.setSilent(true);
                    imgPause = Image.createImage("/Image/pausemute.png");
                    c.s.stop();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (x > 152 && y > 234 && x < 204 && y < 258) {
            c.back();
            c.s.play(c.s.cling);
        }
    }
}
