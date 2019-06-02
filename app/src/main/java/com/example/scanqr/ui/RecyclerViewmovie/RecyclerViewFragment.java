package com.example.scanqr.ui.RecyclerViewmovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scanqr.R;
import com.example.scanqr.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    List<Movie> list;
    RecyclerView recyclerView;
    Integer[] image;
    MyAdapter myAdapter;
    Movie movie;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
           View view= inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
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
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter=new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);

           return view;


    }

}
