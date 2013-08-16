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
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel4(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        win = false;
        i = 0;
        level = 0;
        coll = 0;
        yPencuri = c.getHeight();
        c.ins.pencuri.setFrameSequence(c.ins.gd.malingseq001);
        xPenyelamat = 0;
        c.ins.penyelamat.setFrameSequence(c.ins.gd.penembaksseq001);
        c.ins.penyelamat.setPosition(c.getWidth(), 0);
        c.ins.pencuri.setPosition(c.getWidth(), 0);
        xPencuri = 0;
        xP = false;
        tembak = false;
        over = false;
        ov = 0;
    }

    public void updateLogika() {
        c.sound.play(c.sound.backsound1);
        c.ins.penyelamat.setPosition(c.getWidth() / 2 - c.ins.penyelamat.getWidth() / 2 + xPenyelamat, 50);
        c.ins.pencuri.setPosition(c.getWidth() / 2 - c.ins.pencuri.getWidth() / 2 + xPencuri, yPencuri);
        yPencuri -= 1 + level;

        if (xP) {
            xPencuri = c.t.randomInt3();
            xP = false;
        }

        if (yPencuri < 0) {
            c.t.life--;
            yPencuri = c.getHeight();
            xP = true;
        }

        if (level == 5) {
            win = true;
        }

        if (tembak) {
            p += 5;
            c.ins.peluru.setPosition(temp, c.ins.penyelamat.getY() + c.ins.penyelamat.getHeight() / 2 + 5 + p);
            if (p > c.getHeight()) {
                tembak = false;
            }
            if (c.ins.pencuri.collidesWith(c.ins.peluru, true)) {
                c.ins.pencuri.setFrameSequence(c.ins.gd.malingkena);
                coll++;
                c.ins.pencuri.nextFrame();
                if (coll >= 3) {
                    yPencuri = c.getHeight();
                    c.ins.pencuri.setFrameSequence(c.ins.gd.malingseq001);
                    coll = 0;
                    tembak = false;
                    level++;
                    xP = true;
                }
            }
        } else if (!tembak) {
            c.ins.peluru.setPosition(c.getWidth(), 0);
            p = 0;
        }

        if (c.t.life == 0) {
            over = true;
            ov++;
            if (ov > 15) {
                c.pindahState(c.stateLevel);
                c.t.life = 3;
            }
        }

    }

    public void updateGambar(Graphics g) {
        c.t.background(g, c, 0xffffff);

        c.ins.penyelamat.paint(g);
        c.ins.penyelamat.nextFrame();
        c.ins.pencuri.paint(g);
        c.ins.pencuri.nextFrame();
        c.ins.peluru.paint(g);
        c.ins.peluru.nextFrame();

        c.t.icon(g, c, "Level 4");

        //arah
        g.drawImage(c.ins.imgFire, c.getWidth() / 2, c.getHeight() - c.ins.imgFire.getHeight() / 2 - 60, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.imgLeftArrow, c.ins.imgLeftArrow.getWidth() / 2, c.getHeight() - c.ins.imgLeftArrow.getHeight() / 2 - 60, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.imgRightArrow, c.getWidth() - c.ins.imgRightArrow.getWidth() / 2, c.getHeight() - c.ins.imgRightArrow.getHeight() / 2 - 60, Graphics.HCENTER | Graphics.VCENTER);

        c.t.petunjuk(g, c, "Selamatkan hewan langka", "dari pemburu liar");

        if (win) {
            i++;
            if (i > 8) {
                c.sound.play(c.sound.berubah);
                c.t.win(g, c, true);
                i = 0;
                if (c.t.level == 3) {
                    c.t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }

        //nyawa habis
        if (over) {
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("NYAWA HABIS!", c.getWidth() / 2, c.getHeight() / 2, Graphics.BASELINE | Graphics.HCENTER);
        }
    }

    public void hapusResource() {
        c.ins.hapusBab4();
    }

    public void tapEvent(int x, int y) {
        if (!over) {
            c.t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

            if (y > c.getHeight() - c.ins.imgLeftArrow.getHeight() - 60 && y < c.getHeight() - 60) {
                if (x > 0 && x < c.ins.imgLeftArrow.getWidth() && this.xPenyelamat > -60) {
                    c.sound.play(c.sound.menu);
                    this.xPenyelamat -= 15;
                } else if (x > c.getWidth() - c.ins.imgRightArrow.getWidth() && x < c.getWidth() && this.xPenyelamat < 60) {
                    c.sound.play(c.sound.menu);
                    this.xPenyelamat += 15;
                }
            }

            if (x > c.getWidth() / 2 - c.ins.imgFire.getWidth() / 2 && y > c.getHeight() - c.ins.imgFire.getHeight() - 60 && x < c.getWidth() / 2 + c.ins.imgFire.getWidth() / 2 && y < c.getHeight() - 60 && !tembak) {
                tembak = true;
                temp = c.ins.penyelamat.getX() + c.ins.penyelamat.getWidth() / 2 - c.ins.peluru.getWidth() / 2;
            }
        }
    }
}
