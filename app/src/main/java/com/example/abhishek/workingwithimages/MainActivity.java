package com.example.abhishek.workingwithimages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rv_image);

        // Set Fixed size so that list updates faster
        recyclerView.setHasFixedSize(true);


        // TODO(1): Change layout
        /*
         * 0 - LinearLayout - VERTICAL
         * 1 - LinearLayout - HORIZONTAL
         * 2 - GridLayout
         * 3 - StaggeredLayout
         */
        int layout = 0;

        // TODO(2): Chnage columns to be displayed
        // How many columns for GridLayout or Staggered GridLayout
        int spanCount = 2;


        switch (layout) {
            case 0:
                LinearLayoutManager linearLayoutManagerV = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setAdapter(new ImageAdapter(3));
                recyclerView.setLayoutManager(linearLayoutManagerV);
                break;
            case 1:
                LinearLayoutManager linearLayoutManagerH = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setAdapter(new ImageAdapter(3));
                recyclerView.setLayoutManager(linearLayoutManagerH);
                break;
            case 2:
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);
                recyclerView.setAdapter(new ImageAdapter(2));
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
            case 3:
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setAdapter(new ImageAdapter(3));
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
        }
    }
}
