package com.example.roommatefinder;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    ArrayList<projectModel> list;
    Context context;

    public RecyclerAdapter(ArrayList<projectModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.items_recyclerview , parent,false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        projectModel model = list.get(position);
        RoundedCornersTransformation transformation = new RoundedCornersTransformation(40, 0);

        Picasso.get().load(model.getAdd_photo_posts()).transform(transformation).fit().placeholder(R.drawable.img_card).into(holder.image_post);
        holder.size.setText(model.getEdit_size()+" Size");
        holder.area.setText(model.getEdit_text_area_posts());
        holder.full_adress.setText(model.getEdit_text_full_address_posts());
        holder.baths.setText(model.getEdit_text_no_baths() +" baths");
        holder.beds.setText(model.getEdit_text_no_beds()+ " beds");
        holder.no_of_roommates.setText(model.getEdit_text_no_roommates()+ " mates");
        holder.item_posts.setText(model.getEdit_text_price_posts()+" price");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_posts, size, beds, baths,
                no_of_roommates, full_adress, area;
        ImageView image_post;


        public ViewHolder(@NonNull View itemView) {





            super(itemView);

            item_posts = itemView.findViewById(R.id.price);
            size = itemView.findViewById(R.id.size);
            beds =itemView. findViewById(R.id.beds);
            baths = itemView.findViewById(R.id.baths);
            no_of_roommates = itemView.findViewById(R.id.no_of_roommates);
            full_adress = itemView.findViewById(R.id.full_adress);
            area = itemView.findViewById(R.id.area);
            image_post = itemView.findViewById(R.id.image_post);
        }
    }

}
