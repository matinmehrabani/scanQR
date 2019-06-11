package com.example.scanqr.ui.draCola;


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
public class DraColaFragment extends Fragment {

    private int mPosition = 0;
    private MediaController mMediaController;
   private VideoView mVideoView;



//    public static DraColaFragment newInstance(String name){
//        DraColaFragment movie2Fragment=new DraColaFragment();
//
//        Bundle bundle=new Bundle();
//        bundle.putString("name",name);
//        movie2Fragment.setArguments(bundle);
//        return movie2Fragment;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_movie2, container, false);

        mVideoView= view.findViewById(R.id.videoView2);


        if (mMediaController == null) {
            mMediaController = new MediaController(getActivity());


            mMediaController.setAnchorView(mVideoView);



            mVideoView.setMediaController(mMediaController);
        }


        try {

            int id = this.getRawResIdByName("md");
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


        return view;
    }
    public int getRawResIdByName(String resName) {
        String pkgName = this.getActivity().getPackageName();

        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


        savedInstanceState.putInt("CurrentPosition", mVideoView.getCurrentPosition());
        mVideoView.pause();
    }
}
