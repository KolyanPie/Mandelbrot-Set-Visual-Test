package com.github.fx;

import javafx.scene.control.ProgressBar;

public class SyncProgressBar {
    private ProgressBar progressBar;
    private double curVal;
    private double maxVal;
    private long time;

    public SyncProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public synchronized void incrementValue() {
        curVal++;
    }

    public void setMaxVal(double maxVal) {
        this.maxVal = maxVal;
    }

    public void setZero() {
        curVal = 0;
        time = System.currentTimeMillis();
    }

    public void displayProgress() {
        progressBar.setProgress(curVal / maxVal);
    }

    public long getTime() {
        return System.currentTimeMillis() - time;
    }
}