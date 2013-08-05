/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Tools.LoadInisialisasi;
import GameIPA6.Tools.Sound;
import GameIPA6.Tools.Tools;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author user
 */
public interface State {
    
//    Tools t = new Tools();
//
//    LoadInisialisasi ins = new LoadInisialisasi();
//    
//    Sound sound = new Sound();

    public abstract void inisialisasi();

    public abstract void updateLogika();

    public abstract void updateGambar(Graphics g);

    public abstract void hapusResource();

    public abstract void tapEvent(int x, int y);
}


