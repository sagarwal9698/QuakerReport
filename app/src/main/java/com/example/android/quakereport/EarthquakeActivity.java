
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final String USGS_Request_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";
    private EarthquakeAdapter quakeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

       quakeAdapter=new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        ListView listView= findViewById(R.id.list);
        listView.setAdapter(quakeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Earthquake currentEarthquake = quakeAdapter.getItem(i);
                String url = currentEarthquake.getUrl();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent);
            }
        });

//        EarthquakeAsyncTask task = new EarthquakeAsyncTask();                                        //    Using AsyncTask (1)
//        task.execute(USGS_Request_URL);

//        getSupportLoaderManager().initLoader(0, null, this).forceLoad();;                           // Using Loader


        final EarthquakeViewModel viewModel = new ViewModelProvider(getViewModelStore(),ViewModelProvider.Factory ).get(EarthquakeViewModel.class);
        List<Earthquake> earthquakes = viewModel.startLoading(USGS_Request_URL);
        if(earthquakes!= null){
            quakeAdapter.addAll(earthquakes);
        }


    }



//    @NonNull
//    @Override
//    public Loader<List<Earthquake>> onCreateLoader(int id, @Nullable Bundle args) {
//        return new EarthquakeLoader(EarthquakeActivity.this, USGS_Request_URL);
//    }
//
//    @Override
//    public void onLoadFinished(@NonNull Loader<List<Earthquake>> loader, List<Earthquake> data) {
//        quakeAdapter.clear();
//        if(data!= null){
//            quakeAdapter.addAll(data);                                                                     Using Loader
//
//    }
//    }
//
//    @Override
//    public void onLoaderReset(@NonNull Loader<List<Earthquake>> loader) {
//        quakeAdapter.addAll(new ArrayList<Earthquake>());
//    }

//    public class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>>{
//
//        @Override
//        protected List<Earthquake> doInBackground(String... urls) {
//            if(urls.length<1){
//                return null;
//            }
//
//            List<Earthquake> earthquakes =QueryUtil.fetchJsonString(urls[0]);                        //      Using Asynctask(2)
//            Log.i("DoInBackground", "earthquakes are loaded");
//
//            return earthquakes;
//        }
//
//        @Override
//        protected void onPostExecute(List<Earthquake> earthquakes) {
//            quakeAdapter.clear();
//            if(earthquakes!= null){
//                quakeAdapter.addAll(earthquakes);
//            }
//        }
//    }
}
