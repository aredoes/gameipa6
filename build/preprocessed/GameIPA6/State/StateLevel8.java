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
public class StateLevel8 implements State {

    private Canvas c;
    private Image rumah, jendela, listrik;
    private boolean waktuHabis, kakak, makan, ortu, adik, mandi, win;
    private String tugas1, tugas2, tugas3;
    private int i, limit, tugasSelesai;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel8(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        try {
            i = 0;
            win = false;
            kakak = false;
            makan = false;
            ortu = false;
            adik = false;
            mandi = false;
            waktuHabis = false;
            limit = 1000;
            tugas1 = "kakak bangun";
            tugas2 = "";
            tugas3 = "";
            tugasSelesai = 0;
            rumah = Image.createImage("/GameIPA6/Image/bab8/rumah.png");
            jendela = Image.createImage("/GameIPA6/Image/bab8/jendela.png");
            listrik = Image.createImage("/GameIPA6/Image/bab8/listrik.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        if (!win) {
            if (kakak) {
                limit--;
            }
            if (makan) {
                limit--;
            }
            if (ortu) {
                limit--;
            }
            if (adik) {
                limit--;
            }
            if (mandi) {
                limit--;
            }
        }
        if (limit < -1) {
            t.life--;
            limit = 1000;
            tugasSelesai = 0;
            waktuHabis = true;
            kakak = false;
            makan = false;
            ortu = false;
            adik = false;
            mandi = false;
            tugas1 = "kakak bangun";
        }

        //tugas1
        if (tugas1.equals("kakak bangun")) {
            if (kakak && !adik && !ortu && !mandi && !makan) {
                tugasSelesai++;
                tugas1 = "kakak mandi";
                tugas2 = "adik bangun";
            }
        }
        //tugas2
        if (tugas1.equals("kakak mandi") && tugas2.equals("adik bangun")) {
            if (!kakak && adik && !ortu && mandi && !makan) {
                tugasSelesai++;
                tugas1 = "adik makan";
                tugas2 = "ortu bangun";
                tugas3 = "kakak mandi";
            }
        }
        //tugas3
        if (tugas1.equals("adik makan") && tugas2.equals("ortu bangun") && tugas3.equals("kakak mandi")) {
            if (!kakak && !adik && ortu && mandi && makan) {
                tugasSelesai++;
                tugas1 = "adik mandi";
                tugas2 = "ortu makan";
                tugas3 = "kakak makan";

            }
        }
        //tugas4
        if (tugas1.equals("adik mandi") && tugas2.equals("ortu makan") && tugas3.equals("kakak makan")) {
            if (!kakak && !adik && !ortu && mandi && makan) {
                tugasSelesai++;
                tugas1 = "ortu ke kamar";
                tugas2 = "kakak ke kamar";
                tugas3 = "adik ke kamar kakak";
            }
        }
        //tugas5
        if (tugas1.equals("ortu ke kamar") && tugas2.equals("kakak ke kamar") && tugas3.equals("adik ke kamar kakak")) {
            if (kakak && !adik && ortu && !mandi && !makan) {
                tugasSelesai++;
                tugas1 = "adik ke kamar ortu";
                tugas2 = "kakak ke kamar adik";
                tugas3 = "";
            }
        }
        //tugas6
        if (tugas1.equals("adik ke kamar ortu") && tugas2.equals("kakak ke kamar adik") && tugas3.equals("")) {
            if (!kakak && adik && ortu && !mandi && !makan) {
                tugasSelesai++;
                tugas1 = "ortu tidur";
                tugas2 = "adik ke kamar";
                tugas3 = "";
            }
        }
        //tugas7
        if (tugas1.equals("ortu tidur") && tugas2.equals("adik ke kamar") && tugas3.equals("")) {
            if (!kakak && adik && !ortu && !mandi && !makan) {
                tugasSelesai++;
                tugas1 = "Ibu mandi";
                tugas2 = "adik tidur";
                tugas3 = "kakak ke kamar";
            }
        }
        //tugas8
        if (tugas1.equals("Ibu mandi") && tugas2.equals("adik tidur") && tugas3.equals("kakak ke kamar")) {
            if (kakak && !adik && !ortu && mandi && !makan) {
                tugasSelesai++;
                tugas1 = "Ayah mandi";
                tugas2 = "Ibu ke kamar";
                tugas3 = "Adik bangun";

            }
        }
        //selesai
        if (tugasSelesai == 8 && kakak && adik && ortu && mandi && !makan) {
            win = true;
        }

        //nyawa habis
        if (t.life == 0) {
            c.pindahState(c.stateLevel);
            t.life = 3;
        }
    }

    public void updateGambar(Graphics g) {
        if (waktuHabis) {
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("Gagal", c.getWidth() / 2, c.getHeight() / 2 - 10, Graphics.BASELINE | Graphics.HCENTER);
            g.setColor(0, 0, 0);
            g.drawString("Klik disini...", c.getWidth() / 2, c.getHeight() / 2 + 15, Graphics.BASELINE | Graphics.HCENTER);
        } else {
            g.setColor(255, 255, 255);
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
            g.setColor(0x6e380c);
            g.fillRect(0, 200, c.getWidth(), 80);
            g.drawImage(rumah, c.getWidth() / 2, rumah.getHeight() / 2 + 50, Graphics.HCENTER | Graphics.VCENTER);

            //jendela
            if (kakak) {
                g.drawImage(jendela, jendela.getWidth() / 2 + 30, jendela.getHeight() / 2 + 108, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (makan) {
                g.drawImage(jendela, jendela.getWidth() / 2 + 30, jendela.getHeight() / 2 + 180, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (ortu) {
                g.drawImage(jendela, jendela.getWidth() / 2 + 97, jendela.getHeight() / 2 + 128, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (adik) {
                g.drawImage(jendela, jendela.getWidth() / 2 + 162, jendela.getHeight() / 2 + 108, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (mandi) {
                g.drawImage(jendela, jendela.getWidth() / 2 + 162, jendela.getHeight() / 2 + 180, Graphics.HCENTER | Graphics.VCENTER);
            }

            //tugas1
            g.setColor(0, 0, 255);
            g.fillRect(0, 280, c.getWidth(), c.getHeight() - 280);
            g.setColor(255, 255, 255);
            g.drawString(tugas1, c.getWidth() / 2, 300, Graphics.BASELINE | Graphics.HCENTER);
            g.drawString(tugas2, c.getWidth() / 2, 315, Graphics.BASELINE | Graphics.HCENTER);
            g.drawString(tugas3, c.getWidth() / 2, 330, Graphics.BASELINE | Graphics.HCENTER);

            //limit & time
            g.drawImage(listrik, 10, 270, Graphics.HCENTER | Graphics.VCENTER);
            g.drawString(limit + " A", 50, 275, Graphics.BASELINE | Graphics.HCENTER);
            t.petunjuk(g, c, "Nyalakan lampu", "hanya jika dibutuhkan");

            //icon
            t.icon(g, c, "Level 8");

            if (win) {
                t.win(g, c, true);
                i++;
                if (i > 8) {
                    sound.play(sound.berubah);
                    if (t.level == 7) {
                        t.level++;
                    }
                    c.pindahState(c.stateLevel);
                }
            }
        }
    }

    public void hapusResource() {
        rumah = null;
        jendela = null;
        listrik = null;
    }

    public void tapEvent(int x, int y) {
        if (waktuHabis) {
            if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                waktuHabis = false;
            }
        } else {
            t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

            if (x > 33 && x < 78 && y > 112 && y < 152) {
                sound.play(sound.menu);
                if (kakak) {
                    kakak = false;
                } else {
                    kakak = true;
                }
            }
            if (x > 33 && x < 78 && y > 185 && y < 222) {
                sound.play(sound.menu);
                if (makan) {
                    makan = false;
                } else {
                    makan = true;
                }
            }
            if (x > 100 && x < 145 && y > 134 && y < 172) {
                sound.play(sound.menu);
                if (ortu) {
                    ortu = false;
                } else {
                    ortu = true;
                }
            }
            if (x > 166 && x < 210 && y > 112 && y < 152) {
                sound.play(sound.menu);
                if (adik) {
                    adik = false;
                } else {
                    adik = true;
                }
            }
            if (x > 166 && x < 210 && y > 185 && y < 222) {
                sound.play(sound.menu);
                if (mandi) {
                    mandi = false;
                } else {
                    mandi = true;
                }
            }
        }
    }
}
