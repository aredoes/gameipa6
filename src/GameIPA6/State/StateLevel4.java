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
public class StateLevel4 implements State {

    private Canvas c;
    private int xPenyelamat, xPencuri, yPencuri, coll, p, temp, level, i;
    private boolean tembak, xP, win;

    public StateLevel4(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        win = false;
        i = 0;
        level = 0;
        coll = 0;
        yPencuri = c.getHeight();
        ins.pencuri.setFrameSequence(ins.gd.malingseq001);
        xPenyelamat = 0;
        ins.penyelamat.setFrameSequence(ins.gd.penembaksseq001);
        ins.penyelamat.setPosition(c.getWidth(), 0);
        ins.pencuri.setPosition(c.getWidth(), 0);
        xPencuri = 0;
        xP = false;
        tembak = false;
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        ins.penyelamat.setPosition(c.getWidth() / 2 - ins.penyelamat.getWidth() / 2 + xPenyelamat, 50);
        ins.pencuri.setPosition(c.getWidth() / 2 - ins.pencuri.getWidth() / 2 + xPencuri, yPencuri);
        yPencuri -= 1 + level;

        if (xP) {
            xPencuri = t.randomInt3();
            xP = false;
        }

        if (yPencuri < 0) {
            t.life--;
            yPencuri = c.getHeight();
            xP = true;
        }

        if (level == 5) {
            win = true;
        }

        if (tembak) {
            p += 5;
            ins.peluru.setPosition(temp, ins.penyelamat.getY() + ins.penyelamat.getHeight() / 2 + 5 + p);
            if (p > c.getHeight()) {
                tembak = false;
            }
            if (ins.pencuri.collidesWith(ins.peluru, true)) {
                ins.pencuri.setFrameSequence(ins.gd.malingkena);
                coll++;
                ins.pencuri.nextFrame();
                if (coll >= 3) {
                    yPencuri = c.getHeight();
                    ins.pencuri.setFrameSequence(ins.gd.malingseq001);
                    coll = 0;
                    tembak = false;
                    level++;
                    xP = true;
                }
            }
        } else if (!tembak) {
            ins.peluru.setPosition(c.getWidth(), 0);
            p = 0;
        }

    }

    public void updateGambar(Graphics g) {
        t.background(g, c, 0xffffff);

        ins.penyelamat.paint(g);
        ins.penyelamat.nextFrame();
        ins.pencuri.paint(g);
        ins.pencuri.nextFrame();
        ins.peluru.paint(g);
        ins.peluru.nextFrame();

        t.icon(g, c, "Level 4");

        //arah
        g.drawImage(ins.imgFire, c.getWidth() / 2, c.getHeight() - ins.imgFire.getHeight() / 2 - 60, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.imgLeftArrow, ins.imgLeftArrow.getWidth() / 2, c.getHeight() - ins.imgLeftArrow.getHeight() / 2 - 60, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.imgRightArrow, c.getWidth() - ins.imgRightArrow.getWidth() / 2, c.getHeight() - ins.imgRightArrow.getHeight() / 2 - 60, Graphics.HCENTER | Graphics.VCENTER);

        t.petunjuk(g, c, "Selamatkan hewan langka", "dari pemburu liar");

        if (win) {
            i++;
            if (i > 8) {
                sound.play(sound.berubah);
                t.win(g, c, true);
                i = 0;
                if (t.level == 3) {
                    t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }
    }

    public void hapusResource() {
        ins.hapusBab4();
    }

    public void tapEvent(int x, int y) {
        t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

        if (y > c.getHeight() - ins.imgLeftArrow.getHeight() - 60 && y < c.getHeight() - 60) {
            if (x > 0 && x < ins.imgLeftArrow.getWidth() && this.xPenyelamat > -60) {
                sound.play(sound.menu);
                this.xPenyelamat -= 15;
            } else if (x > c.getWidth() - ins.imgRightArrow.getWidth() && x < c.getWidth() && this.xPenyelamat < 60) {
                sound.play(sound.menu);
                this.xPenyelamat += 15;
            }
        }

        if (x > c.getWidth() / 2 - ins.imgFire.getWidth() / 2 && y > c.getHeight() - ins.imgFire.getHeight() - 60 && x < c.getWidth() / 2 + ins.imgFire.getWidth() / 2 && y < c.getHeight() - 60 && !tembak) {
            tembak = true;
            temp = ins.penyelamat.getX() + ins.penyelamat.getWidth() / 2 - ins.peluru.getWidth() / 2;
        }
    }
}
