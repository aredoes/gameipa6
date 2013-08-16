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
public class StateLoadingLevel5 implements State {

    private Canvas c;
    private int count, story, page;
    private String kalimat[] = {"", "", "", "", "", ""};
    private boolean next;

    public StateLoadingLevel5(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        count = 0;
        story = 1;
        page = 1;
        next = false;
        kalimat[0] = "Logam merupakan konduktor";
        kalimat[1] = "panas yang dapat meng";
        kalimat[2] = "hantarkan panas dengan baik";
        kalimat[3] = "Plastik merupakan isolator";
        kalimat[4] = "panas yang tidak dapat";
        kalimat[5] = "menghantarkan panas";
    }

    public void updateLogika() {
        if (count > 9) {
            page = 2;
        } else {
            try {
                c.ins.bab5(count);
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

        g.drawString("Level 5", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("KONDUKTOR & ISOLATOR PANAS", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

        switch (page) {
            case (1):
                g.setColor(0, 255, 0);
                g.drawString("~ for your information ~", c.getWidth() / 2, 150, Graphics.HCENTER | Graphics.BASELINE);
                g.setColor(0, 0, 0);
                for (int i = 0; i < 3; i++) {
                    g.drawString(kalimat[i], c.getWidth() / 2, 200 + 20 * i, Graphics.HCENTER | Graphics.BASELINE);
                }
                for (int i = 3; i < 6; i++) {
                    g.drawString(kalimat[i], c.getWidth() / 2, 220 + 20 * i, Graphics.HCENTER | Graphics.BASELINE);
                }
                g.drawString("Loading...", c.getWidth() - 50, c.getHeight() - 20, Graphics.HCENTER | Graphics.BASELINE);
                break;
            case (2):
                switch (story) {
                    case (1):
                        g.drawImage(c.ins.story1, c.getWidth() / 2, 100 + c.ins.story1.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Sendi disuru mamanya", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("untuk mandi pagi", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("sebelum sekolah", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(c.ins.story2, c.getWidth() / 2, 100 + c.ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Dia berencana meng", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("gunakan pipa ajaib", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("dibawah bak mandinya", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.setColor(0x9f9d9d);
                        g.fillRect(c.getWidth() / 4, 100, c.getWidth() / 2, 50);
                        g.setColor(0x5556f1);
                        g.fillRect(c.getWidth() / 4, 200, c.getWidth() / 2, 50);

                        g.setColor(255, 255, 255);
                        g.drawString("LOGAM", c.getWidth() / 2, 130, Graphics.BASELINE | Graphics.HCENTER);
                        g.drawString("PLASTIK", c.getWidth() / 2, 230, Graphics.BASELINE | Graphics.HCENTER);
                        g.setColor(0, 0, 0);
                        g.drawString("Ubah pipa menjadi logam", c.getWidth() / 2, 170, Graphics.BASELINE | Graphics.HCENTER);
                        g.drawString("Ubah pipa menjadi plastik", c.getWidth() / 2, 270, Graphics.BASELINE | Graphics.HCENTER);

                        g.drawImage(c.ins.apimerah, c.getWidth() * 1 / 4, 305, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawImage(c.ins.apibiru, c.getWidth() * 3 / 4, 305, Graphics.HCENTER | Graphics.VCENTER);

                        g.drawString("Bersifat panas", c.getWidth() * 1 / 4, 340, Graphics.BASELINE | Graphics.HCENTER);
                        g.drawString("Bersifat dingin", c.getWidth() * 3 / 4, 340, Graphics.BASELINE | Graphics.HCENTER);
                        break;
                }
                g.drawImage(c.ins.cek, c.getWidth() - c.ins.cek.getWidth() / 2, c.getHeight() - c.ins.cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel5);
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
