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
public class StateLevel6 implements State {

    private Canvas c;
    private Image gmb, pilih;
    private int i, j, k, time, tugas;
    private boolean waktuHabis, gagal, win;

    public StateLevel6(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            i = 0;
            j = 0;
            tugas = 0;
            time = 60;
            win = false;
            gagal = false;
            waktuHabis = false;
            gmb = Image.createImage("/GameIPA6/Image/bab6/panci.png");
            pilih = Image.createImage("/GameIPA6/Image/bab6/pilih.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        if (tugas > 0 && !win) {
            time--;
        }
        if (time < 0) {
            waktuHabis = true;
            tugas = 0;
        }
        if (t.life == 0) {
            gagal = true;
            k++;
            if (k > 8) {
                c.pindahState(c.stateLevel);
                t.life = 3;
            }
        }
        try {
            switch (tugas) {
                case (0):
                    gmb = Image.createImage("/GameIPA6/Image/bab6/panci.png");
                    break;
                case (1):
                    gmb = Image.createImage("/GameIPA6/Image/bab6/toples.png");
                    break;
                case (2):
                    gmb = Image.createImage("/GameIPA6/Image/bab6/meja.png");
                    break;
                case (3):
                    gmb = Image.createImage("/GameIPA6/Image/bab6/sofa.png");
                    break;
                case (4):
                    gmb = Image.createImage("/GameIPA6/Image/bab6/cermin.png");
                    break;
                case (5):
                    win = true;
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
            t.background(g, c, 0xffffff);
            t.icon(g, c, "Level 6");

            //gambar
            g.drawImage(gmb, c.getWidth() / 2, c.getHeight() / 2 - 40, Graphics.VCENTER | Graphics.HCENTER);
            g.drawImage(pilih, c.getWidth() / 2, c.getHeight() - pilih.getHeight() / 2 - 70, Graphics.VCENTER | Graphics.HCENTER);

            g.drawString(time + " detik", c.getWidth() / 2, 50, Graphics.BASELINE | Graphics.HCENTER);

            if (gagal) {
                t.win(g, c, false);
                j++;
                if (j > 8) {
                    gagal = false;
                    j = 0;
                }
            } else {
                t.petunjuk(g, c, "Terbuat dari", "apakah benda diatas?");
            }

            if (win) {
                t.win(g, c, true);
                i++;
                if (i > 8) {
                    sound.play(sound.berubah);
                    if (t.level == 5) {
                        if (t.level == 5) {
                            t.level++;
                        }
                    }
                    c.pindahState(c.stateLevel);
                    i = 0;
                }
            }
        }
    }

    public void hapusResource() {
        gmb = null;
        pilih = null;
    }

    public void tapEvent(int x, int y) {
        if (waktuHabis) {
            if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                waktuHabis = false;
                t.life--;
                time = 60;
            }
        } else {
            t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);
            if (x > 21 && y > 272 && x < 51 && y < 324) {
                if (tugas == 1) {
                    sound.play(sound.menu);
                    tugas++;
                } else {
                    sound.play(sound.salah);
                    gagal = true;
                    t.life--;
                    j = 0;
                }
            }
            if (x > 62 && y > 272 && x < 96 && y < 324) {
                if (tugas == 0) {
                    sound.play(sound.menu);
                    tugas++;
                } else {
                    sound.play(sound.salah);
                    gagal = true;
                    t.life--;
                    j = 0;
                }
            }
            if (x > 106 && y > 272 && x < 133 && y < 324) {
                if (tugas == 3) {
                    sound.play(sound.menu);
                    tugas++;
                } else {
                    sound.play(sound.salah);
                    gagal = true;
                    t.life--;
                    j = 0;
                }
            }
            if (x > 141 && y > 272 && x < 177 && y < 324) {
                if (tugas == 4) {
                    sound.play(sound.menu);
                    tugas++;
                } else {
                    sound.play(sound.salah);
                    gagal = true;
                    t.life--;
                    j = 0;
                }
            }
            if (x > 184 && y > 274 && x < 220 && y < 326) {
                if (tugas == 2) {
                    sound.play(sound.menu);
                    tugas++;
                } else {
                    sound.play(sound.salah);
                    gagal = true;
                    t.life--;
                    j = 0;
                }
            }
        }
    }
}