package com.example.scanqr.ui.setting;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scanqr.R;
import com.example.scanqr.model.Setting;

import java.util.List;

import static com.example.scanqr.model.Setting.ONE_TYPE;
import static com.example.scanqr.model.Setting.Two_TYPE;

public class SettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Setting> mList;
    private showAndChange mShowAndChange;

    interface showAndChange {
        void changeText();

        void alertDialog();
    }

    public SettingAdapter(List<Setting> list, showAndChange showAndChange) {
        mList = list;
        mShowAndChange = showAndChange;
    }

    @Override
    public int getItemViewType(int position) {
        Setting settings = mList.get(position);
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_onemodel_setting, viewGroup, false);
                return new clockViewHolder(view, mList, mShowAndChange);

            case Two_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_twomodel_setting, viewGroup, false);
                return new callAndHomeViewHolder(view);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Setting settings1 = mList.get(i);
        switch (settings1.getType()) {
            case ONE_TYPE:
                ((clockViewHolder) viewHolder).mText.setText(settings1.getTitle());
                ((clockViewHolder) viewHolder).mImage.setImageResource(settings1.getImage());
                ((clockViewHolder) viewHolder).mTextClock.setText(settings1.getName());

                break;

            case Two_TYPE:
                ((callAndHomeViewHolder) viewHolder).mText.setText(settings1.getTitle());
                ((callAndHomeViewHolder) viewHolder).mImage.setImageResource(settings1.getImage());
                break;
        }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class clockViewHolder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView mImage;
        private TextView mTextClock;
        private CardView mCardView;

        public clockViewHolder(@NonNull final View itemView, final List<Setting> mList, final showAndChange mShowAndChange) {
            super(itemView);
            mText = itemView.findViewById(R.id.text);
            mImage = itemView.findViewById(R.id.ImageView_setting);
            mTextClock = itemView.findViewById(R.id.text4);
            mCardView = itemView.findViewById(R.id.CardView_setting);
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mList.get(getAdapterPosition()).getTitle()) {
                        case R.string.setting_onetitle:
                            mShowAndChange.alertDialog();
                            break;
                        case R.string.setting_twotitle:
                            mShowAndChange.changeText();

                    }
                }
            });
        }
    }


    static class callAndHomeViewHolder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView mImage;

        public callAndHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.textmilad);
            mImage = itemView.findViewById(R.id.image);
        }
    }


}
