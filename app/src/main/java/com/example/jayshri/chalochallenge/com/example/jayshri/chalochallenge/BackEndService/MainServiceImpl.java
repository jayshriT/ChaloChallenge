package com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService;

import com.example.jayshri.chalochallenge.ViewProcessor.DataViewProcessor;
import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import com.example.jayshri.chalochallenge.utilities.CallBackForData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainServiceImpl implements  MainService{

    private ApiService apiService;
    private CallBackForData callBackForRouteInfoData;
    private CallBackForData <NextStopData> callBackForNextCallData;

    public MainServiceImpl(ApiService apiService, CallBackForData callBackForRouteInfoData, CallBackForData<NextStopData> callBackForNextCallData) {
        this.apiService = apiService;
        this.callBackForRouteInfoData = callBackForRouteInfoData;
        this.callBackForNextCallData = callBackForNextCallData;
    }


    @Override
    public void getAllRoute() {
       apiService.getAllRoutes().enqueue(callBackForRouteInfoData);
    }

    @Override
    public void getNextStop(long routeId , long stopId) {
         apiService.getNextStop(routeId, stopId).enqueue(callBackForNextCallData);
    }
}
