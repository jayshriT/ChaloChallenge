package com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService;

import com.example.jayshri.chalochallenge.RoutesApi;
import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import com.example.jayshri.chalochallenge.utilities.RetrofitClient;

import java.util.List;

import retrofit2.Call;

public class ApiServiceImpl implements  ApiService{

    private RoutesApi api;

    public ApiServiceImpl(RoutesApi api){
        this.api = api;
    }

    @Override
    public Call<List<RouteInfoData>> getAllRoutes() {
        return  api.getAllRoutes();
    }

    @Override
    public Call<NextStopData> getNextStop(long routeId, long stopId) {
        return api.getNextStop(routeId , stopId);
    }
}
