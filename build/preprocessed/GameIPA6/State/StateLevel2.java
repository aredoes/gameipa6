/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Tools.LoadInisialisasi;
import GameIPA6.Tools.Sound;
import GameIPA6.Tools.Tools;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author user
 */
public class StateLevel2 implements State {

    private Canvas c;
    private boolean win, gagal, jgt, kms, pydr, pgl, spr, ovrm;
    private int i, j;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel2(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        i = 0;
        j = 0;
        gagal = false;
        win = false;
        jgt = false;
        kms = false;
        pydr = false;
        pgl = false;
        spr = false;
        ovrm = false;
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        if (t.life == 0) {
            c.pindahState(c.stateLevel);
            t.life = 3;
        }

    }

    public void updateGambar(Graphics g) {
        t.background(g, c, 0xffffff);

        g.drawImage(ins.laki, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.pilih, 160, 175, Graphics.HCENTER | Graphics.VCENTER);

        if (jgt) {
            g.drawImage(ins.jenggot, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (kms) {
            g.drawImage(ins.kumis, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (pydr) {
            g.drawImage(ins.payudara, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (pgl) {
            g.drawImage(ins.pinggul, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }

        g.setColor(0, 0, 0);

        if (spr) {
            g.drawString("Ciri primer:", 42, 278, Graphics.BASELINE | Graphics.HCENTER);
            g.drawImage(ins.sperma, 42, 313, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (ovrm) {
            g.drawString("Ciri primer:", 42, 278, Graphics.BASELINE | Graphics.HCENTER);
            g.drawImage(ins.ovarium, 42, 313, Graphics.HCENTER | Graphics.VCENTER);
        }

        t.petunjuk(g, c, "dewasa nanti", "kamu seperti apa?");

        g.drawImage(ins.imgCheck, c.getWidth() - ins.imgCheck.getWidth() / 2, c.getHeight() - ins.imgCheck.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        t.icon(g, c, "Level 2");

        if (gagal) {
            t.win(g, c, false);
            j++;
            if (j > 8) {
                t.life--;
                j = 0;
                gagal = false;
            }
        }

        if (win) {
            t.win(g, c, true);
            i++;
            if (i > 8) {
                sound.play(sound.berubah);
                if (t.level == 1) {
                    t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }
    }

    public void hapusResource() {
        ins.hapusBab2();
    }

    public void tapEvent(int x, int y) {
        if (x > 131 && x < 200 && y > 22 && y < 110) {
            if (pgl) {
                pgl = false;
            } else {
                pgl = true;
            }
            sound.play(sound.beep);
        }
        if (x > 89 && x < 153 && y > 122 && y < 160) {
            if (pydr) {
                pydr = false;
            } else {
                pydr = true;
            }
            sound.play(sound.beep);
        }
        if (x > 179 && x < 229 && y > 123 && y < 166) {
            if (kms) {
                kms = false;
            } else {
                kms = true;
            }
            sound.play(sound.beep);
        }
        if (x > 95 && x < 146 && y > 184 && y < 228) {
            if (jgt) {
                jgt = false;
            } else {
                jgt = true;
            }
            sound.play(sound.beep);
        }
        if (x > 171 && x < 224 && y > 180 && y < 228) {
            spr = true;
            ovrm = false;
            sound.play(sound.beep);
        }
        if (x > 99 && x < 221 && y > 237 && y < 323) {
            ovrm = true;
            spr = false;
            sound.play(sound.beep);
        }

        t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

        if (x > c.getWidth() - ins.imgCheck.getWidth() && x < c.getWidth() && y > c.getHeight() - ins.imgCheck.getHeight() && y < c.getHeight()) {
            if (kms && jgt && spr && !pydr && !pgl && !ovrm || !kms && !jgt && !spr && pydr && pgl && ovrm) {
                win = true;
            } else {
                gagal = true;
                sound.play(sound.salah);
            }
        }
    }
}
