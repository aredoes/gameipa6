/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Control.GameDesign;
import GameIPA6.Tools.LoadInisialisasi;
import GameIPA6.Tools.Sound;
import GameIPA6.Tools.Tools;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author user
 */
public class StateLevel7 implements State {

    private Canvas c;
    private Image imgRun, imgBackground;
    private GameDesign gd;
    private Sprite pendorong;
    private int x, i, limit;
    private boolean waktuHabis, win;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel7(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        try {
            gd = new GameDesign();
            pendorong = gd.getPendorong();
            pendorong.setFrameSequence(gd.pendorongseq001);
            imgRun = Image.createImage("/GameIPA6/Image/Icon/run.png");
            imgBackground = Image.createImage("/GameIPA6/Image/bab7/background.png");
            x = 0;
            i = 0;
            limit = 60;
            waktuHabis = false;
            win = false;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        //waktu habis
        if (limit < 1) {
            //game finish
            if (x >= 101 && x <= 103) {
                win = true;
            } else {
                waktuHabis = true;
                t.life--;
                x = 0;
                limit = 60;
            }
        }

        //game start
        if (x > 0 && limit > 0) {
            limit--;
        }

        //nyawa habis
        if (t.life == 0) {
            c.pindahState(c.stateLevel);
            t.life = 3;
        }
    }

    public void updateGambar(Graphics g) {
        if (waktuHabis) {
            //waktu habis
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("Gagal", c.getWidth() / 2, c.getHeight() / 2 - 10, Graphics.BASELINE | Graphics.HCENTER);
            g.setColor(0, 0, 0);
            g.drawString("Klik disini...", c.getWidth() / 2, c.getHeight() / 2 + 15, Graphics.BASELINE | Graphics.HCENTER);
        } else {
            g.drawImage(imgBackground, c.getWidth() / 2, imgBackground.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
            t.icon(g, c, "Level 7");
            g.setColor(0, 0, 0);
            g.drawString(limit + " detik", c.getWidth() / 2, 80, Graphics.BASELINE | Graphics.HCENTER);
            g.drawString("Taruh disini", 176, 165, Graphics.BASELINE | Graphics.HCENTER);

            //orang
            pendorong.setPosition(x, 200);
            pendorong.paint(g);

            //run
            g.drawImage(imgRun, c.getWidth() - imgRun.getWidth() / 2, c.getHeight() - imgRun.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            if (win) {
                t.win(g, c, true);
                i++;
                if (i > 8) {
                    sound.play(sound.berubah);
                    if (t.level == 6) {
                        t.level++;
                    }
                    c.pindahState(c.stateLevel);
                }
            }

        }
    }

    public void hapusResource() {
        imgRun = null;
        imgBackground = null;
        pendorong = null;
    }

    public void tapEvent(int x, int y) {
        if (waktuHabis) {
            if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                waktuHabis = false;
            }
        } else {
            t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

            //arah
            if (y > c.getHeight() - imgRun.getHeight() && y < c.getHeight()) {
                if (x > c.getWidth() - imgRun.getWidth() && x < c.getWidth()) {
                    sound.play(sound.menu);
                    pendorong.nextFrame();
                    this.x += 3;
                }
            }
        }
    }
}
