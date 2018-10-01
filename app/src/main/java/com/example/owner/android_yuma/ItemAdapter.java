package com.example.owner.android_yuma;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private List<ItemModel> models;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ItemModel model, View view);
    }

    ItemAdapter(@NonNull List<ItemModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (models.size() > 0 && models.get(position) != null) {
            final ItemModel model = models.get(position);
            holder.setItemModel(model);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(model, holder.itemView);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView prefectureView;

        ViewHolder(View v) {
            super(v);
            this.imageView = v.findViewById(R.id.image_view);
            this.textView = v.findViewById(R.id.text_view);
            this.prefectureView = v.findViewById(R.id.prefecture_view);
        }

        void setItemModel(ItemModel model) {
            this.imageView.setImageResource(model.getImageId());
            this.textView.setText(model.getName());
            this.prefectureView.setText(model.getPrefecture());
        }
    }
}