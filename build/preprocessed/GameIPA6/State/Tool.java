/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.State;

import GameIPA6.Tools.LoadInisialisasi;
import GameIPA6.Tools.Sound;
import GameIPA6.Tools.Tools;



/**
 *
 * @author user
 */
public class Tool {
    
    public Tools t;
    public LoadInisialisasi ins;
    public Sound sound;
    
    public Tool(){
        this.t = new Tools();
        this.ins = new LoadInisialisasi();
        this.sound = new Sound();
    }
}
