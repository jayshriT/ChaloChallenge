package com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService;

import com.example.jayshri.chalochallenge.models.NextStopData;

public interface MainService {

    public void getAllRoute();

    public void getNextStop(long routeId , long stopId);
}
