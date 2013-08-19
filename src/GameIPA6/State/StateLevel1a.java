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
public class StateLevel1a implements State {

    private Canvas c;
    private boolean salah, benar;
    private int x, i;
    
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel1a(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        salah = false;
        benar = false;
        over = false;
        ov = 0;
    }

    public void updateLogika() {
        c.sound.play(c.sound.backsound1);
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

        //balok
        g.drawImage(c.ins.balok, c.getWidth() / 2, 50 + c.ins.balok.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        //pilihan
        g.drawImage(c.ins.ular, c.getWidth() / 2 - 50, c.getHeight() - c.ins.ular.getHeight() / 2 - 70, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.cicak, c.getWidth() / 2, c.getHeight() - c.ins.cicak.getHeight() / 2 - 70, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.bebek, c.getWidth() / 2 + 50, c.getHeight() - c.ins.bebek.getHeight() / 2 - 70, Graphics.HCENTER | Graphics.VCENTER);

        //pertanyaan
        if (salah) {
            x++;
            c.t.win(g, c, false);
            if (x == 10) {
                this.x = 0;
                salah = false;
            }
        } else if (!salah) {
            if (!benar) {
                c.t.petunjuk(g, c, "Hewan mana yang dapat", "memanjat naik ke atas balok?");
            } else {
                c.t.win(g, c, true);
                i++;
                if (i > 8) {
                    i = 0;
                    c.pindahState(c.stateLevel1ab);
                }
            }
        }

        //nyawa habis
        if (over) {
            g.setColor(255, 0, 0);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 255, 255);
            g.drawString("NYAWA HABIS!", c.getWidth() / 2, c.getHeight() / 2, Graphics.BASELINE | Graphics.HCENTER);
        }

        c.t.icon(g, c, "Level 1");
    }

    public void hapusResource() {
        c.sound.play(c.sound.stop);
    }

    public void tapEvent(int x, int y) {
        if (!over && !benar) {
            if (x > 51 && y > 287 && x < 89 && y < 323 || x > 151 && y > 287 && x < 188 && y < 323) {
                c.t.life--;
                this.x = 0;
                salah = true;
                c.sound.play(c.sound.salah);
            }
            if (x > 100 && y > 287 && x < 138 && y < 323) {
                benar = true;
                c.sound.play(c.sound.berubah);
            }
            if (x > 0 && x < 40 && y > 0 && y < 40) {
                c.pindahState(c.statePause);
                c.sound.play(c.sound.beep);
            }
        }
    }
}
