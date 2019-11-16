package com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService;

import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Path;

public interface ApiService {

    public Call<List<RouteInfoData>> getAllRoutes();

    public  Call<NextStopData> getNextStop(long routeId , long stopId);
}
