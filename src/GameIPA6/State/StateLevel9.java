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
public class StateLevel9 implements State {

    private Canvas c;
    private boolean win, gagal, matahari, merkurius, venus, bumi, mars, yupiter, saturnus, uranus, neptunus;
    private String tugas = "";
    private String[] planet = {"", "", "", "", "", "", "", "", ""};
    private int i, tgs, time;

    public StateLevel9(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        i = 0;
        win = false;
        tgs = 0;
        time = 300;
        gagal = false;
        matahari = false;
        merkurius = false;
        venus = false;
        bumi = false;
        mars = false;
        yupiter = false;
        saturnus = false;
        uranus = false;
        neptunus = false;
        planet[0] = "";
        planet[1] = "";
        planet[2] = "";
        planet[3] = "";
        planet[4] = "";
        planet[5] = "";
        planet[6] = "";
        planet[7] = "";
        planet[8] = "";
    }

    public void updateLogika() {
        c.sound.play(c.sound.backsound1);
        if (tgs > 0) {
            time--;
        }
        switch (tgs) {
            case (0):
                tugas = "Bumi";
                break;
            case (1):
                tugas = "Venus";
                break;
            case (2):
                tugas = "Merkurius";
                break;
            case (3):
                tugas = "Yupiter";
                break;
            case (4):
                tugas = "Neptunus";
                break;
            case (5):
                tugas = "Saturnus";
                break;
            case (6):
                tugas = "Mars";
                break;
            case (7):
                tugas = "Uranus";
                break;
            case (8):
                tugas = "Matahari";
                break;
        }

        //selesai
        if (planet[0] == "Matahari" && planet[1] == "Merkurius" && planet[2] == "Venus" && planet[3] == "Bumi" && planet[4] == "Mars" && planet[5] == "Yupiter" && planet[6] == "Saturnus" && planet[7] == "Uranus" && planet[8] == "Neptunus") {
            win = true;
        } else if (tgs > 8) {
            gagal = true;
        }
        if (time < 0) {
            gagal = true;
        }
        if (gagal) {
            tgs = 0;
            matahari = false;
            merkurius = false;
            venus = false;
            bumi = false;
            mars = false;
            yupiter = false;
            saturnus = false;
            uranus = false;
            neptunus = false;
            planet[0] = "";
            planet[1] = "";
            planet[2] = "";
            planet[3] = "";
            planet[4] = "";
            planet[5] = "";
            planet[6] = "";
            planet[7] = "";
            planet[8] = "";
        }

        //nyawa habis
        if (c.t.life == 0) {
            c.pindahState(c.stateLevel);
            c.t.life = 3;
        }
    }

    public void updateGambar(Graphics g) {
        if (gagal) {
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("Gagal", c.getWidth() / 2, c.getHeight() / 2 - 10, Graphics.BASELINE | Graphics.HCENTER);
            g.setColor(0, 0, 0);
            g.drawString("Klik disini...", c.getWidth() / 2, c.getHeight() / 2 + 15, Graphics.BASELINE | Graphics.HCENTER);
        } else {
            c.t.background(g, c, 0x000000);
            g.drawImage(c.ins.imgBackground, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            //tata surya
            g.drawImage(c.ins.tataSurya, c.getWidth() / 2, c.ins.tataSurya.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
            g.drawImage(c.ins.pilih, c.getWidth() / 2, c.ins.pilih.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            
            //tugas
            g.setColor(0, 0, 255);
            g.fillRect(0, c.getHeight() - 110, c.getWidth(), 50);
            g.setColor(255, 255, 255);
            g.drawString(tugas, c.getWidth() / 2, c.getHeight() - 80, Graphics.HCENTER | Graphics.BASELINE);            g.drawString(tugas, c.getWidth() / 2, c.getHeight() - 80, Graphics.HCENTER | Graphics.BASELINE);
                        
            c.t.petunjuk(g, c, "Pilih planet", "sesuai pada posisinya");

            //hasil
            g.setColor(0xffffff);
            g.drawString("Waktu : " + time + " s", 180, 270, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("1. " + planet[0], c.getWidth() / 2, 165, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("2. " + planet[1], c.getWidth() / 2, 180, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("3. " + planet[2], c.getWidth() / 2, 195, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("4. " + planet[3], c.getWidth() / 2, 210, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("5. " + planet[4], c.getWidth() / 2, 225, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("6. " + planet[5], c.getWidth() / 2, 240, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("7. " + planet[6], c.getWidth() / 2, 255, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("8. " + planet[7], c.getWidth() / 2, 270, Graphics.HCENTER | Graphics.BASELINE);
//            g.drawString("9. " + planet[8], c.getWidth() / 2, 285, Graphics.HCENTER | Graphics.BASELINE);

            
            //icon
            c.t.icon(g, c, "Level 9");

            if (win) {
                c.t.win(g, c, true);
                i++;
                if (i > 8) {
                    c.sound.play(c.sound.berubah);
                    if (c.t.level == 8) {
                        c.t.level++;
                    }
                    c.pindahState(c.stateLevel);
                }
            }
        }
    }

    public void hapusResource() {
        planet[0] = "";
        planet[1] = "";
        planet[2] = "";
        planet[3] = "";
        planet[4] = "";
        planet[5] = "";
        planet[6] = "";
        planet[7] = "";
        planet[8] = "";
        c.ins.hapusBab9();
    }

    public void tapEvent(int x, int y) {
        if (gagal) {
            if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                gagal = false;
                time = 300;
                c.t.life--;
            }
        } else {
            c.t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

            //matahari
            if (x > 204 && x < 240 && y > 0 && y < 53) {
                c.sound.play(c.sound.menu);
                matahari = true;
                planet[0] = tugas;
                tgs++;
            }
            //merkurius
            if (x > 195 && x < 206 && y > 65 && y < 73) {
                c.sound.play(c.sound.menu);
                merkurius = true;
                planet[1] = tugas;
                tgs++;
            }
            //venus
            if (x > 179 && x < 193 && y > 84 && y < 93) {
                c.sound.play(c.sound.menu);
                venus = true;
                planet[2] = tugas;
                tgs++;
            }
            //bumi
            if (x > 154 && x < 173 && y > 100 && y < 116) {
                c.sound.play(c.sound.menu);
                bumi = true;
                planet[3] = tugas;
                tgs++;
            }
            //mars
            if (x > 134 && x < 152 && y > 124 && y < 140) {
                c.sound.play(c.sound.menu);
                mars = true;
                planet[4] = tugas;
                tgs++;
            }
            //yupiter
            if (x > 83 && x < 138 && y > 148 && y < 184) {
                c.sound.play(c.sound.menu);
                yupiter = true;
                planet[5] = tugas;
                tgs++;
            }
            //saturnus
            if (x > 53 && x < 83 && y > 196 && y < 221) {
                c.sound.play(c.sound.menu);
                saturnus = true;
                planet[6] = tugas;
                tgs++;
            }
            //uranus
            if (x > 28 && x < 47 && y > 225 && y < 242) {
                c.sound.play(c.sound.menu);
                uranus = true;
                planet[7] = tugas;
                tgs++;
            }
            //neptunus
            if (x > 3 && x < 28 && y > 250 && y < 271) {
                c.sound.play(c.sound.menu);
                neptunus = true;
                planet[8] = tugas;
                tgs++;
            }
        }
    }
}
