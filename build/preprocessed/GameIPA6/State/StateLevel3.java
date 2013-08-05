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
public class StateLevel3 implements State {

    private Canvas c;
    private int x, i, limit, xBackground, xBackground2;
    private boolean waktuHabis, finish;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel3(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        i = 0;
        finish = false;
        ins.orang.setFrameSequence(ins.gd.orangjalanseq002);
        ins.penebang.setFrameSequence(ins.gd.penebangjalanseq002);
        x = 0;
        ins.orang.setPosition(0, c.getHeight() - 65 - ins.orang.getHeight());
        ins.penebang.setPosition(c.getWidth() - ins.penebang.getWidth(), c.getHeight() - 65 - ins.penebang.getHeight());
        limit = 120;
        xBackground = 0;
        xBackground2 = ins.imgBackground.getWidth();
        waktuHabis = false;
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        if (xBackground == ins.imgBackground.getWidth()) {
            xBackground = -ins.imgBackground.getWidth();
        } else if (xBackground2 == ins.imgBackground.getWidth()) {
            xBackground2 = -ins.imgBackground.getWidth();
        }

        //game start
        if (x > 1 && !finish) {
            xBackground += 2;
            xBackground2 += 2;
            limit--;
            ins.penebang.nextFrame();
            if (x > 2) {
                x--;
            }
        }

        //waktu habis
        if (limit < 0) {
            waktuHabis = true;
        }

        //game finish
        if (ins.orang.collidesWith(ins.penebang, true)) {
            finish = true;
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
            t.win(g, c, false);
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("Gagal", c.getWidth() / 2, c.getHeight() / 2 - 10, Graphics.BASELINE | Graphics.HCENTER);
            g.setColor(0, 0, 0);
            g.drawString("Klik disini...", c.getWidth() / 2, c.getHeight() / 2 + 15, Graphics.BASELINE | Graphics.HCENTER);
        } else {
            g.drawImage(ins.imgBackground, c.getWidth() / 2 - xBackground, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
            g.drawImage(ins.imgBackground, c.getWidth() / 2 - xBackground2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            t.petunjuk(g, c, "Tangkap", "Illegal Logging");

            g.drawString(limit + " detik", c.getWidth() / 2, 80, Graphics.BASELINE | Graphics.HCENTER);

            //orang
            ins.orang.setPosition(x, c.getHeight() - 65 - ins.orang.getHeight());
            ins.penebang.setPosition(c.getWidth() - ins.penebang.getWidth(), c.getHeight() - 65 - ins.penebang.getHeight());

            ins.orang.paint(g);
            ins.penebang.paint(g);

            //run
            g.drawImage(ins.imgRun, c.getWidth() - ins.imgRun.getWidth() / 2, c.getHeight() - ins.imgRun.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            t.icon(g, c, "Level 3");

            if (finish) {
                t.win(g, c, true);
                i++;
                if (i > 8) {
                    sound.play(sound.berubah);
                    if (t.level == 2) {
                        t.level++;
                    }
                    i = 0;
                    c.pindahState(c.stateLevel);
                }
            }
        }
    }

    public void hapusResource() {
        ins.hapusBab3();
    }

    public void tapEvent(int x, int y) {
        t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);
        if (waktuHabis) {
            if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                waktuHabis = false;
                t.life--;
                this.x = 0;
                limit = 120;
            }
        } else {
            //arah
            if (y > c.getHeight() - ins.imgRun.getHeight() && y < c.getHeight() && !finish) {
                if (x > c.getWidth() - ins.imgRun.getWidth() && x < c.getWidth()) {
                    sound.play(sound.menu);
                    this.x += 4;
                    ins.orang.nextFrame();
                }
            }
        }
    }
}
