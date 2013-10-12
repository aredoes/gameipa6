/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Tools;

import GameIPA6.Control.Canvas;
import GameIPA6.Control.GameDesign;
import GameIPA6.State.State;
import java.io.IOException;
import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author user
 */
public class Tools {

    public int life = 3;
    public int level = 9;
    public Image imgLife, imgExit;

    public Tools() {
        try {
            imgLife = Image.createImage("/Image/Life.png");
            imgExit = Image.createImage("/Image/Icon/cross.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void tapImg(int x, int y, int xRumus, int yRumus, int width, int height, Canvas c, State statePindah) {
        if (y > yRumus - height / 2 && y < yRumus + height / 2) {
            if (x > xRumus - width / 2 && x < xRumus + width / 2) {
                c.pindahState(statePindah);
            }
        }
    }
    public void tapPause(int x, int y, Canvas c){
        if (x > 0 && x < 40 && y > 0 && y < 40) {
            c.pause(c.statePause);
            c.s.play(c.s.beep);
        }
    }

    public void drawImgTxt(int ri, int gi, int bi, int xRumus, int yRumus, Image img, String string, Canvas c, Graphics g) {
        g.setColor(ri, gi, bi);
        g.drawImage(img, xRumus, yRumus, Graphics.HCENTER | Graphics.VCENTER);
        g.drawString(string, xRumus, yRumus + 5, Graphics.BASELINE | Graphics.HCENTER);
    }

    public void life(int i, Image imgLife, Canvas c, Graphics g) {
        int y = 0;
        for (int x = 0; x < i; x++) {
            g.drawImage(imgLife, c.getWidth() - 10 - y, 8, Graphics.HCENTER | Graphics.VCENTER);
            y += 25;
        }
    }

    public void icon(Graphics g, Canvas c, String s) {
        life(life, imgLife, c, g);
        g.setColor(0, 0, 0);
        g.drawString(s, c.getWidth() / 2, 15, Graphics.HCENTER | Graphics.BASELINE);
        g.drawImage(imgExit, 0 + imgExit.getWidth() / 2, 0 + imgExit.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
    }

    public void background(Graphics g, Canvas c, int RGB) {
        g.setColor(RGB);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
    }

    public void win(Graphics g, Canvas c, boolean win) {
        String s;
        g.setColor(0xffb638);
        g.fillRect(0, c.getHeight() - 60, c.getWidth(), 60);
        if (win) {
            g.setColor(0, 255, 0);
            s = "BERHASIL";
        } else {
            g.setColor(255, 0, 0);
            s = "GAGAL";
        }
        g.drawString(s, c.getWidth() / 2, c.getHeight() - 25, Graphics.BASELINE | Graphics.HCENTER);
    }

    public void petunjuk(Graphics g, Canvas c, String b1, String b2) {
        g.setColor(0xffb638);
        g.fillRect(0, c.getHeight() - 60, c.getWidth(), 60);
        g.setColor(0, 0, 0);
        g.drawString(b1, c.getWidth() / 2, c.getHeight() - 35, Graphics.BASELINE | Graphics.HCENTER);
        g.drawString(b2, c.getWidth() / 2, c.getHeight() - 15, Graphics.BASELINE | Graphics.HCENTER);
    }

    public int randomInt() {
        int[] xAxis = {-100, 0, 100};
        Random random = new Random();
        int index = random.nextInt(xAxis.length);
        return xAxis[index];
    }

    public int randomInt2() {
        int[] xAxis = {-50, 50};
        Random random = new Random();
        int index = random.nextInt(xAxis.length);
        return xAxis[index];
    }

    public int randomInt3() {
        int[] xAxis = {-60, -45, -30, -15, 15, 30, 45, 60};
        Random random = new Random();
        int index = random.nextInt(xAxis.length);
        return xAxis[index];
    }
}