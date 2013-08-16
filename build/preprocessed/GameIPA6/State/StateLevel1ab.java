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
public class StateLevel1ab implements State {

    private Canvas c;
    private int x, xh1, xh2, yh, i, j, finish;
    //nyawa habis
    private boolean over;
    private int ov;

    public StateLevel1ab(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        i = 0;
        j = 0;
        x = 0;
        xh1 = 0;
        xh2 = 0;
        finish = 0;
        yh = c.getHeight() + c.ins.balokHalang1.getHeight();
        over = false;
        ov = 0;
    }

    public void updateLogika() {
        c.sound.play(c.sound.backsound1);
        c.ins.cicakSprite.setPosition(c.getWidth() / 2 - c.ins.cicakSprite.getWidth() / 2 + x, c.getHeight() - c.ins.cicakSprite.getHeight() - c.ins.imgLeftArrow.getHeight());
        c.ins.balokHalang1.setPosition(c.getWidth() / 2 - c.ins.balokHalang1.getWidth() / 2 + xh1, yh - c.ins.balokHalang1.getHeight());
        c.ins.balokHalang2.setPosition(c.getWidth() / 2 - c.ins.balokHalang2.getWidth() / 2 + xh2, yh - c.ins.balokHalang2.getHeight());

        if (yh > c.getHeight() + c.ins.balokHalang1.getHeight()) {
            xh1 = c.t.randomInt();
            xh2 = c.t.randomInt2();
            yh = 0;
            finish++;
        }

        if (c.ins.cicakSprite.collidesWith(c.ins.balokHalang1, true) || c.ins.cicakSprite.collidesWith(c.ins.balokHalang2, true)) {
            c.ins.cicakSprite.setFrameSequence(c.ins.gd.CicakSpriteHit);
            i++;
            if (i > 8) {
                c.sound.play(c.sound.argh);
                xh1 = c.t.randomInt();
                xh2 = c.t.randomInt2();
                yh = 0;
                c.t.life--;
                c.ins.cicakSprite.setFrameSequence(c.ins.gd.CicakSpriteMove);
                i = 0;
            }
        } else {
            yh += 8;
        }

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
        c.t.background(g, c, 0x37eafb);

        //cicak
        c.ins.cicakSprite.paint(g);
        c.ins.cicakSprite.nextFrame();

        //balokHalang
        c.ins.balokHalang1.paint(g);
        c.ins.balokHalang2.paint(g);

        //arah
        g.drawImage(c.ins.imgLeftArrow, c.ins.imgLeftArrow.getWidth() / 2, c.getHeight() - c.ins.imgLeftArrow.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(c.ins.imgRightArrow, c.getWidth() - c.ins.imgRightArrow.getWidth() / 2, c.getHeight() - c.ins.imgRightArrow.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        if (finish > 5) {
            c.t.win(g, c, true);
            j++;
            if (j > 8) {
                c.sound.play(c.sound.berubah);
                if (c.t.level == 0) {
                    c.t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }

        //nyawa habis
        if (over) {
            g.setColor(0xffb638);
            g.fillRect(0, c.getHeight() / 2 - 25, c.getWidth(), 50);
            g.setColor(255, 0, 0);
            g.drawString("NYAWA HABIS!", c.getWidth() / 2, c.getHeight() / 2, Graphics.BASELINE | Graphics.HCENTER);
        }

        c.t.icon(g, c, "Level 1");
    }

    public void hapusResource() {
        c.ins.hapusBab1();
    }

    public void tapEvent(int x, int y) {
        if (!over) {
            c.t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

            if (y > c.getHeight() - c.ins.imgLeftArrow.getHeight() && y < c.getHeight() && !c.ins.cicakSprite.collidesWith(c.ins.balokHalang1, true) && !c.ins.cicakSprite.collidesWith(c.ins.balokHalang2, true) && finish <= 5) {
                if (x > 0 && x < c.ins.imgLeftArrow.getWidth() && this.x > -75) {
                    this.x -= 25;
                    c.sound.play(c.sound.menu);
                } else if (x > c.getWidth() - c.ins.imgRightArrow.getWidth() && x < c.getWidth() && this.x < 75) {
                    this.x += 25;
                    c.sound.play(c.sound.menu);
                }
            }
        }
    }
}
