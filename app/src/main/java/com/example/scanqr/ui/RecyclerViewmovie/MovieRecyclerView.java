package com.example.scanqr.ui.RecyclerViewmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.scanqr.R;
import com.example.scanqr.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRecyclerView extends AppCompatActivity {
    List<Movie> list;
    RecyclerView recyclerView;
    Integer[] image;
MyAdapter myAdapter;
Movie movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        image = new Integer[]{
         R.drawable.images, R.drawable.index
        };
list.add(new Movie( R.drawable.images));
list.add(new Movie(R.drawable.index));
        list.add(new Movie( R.drawable.images));
        list.add(new Movie(R.drawable.index));
        list.add(new Movie( R.drawable.images));
        list.add(new Movie(R.drawable.index));
//for(int i=0 ;i<image.length;i++){
//  Movie movie=new Movie();
//  movie.setImage(image);
//   //list.add();
//}
        Log.i("Movie", "onCreate: "+list.toString());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
recyclerView.setLayoutManager(layoutManager);
myAdapter=new MyAdapter(list,MovieRecyclerView.this);
recyclerView.setAdapter(myAdapter);
    }
}



