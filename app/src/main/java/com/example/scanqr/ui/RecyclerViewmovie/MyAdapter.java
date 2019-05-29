package com.example.scanqr.ui.RecyclerViewmovie;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.scanqr.R;
import com.example.scanqr.model.Movie;
import com.example.scanqr.ui.Movie1.Movie1Activity;
import com.example.scanqr.ui.Movie2.Movie2Activity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

List<Movie> list;
Activity activity;

    public MyAdapter(List<Movie> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.modelmovie,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
Movie movie=list.get(i);
myViewHolder.imageView.setImageResource(movie.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movie id=list.get(getPosition());
                    Log.i("id", "onClick: "+id.toString());
switch (list.get(getAdapterPosition()).getImage()){

    case  R.drawable.images :
        Intent intent=new Intent(activity, Movie1Activity.class);
        activity.startActivity(intent);break;
    case R.drawable.index :   Intent intent2=new Intent(activity, Movie2Activity.class);
        activity.startActivity(intent2);break;
}
                }
            });
        }

    }


}
