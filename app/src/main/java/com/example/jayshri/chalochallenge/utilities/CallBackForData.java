package com.example.jayshri.chalochallenge.utilities;

import com.example.jayshri.chalochallenge.ViewProcessor.DataViewProcessor;
import com.example.jayshri.chalochallenge.models.NextStopData;

import org.springframework.core.GenericTypeResolver;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CallBackForData <T> implements Callback <T>{


    private DataViewProcessor dataViewProcessor;


    private static Logger logger = Logger.getLogger(CallBackForData.class.getName());

    public CallBackForData(DataViewProcessor dataViewProcessor) {
        this.dataViewProcessor = dataViewProcessor;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        dataViewProcessor.processData(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        logger.log(Level.WARNING  , t.getCause().toString());
    }
}
