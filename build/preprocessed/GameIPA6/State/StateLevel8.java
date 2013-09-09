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
public class StateLevel8 implements State {

    private Canvas c;
    private boolean waktuHabis, kakak, makan, ortu, adik, mandi, win;
    private String tugas1, tugas2, tugas3;
    private int i, limit, tugasSelesai;
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel8(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
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
        over = false;
        ov = 0;
    }

    public void updateLogika() {
//        c.getAudioManager().playSample(c.backsound1);
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
            c.t.life--;
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
            g.drawImage(c.ins.rumah, c.getWidth() / 2, c.ins.rumah.getHeight() / 2 + 50, Graphics.HCENTER | Graphics.VCENTER);

            //jendela
            if (kakak) {
                g.drawImage(c.ins.jendela, c.ins.jendela.getWidth() / 2 + 30, c.ins.jendela.getHeight() / 2 + 108, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (makan) {
                g.drawImage(c.ins.jendela, c.ins.jendela.getWidth() / 2 + 30, c.ins.jendela.getHeight() / 2 + 180, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (ortu) {
                g.drawImage(c.ins.jendela, c.ins.jendela.getWidth() / 2 + 97, c.ins.jendela.getHeight() / 2 + 128, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (adik) {
                g.drawImage(c.ins.jendela, c.ins.jendela.getWidth() / 2 + 162, c.ins.jendela.getHeight() / 2 + 108, Graphics.HCENTER | Graphics.VCENTER);
            }
            if (mandi) {
                g.drawImage(c.ins.jendela, c.ins.jendela.getWidth() / 2 + 162, c.ins.jendela.getHeight() / 2 + 180, Graphics.HCENTER | Graphics.VCENTER);
            }

            //tugas1
            g.setColor(0, 0, 255);
            g.fillRect(0, 280, c.getWidth(), c.getHeight() - 280);
            g.setColor(255, 255, 255);
            g.drawString(tugas1, c.getWidth() / 2, 300, Graphics.BASELINE | Graphics.HCENTER);
            g.drawString(tugas2, c.getWidth() / 2, 315, Graphics.BASELINE | Graphics.HCENTER);
            g.drawString(tugas3, c.getWidth() / 2, 330, Graphics.BASELINE | Graphics.HCENTER);

            //limit & time
            g.drawImage(c.ins.listrik, 10, 270, Graphics.HCENTER | Graphics.VCENTER);
            g.drawString(limit + " watt", 50, 275, Graphics.BASELINE | Graphics.HCENTER);
            c.t.petunjuk(g, c, "Nyalakan lampu", "hanya jika dibutuhkan");

            //icon
            c.t.icon(g, c, "Level 8");

            if (win) {
                c.t.win(g, c, true);
                i++;
                if (i > 8) {
                    c.getAudioManager().playSample(c.berubah);
                    if (c.t.level == 7) {
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
    }

    public void hapusResource() {
        c.ins.hapusBab8();
    }

    public void tapEvent(int x, int y) {
        if (!over) {
            if (waktuHabis) {
                if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                    waktuHabis = false;
                }
            } else if (!win) {
                c.t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

                if (x > 33 && x < 78 && y > 112 && y < 152) {
                    c.getAudioManager().playSample(c.menu);
                    if (kakak) {
                        kakak = false;
                    } else {
                        kakak = true;
                    }
                }
                if (x > 33 && x < 78 && y > 185 && y < 222) {
                    c.getAudioManager().playSample(c.menu);
                    if (makan) {
                        makan = false;
                    } else {
                        makan = true;
                    }
                }
                if (x > 100 && x < 145 && y > 134 && y < 172) {
                    c.getAudioManager().playSample(c.menu);
                    if (ortu) {
                        ortu = false;
                    } else {
                        ortu = true;
                    }
                }
                if (x > 166 && x < 210 && y > 112 && y < 152) {
                    c.getAudioManager().playSample(c.menu);
                    if (adik) {
                        adik = false;
                    } else {
                        adik = true;
                    }
                }
                if (x > 166 && x < 210 && y > 185 && y < 222) {
                    c.getAudioManager().playSample(c.menu);
                    if (mandi) {
                        mandi = false;
                    } else {
                        mandi = true;
                    }
                }
            }
        }
    }
}