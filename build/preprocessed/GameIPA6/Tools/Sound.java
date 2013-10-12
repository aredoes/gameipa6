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

    private boolean silent = false;
    private Player slh, mn, pdg, clg, bp, arg, b1;
    
    public int 
            salah = 0,
            menu = 1,
            pedang = 2,
            cling = 3,
            beep = 4,
            argh = 5,
            backsound1 = 101,
            stop = 111;
    public int i = 0;

    public Sound() {
        try {
            slh = Manager.createPlayer(getClass().getResourceAsStream("/Sound/button-10.wav"), "audio/wav");
            mn = Manager.createPlayer(getClass().getResourceAsStream("/Sound/button-30.wav"), "audio/wav");
            pdg = Manager.createPlayer(getClass().getResourceAsStream("/Sound/Pedang.wav"), "audio/wav");
            clg = Manager.createPlayer(getClass().getResourceAsStream("/Sound/Cling.wav"), "audio/wav");
            bp = Manager.createPlayer(getClass().getResourceAsStream("/Sound/button-9.wav"), "audio/wav");
            arg = Manager.createPlayer(getClass().getResourceAsStream("/Sound/arg.wav"), "audio/wav");
            b1 = Manager.createPlayer(getClass().getResourceAsStream("/Sound/backsound.mp3"), "audio/mp3");
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
        if (!this.silent) {
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
                        clg.deallocate();
                        clg.prefetch();
                        clg.realize();
                        clg.start();
                        break;
                    case (4):
                        bp.deallocate();
                        bp.prefetch();
                        bp.realize();
                        bp.start();
                        break;
                    case (5):
                        arg.deallocate();
                        arg.prefetch();
                        arg.realize();
                        arg.start();
                        break;
                    case (101):
                        if (i > 2000) {
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
                }
            } catch (MediaException ex) {
            }
        }
    }
    
    public void stop(){
        try {
            b1.stop();
            i = 2001;
        } catch (MediaException ex) {
            ex.printStackTrace();
        }
    }
}
