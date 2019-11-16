package com.example.jayshri.chalochallenge;

import com.example.jayshri.chalochallenge.models.RouteInfoData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoutesApi {

    @GET("/metadata")
    public Call<List<RouteInfoData>> getAllRoutes();
}
