package com.example.jayshri.chalochallenge.ViewProcessor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import  java.util.*;

public class ProcessAllRouteDataInfo extends DataViewProcessor{


    private List<RouteInfoData> routeInfoDataList;

    public ProcessAllRouteDataInfo(ProgressBar progressBar, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, AllRoutesAdapter allRoutesAdapter, Context context) {
        super(progressBar, linearLayoutManager, recyclerView, allRoutesAdapter, context);
        this.routeInfoDataList = new ArrayList<>();
    }

    @Override
    public void processData(Object data) {
        List<RouteInfoData> responseData = (List<RouteInfoData>) data;
        routeInfoDataList.addAll(responseData);
        setRecyclerView();
    }

    private void setRecyclerView(){
        allRoutesAdapter = new AllRoutesAdapter(context,routeInfoDataList);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(allRoutesAdapter);
        progressBar.setVisibility(View.GONE);

    }
}
