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
public class StateLevel3 implements State {

    private Canvas c;
    private int x, i, limit, xBackground, xBackground2;
    private boolean waktuHabis, finish;
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel3(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        i = 0;
        finish = false;
        c.ins.orang.setFrameSequence(c.ins.gd.orangjalanseq002);
        c.ins.penebang.setFrameSequence(c.ins.gd.penebangjalanseq002);
        x = 0;
        c.ins.orang.setPosition(0, c.getHeight() - 65 - c.ins.orang.getHeight());
        c.ins.penebang.setPosition(c.getWidth() - c.ins.penebang.getWidth(), c.getHeight() - 65 - c.ins.penebang.getHeight());
        limit = 120;
        xBackground = 0;
        xBackground2 = c.ins.imgBackground.getWidth();
        waktuHabis = false;
        over = false;
        ov = 0;
    }

    public void updateLogika() {
//        c.getAudioManager().playSample(c.backsound1);
        if (xBackground == c.ins.imgBackground.getWidth()) {
            xBackground = -c.ins.imgBackground.getWidth();
        } else if (xBackground2 == c.ins.imgBackground.getWidth()) {
            xBackground2 = -c.ins.imgBackground.getWidth();
        }

        //game start
        if (x > 1 && !finish) {
            xBackground += 2;
            xBackground2 += 2;
            limit--;
            c.ins.penebang.nextFrame();
            if (x > 2) {
                x--;
            }
        }

        //waktu habis
        if (limit < 0) {
            waktuHabis = true;
        }

        //game finish
        if (c.ins.orang.collidesWith(c.ins.penebang, true)) {
            finish = true;
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
            c.t.win(g, c, false);
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("Gagal", c.getWidth() / 2, c.getHeight() / 2 - 10, Graphics.BASELINE | Graphics.HCENTER);
            g.setColor(0, 0, 0);
            g.drawString("Klik disini...", c.getWidth() / 2, c.getHeight() / 2 + 15, Graphics.BASELINE | Graphics.HCENTER);
        } else {
            g.drawImage(c.ins.imgBackground, c.getWidth() / 2 - xBackground, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
            g.drawImage(c.ins.imgBackground, c.getWidth() / 2 - xBackground2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            c.t.petunjuk(g, c, "Tangkap", "Illegal Logging");

            g.drawString(limit + " detik", c.getWidth() / 2, 80, Graphics.BASELINE | Graphics.HCENTER);

            //orang
            c.ins.orang.setPosition(x, c.getHeight() - 65 - c.ins.orang.getHeight());
            c.ins.penebang.setPosition(c.getWidth() - c.ins.penebang.getWidth(), c.getHeight() - 65 - c.ins.penebang.getHeight());

            c.ins.orang.paint(g);
            c.ins.penebang.paint(g);

            //run
            g.drawImage(c.ins.imgRun, c.getWidth() - c.ins.imgRun.getWidth() / 2, c.getHeight() - c.ins.imgRun.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            c.t.icon(g, c, "Level 3");

            if (finish) {
                c.t.win(g, c, true);
                i++;
                if (i > 8) {
                    c.getAudioManager().playSample(c.berubah);
                    if (c.t.level == 2) {
                        c.t.level++;
                    }
                    i = 0;
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
        c.ins.hapusBab3();
    }

    public void tapEvent(int x, int y) {
        if (!over) {
            c.t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);
            if (waktuHabis) {
                if (x > 0 && y > c.getHeight() / 2 - 25 && x < c.getWidth() && y < c.getHeight() / 2 + 25) {
                    waktuHabis = false;
                    c.t.life--;
                    this.x = 0;
                    limit = 120;
                }
            } else {
                //arah
                if (y > c.getHeight() - c.ins.imgRun.getHeight() && y < c.getHeight() && !finish) {
                    if (x > c.getWidth() - c.ins.imgRun.getWidth() && x < c.getWidth()) {
                        c.getAudioManager().playSample(c.menu);
                        this.x += 4;
                        c.ins.orang.nextFrame();
                    }
                }
            }
        }
    }
}
