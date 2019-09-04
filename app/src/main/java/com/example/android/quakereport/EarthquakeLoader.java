//package com.example.android.quakereport;
//
//import android.content.Context;
//import android.util.Log;
//
//import androidx.annotation.Nullable;
//import androidx.loader.content.AsyncTaskLoader;
//
//import java.util.List;
//
//public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
//
//    String[] murls;
//
//
//    public  EarthquakeLoader (Context context, String... urls){
//        super(context);
//        murls = urls;
//
//
//    }
//
//    @Override
//    protected void onStartLoading() {
//        forceLoad();
//    }
//
//    @Override
//    public List<Earthquake> loadInBackground() {
//
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
