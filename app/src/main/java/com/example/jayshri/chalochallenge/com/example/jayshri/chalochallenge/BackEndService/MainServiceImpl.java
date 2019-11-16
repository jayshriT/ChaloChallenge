package com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService;

import com.example.jayshri.chalochallenge.ViewProcessor.DataViewProcessor;
import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import com.example.jayshri.chalochallenge.utilities.CallBackForData;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import retrofit2.Call;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainServiceImpl implements  MainService{

    private ApiService apiService;
    private CallBackForData callBackForRouteInfoData;

    @Override
    public void getAllRoute() {
       apiService.getAllRoutes().enqueue(callBackForRouteInfoData);
    }

    @Override
    public void getNextStop(long routeId , long stopId) {
         apiService.getNextStop(routeId, stopId).enqueue(callBackForRouteInfoData);
    }
}
