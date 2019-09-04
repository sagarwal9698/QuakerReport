package com.example.android.quakereport;

import android.util.Log;

public class Earthquake {

    // Name of the Android version (e.g. Gingerbread, Honeycomb, Ice Cream Sandwich)
    private String mDate;

    // Android version number (e.g. 2.3-2.7, 3.0-3.2.6, 4.0-4.0.4)
    private String mPlace;

    // Drawable resource ID
    private String mMag;

    public String[] parts;
    // URL of the earthquake

    private String murl;

    /*
     * Create a new AndroidFlavor object.
     *
     * @param vName is the name of the Android version (e.g. Gingerbread)
     * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
     * @param image is drawable reference ID that corresponds to the Android version
     * */
    public Earthquake(String vPlace, String vDate, String vMag, String vurl)
    {
        mDate = vDate;
        mPlace = vPlace;
        mMag = vMag;
        murl= vurl;


        if (mPlace.contains("of")){
        parts = mPlace.split("of");
        parts[0]= parts[0] + "of";
    }
        else {
            if(mPlace.contains("-")){
                parts= mPlace.split("-");
            }
            else{
                parts[0] = mPlace;
                parts[1] = mPlace;
            }
        }
        Log.i("Earthquake", parts[0] + parts[1]);

    }

    /**
     * Get the name of the Android version
     */
    public String getDate() {

        return mDate;
    }
    public String getPlacePart1(){
        return (parts[0]);
    }

    public String getPlacePart2()
    {
        return parts[1];
    }

    public String getMag() {
        return mMag;
    }
    public String getUrl(){
        return murl;
    }


}