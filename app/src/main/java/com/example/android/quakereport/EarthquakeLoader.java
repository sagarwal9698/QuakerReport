//package com.example.android.quakereport;
//
//import android.content.Context;
//import android.util.Log;
//
//import androidx.annotation.Nullable;
//import androidx.lifecycle.ViewModel;
//import androidx.loader.content.AsyncTaskLoader;
//
//import java.util.List;
//
//public class EarthquakeLoader extends ViewModel {
//
//    String[] murls;
//
//
//    public  EarthquakeLoader (String... urls){
//        murls = urls;
//        startLoading();
//
//
//    }
//
//    protected List<Earthquake> startLoading() {
//        if(murls.length<1){
//            return null;
//        }
//
//        List<Earthquake> earthquakes =QueryUtil.fetchJsonString(murls[0]);
//        Log.i("DoInBackground", "earthquakes are loaded");
//
//        return earthquakes;
//    }
//}
