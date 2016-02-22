package com.gameapp.gameapp;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private static final String TAG = MainThread.class.getSimpleName();

    //Main components
    private SurfaceHolder surfaceHolder;
    private Game game; //Primary class
    public static Canvas canvas;

    //FPS
    private int FPS = 30;
    private double averageFPS;

    private boolean running;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public MainThread(SurfaceHolder surfaceHolder, Game game) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.game = game;
    }

    @Override
    public void run() {
        //Variable for keeping track of time and FPS
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS;

        //Others
        long tickCount = 0L;
        Log.d(TAG, "Starting game loop");
        while (running) {
            tickCount++;

            startTime = System.nanoTime();
            canvas = null;

            //lock canvas
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    //this.game.update();
                    //this.game.draw(canvas);
                }
            } catch(Exception e) {}

            finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;

            try {
                this.sleep(waitTime);
            } catch(Exception e) {}

            totalTime += System.nanoTime();
            frameCount++;

            if (frameCount == FPS) {
                averageFPS = 1000 / (totalTime/frameCount)/1000000;
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
        Log.d(TAG, "Game loop executed " + tickCount + " times");
    }
}
