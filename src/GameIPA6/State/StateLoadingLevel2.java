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
public class StateLoadingLevel2 implements State {

    private Canvas c;
    private int page, story, count;
    private String kalimat[] = {"", "", "", ""};
    private boolean next;
    private Image cek, pilih;

    public StateLoadingLevel2(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            count = 0;
            page = 1;
            story = 1;
            next = false;
            cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
            pilih = Image.createImage("/GameIPA6/Image/bab2/pilihhint.png");
            kalimat[0] = "Pada masa pubertas,";
            kalimat[1] = "manusia mengalami";
            kalimat[2] = "perkembangan ciri-ciri";
            kalimat[3] = "kelamin primer & sekunder";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateLogika() {
        if (count > 10) {
            page = 2;
        } else {
            try {
                ins.bab2(count);
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

        g.drawString("Level 2", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("PERKEMBANGAN MAHLUK HIDUP", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

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
                        g.drawString("Seorang anak sedang", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("berbincang dengan dua", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("orang tua", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(ins.story2, c.getWidth() / 2, 100 + ins.story1.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Lalu, dia memperhatikan", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("perbedaan dirinya dengan", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("kedua orang tua tersebut", c.getWidth() / 2, c.getHeight() / 2 + ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(pilih, c.getWidth() / 2, 150 + pilih.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik pada pilihan diatas", c.getWidth() / 2, 200 + pilih.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("sesuai dengan petunjuk", c.getWidth() / 2, 200 + pilih.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("yang diberikan", c.getWidth() / 2, 200 + pilih.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(cek, c.getWidth() - cek.getWidth() / 2, c.getHeight() - cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel2);
                }
                break;
        }
    }

    public void hapusResource() {
        cek = null;
        pilih = null;
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
