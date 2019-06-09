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

    List<Movie> mList;
    RecyclerView mRecyclerView;
    Integer[] mImage;
    MyAdapter mMyAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
//for(int i=0 ;i<image.length;i++){
//  Movie movie=new Movie();
//  movie.setImage(image);
//   //list.add();
//}
        Log.i("Movie", "onCreate: "+mList.toString());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mMyAdapter=new MyAdapter(mList,this);
        mRecyclerView.setAdapter(mMyAdapter);

           return view;


    }

}
