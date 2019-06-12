package com.example.scanqr.ui.movie;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.scanqr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MovieInterface.view {

    private int mPosition = 0;
    private MediaController mMediaController;
    private VideoView mVideoView;
    private View mRoot;
    private String mMovie;
private Toolbar mToolbar;
MovieFragment movieFragment;
    public static MovieFragment newInstance(int id) {
        MovieFragment movie2Fragment = new MovieFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("name", id);
        movie2Fragment.setArguments(bundle);
        return movie2Fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRoot = inflater.inflate(R.layout.fragment_movie, container, false);

        init();
toolBar();

        if (mMediaController == null) {
            mMediaController = new MediaController(getActivity());


            mMediaController.setAnchorView(mVideoView);


            mVideoView.setMediaController(mMediaController);
        }


        try {
            switch (getArguments().getInt("name")) {
                case 1:
                    mMovie = "md";
                    break;
                case 2:
                    mMovie = "big_buck_bunny";
            }
            int id = this.getRawResIdByName(mMovie);
            mVideoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName()
                    + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        mVideoView.requestFocus();


        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                mVideoView.seekTo(mPosition);
                if (mPosition == 0) {
                    mVideoView.start();
                }


                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {


                        mMediaController.setAnchorView(mVideoView);
                    }
                });
            }
        });

        setHasOptionsMenu(true);
        return mRoot;
    }

    public int getRawResIdByName(String resName) {
        String packageName = this.getActivity().getPackageName();

        int resID = this.getResources().getIdentifier(resName, "raw", packageName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


        savedInstanceState.putInt("CurrentPosition", mVideoView.getCurrentPosition());
        mVideoView.pause();
    }

    @Override
    public void init() {
        mVideoView = mRoot.findViewById(R.id.videoView2);
        mToolbar=mRoot.findViewById(R.id.Toolbar_movie);
    }
    public void toolBar(){

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("movie");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){

            getActivity().getSupportFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);

    }
}
