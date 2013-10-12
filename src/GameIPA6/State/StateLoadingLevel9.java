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
public class StateLoadingLevel9 implements State {

    private Canvas c;
    private int page, story, count;
    private String kalimat[] = {"", "", "", "", ""};
    private boolean next;
    private Image bgloading;

    public StateLoadingLevel9(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            bgloading = Image.createImage("/Image/bgloading.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        count = 0;
        page = 1;
        story = 1;
        next = false;
        kalimat[0] = "Jumlah planet dalam sistem";
        kalimat[1] = "tata surya ada delapan, yaitu";
        kalimat[2] = "Merkurius, Venus, Bumi,";
        kalimat[3] = "Mars, Jupiter, Saturnus,";
        kalimat[4] = "Uranus dan Neptunus";
    }

    public void updateLogika() {
        if (count > 6) {
            page = 2;
        } else {
            try {
                c.ins.bab9(count);
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
        g.drawImage(bgloading, c.getWidth() / 2, c.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

        g.setColor(0, 0, 0);
        g.drawString("Level 9", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("TATA SURYA", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

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
                        g.drawString("Dedi melihat langit", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("dengan teropong", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("bintangnya", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(c.ins.story2, c.getWidth() / 2, 100 + c.ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Dilangit banyak planet.", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Planet apa saja", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("itu yaa...?", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(c.ins.ttsurya, c.getWidth() / 2, 150 + c.ins.ttsurya.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik pada planet untuk", c.getWidth() / 2, 200 + c.ins.ttsurya.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("memberi jawaban sesuai", c.getWidth() / 2, 200 + c.ins.ttsurya.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("pertanyaan yang diberikan", c.getWidth() / 2, 200 + c.ins.ttsurya.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(c.ins.cek, c.getWidth() - c.ins.cek.getWidth() / 2, c.getHeight() - c.ins.cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel9);
                }
                break;
        }
    }

    public void hapusResource() {
        c.ins.cek = null;
        c.ins.ttsurya = null;
        c.ins.story1 = null;
        c.ins.story2 = null;
        bgloading = null;
    }

    public void tapEvent(int x, int y) {
        if (page == 2) {
            if (x > c.getWidth() - c.ins.cek.getWidth() && x < c.getWidth() && y > c.getHeight() - c.ins.cek.getHeight() && y < c.getHeight()) {
                if (story < 3) {
                    story++;
                } else {
                    next = true;
                    c.s.play(c.s.pedang);
                }
            }
        }
    }
}
