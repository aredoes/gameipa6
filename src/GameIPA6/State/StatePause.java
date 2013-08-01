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
            if (sound.getSilent() == true) {
                imgPause = Image.createImage("/GameIPA6/Image/pausemute.png");
            } else {
                imgPause = Image.createImage("/GameIPA6/Image/pause.png");
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
            c.pause(c.stateLevel);
            sound.play(sound.cling);
            sound.play(sound.stop);
        } else if (x > 92 && y > 234 && x < 146 && y < 258) {
            try {
                if (sound.getSilent() == true) {
                    sound.play(sound.backsound1);
                    imgPause = Image.createImage("/GameIPA6/Image/pause.png");
                    sound.setSilent(false);
                } else {
                        sound.play(sound.stop);
                        imgPause = Image.createImage("/GameIPA6/Image/pausemute.png");
                        sound.setSilent(true);
                    }
                }  catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (x > 152 && y > 234 && x < 204 && y < 258) {
            c.pause(c.stateSebelumnya);
            sound.play(sound.cling);
        }
    }
}
