package com.example.jayshri.chalochallenge.ViewProcessor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jayshri.chalochallenge.ItemClickListener;
import com.example.jayshri.chalochallenge.activities.MapsActivity;
import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import  java.util.*;

import retrofit2.Response;

public class ProcessAllRouteDataInfo extends DataViewProcessor{


    private List<RouteInfoData> routeInfoDataList;

    public ProcessAllRouteDataInfo(ProgressBar progressBar, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, AllRoutesAdapter allRoutesAdapter, Context context) {
        super(progressBar, linearLayoutManager, recyclerView, allRoutesAdapter, context);
        this.routeInfoDataList = new ArrayList<>();
    }

    @Override
    public void processData(Response data) {
        List<RouteInfoData> responseData = (List<RouteInfoData>) (data.body());
        routeInfoDataList.addAll(responseData);
        setRecyclerView();
    }

    private void setRecyclerView(){
        allRoutesAdapter = new AllRoutesAdapter(context,routeInfoDataList);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(allRoutesAdapter);
        progressBar.setVisibility(View.GONE);
        allRoutesAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void itemClicked(RouteInfoData routeInfoData, int position) {
                Toast.makeText(context,"position clicked "+position,Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, MapsActivity.class);
                i.putExtra("data",routeInfoData);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }
}
