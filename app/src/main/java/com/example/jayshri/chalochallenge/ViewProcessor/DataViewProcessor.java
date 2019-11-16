package com.example.jayshri.chalochallenge.ViewProcessor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.models.RouteInfoData;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
public abstract class DataViewProcessor <T>{

    public ProgressBar progressBar;
    public LinearLayoutManager linearLayoutManager;
    public RecyclerView recyclerView;
    public AllRoutesAdapter allRoutesAdapter;
    public Context context;

    public void processData(T data){
        //default implemention
    }
}
