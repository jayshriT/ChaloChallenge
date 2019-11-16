package com.example.jayshri.chalochallenge.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jayshri.chalochallenge.R;
import com.example.jayshri.chalochallenge.RoutesApi;
import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import com.example.jayshri.chalochallenge.utilities.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<RouteInfoData> routeInfoDataList;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private AllRoutesAdapter allRoutesAdapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        routeInfoDataList = new ArrayList<>();
        getAllRoutes();
        init();
        setRecyclerView();
    }

    private void init(){
        context = getApplicationContext();
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void setRecyclerView(){
        allRoutesAdapter = new AllRoutesAdapter(context,routeInfoDataList);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(allRoutesAdapter);
        progressBar.setVisibility(View.GONE);


    }

    private void getAllRoutes(){
        RetrofitClient.getRetrofitInstance().create(RoutesApi.class).getAllRoutes().enqueue(new Callback<List<RouteInfoData>>() {
            @Override
            public void onResponse(Call<List<RouteInfoData>> call, Response<List<RouteInfoData>> response) {
                if(response.isSuccessful()){
                    routeInfoDataList.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<RouteInfoData>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
