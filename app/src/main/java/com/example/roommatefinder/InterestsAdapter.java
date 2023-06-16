package com.example.roommatefinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.InterestsViewHolder> {
    private List<String> itemList;
    private OnItemClickListener onItemClickListener;

    public InterestsAdapter(List<String> itemList) {
        this.itemList = itemList;
    }

    public InterestsAdapter() {
        this.itemList = Util.interests;;
    }

    @NonNull
    @Override
    public InterestsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.intrest_item, parent, false);
        return new InterestsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InterestsViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.itemText.setText(item);
        holder.itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    if (holder.itemView.isSelected())
                        holder.itemText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.interest_text_color));
                    else
                        holder.itemText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white));
                    holder.itemView.setSelected(!holder.itemView.isSelected());
                    onItemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class InterestsViewHolder extends RecyclerView.ViewHolder {
        public TextView itemText;

        public InterestsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.item_text);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(String item);
    }
}
