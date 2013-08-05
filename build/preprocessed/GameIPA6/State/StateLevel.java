/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Tools.*;
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
    private Sound sound;
    private Tools t;

    public StateLevel(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
    }

    public void inisialisasi() {
        try {
            sound.play(sound.stop);
            imgLevelMenu = Image.createImage("/GameIPA6/Image/Level.png");
            imgLevelLocked = Image.createImage("/GameIPA6/Image/Levellocked.png");
            imgExit = Image.createImage("/GameIPA6/Image/Icon/X.png");
            background = Image.createImage("/GameIPA6/Image/freepik.jpg");
            if (sound.getSilent() == true) {
                imgSound = Image.createImage("/GameIPA6/Image/Icon/soundmute.png");
            } else {
                imgSound = Image.createImage("/GameIPA6/Image/Icon/sound.png");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
    }

    public void updateGambar(Graphics g) {
        g.drawImage(background, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
        t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 - 110, imgLevelMenu, "Level 1", c, g);
        if (t.level > 0) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 110, imgLevelMenu, "Level 2", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 110, imgLevelLocked, "Level 2", c, g);
        }
        if (t.level > 1) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 110, imgLevelMenu, "Level 3", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 110, imgLevelLocked, "Level 3", c, g);
        }
        if (t.level > 2) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 - 30, imgLevelMenu, "Level 4", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 - 30, imgLevelLocked, "Level 4", c, g);
        }
        if (t.level > 3) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 30, imgLevelMenu, "Level 5", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 - 30, imgLevelLocked, "Level 5", c, g);
        }
        if (t.level > 4) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 30, imgLevelMenu, "Level 6", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 - 30, imgLevelLocked, "Level 6", c, g);
        }
        if (t.level > 5) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 + 50, imgLevelMenu, "Level 7", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 - 80, c.getHeight() / 2 + 50, imgLevelLocked, "Level 7", c, g);
        }
        if (t.level > 6) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 + 50, imgLevelMenu, "Level 8", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2, c.getHeight() / 2 + 50, imgLevelLocked, "Level 8", c, g);
        }
        if (t.level > 7) {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 + 50, imgLevelMenu, "Level 9", c, g);
        } else {
            t.drawImgTxt(0, 0, 0, c.getWidth() / 2 + 80, c.getHeight() / 2 + 50, imgLevelLocked, "Level 9", c, g);
        }

        g.drawImage(imgExit, c.getWidth() - imgExit.getWidth() / 2, imgExit.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(imgSound, c.getWidth() / 2, c.getHeight() - imgSound.getHeight(), Graphics.HCENTER | Graphics.VCENTER);
    }

    public void hapusResource() {
        imgLevelMenu = null;
        imgExit = null;
        imgSound = null;
    }

    public void tapEvent(int x, int y) {
        if (y > c.getHeight() / 2 - 110 - 60 / 2 && y < c.getHeight() / 2 - 110 + 60 / 2) {
            if (x > c.getWidth() / 2 - 80 - 60 / 2 && x < c.getWidth() / 2 - 80 + 60 / 2) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel1);
            }
            if (x > c.getWidth() / 2 - 60 / 2 && x < c.getWidth() / 2 + 60 / 2 && t.level > 0) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel2);

            }
            if (x > c.getWidth() / 2 + 80 - 60 / 2 && x < c.getWidth() / 2 + 80 + 60 / 2 && t.level > 1) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel3);

            }
        }
        if (y > c.getHeight() / 2 - 30 - 60 / 2 && y < c.getHeight() / 2 - 30 + 60 / 2) {
            if (x > c.getWidth() / 2 - 80 - 60 / 2 && x < c.getWidth() / 2 - 80 + 60 / 2 && t.level > 2) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel4);
            }
            if (x > c.getWidth() / 2 - 60 / 2 && x < c.getWidth() / 2 + 60 / 2 && t.level > 3) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel5);
            }
            if (x > c.getWidth() / 2 + 80 - 60 / 2 && x < c.getWidth() / 2 + 80 + 60 / 2 && t.level > 4) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel6);

            }
        }
        if (y > c.getHeight() / 2 + 50 - 60 / 2 && y < c.getHeight() / 2 + 50 + 60 / 2) {
            if (x > c.getWidth() / 2 - 80 - 60 / 2 && x < c.getWidth() / 2 - 80 + 60 / 2 && t.level > 5) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel7);
            }
            if (x > c.getWidth() / 2 - 60 / 2 && x < c.getWidth() / 2 + 60 / 2 && t.level > 6) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel8);
            }
            if (x > c.getWidth() / 2 + 80 - 60 / 2 && x < c.getWidth() / 2 + 80 + 60 / 2 && t.level > 7) {
                sound.play(sound.beep);
                c.pindahState(c.stateLoadingLevel9);

            }
        }
        if (x > 92 && y > 313 && x < 149 && y < 368) {
            try {
                if (sound.getSilent() == true) {
                    imgSound = Image.createImage("/GameIPA6/Image/Icon/sound.png");
                    sound.setSilent(false);
                } else {
                    imgSound = Image.createImage("/GameIPA6/Image/Icon/soundmute.png");
                    sound.setSilent(true);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        t.tapImg(x, y, c.getWidth() - imgExit.getWidth() / 2, imgExit.getHeight() / 2, imgExit.getWidth(), imgExit.getHeight(), c, c.stateMenu);
        
    }
}
