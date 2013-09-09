/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Control.Canvas;
import GameIPA6.Control.GameDesign;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author user
 */
public class StateLevel7 implements State {

    private Canvas c;
    private int x, i, limit;
    private boolean waktuHabis, win;
    private String ket;
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel7(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        c.ins.pendorong.setFrameSequence(c.ins.gd.pendorongseq001);
        x = 0;
        i = 0;
        limit = 60;
        waktuHabis = false;
        win = false;
        over = false;
        ov = 0;
    }

    public void updateLogika() {
//        c.getAudioManager().playSample(c.backsound1);
        ket = "Taruh disini";
        //waktu habis
        if (limit < 1) {
            //game finish
            if (x >= 101 && x <= 103) {
                ket = "Hore, berhasil!";
                win = true;
            } else {
                waktuHabis = true;
                c.t.life--;
                x = 0;
                limit = 60;
            }
        } else if (x >= 101 && x <= 103) {
            ket = "Stop, sudah pas!!";
        } else if (x > 103) {
            ket = "Yah, lewat...";
        }

        //game start
        if (x > 0 && limit > 0) {
            limit--;
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
            //waktu habis
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("Gagal", c.getWidth() / 2, c.getHeight() / 2 - 10, Graphics.BASELINE | Graphics.HCENTER);
            g.setColor(0, 0, 0);
            g.drawString("Klik disini...", c.getWidth() / 2, c.getHeight() / 2 + 15, Graphics.BASELINE | Graphics.HCENTER);
        } else {
            g.drawImage(c.ins.imgBackground, c.getWidth() / 2, c.ins.imgBackground.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
            c.t.icon(g, c, "Level 7");
            g.setColor(0, 0, 0);
            g.drawString(limit + " detik", c.getWidth() / 2, 80, Graphics.BASELINE | Graphics.HCENTER);
            g.drawString(ket, 176, 165, Graphics.BASELINE | Graphics.HCENTER);

            //orang
            c.ins.pendorong.setPosition(x, 200);
            c.ins.pendorong.paint(g);

            //run
            g.drawImage(c.ins.imgRun, c.getWidth() - c.ins.imgRun.getWidth() / 2, c.getHeight() - c.ins.imgRun.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            if (win) {
                c.t.win(g, c, true);
                i++;
                if (i > 8) {
                    c.getAudioManager().playSample(c.berubah);
                    if (c.t.level == 6) {
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
        c.ins.hapusBab7();
    }

    public void tapEvent(int x, int y) {
        if (!over) {
            if (waktuHabis) {
                if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                    waktuHabis = false;
                }
            } else if (!win) {
                c.t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

                //arah
                if (y > c.getHeight() - c.ins.imgRun.getHeight() && y < c.getHeight() && !win) {
                    if (x > c.getWidth() - c.ins.imgRun.getWidth() && x < c.getWidth()) {
                        c.getAudioManager().playSample(c.menu);
                        c.ins.pendorong.nextFrame();
                        this.x += 3;
                    }
                }
            }
        }
    }
}
