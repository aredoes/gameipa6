/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Tools.AudioManager;
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
            if (c.silent == true) {
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
            c.getAudioManager().playSample(c.cling);
        } else if (x > 92 && y > 234 && x < 146 && y < 258) {
            c.silent = !c.silent;
            AudioManager.audioEnabled = !c.silent;
            try {
                if (c.silent == true) {
                    c.getAudioManager().stopAll();
                    imgPause = Image.createImage("/Image/pausemute.png");
                } else {
                    c.getAudioManager().playSample(c.backsound);
                    imgPause = Image.createImage("/Image/pause.png");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (x > 152 && y > 234 && x < 204 && y < 258) {
            c.back();
            c.getAudioManager().playSample(c.cling);
        }
    }
}
