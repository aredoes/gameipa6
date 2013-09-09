/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Control;

//import GameIPA6.Tools.SoundEfect;
//import GameIPA6.Tools.Backsound;
import GameIPA6.State.*;
import GameIPA6.Tools.AudioManager;
import GameIPA6.Tools.LoadInisialisasi;
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
    public State stateSekarang, stateSebelumnya, statePause, stateSplash, stateMenu, stateLoading, stateLoadingLevel1, stateLoadingLevel2, stateLoadingLevel3, stateLoadingLevel4, stateLoadingLevel5, stateLoadingLevel6, stateLoadingLevel7, stateLoadingLevel8, stateLoadingLevel9, stateLevel, stateLevel1aa, stateLevel1ab, stateLevel2, stateLevel3, stateLevel4, stateLevel5, stateLevel6, stateLevel7, stateLevel8, stateLevel9;
    public Tools t;
    public LoadInisialisasi ins;
//    public Backsound s;
//    public SoundEfect sm;
    private AudioManager audioManager;
    //sound
    public boolean silent = false;
    public final String salah = "/Sound/button-10.wav";
    public final String menu = "/Sound/button-30.wav";
    public final String pedang = "/Sound/Pedang.wav";
    public final String berubah = "/Sound/button-2.wav";
    public final String cling = "/Sound/Cling.wav";
    public final String beep = "/Sound/button-9.wav";
    public final String argh = "/Sound/arg.wav";
    public final String backsound = "/Sound/Cling.wav";
    //sound

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
        stateLevel1aa = new StateLevel1a(this);
        stateLevel1ab = new StateLevel1b(this);
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
        stateMenu = new StateMenu(this);

        this.t = new Tools();
        this.ins = new LoadInisialisasi();
        audioManager = AudioManager.getInstance();

        stateSplash = new StateSplash(this);
        stateSplash.inisialisasi();
        stateSekarang = stateSplash;
    }

    public void run() {
        Graphics g = getGraphics();
        while (isGameJalan) {
            try {
                if (!isPindah) {
                    stateSekarang.updateLogika();
                    stateSekarang.updateGambar(g);
                }
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            flushGraphics();
        }
        this.m.destroyApp(true);
    }

    protected void pointerPressed(int x, int y) {
        stateSekarang.tapEvent(x, y);
    }

    public void pindahState(State state) {
        isPindah = true;
        stateSebelumnya = stateSekarang;
        state.inisialisasi();
        stateSekarang = state;
        stateSebelumnya.hapusResource();
        System.gc();
        isPindah = false;
    }

    public void pause(State state) {
        stateSebelumnya = stateSekarang;
        state.inisialisasi();
        stateSekarang = state;
        System.gc();
    }

    public void back() {
        stateSekarang.hapusResource();
        System.gc();
        stateSekarang = stateSebelumnya;
        System.gc();
    }

    public AudioManager getAudioManager() {
        return audioManager;
    }
}
