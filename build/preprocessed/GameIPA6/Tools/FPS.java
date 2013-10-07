/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameIPA6.Tools;

/**
 *
 * @author Novelia
 */
public class FPS {
    private int fpsCounter;
    private long timer;
    private long startTimer;
    private static FPS fpsInstance;
    private double fps;
    
    public FPS() {
        startTimer = System.currentTimeMillis();
    }
    
    public static FPS getInstance() {
        if (fpsInstance==null)
            return new FPS();
        return fpsInstance;
    }
    
    public void tick() {
        fpsCounter++;
        timer = System.currentTimeMillis();
    }
    
    public double getFPS() {
        try {
            fps = (int)(fpsCounter / (double)((timer-startTimer) / 1000));
            return fps;
        } catch (ArithmeticException e) {
            return 0;
        }
    } 
}
