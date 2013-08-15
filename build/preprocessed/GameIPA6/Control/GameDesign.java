/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Control;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author user
 */
public class GameDesign {
    
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image cicak;
    private Image dorongall;
    private Image CicakFull;
    private Image orang;
    private Image CicakFullKecil;
    private Image air5;
    private Image hint;
    private Image penebangs;
    private Sprite tembak;
    public int tembakseq003Delay = 200;
    public int[] tembakseq003 = {0, 4};
    private Image orangs;
    private Image penembak;
    private Sprite penembaks;
    public int penembaksseq001Delay = 200;
    public int[] penembaksseq001 = {0};
    private Sprite orangjalan;
    public int orangjalanseq002Delay = 200;
    public int[] orangjalanseq002 = {0, 1, 2, 3, 2, 1, 0, 4, 5, 4, 0};
    private Sprite penebangjalan;
    public int penebangjalanseq002Delay = 200;
    public int[] penebangjalanseq002 = {0, 1, 2, 3, 4, 3, 2, 1};
    private Sprite CicakSprite;
    public int CicakSpriteHitDelay = 200;
    public int[] CicakSpriteHit = {0};
    public int CicakSpriteMoveDelay = 200;
    public int[] CicakSpriteMove = {1, 2, 1, 3};
    private Sprite BalokHalangSprite;
    public int BalokHalangSpriteseq001Delay = 200;
    public int[] BalokHalangSpriteseq001 = {0};
    private Image BalokHalang;
    private Image malingall;
    private Sprite BalokHalangSprite2;
    public int BalokHalangSprite2seq001Delay = 200;
    public int[] BalokHalangSprite2seq001 = {0};
    private Image pemburuall;
    private Sprite maling;
    public int malingseq001Delay = 200;
    public int[] malingseq001 = {0, 1};
    public int malingkenaDelay = 200;
    public int[] malingkena = {2};
    private Image pendorongall;
    private Sprite pendorong;
    public int pendorongseq001Delay = 200;
    public int[] pendorongseq001 = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
//</editor-fold>//GEN-END:|fields|0|
    
//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|

    public Image getCicak() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (cicak == null) {//GEN-END:|1-getter|0|1-preInit
            // write pre-init user code here
            cicak = Image.createImage("/GameIPA6/Image/cicak.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
        // write post-init user code here
        return this.cicak;//GEN-BEGIN:|1-getter|2|
    }//GEN-END:|1-getter|2|

    public Image getCicakFull() throws java.io.IOException {//GEN-BEGIN:|4-getter|0|4-preInit
        if (CicakFull == null) {//GEN-END:|4-getter|0|4-preInit
            // write pre-init user code here
            CicakFull = Image.createImage("/GameIPA6/Image/bab1/CicakFull.png");//GEN-BEGIN:|4-getter|1|4-postInit
        }//GEN-END:|4-getter|1|4-postInit
        // write post-init user code here
        return this.CicakFull;//GEN-BEGIN:|4-getter|2|
    }//GEN-END:|4-getter|2|



    public Image getCicakFullKecil() throws java.io.IOException {//GEN-BEGIN:|7-getter|0|7-preInit
        if (CicakFullKecil == null) {//GEN-END:|7-getter|0|7-preInit
            // write pre-init user code here
            CicakFullKecil = Image.createImage("/GameIPA6/Image/bab1/CicakFullKecil.png");//GEN-BEGIN:|7-getter|1|7-postInit
        }//GEN-END:|7-getter|1|7-postInit
        // write post-init user code here
        return this.CicakFullKecil;//GEN-BEGIN:|7-getter|2|
    }//GEN-END:|7-getter|2|













    public Sprite getCicakSprite() throws java.io.IOException {//GEN-BEGIN:|51-getter|0|51-preInit
        if (CicakSprite == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            CicakSprite = new Sprite(getCicakFullKecil(), 40, 60);//GEN-BEGIN:|51-getter|1|51-postInit
            CicakSprite.setFrameSequence(CicakSpriteMove);//GEN-END:|51-getter|1|51-postInit
            // write post-init user code here
        }//GEN-BEGIN:|51-getter|2|
        return CicakSprite;
    }//GEN-END:|51-getter|2|

    public Image getBalokHalang() throws java.io.IOException {//GEN-BEGIN:|54-getter|0|54-preInit
        if (BalokHalang == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            BalokHalang = Image.createImage("/GameIPA6/Image/bab1/BalokHalang.png");//GEN-BEGIN:|54-getter|1|54-postInit
        }//GEN-END:|54-getter|1|54-postInit
        // write post-init user code here
        return this.BalokHalang;//GEN-BEGIN:|54-getter|2|
    }//GEN-END:|54-getter|2|

    public Sprite getBalokHalangSprite() throws java.io.IOException {//GEN-BEGIN:|55-getter|0|55-preInit
        if (BalokHalangSprite == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            BalokHalangSprite = new Sprite(getBalokHalang(), 100, 50);//GEN-BEGIN:|55-getter|1|55-postInit
            BalokHalangSprite.setFrameSequence(BalokHalangSpriteseq001);//GEN-END:|55-getter|1|55-postInit
            // write post-init user code here
        }//GEN-BEGIN:|55-getter|2|
        return BalokHalangSprite;
    }//GEN-END:|55-getter|2|

    public Sprite getBalokHalangSprite2() throws java.io.IOException {//GEN-BEGIN:|57-getter|0|57-preInit
        if (BalokHalangSprite2 == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            BalokHalangSprite2 = new Sprite(getBalokHalang(), 100, 50);//GEN-BEGIN:|57-getter|1|57-postInit
            BalokHalangSprite2.setFrameSequence(BalokHalangSprite2seq001);//GEN-END:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return BalokHalangSprite2;
    }//GEN-END:|57-getter|2|

    public Image getMalingall() throws java.io.IOException {//GEN-BEGIN:|59-getter|0|59-preInit
        if (malingall == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            malingall = Image.createImage("/GameIPA6/Image/bab4/malingall.png");//GEN-BEGIN:|59-getter|1|59-postInit
        }//GEN-END:|59-getter|1|59-postInit
        // write post-init user code here
        return this.malingall;//GEN-BEGIN:|59-getter|2|
    }//GEN-END:|59-getter|2|





    public Image getOrang() throws java.io.IOException {//GEN-BEGIN:|67-getter|0|67-preInit
        if (orang == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            orang = Image.createImage("/GameIPA6/Image/bab4/orang.png");//GEN-BEGIN:|67-getter|1|67-postInit
        }//GEN-END:|67-getter|1|67-postInit
        // write post-init user code here
        return this.orang;//GEN-BEGIN:|67-getter|2|
    }//GEN-END:|67-getter|2|



    public Image getDorongall() throws java.io.IOException {//GEN-BEGIN:|70-getter|0|70-preInit
        if (dorongall == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            dorongall = Image.createImage("/GameIPA6/Image/bab7/dorongall.png");//GEN-BEGIN:|70-getter|1|70-postInit
        }//GEN-END:|70-getter|1|70-postInit
        // write post-init user code here
        return this.dorongall;//GEN-BEGIN:|70-getter|2|
    }//GEN-END:|70-getter|2|



    public Image getHint() throws java.io.IOException {//GEN-BEGIN:|75-getter|0|75-preInit
        if (hint == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            hint = Image.createImage("/GameIPA6/Image/Icon/hint.png");//GEN-BEGIN:|75-getter|1|75-postInit
        }//GEN-END:|75-getter|1|75-postInit
        // write post-init user code here
        return this.hint;//GEN-BEGIN:|75-getter|2|
    }//GEN-END:|75-getter|2|



    public Image getAir5() throws java.io.IOException {//GEN-BEGIN:|78-getter|0|78-preInit
        if (air5 == null) {//GEN-END:|78-getter|0|78-preInit
            // write pre-init user code here
            air5 = Image.createImage("/GameIPA6/Image/bab5/air5.png");//GEN-BEGIN:|78-getter|1|78-postInit
        }//GEN-END:|78-getter|1|78-postInit
        // write post-init user code here
        return this.air5;//GEN-BEGIN:|78-getter|2|
    }//GEN-END:|78-getter|2|



    public Sprite getTembak() throws java.io.IOException {//GEN-BEGIN:|81-getter|0|81-preInit
        if (tembak == null) {//GEN-END:|81-getter|0|81-preInit
            // write pre-init user code here
            tembak = new Sprite(getAir5(), 5, 20);//GEN-BEGIN:|81-getter|1|81-postInit
            tembak.setFrameSequence(tembakseq003);//GEN-END:|81-getter|1|81-postInit
            // write post-init user code here
        }//GEN-BEGIN:|81-getter|2|
        return tembak;
    }//GEN-END:|81-getter|2|

    public Image getOrangs() throws java.io.IOException {//GEN-BEGIN:|83-getter|0|83-preInit
        if (orangs == null) {//GEN-END:|83-getter|0|83-preInit
            // write pre-init user code here
            orangs = Image.createImage("/GameIPA6/Image/bab3/orangs.png");//GEN-BEGIN:|83-getter|1|83-postInit
        }//GEN-END:|83-getter|1|83-postInit
        // write post-init user code here
        return this.orangs;//GEN-BEGIN:|83-getter|2|
    }//GEN-END:|83-getter|2|



    public Image getPenebangs() throws java.io.IOException {//GEN-BEGIN:|86-getter|0|86-preInit
        if (penebangs == null) {//GEN-END:|86-getter|0|86-preInit
            // write pre-init user code here
            penebangs = Image.createImage("/GameIPA6/Image/bab3/penebangs.png");//GEN-BEGIN:|86-getter|1|86-postInit
        }//GEN-END:|86-getter|1|86-postInit
        // write post-init user code here
        return this.penebangs;//GEN-BEGIN:|86-getter|2|
    }//GEN-END:|86-getter|2|

    public Sprite getOrangjalan() throws java.io.IOException {//GEN-BEGIN:|89-getter|0|89-preInit
        if (orangjalan == null) {//GEN-END:|89-getter|0|89-preInit
            // write pre-init user code here
            orangjalan = new Sprite(getOrangs(), 57, 150);//GEN-BEGIN:|89-getter|1|89-postInit
            orangjalan.setFrameSequence(orangjalanseq002);//GEN-END:|89-getter|1|89-postInit
            // write post-init user code here
        }//GEN-BEGIN:|89-getter|2|
        return orangjalan;
    }//GEN-END:|89-getter|2|

    public Sprite getPenebangjalan() throws java.io.IOException {//GEN-BEGIN:|91-getter|0|91-preInit
        if (penebangjalan == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            penebangjalan = new Sprite(getPenebangs(), 120, 150);//GEN-BEGIN:|91-getter|1|91-postInit
            penebangjalan.setFrameSequence(penebangjalanseq002);//GEN-END:|91-getter|1|91-postInit
            // write post-init user code here
        }//GEN-BEGIN:|91-getter|2|
        return penebangjalan;
    }//GEN-END:|91-getter|2|

    public Image getPenembak() throws java.io.IOException {//GEN-BEGIN:|93-getter|0|93-preInit
        if (penembak == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            penembak = Image.createImage("/GameIPA6/Image/bab4/penembak.png");//GEN-BEGIN:|93-getter|1|93-postInit
        }//GEN-END:|93-getter|1|93-postInit
        // write post-init user code here
        return this.penembak;//GEN-BEGIN:|93-getter|2|
    }//GEN-END:|93-getter|2|

    public Sprite getPenembaks() throws java.io.IOException {//GEN-BEGIN:|94-getter|0|94-preInit
        if (penembaks == null) {//GEN-END:|94-getter|0|94-preInit
            // write pre-init user code here
            penembaks = new Sprite(getPenembak(), 31, 78);//GEN-BEGIN:|94-getter|1|94-postInit
            penembaks.setFrameSequence(penembaksseq001);//GEN-END:|94-getter|1|94-postInit
            // write post-init user code here
        }//GEN-BEGIN:|94-getter|2|
        return penembaks;
    }//GEN-END:|94-getter|2|

    public Image getPemburuall() throws java.io.IOException {//GEN-BEGIN:|96-getter|0|96-preInit
        if (pemburuall == null) {//GEN-END:|96-getter|0|96-preInit
            // write pre-init user code here
            pemburuall = Image.createImage("/GameIPA6/Image/bab4/pemburuall.png");//GEN-BEGIN:|96-getter|1|96-postInit
        }//GEN-END:|96-getter|1|96-postInit
        // write post-init user code here
        return this.pemburuall;//GEN-BEGIN:|96-getter|2|
    }//GEN-END:|96-getter|2|

    public Sprite getMaling() throws java.io.IOException {//GEN-BEGIN:|97-getter|0|97-preInit
        if (maling == null) {//GEN-END:|97-getter|0|97-preInit
            // write pre-init user code here
            maling = new Sprite(getPemburuall(), 32, 81);//GEN-BEGIN:|97-getter|1|97-postInit
            maling.setFrameSequence(malingseq001);//GEN-END:|97-getter|1|97-postInit
            // write post-init user code here
        }//GEN-BEGIN:|97-getter|2|
        return maling;
    }//GEN-END:|97-getter|2|

    public Image getPendorongall() throws java.io.IOException {//GEN-BEGIN:|100-getter|0|100-preInit
        if (pendorongall == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            pendorongall = Image.createImage("/GameIPA6/Image/bab7/pendorongall.png");//GEN-BEGIN:|100-getter|1|100-postInit
        }//GEN-END:|100-getter|1|100-postInit
        // write post-init user code here
        return this.pendorongall;//GEN-BEGIN:|100-getter|2|
    }//GEN-END:|100-getter|2|

    public Sprite getPendorong() throws java.io.IOException {//GEN-BEGIN:|101-getter|0|101-preInit
        if (pendorong == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            pendorong = new Sprite(getPendorongall(), 100, 100);//GEN-BEGIN:|101-getter|1|101-postInit
            pendorong.setFrameSequence(pendorongseq001);//GEN-END:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return pendorong;
    }//GEN-END:|101-getter|2|






    
}
