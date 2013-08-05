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
public class StateLevel1ab implements State {

    private Canvas c;
    private int x, xh1, xh2, yh, i, j, finish;
    private Sound sound;
    private Tools t;
    private LoadInisialisasi ins;  

    public StateLevel1ab(Canvas c) {
        this.c = c;
        this.sound = new Sound();
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
    }

    public void inisialisasi() {
        i = 0;
        j = 0;
        x = 0;
        xh1 = 0;
        xh2 = 0;
        finish = 0;
        yh = c.getHeight() + ins.balokHalang1.getHeight();
    }

    public void updateLogika() {
        sound.play(sound.backsound1);
        ins.cicakSprite.setPosition(c.getWidth() / 2 - ins.cicakSprite.getWidth() / 2 + x, c.getHeight() - ins.cicakSprite.getHeight() - ins.imgLeftArrow.getHeight());
        ins.balokHalang1.setPosition(c.getWidth() / 2 - ins.balokHalang1.getWidth() / 2 + xh1, yh - ins.balokHalang1.getHeight());
        ins.balokHalang2.setPosition(c.getWidth() / 2 - ins.balokHalang2.getWidth() / 2 + xh2, yh - ins.balokHalang2.getHeight());

        if (yh > c.getHeight() + ins.balokHalang1.getHeight()) {
            xh1 = t.randomInt();
            xh2 = t.randomInt2();
            yh = 0;
            finish++;
        }

        if (ins.cicakSprite.collidesWith(ins.balokHalang1, true) || ins.cicakSprite.collidesWith(ins.balokHalang2, true)) {
            ins.cicakSprite.setFrameSequence(ins.gd.CicakSpriteHit);
            i++;
            if (i > 8) {
                sound.play(sound.argh);
                xh1 = t.randomInt();
                xh2 = t.randomInt2();
                yh = 0;
                t.life--;
                ins.cicakSprite.setFrameSequence(ins.gd.CicakSpriteMove);
                i = 0;
            }
        } else {
            yh += 8;
        }

        if (t.life == 0) {
            c.pindahState(c.stateLevel);
            t.life = 3;
        }

    }

    public void updateGambar(Graphics g) {
        t.background(g, c, 0x37eafb);

        //cicak
        ins.cicakSprite.paint(g);
        ins.cicakSprite.nextFrame();

        //balokHalang
        ins.balokHalang1.paint(g);
        ins.balokHalang2.paint(g);

        //arah
        g.drawImage(ins.imgLeftArrow, ins.imgLeftArrow.getWidth() / 2, c.getHeight() - ins.imgLeftArrow.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
        g.drawImage(ins.imgRightArrow, c.getWidth() - ins.imgRightArrow.getWidth() / 2, c.getHeight() - ins.imgRightArrow.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        if (finish > 5) {
            t.win(g, c, true);
            j++;
            if (j > 8) {
                sound.play(sound.berubah);
                if (t.level == 0) {
                    t.level++;
                }
                c.pindahState(c.stateLevel);
            }
        }

        t.icon(g, c, "Level 1");
    }

    public void hapusResource() {
        ins.hapusBab1();
    }

    public void tapEvent(int x, int y) {
        t.tapImg(x, y, 20, 20, 40, 40, c, c.statePause);

        if (y > c.getHeight() - ins.imgLeftArrow.getHeight() && y < c.getHeight() && !ins.cicakSprite.collidesWith(ins.balokHalang1, true) && !ins.cicakSprite.collidesWith(ins.balokHalang2, true) && finish <= 5) {
            if (x > 0 && x < ins.imgLeftArrow.getWidth() && this.x > -75) {
                this.x -= 25;
                sound.play(sound.menu);
            } else if (x > c.getWidth() - ins.imgRightArrow.getWidth() && x < c.getWidth() && this.x < 75) {
                this.x += 25;
                sound.play(sound.menu);
            }
        }
    }
}
