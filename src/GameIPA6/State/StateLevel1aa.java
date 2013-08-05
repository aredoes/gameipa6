/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Tools.LoadInisialisasi;
import GameIPA6.Tools.Sound;
import GameIPA6.Tools.Tools;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author user
 */
public class StateLevel1aa implements State {

    private Canvas c;
    private boolean salah, benar;
    private int x, i;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel1aa(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        salah = false;
        benar = false;
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

        //balok
        g.drawImage(ins.balok, c.getWidth() / 2, 50 + ins.balok.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        //pilihan
        g.drawImage(ins.ular, c.getWidth() / 2 - 50, c.getHeight() - ins.ular.getHeight() / 2 - 70, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.cicak, c.getWidth() / 2, c.getHeight() - ins.cicak.getHeight() / 2 - 70, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.bebek, c.getWidth() / 2 + 50, c.getHeight() - ins.bebek.getHeight() / 2 - 70, Graphics.HCENTER | Graphics.VCENTER);

        //pertanyaan
        if (salah) {
            x++;
            t.win(g, c, false);
            if (x == 10) {
                this.x = 0;
                salah = false;
            }
        } else if (!salah) {
            if (!benar) {
                t.petunjuk(g, c, "Hewan mana yang dapat", "memanjat naik ke atas balok?");
            } else {
                t.win(g, c, true);
                i++;
                if (i > 8) {
                    i = 0;
                    c.pindahState(c.stateLevel1ab);
                }
            }
        }

        t.icon(g, c, "Level 1");
    }

    public void hapusResource() {
        sound.play(sound.stop);
    }

    public void tapEvent(int x, int y) {
        if (x > 51 && y > 287 && x < 89 && y < 323 || x > 151 && y > 287 && x < 188 && y < 323 && !benar) {
            t.life--;
            this.x = 0;
            salah = true;
            sound.play(sound.salah);
        }
        if (x > 100 && y > 287 && x < 138 && y < 323 && !benar) {
            benar = true;
            sound.play(sound.berubah);
        }
        if (x > 0 && x < 40 && y > 0 && y < 40) {
            c.pindahState(c.statePause);
            sound.play(sound.beep);
        }
    }
}
