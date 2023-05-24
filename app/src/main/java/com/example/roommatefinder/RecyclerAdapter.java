package com.example.roommatefinder;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private boolean clicked = false ;

    ArrayList<projectModel> list;
    Context context;
FirebaseDatabase firebaseDatabase;
    ImageButton imageButton;
    private List<projectModel> favoriteList;
    private DatabaseReference databaseReference;


    public RecyclerAdapter(ArrayList<projectModel> list, Context context) {
        this.list = list;
        this.context = context;
        favoriteList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("favourite");
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
        profile_model profileModel = new profile_model();

        boolean isFavorite = model.isFavorite();
        if (model.isFavorite()) {
            holder.imageButton.setImageResource(R.drawable.fav_svg);
        } else {
            holder.imageButton.setImageResource(R.drawable.favourtire_unfilled);
        }

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setFavorite(!model.isFavorite());

                // Update the favorite button's icon
                if (model.isFavorite()) {
                    holder.imageButton.setImageResource(R.drawable.fav_svg);

                    // Add the item to the favorite list
                    favoriteList.add(model);

                    // Save the item to the Firebase database
                    String id = databaseReference.push().getKey();
                    model.setId(id);
                    databaseReference.child(id).setValue(model);
                } else {
                    holder.imageButton.setImageResource(R.drawable.favourtire_unfilled);

                    // Remove the item from the favorite list
                    favoriteList.remove(model);

                    // Remove the item from the Firebase database
                    databaseReference.child(model.getId()).removeValue();
                }
            }
        });

        RoundedCornersTransformation transformation = new RoundedCornersTransformation(40, 0);

        Picasso.get().load(model.getAdd_photo_posts()).transform(transformation).fit().placeholder(R.drawable.img_card).into(holder.image_post);

        holder.size.setText(model.getEdit_size()+" Size");
        holder.area.setText(model.getEdit_text_area_posts());
        holder.full_adress.setText(model.getEdit_text_full_address_posts());
        holder.baths.setText(model.getEdit_text_no_baths() +" baths");
        holder.beds.setText(model.getEdit_text_no_beds()+ " beds");
        holder.no_of_roommates.setText(model.getEdit_text_no_roommates()+ " mates");
        holder.item_posts.setText(model.getEdit_text_price_posts()+" price");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , detailActivity.class);

                intent.putExtra("imageslider" , model.getAdd_photo_posts());
                intent.putExtra("full_adress" , model.getEdit_text_full_address_posts());
                intent.putExtra("size" , model.getEdit_size());
                intent.putExtra("baths" , model.getEdit_text_no_baths());
                intent.putExtra("beds" , model.getEdit_text_no_beds());
                intent.putExtra("roommates" , model.getEdit_text_no_roommates());
                intent.putExtra("description" , model.getAddesc());
                intent.putExtra("date" , model.getDate());
                intent.putExtra("price" , model.getEdit_text_price_posts());
                intent.putExtra("amenties" , model.getPropertytype());
                intent.putExtra("apartment_textview" , model.getPropertytype());
                intent.putExtra("villa_textview" , model.getPropertytype());
                intent.putExtra("other_property_textview" , model.getPropertytype());
                intent.putExtra("garage_textview" , model.getGarage());
                intent.putExtra("parking_textview" , model.getParking());
                intent.putExtra("internet_textview" , model.getInternet());
                intent.putExtra("balacony_textview" , model.getBalacony());
                intent.putExtra("garden_textview" , model.getGarden());
                intent.putExtra("workingout_textview" , model.getWorkout());
                intent.putExtra("security_textview" , model.getSecurity());
                intent.putExtra("pets_textview" , model.getPets());
                intent.putExtra("other_amenities_textview" , model.getPropertytype());
                intent.putExtra("furnishing_textview" , model.getFurinture());
                intent.putExtra("notfurnishing_textview" , model.getFurinture());
                intent.putExtra("" , model.getWashingmachines());
                intent.putExtra("tv_textview" , model.getTv());
                intent.putExtra("airconditioner_textview" , model.getAirconditioner());
                intent.putExtra("otherappliance_textview" , model.getOther());
//                intent.putExtra("first_name" , model.getEdit_text_first_name_fill_information());
                intent.putExtra("profile_detail" , model.getAdd_photo());










                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_posts, size, beds, baths,
                no_of_roommates, full_adress, area , first_name;
        ImageView image_post;
        ImageView profile_img;
        ImageButton imageButton;


        public ViewHolder(@NonNull View itemView) {





            super(itemView);

            item_posts = itemView.findViewById(R.id.price);
            size = itemView.findViewById(R.id.size);
            beds =itemView. findViewById(R.id.beds);
            baths = itemView.findViewById(R.id.baths);
            no_of_roommates = itemView.findViewById(R.id.no_of_roommates);
            full_adress = itemView.findViewById(R.id.full_adress);
            area = itemView.findViewById(R.id.area);
            imageButton = itemView.findViewById(R.id.fav_btn);
            image_post = itemView.findViewById(R.id.image_post);
//
//            if (clicked) {
//                imageButton.setImageResource(R.drawable.fav_svg);
//
//
//            } else {
//                imageButton.setImageResource(R.drawable.favourtire_unfilled);
//            }
//            imageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    clicked = !clicked;
//
//                    if (clicked) {
//
//                        imageButton.setImageResource(R.drawable.fav_svg);
//
//
//
//                    } else {
//                        imageButton.setImageResource(R.drawable. favourtire_unfilled);
//                    }
//
//
//
//                }
//            });


        }



    }

}
