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
    private Image cek, ttsurya;

    public StateLoadingLevel9(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            count = 0;
            page = 1;
            story = 1;
            next = false;
            cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
            ttsurya = Image.createImage("/GameIPA6/Image/bab9/tatasurya2.png");
            kalimat[0] = "Jumlah planet dalam sistem";
            kalimat[1] = "tata surya ada delapan, yaitu";
            kalimat[2] = "Merkurius, Venus, Bumi,";
            kalimat[3] = "Mars, Jupiter, Saturnus,";
            kalimat[4] = "Uranus dan Neptunus";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        if (count > 5) {
            page = 2;
        } else {
            try {
                ins.bab9(count);
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
                        g.drawImage(ins.story1, c.getWidth() / 2, 100 + ins.story1.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Dedi melihat langit", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("dengan teropong", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("bintangnya", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(ins.story2, c.getWidth() / 2, 100 + ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Dilangit banyak planet.", c.getWidth() / 2, c.getHeight() / 2 + ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Planet apa saja", c.getWidth() / 2, c.getHeight() / 2 + ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("itu yaa...?", c.getWidth() / 2, c.getHeight() / 2 + ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(ttsurya, c.getWidth() / 2, 150 + ttsurya.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik pada planet untuk", c.getWidth() / 2, 200 + ttsurya.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("memberi jawaban sesuai", c.getWidth() / 2, 200 + ttsurya.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("pertanyaan yang diberikan", c.getWidth() / 2, 200 + ttsurya.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(cek, c.getWidth() - cek.getWidth() / 2, c.getHeight() - cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel9);
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
