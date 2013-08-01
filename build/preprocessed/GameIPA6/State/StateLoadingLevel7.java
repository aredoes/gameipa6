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
public class StateLoadingLevel7 implements State {

    private Canvas c;
    private int page, story, count;
    private String kalimat[] = {"", "", "", ""};
    private boolean next;
    private Image cek;

    public StateLoadingLevel7(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            count = 0;
            page = 1;
            story = 1;
            next = false;
            cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
            kalimat[0] = "Gaya dapat menyebabkan";
            kalimat[1] = "benda yang diam";
            kalimat[2] = "menjadi bergerak";
            kalimat[3] = "";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        if (count > 5) {
            page = 2;
        } else {
            try {
                ins.bab7(count);
                Thread.sleep(1000);
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

        g.drawString("Level 7", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("ENERGI DAN PERUBAHANNYA", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

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
                        g.drawImage(ins.story1, c.getWidth() / 2, 100 + ins.story1.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Budi disuru orang", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("tua nya memindah", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("lemari secara tepat", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(ins.story2, c.getWidth() / 2, 100 + ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Namun, dia tidak", c.getWidth() / 2, c.getHeight() / 2 + ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("tahu apakah bisa", c.getWidth() / 2, c.getHeight() / 2 + ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("mendorongnya", c.getWidth() / 2, c.getHeight() / 2 + ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(ins.imgRun, c.getWidth() / 2, 150 + ins.imgRun.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik tombol diatas", c.getWidth() / 2, 200 + ins.imgRun.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("untuk memberikan gaya", c.getWidth() / 2, 200 + ins.imgRun.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("dorong pada benda", c.getWidth() / 2, 200 + ins.imgRun.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(cek, c.getWidth() - cek.getWidth() / 2, c.getHeight() - cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel7);
                }
                break;
        }
    }

    public void hapusResource() {
        cek = null;
    }

    public void tapEvent(int x, int y) {
        if (page == 2) {
            if (x > c.getWidth() - cek.getWidth() && x < c.getWidth() && y > c.getHeight() - cek.getHeight() && y < c.getHeight()) {
                if (story < 3) {
                    story++;
                    sound.play(sound.menu);
                } else {
                    next = true;
                    sound.play(sound.berubah);
                }
            }
        }
    }
}
