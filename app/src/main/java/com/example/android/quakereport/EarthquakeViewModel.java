package com.example.android.quakereport;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.List;



public class EarthquakeViewModel extends ViewModel {



    protected List<Earthquake> startLoading(String... murls) {
        if(murls.length<1){
            return null;
        }

        List<Earthquake> earthquakes =QueryUtil.fetchJsonString(murls[0]);
        Log.i("StartLoading", "earthquakes are loaded");

        return earthquakes;
    }
}
