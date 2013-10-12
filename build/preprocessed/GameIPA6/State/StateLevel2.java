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
public class StateLevel2 implements State {

    private Canvas c;
    private boolean win, gagal, jgt, kms, pydr, pgl, spr, ovrm;
    private int i, j;
    
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel2(Canvas c) {
        this.c = c;
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
        over = false;
        ov = 0;
    }

    public void updateLogika() {
        c.s.play(c.s.backsound1);
        if (c.t.life == 0) {
            over = true;
            ov++;
            if (ov > 30) {
                c.pindahState(c.stateLevel);
                c.t.life = 3;
            }
        }
    }

    public void updateGambar(Graphics g) {
        c.t.background(g, c, 0xffffff);

        g.drawImage(c.ins.laki, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.pilih, 160, 175, Graphics.HCENTER | Graphics.VCENTER);

        if (jgt) {
            g.drawImage(c.ins.jenggot, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (kms) {
            g.drawImage(c.ins.kumis, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (pydr) {
            g.drawImage(c.ins.payudara, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (pgl) {
            g.drawImage(c.ins.pinggul, 47, 151, Graphics.HCENTER | Graphics.VCENTER);
        }

        g.setColor(0, 0, 0);

        if (spr) {
            g.drawString("Ciri primer:", 42, 278, Graphics.BASELINE | Graphics.HCENTER);
            g.drawImage(c.ins.sperma, 42, 313, Graphics.HCENTER | Graphics.VCENTER);
        }
        if (ovrm) {
            g.drawString("Ciri primer:", 42, 278, Graphics.BASELINE | Graphics.HCENTER);
            g.drawImage(c.ins.ovarium, 42, 313, Graphics.HCENTER | Graphics.VCENTER);
        }

        c.t.petunjuk(g, c, "dewasa nanti", "kamu seperti apa?");

        g.drawImage(c.ins.imgCheck, c.getWidth() - c.ins.imgCheck.getWidth() / 2, c.getHeight() - c.ins.imgCheck.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        c.t.icon(g, c, "Level 2");

        if (gagal) {
            c.t.win(g, c, false);
            j++;
            if (j > 30) {
                c.t.life--;
                j = 0;
                gagal = false;
            }
        }

        if (win) {
            c.t.win(g, c, true);
            i++;
            if (i > 30) {
                c.s.play(c.s.pedang);
                if (c.t.level == 1) {
                    c.t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }
        
        //nyawa habis
        if (over) {
            g.setColor(255, 0, 0);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 255, 255);
            g.drawString("NYAWA HABIS!", c.getWidth() / 2, c.getHeight() / 2, Graphics.BASELINE | Graphics.HCENTER);
        }
    }

    public void hapusResource() {
        c.ins.hapusBab2();
    }

    public void tapEvent(int x, int y) {
        if (! over && !win) {
            c.t.tapPause(x, y, c);
            if (x > c.getWidth() - c.ins.imgCheck.getWidth() && x < c.getWidth() && y > c.getHeight() - c.ins.imgCheck.getHeight() && y < c.getHeight()) {
                if (kms && jgt && spr && !pydr && !pgl && !ovrm || !kms && !jgt && !spr && pydr && pgl && ovrm) {
                    win = true;
                } else {
                    gagal = true;
                    c.s.play(c.s.salah);
                }
            }
            if (x > 131 && x < 200 && y > 22 && y < 110) {
                if (pgl) {
                    pgl = false;
                } else {
                    pgl = true;
                }
                c.s.play(c.s.beep);
            }
            if (x > 89 && x < 153 && y > 122 && y < 160) {
                if (pydr) {
                    pydr = false;
                } else {
                    pydr = true;
                }
                c.s.play(c.s.beep);
            }
            if (x > 179 && x < 229 && y > 123 && y < 166) {
                if (kms) {
                    kms = false;
                } else {
                    kms = true;
                }
                c.s.play(c.s.beep);
            }
            if (x > 95 && x < 146 && y > 184 && y < 228) {
                if (jgt) {
                    jgt = false;
                } else {
                    jgt = true;
                }
                c.s.play(c.s.beep);
            }
            if (x > 171 && x < 224 && y > 180 && y < 228) {
                spr = true;
                ovrm = false;
                c.s.play(c.s.beep);
            }
            if (x > 99 && x < 221 && y > 237 && y < 323) {
                ovrm = true;
                spr = false;
                c.s.play(c.s.beep);
            }
        }
    }
}
