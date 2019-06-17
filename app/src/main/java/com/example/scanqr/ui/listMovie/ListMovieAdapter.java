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

    private   List<Movie> mList;

private listAdapter mListAdapter;

   public interface listAdapter{

      void replaces(int id);
}

    public ListMovieAdapter(List<Movie> list,listAdapter ListAdapter) {
        mList = list;
mListAdapter=ListAdapter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_modelmovie_listmovie, viewGroup, false);
        return new MyViewHolder(view,mList,mListAdapter);
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

        public MyViewHolder(@NonNull View itemView, final List<Movie> movieList,final listAdapter mListAdapter) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (movieList.get(getAdapterPosition()).getImage()) {

                        case R.drawable.listmovie_takhtgazimage:
                          mListAdapter.replaces(1);

                            break;

                        case R.drawable.listmovie_drakolaimage:
                           mListAdapter.replaces(2);

                    }
                }
            });
        }

    }


}
