/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Tools;

import java.io.IOException;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author user
 */
public class Sound {

    private boolean silent;
    private Player slh, mn, pdg, ub, clg, bp, arg, b1;
    public int 
            salah = 0,
            menu = 1,
            pedang = 2,
            berubah = 3,
            cling = 4,
            beep = 5,
            argh = 6,
            backsound1 = 101,
            stop = 111;
    public int i = 0;

    public Sound() {
        silent = false;
        try {
//            slh = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/button-10.wav"), "audio/wav");
//            mn = slh;
//            pdg = slh;
//            ub = slh;
//            clg = slh;
//            bp = slh;
//            arg = slh;
//            b1 = slh;
            
            slh = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/button-10.wav"), "audio/wav");
            mn = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/button-30.wav"), "audio/wav");
            pdg = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/Pedang.wav"), "audio/wav");
            ub = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/button-2.wav"), "audio/wav");
            clg = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/Cling.wav"), "audio/wav");
            bp = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/button-9.wav"), "audio/wav");
            arg = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/arg.wav"), "audio/wav");
            b1 = Manager.createPlayer(getClass().getResourceAsStream("/GameIPA6/Sound/b1.mp3"), "audio/mp3");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (MediaException ex) {
            ex.printStackTrace();
        }

    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public boolean getSilent() {
        return this.silent;
    }

    public void play(int player) {
        if (!silent) {
            try {
                switch (player) {
                    case (0):
                        slh.deallocate();
                        slh.prefetch();
                        slh.realize();
                        slh.start();
                        break;
                    case (1):
                        mn.deallocate();
                        mn.prefetch();
                        mn.realize();
                        mn.start();
                        break;
                    case (2):
                        pdg.deallocate();
                        pdg.prefetch();
                        pdg.realize();
                        pdg.start();
                        break;
                    case (3):
                        ub.deallocate();
                        ub.prefetch();
                        ub.realize();
                        ub.start();
                        break;
                    case (4):
                        clg.deallocate();
                        clg.prefetch();
                        clg.realize();
                        clg.start();
                        break;
                    case (5):
                        bp.deallocate();
                        bp.prefetch();
                        bp.realize();
                        bp.start();
                        break;
                    case (6):
                        arg.deallocate();
                        arg.prefetch();
                        arg.realize();
                        arg.start();
                        break;
                    case (101):
                        if (i > b1.getMediaTime()) {
                            b1.deallocate();
                            i = 0;
                        } else {
                            try {
                                b1.prefetch();
                                b1.realize();
                                b1.start();
                                i++;
                            } catch (MediaException ex) {
                                ex.printStackTrace();
                            }
                        }
                        break;
                    case (111):
                        try {
                            b1.stop();
                            i = 1000;
                        } catch (MediaException ex) {
                            ex.printStackTrace();
                        }
                        break;
                }
            } catch (MediaException ex) {
            }
        }
    }
}
