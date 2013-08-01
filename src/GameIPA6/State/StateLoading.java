/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author user
 */
public class StateLoading implements State {

    private Canvas c;
    private int count = 0;

    public StateLoading(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
    }

    public void updateLogika() {
        count++;
        if (count > 8) {
            count = 0;
            c.pindahState(c.stateLevel);
        }
    }

    public void updateGambar(Graphics g) {
        g.setColor(0, 255, 0);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(0, 0, 0);
        g.drawString("Loading...", c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.BASELINE);
    }

    public void hapusResource() {
    }

    public void tapEvent(int x, int y) {
    }
}
