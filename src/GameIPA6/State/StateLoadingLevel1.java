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
public class StateLoadingLevel1 implements State {

    private Canvas c;
    private int page, story, count, pelajaran;
    private String kalimat[] = {"", "", ""};
    private boolean next;

    public StateLoadingLevel1(Canvas c) {
        this.c = c;
    }

    public void inisialisasi() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        count = 0;
        pelajaran = c.t.randomInt2();
        page = 1;
        story = 1;
        next = false;
    }

    public void updateLogika() {
        if (count > 12) {
            page = 2;
        } else {
            try {
                c.ins.bab1(count);
                Thread.sleep(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            count++;
        }

        switch (pelajaran) {
            case (-50):
                kalimat[0] = "Bebek memiliki kaki berselaput";
                kalimat[1] = "sehingga memudahkannya";
                kalimat[2] = "berenang di air";
                break;
            case (50):
                kalimat[0] = "Cecak memiliki kaki pelekat";
                kalimat[1] = "sehingga memudahkannya";
                kalimat[2] = "dapat berjalan di dinding";
                break;
        }
    }

    public void updateGambar(Graphics g) {
        g.setColor(0xccfaff);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(0, 0, 0);

        g.drawString("Level 1", c.getWidth() / 2, 50, Graphics.HCENTER | Graphics.BASELINE);
        g.drawString("CIRI KHUSUS MAHLUK HIDUP", c.getWidth() / 2, 70, Graphics.HCENTER | Graphics.BASELINE);

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
                        g.drawString("Seorang anak bernama", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Johan sedang mengamati", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("sebuah balok diatas meja", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story1.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (2):
                        g.drawImage(c.ins.story2, c.getWidth() / 2, 100 + c.ins.story2.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Lalu Johan pun berfikir...", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("Bantulah Johan untuk", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 40, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("menemukan siapa yang dapat", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 60, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("memanjat balok tersebut", c.getWidth() / 2, c.getHeight() / 2 + c.ins.story2.getHeight() / 2 + 80, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                    case (3):
                        g.drawImage(c.ins.ular, c.getWidth() / 2 - 50, 150 + c.ins.ular.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawImage(c.ins.cicak, c.getWidth() / 2, 150 + c.ins.cicak.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawImage(c.ins.bebek, c.getWidth() / 2 + 50, 150 + c.ins.bebek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                        g.drawString("Klik pada pilihan diatas", c.getWidth() / 2, 200 + c.ins.ular.getHeight(), Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("sesuai dengan petunjuk", c.getWidth() / 2, 200 + c.ins.ular.getHeight() + 20, Graphics.HCENTER | Graphics.BASELINE);
                        g.drawString("yang diberikan", c.getWidth() / 2, 200 + c.ins.ular.getHeight() + 40, Graphics.HCENTER | Graphics.BASELINE);
                        break;
                }
                g.drawImage(c.ins.cek, c.getWidth() - c.ins.cek.getWidth() / 2, c.getHeight() - c.ins.cek.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
                if (next) {
                    c.pindahState(c.stateLevel1aa);
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
                    c.getAudioManager().playSample(c.menu);
                } else {
                    next = true;
                    c.getAudioManager().playSample(c.berubah);
                }
            }
        }
    }
}
