package com.example.jayshri.chalochallenge.models;

import com.google.gson.annotations.SerializedName;


public class NextStopData {

    @SerializedName("routeId")
    private long routId;

    @SerializedName("nextStopId")
    private long nextStop;

    public NextStopData(long routId, long nextStop) {
        this.routId = routId;
        this.nextStop = nextStop;
    }

    public long getRoutId() {
        return routId;
    }

    public void setRoutId(long routId) {
        this.routId = routId;
    }

    public long getNextStop() {
        return nextStop;
    }

    public void setNextStop(long nextStop) {
        this.nextStop = nextStop;
    }
}
