package de.thu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private ArrayList<RestaurantItems> restaurantLocations = new ArrayList<>();

    private Context context;

    public RestaurantAdapter(Context context) {
        this.context = context;
    }



    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.restaurant_name.setText(restaurantLocations.get(position).getRestaurant_name());
        holder.restaurant_image.setImageResource(restaurantLocations.get(position).getRestaurant_image());
        holder.restaurant_address.setText(restaurantLocations.get(position).getRestaurant_address());

        boolean isExpanded = restaurantLocations.get(position).isExtendable_restaurant();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  restaurantLocations.size();
    }

    public void setContacts(ArrayList<RestaurantItems> contacts) {
        this.restaurantLocations = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView restaurant_name, restaurant_address;
        private ImageView restaurant_image;
        private LinearLayout linearLayout;
        private RelativeLayout extendableLayout;


        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurant_name =itemView.findViewById(R.id.restaurants_name);
            restaurant_image = itemView.findViewById(R.id.restaurants_image);
            restaurant_address = itemView.findViewById(R.id.restaurants_address);

            parent = itemView.findViewById(R.id.parent);

            linearLayout = itemView.findViewById(R.id.linear_layout7);
            extendableLayout = itemView.findViewById(R.id.extendable_restaurants);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RestaurantItems restaurantItems = restaurantLocations.get(getAdapterPosition());
                    restaurantItems.setExtendable_restaurant(!restaurantItems.isExtendable_restaurant());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
