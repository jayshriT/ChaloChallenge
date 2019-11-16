package com.example.jayshri.chalochallenge.models;

public class StopData {

    private String stopId;
    private String stopName;
    private int sequence;
    private double latitute;
    private double longitude;

    public StopData(String stopId,String stopName,int sequence,double latitute,double longitude){
        this.latitute = latitute;
        this.longitude = longitude;
        this.stopId = stopId;
        this.stopName = stopName;
        this.sequence = sequence;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
