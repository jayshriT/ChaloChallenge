package com.example.jayshri.chalochallenge.ViewProcessor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.models.RouteInfoData;

import java.util.List;

import retrofit2.Response;

public abstract class DataViewProcessor{

    public ProgressBar progressBar;
    public LinearLayoutManager linearLayoutManager;
    public RecyclerView recyclerView;
    public AllRoutesAdapter allRoutesAdapter;
    public Context context;

    public DataViewProcessor(ProgressBar progressBar, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, AllRoutesAdapter allRoutesAdapter, Context context) {
        this.progressBar = progressBar;
        this.linearLayoutManager = linearLayoutManager;
        this.recyclerView = recyclerView;
        this.allRoutesAdapter = allRoutesAdapter;
        this.context = context;
    }


    public void processData(Response data){
        //default implemention
    }
}
