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
import com.example.jayshri.chalochallenge.ViewProcessor.DataViewProcessor;
import com.example.jayshri.chalochallenge.ViewProcessor.ProcessAllRouteDataInfo;
import com.example.jayshri.chalochallenge.ViewProcessor.ProcessNextNodeInfo;
import com.example.jayshri.chalochallenge.adapter.AllRoutesAdapter;
import com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService.ApiService;
import com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService.ApiServiceImpl;
import com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService.MainService;
import com.example.jayshri.chalochallenge.com.example.jayshri.chalochallenge.BackEndService.MainServiceImpl;
import com.example.jayshri.chalochallenge.models.NextStopData;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import com.example.jayshri.chalochallenge.utilities.CallBackForData;
import com.example.jayshri.chalochallenge.utilities.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private List<RouteInfoData> routeInfoDataList;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private AllRoutesAdapter allRoutesAdapter;
    private Context context;
    private  MainService mainService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        routeInfoDataList = new ArrayList<>();
        init();
        initAllTheService();
        getAllRoutes();
    }

    private void init() {
        context = getApplicationContext();
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void getAllRoutes() {
        mainService.getAllRoute();
    }

    private void initAllTheService() {
        RoutesApi routesApi = RetrofitClient.getRetrofitInstance().create(RoutesApi.class);
        ApiService apiService = new ApiServiceImpl(routesApi);


        DataViewProcessor viewProcessorForAllRoutes = new ProcessAllRouteDataInfo(progressBar ,linearLayoutManager , recyclerView ,allRoutesAdapter, context);
        DataViewProcessor viewProcessorForNode = new ProcessAllRouteDataInfo(progressBar , linearLayoutManager , recyclerView , allRoutesAdapter , context);

        CallBackForData callBackForData = new CallBackForData(viewProcessorForAllRoutes );
        CallBackForData<NextStopData> callBackForNextStopData = new CallBackForData<>(viewProcessorForNode);


        mainService = new MainServiceImpl(apiService , callBackForData , callBackForNextStopData);
    }
}
