package com.example.jayshri.chalochallenge.models;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NextStopData {

    @SerializedName("routeId")
    private long routId;

    @SerializedName("nextStopId")
    private long nextStop;
}
