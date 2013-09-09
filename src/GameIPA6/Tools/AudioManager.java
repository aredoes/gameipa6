/*
 * Copyright © 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation.
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners.
 * See LICENSE.TXT for license information.
 */
package GameIPA6.Tools;

import java.io.InputStream;
import java.util.Vector;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

public class AudioManager
        implements PlayerListener {

    public static boolean audioEnabled = true;
    private static final int MAX_PLAYERS = 8;
    // Vector holding information on which players are or have been playing
    private static Vector playing = new Vector();
    private static Vector looping = new Vector();
    private static AudioManager instance;

    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    public Player loopSample(String filename) {
        Player p = playSample(filename);
        looping.addElement(p);
        return p;
    }

    public Player playSample(String filename) {
        Player player = null;
        if (audioEnabled) {
            InputStream stream = AudioManager.class.getResourceAsStream(filename);
            try {
                limitPlaybacks();
                player = Manager.createPlayer(stream, "audio/" + filename.substring(filename.length() - 3, filename.length()));
                playing.addElement(player);
                player.realize();
                player.prefetch();
                player.addPlayerListener(this);
                player.start();
            } catch (Exception e) {
            }
        }
        return player;
    }

    /**
     * Shuts down the player, that has been playing the longest
     */
    private synchronized static void limitPlaybacks() {
        try {
            while (playing.size() > MAX_PLAYERS) {
                Player player = (Player) playing.firstElement();
                playing.removeElementAt(0);
                stop(player);
            }
        } catch (Exception e) {
        }
    }

    public void stopPlayer(Player player) {
        stop(player);
        looping.removeElement(player);
        playing.removeElement(player);
    }

    public void stopLooping() {
        for (int i = 0; i < looping.size(); i++) {
            stop((Player) looping.elementAt(i));
        }
        looping = new Vector();
    }

    private synchronized static void stop(Player player) {
        try {
            if (player.getState() == Player.STARTED) {
                try {
                    player.stop();
                } catch (Exception e) {
                }
            }
            player.deallocate();
            player.close();
            player = null;
        } catch (Exception e) {
        }
    }

    public void playerUpdate(Player player, String event, Object eventData) {
        if (event.equals(PlayerListener.END_OF_MEDIA)) {
            if (looping.contains(player)) {
                try {
                    player.setMediaTime(0);
                    player.start();
                } catch (Exception e) {
                }
            } else {
                stopPlayer(player);
            }
        }
    }

    public void stopAll() {
        for (int i = 0; i < playing.size(); i++) {
            stop((Player) playing.elementAt(i));
        }
        playing = new Vector();
        looping = new Vector();
    }
}
