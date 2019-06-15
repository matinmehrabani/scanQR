package com.example.scanqr.ui.listMovie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scanqr.R;
import com.example.scanqr.model.Movie;
import com.example.scanqr.ui.showMovie.MovieFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewMovieFragment extends Fragment implements ListMovieInterface.view {

    private List<Movie> mList;
    private RecyclerView mRecyclerView;
    private ListMovieAdapter mListMovieAdapter;
    private Toolbar mToolbar;
    private View mRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.list_movie, container, false);
        init();
        setToolBar();
        dataSet();
        recyclerView();

        return mRoot;


    }

    private void dataSet() {
        mList = new ArrayList<>();

        mList.add(new Movie(R.drawable.takhtgaz));
        mList.add(new Movie(R.drawable.drakola));
        mList.add(new Movie(R.drawable.takhtgaz));
        mList.add(new Movie(R.drawable.drakola));
        mList.add(new Movie(R.drawable.takhtgaz));
        mList.add(new Movie(R.drawable.drakola));

    }

    private void recyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mListMovieAdapter = new ListMovieAdapter(mList, RecyclerViewMovieFragment.this);
        mRecyclerView.setAdapter(mListMovieAdapter);

    }

    private void setToolBar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.movie);

    }

    @Override
    public void replace(int id) {
        MovieFragment movieFragment = MovieFragment.newInstance(id);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, movieFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void init() {
        mToolbar = mRoot.findViewById(R.id.Toolbar_recycler);
        mRecyclerView = mRoot.findViewById(R.id.recyclerView);
    }
}
