/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Tools.AudioManager;
//import GameIPA6.Tools.SoundEfect;
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
    private Image imgMenu, mute, unmute;

    public StateMenu(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            mute = Image.createImage("/Image/homemute.png");
            unmute = Image.createImage("/Image/home.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (c.silent == true) {
            imgMenu = mute;
        } else {
            imgMenu = unmute;
            c.getAudioManager().loopSample(c.backsound);
        }

    }

    public void updateLogika() {
//       c.s.play(c.s.backsound1);
    }

    public void updateGambar(Graphics g) {
        g.drawImage(imgMenu, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
    }

    public void hapusResource() {
        mute = null;
        unmute = null;
        imgMenu = null;
        c.getAudioManager().stopAll();
    }

    public void tapEvent(int x, int y) {
        if (x > 46 && y > 167 && x < 118 && y < 253) {
            c.getAudioManager().playSample(c.beep);
            c.pindahState(c.stateLoading);
        }
        if (x > 129 && y > 167 && x < 204 && y < 253) {
            c.setIsGameJalan(false);
        }
        if (x > 89 && y > 304 && x < 149 && y < 350) {
            c.silent = !c.silent;
            AudioManager.audioEnabled = !c.silent;
            if (c.silent == true) {
                c.getAudioManager().stopAll();
                imgMenu = mute;
            } else {
                c.getAudioManager().loopSample(c.backsound);
                imgMenu = unmute;
            }
        }

    }
}
