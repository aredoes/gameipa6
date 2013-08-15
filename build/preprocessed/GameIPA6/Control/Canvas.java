/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Control;

import GameIPA6.State.*;
import GameIPA6.Tools.LoadInisialisasi;
import GameIPA6.Tools.Sound;
import GameIPA6.Tools.Tools;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author user
 */
public class Canvas extends GameCanvas implements Runnable {

    private boolean isGameJalan = true, isPindah = false;
    private Midlet m;
    public State stateSekarang, stateSebelumnya, statePause, stateMenu, stateLoading, stateLoadingLevel1, stateLoadingLevel2, stateLoadingLevel3, stateLoadingLevel4, stateLoadingLevel5, stateLoadingLevel6, stateLoadingLevel7, stateLoadingLevel8, stateLoadingLevel9, stateLevel, stateLevel1aa, stateLevel1ab, stateLevel2, stateLevel3, stateLevel4, stateLevel5, stateLevel6, stateLevel7, stateLevel8, stateLevel9;
    public Tools t;
    public LoadInisialisasi ins;
    public Sound sound;
    
    public void setIsGameJalan(boolean isGameJalan) {
        this.isGameJalan = isGameJalan;
    }
    
    public Canvas(Midlet m) {
        super(false);
        setFullScreenMode(true);
        this.m = m;
        stateLoading = new StateLoading(this);
        statePause = new StatePause(this);
        stateLevel = new StateLevel(this);
        stateLevel1aa = new StateLevel1aa(this);
        stateLevel1ab = new StateLevel1ab(this);
        stateLevel2 = new StateLevel2(this);
        stateLevel3 = new StateLevel3(this);
        stateLevel4 = new StateLevel4(this);
        stateLevel5 = new StateLevel5(this);
        stateLevel6 = new StateLevel6(this);
        stateLevel7 = new StateLevel7(this);
        stateLevel8 = new StateLevel8(this);
        stateLevel9 = new StateLevel9(this);
        stateLoadingLevel1 = new StateLoadingLevel1(this);
        stateLoadingLevel2 = new StateLoadingLevel2(this);
        stateLoadingLevel3 = new StateLoadingLevel3(this);
        stateLoadingLevel4 = new StateLoadingLevel4(this);
        stateLoadingLevel5 = new StateLoadingLevel5(this);
        stateLoadingLevel6 = new StateLoadingLevel6(this);
        stateLoadingLevel7 = new StateLoadingLevel7(this);
        stateLoadingLevel8 = new StateLoadingLevel8(this);
        stateLoadingLevel9 = new StateLoadingLevel9(this);
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
        this.sound = new Sound();
        stateMenu = new StateMenu(this);
        stateMenu.inisialisasi();
        stateSekarang = stateMenu;
    }

    public void run() {
        Graphics g = getGraphics();
        while (isGameJalan) {
            System.out.println(sound.backsound1);
            flushGraphics();
            try {
                stateSekarang.updateLogika();
                stateSekarang.updateGambar(g);
                if (isPindah) {
                    stateSekarang.hapusResource();
                }
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.m.destroyApp(true);
    }

    protected void pointerPressed(int x, int y) {
        stateSekarang.tapEvent(x, y);
    }

    public void pindahState(State state) {
        isPindah = true;
        System.gc();
        stateSebelumnya = stateSekarang;
        stateSekarang = state;
        stateSekarang.inisialisasi();
        System.gc();
        isPindah = false;
    }
    
    public void pause(State state) {
        isPindah = true;
        System.gc();
        stateSekarang = state;
        System.gc();
        isPindah = false;
    }
}
