/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Tools;

import GameIPA6.Control.GameDesign;
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author user
 */
public class LoadInisialisasi {

    public GameDesign gd;
    public Image imgLeftArrow, imgRightArrow, imgFire, imgCheck, imgBackground, imgRun, pilih, story1, story2, cek, gmb;
    //bab1
    public Image cicak, ular, bebek, balok;
    public Sprite cicakSprite, balokHalang1, balokHalang2;
    //bab2
    public Image laki, jenggot, kumis, payudara, pinggul, sperma, ovarium;
    //bab3
    public Sprite orang, penebang;
    //bab4
    public Sprite pencuri, penyelamat, peluru;
    //bab5
    public Image bak, air, pipa, apibirukanan, apimerahkanan, apibiru, apimerah;
    //bab6
    //bab7
    public Sprite pendorong;
    //bab8
    public Image rumah, jendela, listrik;
    //bab9
    public Image tataSurya, ttsurya;

    public void bab1(int i) throws IOException {
        switch (i) {
            case (0):
                cicak = Image.createImage("/GameIPA6/Image/bab1/ck.jpg");
                break;
            case (1):
                ular = Image.createImage("/GameIPA6/Image/bab1/ul.jpg");
                break;
            case (2):
                bebek = Image.createImage("/GameIPA6/Image/bab1/bk.jpg");
                break;
            case (3):
                balok = Image.createImage("/GameIPA6/Image/bab1/Balok.png");
                break;
            case (4):
                imgLeftArrow = Image.createImage("/GameIPA6/Image/Icon/L.png");
                break;
            case (5):
                imgRightArrow = Image.createImage("/GameIPA6/Image/Icon/R.png");
                break;
            case (6):
                gd = new GameDesign();
                break;
            case (7):
                cicakSprite = gd.getCicakSprite();
                break;
            case (8):
                balokHalang1 = gd.getBalokHalangSprite();
                break;
            case (9):
                balokHalang2 = gd.getBalokHalangSprite2();
                break;
            case (10):
                story1 = Image.createImage("/GameIPA6/Image/bab1/story1.png");
                break;
            case (11):
                story2 = Image.createImage("/GameIPA6/Image/bab1/story2.png");
                break;
            case (12):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void bab2(int i) throws IOException {
        switch (i) {
            case (0):
                laki = Image.createImage("/GameIPA6/Image/bab2/laki.png");
                break;
            case (1):
                pilih = Image.createImage("/GameIPA6/Image/bab2/pilih.png");
                break;
            case (2):
                jenggot = Image.createImage("/GameIPA6/Image/bab2/jenggot.png");
                break;
            case (3):
                kumis = Image.createImage("/GameIPA6/Image/bab2/kumis.png");
                break;
            case (4):
                payudara = Image.createImage("/GameIPA6/Image/bab2/payudara.png");
                break;
            case (5):
                pinggul = Image.createImage("/GameIPA6/Image/bab2/panggul.png");
                break;
            case (6):
                sperma = Image.createImage("/GameIPA6/Image/bab2/sperma.png");
                break;
            case (7):
                ovarium = Image.createImage("/GameIPA6/Image/bab2/ovarium.png");
                break;
            case (8):
                imgCheck = Image.createImage("/GameIPA6/Image/Icon/V.png");
                break;
            case (9):
                story1 = Image.createImage("/GameIPA6/Image/bab2/story1.png");
                break;
            case (10):
                story2 = Image.createImage("/GameIPA6/Image/bab2/story2.png");
                break;
            case (11):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
            case (12):
                gmb = Image.createImage("/GameIPA6/Image/bab2/pilihhint.png");
                break;
        }
    }

    public void bab3(int i) throws IOException {
        switch (i) {
            case (0):
                imgRun = Image.createImage("/GameIPA6/Image/Icon/run.png");
                break;
            case (1):
                imgBackground = Image.createImage("/GameIPA6/Image/bab3/backgroundPohon.png");
                break;
            case (2):
                gd = new GameDesign();
                break;
            case (3):
                orang = gd.getOrangjalan();
                break;
            case (4):
                penebang = gd.getPenebangjalan();
                break;
            case (5):
                story1 = Image.createImage("/GameIPA6/Image/bab3/story1.png");
                break;
            case (6):
                story2 = Image.createImage("/GameIPA6/Image/bab3/story2.png");
                break;
            case (7):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void bab4(int i) throws IOException {
        switch (i) {
            case (0):
                gd = new GameDesign();
                break;
            case (1):
                pencuri = gd.getMaling();
                break;
            case (2):
                penyelamat = gd.getPenembaks();
                break;
            case (3):
                peluru = gd.getTembak();
                break;
            case (4):
                imgLeftArrow = Image.createImage("/GameIPA6/Image/Icon/L.png");
                break;
            case (5):
                imgRightArrow = Image.createImage("/GameIPA6/Image/Icon/R.png");
                break;
            case (6):
                imgFire = Image.createImage("/GameIPA6/Image/Icon/fire.png");
                break;
            case (7):
                story1 = Image.createImage("/GameIPA6/Image/bab4/story1.png");
                break;
            case (8):
                story2 = Image.createImage("/GameIPA6/Image/bab4/story2.png");
                break;
            case (9):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void bab5(int i) throws IOException {
        switch (i) {
            case (0):
                bak = Image.createImage("/GameIPA6/Image/bab5/bak.png");
                break;
            case (1):
                air = Image.createImage("/GameIPA6/Image/bab5/air.png");
                break;
            case (2):
                pipa = Image.createImage("/GameIPA6/Image/bab5/pipa plastik.png");
                break;
            case (3):
                apibirukanan = Image.createImage("/GameIPA6/Image/bab5/apibirukanan.png");
                break;
            case (4):
                apimerahkanan = Image.createImage("/GameIPA6/Image/bab5/apimerahkanan.png");
                break;
            case (5):
                apibiru = Image.createImage("/GameIPA6/Image/bab5/apibiru.png");
                break;
            case (6):
                apimerah = Image.createImage("/GameIPA6/Image/bab5/apimerah.png");
                break;
            case (7):
                story1 = Image.createImage("/GameIPA6/Image/bab5/story1.png");
                break;
            case (8):
                story2 = Image.createImage("/GameIPA6/Image/bab5/story2.png");
                break;
            case (9):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void bab6(int i) throws IOException {
        switch (i) {
            case (0):
                pilih = Image.createImage("/GameIPA6/Image/bab6/pilih.png");
                break;
            case (1):
                gmb = Image.createImage("/GameIPA6/Image/bab8/bab8hint.png");
                break;
            case (2):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
            case (3):
                story1 = Image.createImage("/GameIPA6/Image/bab6/story1.png");
                break;
            case (4):
                story2 = Image.createImage("/GameIPA6/Image/bab6/story2.png");
                break;
        }
    }

    public void bab7(int i) throws IOException {
        switch (i) {
            case (0):
                gd = new GameDesign();
                break;
            case (1):
                pendorong = gd.getPendorong();
                break;
            case (2):
                imgRun = Image.createImage("/GameIPA6/Image/Icon/run.png");
                break;
            case (3):
                imgBackground = Image.createImage("/GameIPA6/Image/bab7/background.png");
                break;
            case (4):
                story1 = Image.createImage("/GameIPA6/Image/bab7/story1.png");
                break;
            case (5):
                story2 = Image.createImage("/GameIPA6/Image/bab7/story2.png");
                break;
            case (6):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void bab8(int i) throws IOException {
        switch (i) {
            case (0):
                rumah = Image.createImage("/GameIPA6/Image/bab8/rumah.png");
                break;
            case (1):
                jendela = Image.createImage("/GameIPA6/Image/bab8/jendela.png");
                break;
            case (2):
                listrik = Image.createImage("/GameIPA6/Image/bab8/listrik.png");
                break;
            case (3):
                story1 = Image.createImage("/GameIPA6/Image/bab8/story1.png");
                break;
            case (4):
                story2 = Image.createImage("/GameIPA6/Image/bab8/story2.png");
                break;
            case (5):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void bab9(int i) throws IOException {
        switch (i) {
            case (0):
                tataSurya = Image.createImage("/GameIPA6/Image/bab9/tatasurya.png");
                break;
            case (1):
                pilih = Image.createImage("/GameIPA6/Image/bab9/pilih.png");
                break;
            case (2):
                imgBackground = Image.createImage("/GameIPA6/Image/bab9/angkasabackground.png");
                break;
            case (3):
                story1 = Image.createImage("/GameIPA6/Image/bab9/story1.png");
                break;
            case (4):
                story2 = Image.createImage("/GameIPA6/Image/bab9/story2.png");
                break;
            case (5):
                ttsurya = Image.createImage("/GameIPA6/Image/bab9/tatasurya.png");
                break;
            case (6):
                cek = Image.createImage("/GameIPA6/Image/Icon/next.png");
                break;
        }
    }

    public void hapusBab1() {
        cicak = null;
        ular = null;
        bebek = null;
        balok = null;
        imgLeftArrow = null;
        imgRightArrow = null;
        cicakSprite = null;
        balokHalang1 = null;
        balokHalang2 = null;
        gd = null;
    }

    public void hapusBab2() {
        imgCheck = null;
        laki = null;
        pilih = null;
        jenggot = null;
        kumis = null;
        payudara = null;
        pinggul = null;
        sperma = null;
        ovarium = null;
    }

    public void hapusBab3() {
        imgRun = null;
        imgBackground = null;
        orang = null;
        penebang = null;
        gd = null;
    }

    public void hapusBab4() {
        pencuri = null;
        penyelamat = null;
        peluru = null;
        imgLeftArrow = null;
        imgRightArrow = null;
        imgFire = null;
        gd = null;
    }

    public void hapusBab5() {
        bak = null;
        air = null;
        pipa = null;
        apibirukanan = null;
        apimerahkanan = null;
        apibiru = null;
        apimerah = null;
    }

    public void hapusBab6() {
        pilih = null;
    }

    public void hapusBab7() {
        imgRun = null;
        imgBackground = null;
        pendorong = null;
        gd = null;
    }

    public void hapusBab8() {
        rumah = null;
        jendela = null;
        listrik = null;
    }

    public void hapusBab9() {
        tataSurya = null;
        pilih = null;
        imgBackground = null;
    }
}
