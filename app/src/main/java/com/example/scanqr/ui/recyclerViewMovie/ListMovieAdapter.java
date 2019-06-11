package com.example.scanqr.ui.recyclerViewMovie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.scanqr.R;
import com.example.scanqr.model.Movie;
import com.example.scanqr.ui.taKhtGaz.TaKhtGazActivity;
import com.example.scanqr.ui.draCola.DraColaActivity;

import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.MyViewHolder> {

  private   List<Movie> mList;
  private   Fragment mRecyclerViewFragment;

    public ListMovieAdapter(List<Movie> list, Fragment recyclerViewFragment) {
        mList = list;
        mRecyclerViewFragment = recyclerViewFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.modelmovie, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Movie movie = mList.get(i);
        myViewHolder.mImageView.setImageResource(movie.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mList.get(getAdapterPosition()).getImage()) {

                        case R.drawable.images:
                            Intent intent = new Intent(mRecyclerViewFragment.getActivity(), TaKhtGazActivity.class);
                            mRecyclerViewFragment.startActivity(intent);
                            break;
                        case R.drawable.index:
                            Intent intent2 = new Intent(mRecyclerViewFragment.getActivity(), DraColaActivity.class);
                            mRecyclerViewFragment.startActivity(intent2);
                            break;
                    }
                }
            });
        }

    }


}
