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
public class StateLoading implements State {

    private Canvas c;
    private int count = 0;
    private Image bg;

    public StateLoading(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            bg = Image.createImage("/Image/bgfirstloading.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        count++;
        if (count > 8) {
            count = 0;
            c.pindahState(c.stateLevel);
        }
    }

    public void updateGambar(Graphics g) {
        g.drawImage(bg, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
    }

    public void hapusResource() {
    }

    public void tapEvent(int x, int y) {
    }
}
