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
public class StateLoadingLevel3 implements State {

    private Canvas c;
    private int count, story, page;
    private String kalimat[] = {"", "", "", ""};
    private boolean next;
    private Image bgloading;

    public StateLoadingLevel3(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            bgloading = Image.createImage("/Image/bgloading.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        count = 0;
        story = 1;
        page = 1;
        next = false;
        kalimat[0] = "Penebangan pohon secara liar";
        kalimat[1] = "oleh manusia akan";
        kalimat[2] = "dapat merusak";
        kalimat[3] = "keseimbangan ekosistem";
    }

    public void updateLogika() {
        if (count > 7) {
            page = 2;
        } else {
            try {
                c.ins.bab3(count);
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
        g.drawString("Level 3", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("KESEIMBANGAN EKOSISTEM", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

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
                        g.drawString("Bari mengunjungi hutan", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Malabar yang penuh", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("dengan pohon lebat", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(c.ins.story2, c.getWidth() / 2, 100 + c.ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Namun, didalam hutan", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("dia melihat ada pe", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("nebang liar", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(c.ins.imgRun, c.getWidth() / 2, 150 + c.ins.imgRun.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik tombol diatas", c.getWidth() / 2, 200 + c.ins.imgRun.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("untuk mempercepat", c.getWidth() / 2, 200 + c.ins.imgRun.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("laju orang", c.getWidth() / 2, 200 + c.ins.imgRun.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(c.ins.cek, c.getWidth() - c.ins.cek.getWidth() / 2, c.getHeight() - c.ins.cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel3);
                }
                break;
        }
    }

    public void hapusResource() {
        c.ins.cek = null;
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
