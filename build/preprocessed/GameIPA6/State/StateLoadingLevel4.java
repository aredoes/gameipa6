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
public class StateLoadingLevel4 implements State {

    private Canvas c;
    private int count, story, page;
    private String kalimat[] = {"", "", "", ""};
    private boolean next;

    public StateLoadingLevel4(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        count = 0;
        story = 1;
        page = 1;
        next = false;
        kalimat[0] = "Komodo, badak, rafflesia";
        kalimat[1] = "arnoldii, burung cenderawasih";
        kalimat[2] = "dan jalak bali merupakan";
        kalimat[3] = "hewan langka yang dilindungi";
    }

    public void updateLogika() {
        if (count > 9) {
            page = 2;
        } else {
            try {
                c.ins.bab4(count);
                Thread.sleep(600);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            count++;
        }
    }

    public void updateGambar(Graphics g) {
        g.setColor(255, 255, 0);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(0, 0, 0);

        g.drawString("Level 4", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("PELESTARIAN MAHLUK HIDUP", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

        switch (page) {
            case (1):
                g.setColor(0, 255, 0);
                g.drawString("~ for your information ~", c.getWidth() / 2, 150, Graphics.HCENTER | Graphics.BASELINE);
                g.setColor(0, 0, 0);
                for (int i = 0; i < kalimat.length; i++) {
                    g.drawString(kalimat[i], c.getWidth() / 2, 200 + 20 * i, Graphics.HCENTER | Graphics.BASELINE);
                }
                g.drawString("Loading...", c.getWidth() - 50, c.getHeight() - 20, Graphics.HCENTER | Graphics.BASELINE);
                break;
            case (2):
                switch (story) {
                    case (1):
                        g.drawImage(c.ins.story1, c.getWidth() / 2, 100 + c.ins.story1.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Bryan mengunjungi", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("pertunjukan binatang", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("langka, tapi...", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(c.ins.story2, c.getWidth() / 2, 100 + c.ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Dia berencana meng", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("halangi pencuri dengan", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("menembaki mereka", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(c.ins.imgFire, 60, 165, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawImage(c.ins.imgLeftArrow, 60, 225, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawImage(c.ins.imgRightArrow, 60, 285, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Tembak", 150, 167, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Gerak kiri", 155, 227, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Gerak kanan", 165, 287, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(c.ins.cek, c.getWidth() - c.ins.cek.getWidth() / 2, c.getHeight() - c.ins.cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel4);
                }
                break;
        }
    }

    public void hapusResource() {
        c.ins.cek = null;
        c.ins.story1 = null;
        c.ins.story2 = null;
    }

    public void tapEvent(int x, int y) {
        if (page == 2) {
            if (x > c.getWidth() - c.ins.cek.getWidth() && x < c.getWidth() && y > c.getHeight() - c.ins.cek.getHeight() && y < c.getHeight()) {
                if (story < 3) {
                    story++;
                } else {
                    next = true;
                    c.sound.play(c.sound.berubah);
                }
            }
        }
    }
}
