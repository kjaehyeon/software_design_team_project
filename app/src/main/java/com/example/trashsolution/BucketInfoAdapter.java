package com.example.trashsolution;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class BucketInfoAdapter implements GoogleMap.InfoWindowAdapter {
    View window;
    FoodWasteBucket bucket;

    public BucketInfoAdapter(View window, FoodWasteBucket bucket){
        this.window = window;
        this.bucket = bucket;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        //mapping
        TextView title = window.findViewById(R.id.name);
        TextView remain = window.findViewById(R.id.remain_capacity);
        TextView location = window.findViewById(R.id.location);
        ProgressBar progressBar = window.findViewById(R.id.progressbar);

        title.setText(bucket.serialNumber);
        remain.setText(bucket.capacity.currentCapacity + " / "+ 200);
        location.setText(""+bucket.location.getLatitude());
        progressBar.setProgress((int)bucket.getCapacity().getCurrentCapacity());
        progressBar.setIndeterminate(false);

        Log.d("progress", bucket.getCapacity().getCurrentCapacity() + "");
        return window;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
