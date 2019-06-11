package com.example.scanqr.ui.recyclerViewMovie;


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
public class RecyclerViewMovieFragment extends Fragment {

   private List<Movie> mList;
   private RecyclerView mRecyclerView;
   private Integer[] mImage;
   private ListMovieAdapter mListMovieAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

           View view= inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        mImage = new Integer[]{
                R.drawable.images, R.drawable.index
        };
        mList.add(new Movie( R.drawable.images));
        mList.add(new Movie(R.drawable.index));
        mList.add(new Movie( R.drawable.images));
        mList.add(new Movie(R.drawable.index));
        mList.add(new Movie( R.drawable.images));
        mList.add(new Movie(R.drawable.index));

        Log.i("Movie", "onCreate: "+mList.toString());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mListMovieAdapter=new ListMovieAdapter(mList,this);
        mRecyclerView.setAdapter(mListMovieAdapter);

           return view;


    }

}
