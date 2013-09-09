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
public class StateLevel implements State {

    private Canvas c;
    private Image imgLevelMenu, imgLevelLocked, imgExit, imgSound, background;

    public StateLevel(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            c.getAudioManager().stopAll();
            imgLevelMenu = Image.createImage("/Image/Level.png");
            imgLevelLocked = Image.createImage("/Image/Levellocked.png");
            imgExit = Image.createImage("/Image/Icon/cross.png");
            background = Image.createImage("/Image/freepik.jpg");
            if (c.silent == true) {
                imgSound = Image.createImage("/Image/Icon/soundmute.png");
            } else {
                imgSound = Image.createImage("/Image/Icon/sound.png");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
    }

    public void updateGambar(Graphics g) {
        g.drawImage(background, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(imgExit, c.getWidth() - imgExit.getWidth() / 2, imgExit.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(imgSound, c.getWidth() / 2, c.getHeight() - imgSound.getHeight(), Graphics.HCENTER | Graphics.VCENTER);
        c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 - 110, imgLevelMenu, "Level 1", c, g);
        if (c.t.level > 0) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 110, imgLevelMenu, "Level 2", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 110, imgLevelLocked, "Level 2", c, g);
        }
        if (c.t.level > 1) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 110, imgLevelMenu, "Level 3", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 110, imgLevelLocked, "Level 3", c, g);
        }
        if (c.t.level > 2) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 - 30, imgLevelMenu, "Level 4", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 - 30, imgLevelLocked, "Level 4", c, g);
        }
        if (c.t.level > 3) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 30, imgLevelMenu, "Level 5", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 30, imgLevelLocked, "Level 5", c, g);
        }
        if (c.t.level > 4) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 30, imgLevelMenu, "Level 6", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 30, imgLevelLocked, "Level 6", c, g);
        }
        if (c.t.level > 5) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 + 50, imgLevelMenu, "Level 7", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 + 50, imgLevelLocked, "Level 7", c, g);
        }
        if (c.t.level > 6) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 + 50, imgLevelMenu, "Level 8", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 + 50, imgLevelLocked, "Level 8", c, g);
        }
        if (c.t.level > 7) {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 + 50, imgLevelMenu, "Level 9", c, g);
        } else {
            c.t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 + 50, imgLevelLocked, "Level 9", c, g);
        }
    }

    public void hapusResource() {
        imgLevelMenu = null;
        imgExit = null;
        imgSound = null;
        c.getAudioManager().stopAll();
    }

    public void tapEvent(int x, int y) {
        c.t.tapImg(x, y, c.getWidth() - imgExit.getWidth() / 2, imgExit.getHeight() / 2, imgExit.getWidth(), imgExit.getHeight(), c, c.stateMenu);
        if (y > c.getHeight() / 2 - 110 - 60 / 2 && y < c.getHeight() / 2 - 110 + 60 / 2) {
            if (x > c.getWidth() / 2 - 80 - 60 / 2 && x < c.getWidth() / 2 - 80 + 60 / 2) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel1);
            }
            if (x > c.getWidth() / 2 - 60 / 2 && x < c.getWidth() / 2 + 60 / 2 && c.t.level > 0) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel2);
            }
            if (x > c.getWidth() / 2 + 80 - 60 / 2 && x < c.getWidth() / 2 + 80 + 60 / 2 && c.t.level > 1) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel3);
            }
        }
        if (y > c.getHeight() / 2 - 30 - 60 / 2 && y < c.getHeight() / 2 - 30 + 60 / 2) {
            if (x > c.getWidth() / 2 - 80 - 60 / 2 && x < c.getWidth() / 2 - 80 + 60 / 2 && c.t.level > 2) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel4);
            }
            if (x > c.getWidth() / 2 - 60 / 2 && x < c.getWidth() / 2 + 60 / 2 && c.t.level > 3) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel5);
            }
            if (x > c.getWidth() / 2 + 80 - 60 / 2 && x < c.getWidth() / 2 + 80 + 60 / 2 && c.t.level > 4) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel6);
            }
        }
        if (y > c.getHeight() / 2 + 50 - 60 / 2 && y < c.getHeight() / 2 + 50 + 60 / 2) {
            if (x > c.getWidth() / 2 - 80 - 60 / 2 && x < c.getWidth() / 2 - 80 + 60 / 2 && c.t.level > 5) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel7);
            }
            if (x > c.getWidth() / 2 - 60 / 2 && x < c.getWidth() / 2 + 60 / 2 && c.t.level > 6) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel8);
            }
            if (x > c.getWidth() / 2 + 80 - 60 / 2 && x < c.getWidth() / 2 + 80 + 60 / 2 && c.t.level > 7) {
                c.getAudioManager().playSample(c.beep);
                c.pindahState(c.stateLoadingLevel9);
            }
        }
        if (x > 92 && y > 313 && x < 149 && y < 368) {
            c.silent = !c.silent;
            AudioManager.audioEnabled = !c.silent;
            try {
                if (c.silent == true) {
                    c.getAudioManager().stopAll();
                    imgSound = Image.createImage("/Image/Icon/soundmute.png");
                } else {
                    c.getAudioManager().playSample(c.backsound);
                    imgSound = Image.createImage("/Image/Icon/sound.png");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
