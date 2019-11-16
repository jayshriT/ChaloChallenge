package com.example.jayshri.chalochallenge.utilities;

import com.example.jayshri.chalochallenge.ViewProcessor.DataViewProcessor;
import com.example.jayshri.chalochallenge.models.NextStopData;

import org.springframework.core.GenericTypeResolver;

import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class CallBackForData<T> implements Callback <T> {


    private DataViewProcessor processorForNextNode;
    private DataViewProcessor processorForAllRouteData;

    private static Logger logger = Logger.getLogger(CallBackForData.class.getName());
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Class c = GenericTypeResolver.resolveTypeArgument(response.getClass() , Response.class);
        if(c.getName().equals(NextStopData.class.getName())){
            processorForNextNode.processData(response);
        } else {
            processorForAllRouteData.processData(response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        logger.log(Level.WARNING  , t.getCause().toString());
    }
}
