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
public class StateInfo implements State {

    private Canvas c;

    public StateInfo(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
    }

    public void updateLogika() {
    }

    public void updateGambar(Graphics g) {
        g.setColor(0xffb638);
        g.fillRect(0, c.getHeight() / 2 - 20, c.getWidth(), 40);
        g.setColor(0, 0, 0);
        g.drawString("GAGAL", c.getWidth() / 2, c.getHeight() / 2 - 35, Graphics.BASELINE | Graphics.HCENTER);
        g.drawString("Klik disembarang tempat...", c.getWidth() / 2, c.getHeight() / 2 - 15, Graphics.BASELINE | Graphics.HCENTER);
    }

    public void hapusResource() {
    }

    public void tapEvent(int x, int y) {
        if (x > 0 && x < c.getWidth() && y > 0 && y < c.getHeight()) {
            c.pause(c.stateSebelumnya);
        }
    }
}
