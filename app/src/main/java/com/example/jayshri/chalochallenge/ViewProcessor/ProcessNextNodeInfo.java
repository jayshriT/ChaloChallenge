package com.example.jayshri.chalochallenge.ViewProcessor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;

import java.util.List;

public class ProcessNextNodeInfo extends DataViewProcessor<NextStopData>{

    public ProcessNextNodeInfo(ProgressBar progressBar, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, AllRoutesAdapter allRoutesAdapter, Context context) {
        super(progressBar, linearLayoutManager, recyclerView, allRoutesAdapter, context);
    }

    @Override
    public void processData(NextStopData data) {

    }
}
