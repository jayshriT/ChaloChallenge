package com.example.jayshri.chalochallenge;

import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RoutesApi {

    @GET("/metadata")
    public Call<List<RouteInfoData>> getAllRoutes();

    @GET("/routes/{routeId}/stops/{stopId}")
    public  Call<NextStopData> getNextStop(@Path("routeId") long routeId , @Path("stopId") long stopId);
}
