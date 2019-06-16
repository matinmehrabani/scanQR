package com.example.scanqr.ui.listMovie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.scanqr.R;
import com.example.scanqr.model.Movie;

import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.MyViewHolder> {

    private static List<Movie> mList;
    private static ListMovieInterface.view mReplace;


    public ListMovieAdapter(List<Movie> list, ListMovieInterface.view view) {
        mList = list;
        mReplace = view;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_modelmovie_listmovie, viewGroup, false));
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mList.get(getAdapterPosition()).getImage()) {

                        case R.drawable.takhtgaz:
                            mReplace.replace(1);
                            break;

                        case R.drawable.drakola:

                            mReplace.replace(2);
                    }
                }
            });
        }

    }


}
