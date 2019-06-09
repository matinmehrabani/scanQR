package com.example.scanqr.ui.Movie1;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.scanqr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Movie1Fragment extends Fragment {
    private int mPosition = 0;
    private MediaController mMediaController;
    VideoView mVideoView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_movie1, container, false);

        mVideoView = view.findViewById(R.id.videoView);

        // Set the media controller buttons
        if (mMediaController == null) {
            mMediaController = new MediaController(getActivity());

            // Set the videoView that acts as the anchor for the MediaController.
            mMediaController.setAnchorView(mVideoView);


            // Set MediaController for VideoView
            mVideoView.setMediaController(mMediaController);
        }


        try {
            // ID of video file.
            int id = this.getRawResIdByName("big_buck_bunny");
            mVideoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName()
                    + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        mVideoView.requestFocus();


        // When the video file ready for playback.
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                mVideoView.seekTo(mPosition);
                if (mPosition == 0) {
                    mVideoView.start();
                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mMediaController.setAnchorView(mVideoView);
                    }
                });
            }
        });





       return view;
    }
    public int getRawResIdByName(String resName) {
        String pkgName = this.getActivity().getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }


    // When you change direction of phone, this method will be called.
// It store the state of video (Current position)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", mVideoView.getCurrentPosition());
        mVideoView.pause();
    }
}
