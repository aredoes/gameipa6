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
public class StateLoadingLevel6 implements State {

    private Canvas c;
    private int page, story, count;
    private String kalimat[] = {"", "", "", ""};
    private boolean next;
    private Image bgloading;

    public StateLoadingLevel6(Canvas c) {
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
        kalimat[0] = "Logam bersifat kuat, keras";
        kalimat[1] = "dan lentur. Logam banyak ";
        kalimat[2] = "digunakan untuk membuat";
        kalimat[3] = "panci, sendok, dan kompor";
    }

    public void updateLogika() {
        if (count > 3) {
            page = 2;
        } else {
            try {
                c.ins.bab6(count);
                Thread.sleep(1600);
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
        g.drawString("Level 6", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("PERUBAHAN BENDA", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

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
                        g.drawString("Yuda mengunjungi", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("TOKO UDIN untuk", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("melihat perabotan", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(c.ins.story2, c.getWidth() / 2, 100 + c.ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Dia melihat barang", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("yang dijual dan men", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("cari tahu bahan bakunya", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(c.ins.pilih, c.getWidth() / 2, 150 + c.ins.pilih.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik pada pilihan diatas", c.getWidth() / 2, 200 + c.ins.pilih.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("sesuai dengan petunjuk", c.getWidth() / 2, 200 + c.ins.pilih.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("yang diberikan", c.getWidth() / 2, 200 + c.ins.pilih.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(c.ins.cek, c.getWidth() - c.ins.cek.getWidth() / 2, c.getHeight() - c.ins.cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel6);
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
