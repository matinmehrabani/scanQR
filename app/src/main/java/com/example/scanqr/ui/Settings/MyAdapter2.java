package com.example.scanqr.ui.Settings;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scanqr.R;
import com.example.scanqr.model.Settings;

import java.util.List;

import static com.example.scanqr.model.Settings.ONE_TYPE;
import static com.example.scanqr.model.Settings.Two_TYPE;

public class MyAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Settings> list;

    public MyAdapter2(List<Settings> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        Settings settings=list.get(position);
        if(settings!=null){
          return settings.getType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i){
            case ONE_TYPE:
                view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom1,viewGroup,false);
            return new oneViewHolder(view);

            case Two_TYPE:
                view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom2,viewGroup,false);
                return new twoViewHolder(view);
        }



        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
Settings settings1=list.get(i);
switch (settings1.getType()){
    case ONE_TYPE:
        ((oneViewHolder)viewHolder).text.setText(settings1.getTitle());
        ((oneViewHolder)viewHolder).imag1.setImageResource(settings1.getImage());
        ((oneViewHolder)viewHolder).text4.setText(settings1.getName());break;

    case Two_TYPE:
        ((twoViewHolder)viewHolder).text.setText(settings1.getTitle());
        ((twoViewHolder)viewHolder).image2.setImageResource(settings1.getImage());break;

}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class oneViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView imag1;
        TextView text4;
        public oneViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            imag1=itemView.findViewById(R.id.image2);
            text4=itemView.findViewById(R.id.text4);
        }
    }


    class twoViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image2;
        public twoViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.textmilad);
            image2=itemView.findViewById(R.id.image);
        }
    }

}
