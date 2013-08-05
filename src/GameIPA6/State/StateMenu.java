/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Tools.Sound;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 *
 * @author user
 */
public class StateMenu implements State {

    private Canvas c;
    private Image imgMenu;
    private Sound s;

    public StateMenu(Canvas c) {
        this.s = new Sound();
        this.c = c;
    }

    public void inisialisasi() {
        try {
            if (s.getSilent() == true) {
                imgMenu = Image.createImage("/GameIPA6/Image/homemute.png");
            } else {
                imgMenu = Image.createImage("/GameIPA6/Image/home.png");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        s.play(s.backsound1);
    }

    public void updateGambar(Graphics g) {
        g.drawImage(imgMenu, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
    }

    public void hapusResource() {
        imgMenu = null;
    }

    public void tapEvent(int x, int y) {
        if (x > 40 && y > 187 && x < 126 && y < 234) {
            s.play(s.beep);
            c.pindahState(c.stateLoading);
        }
        if (x > 131 && y > 245 && x < 216 && y < 290) {
            c.setIsGameJalan(false);
        }
        if (x > 42 && y > 289 && x < 121 && y < 351) {
            try {
                if (s.getSilent() == true) {
                    s.play(s.backsound1);
                    imgMenu = Image.createImage("/GameIPA6/Image/home.png");
                    s.setSilent(false);
                } else {
                    s.play(s.stop);
                    imgMenu = Image.createImage("/GameIPA6/Image/homemute.png");
                    s.setSilent(true);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
