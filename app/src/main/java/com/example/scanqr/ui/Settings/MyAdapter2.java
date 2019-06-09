package com.example.scanqr.ui.Settings;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scanqr.R;
import com.example.scanqr.model.Settings;

import java.util.ArrayList;
import java.util.List;

import static com.example.scanqr.model.Settings.ONE_TYPE;
import static com.example.scanqr.model.Settings.Two_TYPE;

public class MyAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Settings> list;
    android.support.v7.app.AlertDialog alertDialog1;
    CharSequence[] values = {" First Item ", " Second Item ", " Third Item "};
    settings.ui view;
    public MyAdapter2(List<Settings> list ,settings.ui view) {
        this.list = list;
        this.view=view;
    }

    @Override
    public int getItemViewType(int position) {
        Settings settings = list.get(position);
        if (settings != null) {
            return settings.getType();
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case ONE_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom1, viewGroup, false);
                return new oneViewHolder(view);

            case Two_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom2, viewGroup, false);
                return new twoViewHolder(view);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Settings settings1 = list.get(i);
        switch (settings1.getType()) {
            case ONE_TYPE:
                ((oneViewHolder) viewHolder).text.setText(settings1.getTitle());
                ((oneViewHolder) viewHolder).imag1.setImageResource(settings1.getImage());
                ((oneViewHolder) viewHolder).text4.setText(settings1.getName());
//                ((oneViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//
//                    }
//                });
                break;

            case Two_TYPE:
                ((twoViewHolder) viewHolder).text.setText(settings1.getTitle());
                ((twoViewHolder) viewHolder).image2.setImageResource(settings1.getImage());
                break;
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
        CardView cardview;

        public oneViewHolder(@NonNull final View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            imag1 = itemView.findViewById(R.id.image2);
            text4 = itemView.findViewById(R.id.text4);
            cardview = itemView.findViewById(R.id.card1);
cardview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (list.get(getAdapterPosition()).getTitle()){
            case "بازه زمانی قفل صفحه": view.alert(list);break;
            case "روش احراز هویت": view.change();

        }
    }
});
        }
    }


    class twoViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image2;

        public twoViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textmilad);
            image2 = itemView.findViewById(R.id.image);
        }
    }


}
