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
public class ListMovieFragment extends Fragment implements ListMovieInterface.view {

    private List<Movie> mList;
    private RecyclerView mRecyclerView;
    private ListMovieAdapter mListMovieAdapter;
    private Toolbar mToolbar;
    private View mRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_listmovie, container, false);
        initUi();
        setToolBar();
        dataSetListMovie();
        initializeMovieRecyclerView();

        return mRoot;


    }

    private void dataSetListMovie() {
        mList = new ArrayList<>();

        mList.add(new Movie(R.drawable.takhtgaz));
        mList.add(new Movie(R.drawable.drakola));
        mList.add(new Movie(R.drawable.takhtgaz));
        mList.add(new Movie(R.drawable.drakola));
        mList.add(new Movie(R.drawable.takhtgaz));
        mList.add(new Movie(R.drawable.drakola));

    }

    private void initializeMovieRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mListMovieAdapter = new ListMovieAdapter(mList, ListMovieFragment.this);
        mRecyclerView.setAdapter(mListMovieAdapter);

    }

    private void setToolBar() {

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.listmovie_textsettitle);

    }

    @Override
    public void replace(int id) {
        MovieFragment movieFragment = MovieFragment.newInstance(id);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_main_replaceFragments, movieFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void initUi() {
        mToolbar = mRoot.findViewById(R.id.Toolbar_recycler);
        mRecyclerView = mRoot.findViewById(R.id.recyclerView);
    }
}
