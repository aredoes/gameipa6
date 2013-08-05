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
public class StateLevel5 implements State {

    private Canvas c;
    private int i, x, y, x2, y2, x3, y3, x4, y4, tugas;
    private boolean plastik, win;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel5(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        win = false;
        i = 0;
        tugas = 0;
        x = -20;
        x2 = -140;
        x3 = c.getWidth() + 80;
        x4 = c.getWidth() + 200;
        y = 180;
        y2 = 220;
        y3 = 230;
        y4 = 200;
        plastik = true;
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        if (t.life == 0) {
            c.pindahState(c.stateLevel);
            t.life = 3;
        }
        if (tugas == 5) {
            win = true;
        }
        try {
            switch (tugas) {
                case (0):
                    ins.air = Image.createImage("/GameIPA6/Image/bab5/air.png");
                    break;
                case (1):
                    ins.air = Image.createImage("/GameIPA6/Image/bab5/air2.png");
                    break;
                case (2):
                    ins.air = Image.createImage("/GameIPA6/Image/bab5/air3.png");
                    break;
                case (3):
                    ins.air = Image.createImage("/GameIPA6/Image/bab5/air4.png");
                    break;
                case (4):
                    ins.air = Image.createImage("/GameIPA6/Image/bab5/air5.png");
                    break;
                case (5):
                    ins.air = Image.createImage("/GameIPA6/Image/bab5/air6.png");
                    break;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        x += 2;
        x2 += 1;
        x3 -= 1;
        x4 -= 2;
        if (x > c.getWidth() / 2 - 27) {
            x = -70;
            if (y == 180) {
                y = 220;
            } else if (y == 220) {
                y = 180;
            }
            if (!plastik && tugas < 5) {
                t.life--;
            }

        }
        if (x2 > c.getWidth() / 2 - 27) {
            x2 = -20;
            if (y2 == 180) {
                y2 = 220;
            } else if (y2 == 220) {
                y2 = 180;
            }
            if (!plastik) {
                tugas++;
            } else {
                t.life--;
            }
        }

        if (x3 < c.getWidth() / 2 + 27) {
            x3 = c.getWidth() + 70;
            if (y3 == 230) {
                y3 = 200;
            } else if (y3 == 200) {
                y3 = 230;
            }
            if (!plastik) {
                tugas++;
            } else {
                t.life--;
            }
        }

        if (x4 < c.getWidth() / 2 + 27) {
            x4 = c.getWidth() + 20;
            if (y4 == 200) {
                y4 = 230;
            } else if (y4 == 230) {
                y4 = 200;
            }
            if (!plastik && tugas < 5) {
                t.life--;
            }
        }
    }

    public void updateGambar(Graphics g) {
        t.background(g, c, 0xffffff);

        //gambar
        g.drawImage(ins.bak, c.getWidth() / 2, 100, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.air, c.getWidth() / 2, 100, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.pipa, c.getWidth() / 2, 200, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.apibirukanan, x, y, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.apimerahkanan, x2, y2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.apimerah, x3, y3, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.apibiru, x4, y4, Graphics.HCENTER | Graphics.VCENTER);
        g.setColor(0, 0, 0);
        g.drawString("Panaskan Air!", c.getWidth() / 2, c.getHeight() - 120, Graphics.BASELINE | Graphics.HCENTER);
        g.setColor(0x9f9d9d);
        g.fillRect(0, c.getHeight() - 110, c.getWidth() / 2, 50);
        g.setColor(255, 255, 255);
        g.drawString("LOGAM", c.getWidth() * 1 / 4, c.getHeight() - 80, Graphics.BASELINE | Graphics.HCENTER);
        g.setColor(0x5556f1);
        g.fillRect(c.getWidth() / 2, c.getHeight() - 110, c.getWidth() / 2, 50);
        g.setColor(255, 255, 255);
        g.drawString("PLASTIK", c.getWidth() * 3 / 4, c.getHeight() - 80, Graphics.BASELINE | Graphics.HCENTER);

        t.petunjuk(g, c, "Logam menyerap panas", "Plastik tahan dingin");
        t.icon(g, c, "Level 5");

        if (win) {
            t.win(g, c, true);
            i++;
            if (i > 8) {
                sound.play(sound.berubah);
                i = 0;
                if (t.level == 4) {
                    t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }

    }

    public void hapusResource() {
        ins.hapusBab5();
    }

    public void tapEvent(int x, int y) {
        t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);
        try {
            if (x > 0 && y > c.getHeight() - 110 && x < c.getWidth() / 2 && y < c.getHeight() - 60) {
                sound.play(sound.menu);
                ins.pipa = Image.createImage("/GameIPA6/Image/bab5/pipa logam.png");
                plastik = false;
            }
            if (x > c.getWidth() / 2 && y > c.getHeight() - 110 && x < c.getWidth() && y < c.getHeight() - 60) {
                sound.play(sound.menu);
                ins.pipa = Image.createImage("/GameIPA6/Image/bab5/pipa plastik.png");
                plastik = true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
