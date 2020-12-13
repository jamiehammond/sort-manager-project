package com.sparta.jh.sortManager.utility;

/**
 * Class for timing.
 */
public class Timer {

    private long startTime;
    private long endTime;

    public long getTimeDifference() {
        return endTime - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
