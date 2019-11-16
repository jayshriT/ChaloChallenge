package com.example.jayshri.chalochallenge.models;

import java.util.List;

public class RouteInfoData {
    private String routeId;
    private String routeName;
    private List<StopData> stopDataList;

    public RouteInfoData(String routeId,String routeName,List<StopData> stopDataList){
        this.routeId = routeId;
        this.routeName = routeName;
        this.stopDataList = stopDataList;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public List<StopData> getStopDataList() {
        return stopDataList;
    }

    public void setStopDataList(List<StopData> stopDataList) {
        this.stopDataList = stopDataList;
    }
}
