/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
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
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel5(Canvas c) {
        this.c = c;
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
        over = false;
        ov = 0;
    }

    public void updateLogika() {
//        c.getAudioManager().playSample(c.backsound1);
        if (c.t.life == 0) {
            over = true;
            ov++;
            if (ov > 15) {
                c.pindahState(c.stateLevel);
                c.t.life = 3;
            }
        }
        if (tugas == 5) {
            win = true;
        }
        try {
            switch (tugas) {
                case (0):
                    c.ins.air = Image.createImage("/Image/bab5/air.png");
                    break;
                case (1):
                    c.ins.air = Image.createImage("/Image/bab5/air2.png");
                    break;
                case (2):
                    c.ins.air = Image.createImage("/Image/bab5/air3.png");
                    break;
                case (3):
                    c.ins.air = Image.createImage("/Image/bab5/air4.png");
                    break;
                case (4):
                    c.ins.air = Image.createImage("/Image/bab5/air5.png");
                    break;
                case (5):
                    c.ins.air = Image.createImage("/Image/bab5/air6.png");
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
                c.getAudioManager().playSample(c.salah);
                c.t.life--;
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
                c.getAudioManager().playSample(c.salah);
                c.t.life--;
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
                c.getAudioManager().playSample(c.salah);
                c.t.life--;
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
                c.getAudioManager().playSample(c.salah);
                c.t.life--;
            }
        }
    }

    public void updateGambar(Graphics g) {
        c.t.background(g, c, 0xffffff);

        //gambar
        g.drawImage(c.ins.bak, c.getWidth() / 2, 100, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.air, c.getWidth() / 2, 100, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.pipa, c.getWidth() / 2, 200, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.apibirukanan, x, y, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.apimerahkanan, x2, y2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.apimerah, x3, y3, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.apibiru, x4, y4, Graphics.HCENTER | Graphics.VCENTER);
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

        c.t.petunjuk(g, c, "Logam menyerap panas", "Plastik tahan dingin");
        c.t.icon(g, c, "Level 5");

        if (win) {
            c.t.win(g, c, true);
            i++;
            if (i > 8) {
                c.getAudioManager().playSample(c.berubah);
                i = 0;
                if (c.t.level == 4) {
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
        c.ins.hapusBab5();
    }

    public void tapEvent(int x, int y) {
        if (!over) {
            c.t.tapPause(x, y, c);
            try {
                if (x > 0 && y > c.getHeight() - 110 && x < c.getWidth() / 2 && y < c.getHeight() - 60) {
                    c.getAudioManager().playSample(c.menu);
                    c.ins.pipa = Image.createImage("/Image/bab5/pipa logam.png");
                    plastik = false;
                }
                if (x > c.getWidth() / 2 && y > c.getHeight() - 110 && x < c.getWidth() && y < c.getHeight() - 60) {
                    c.getAudioManager().playSample(c.menu);
                    c.ins.pipa = Image.createImage("/Image/bab5/pipa plastik.png");
                    plastik = true;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
