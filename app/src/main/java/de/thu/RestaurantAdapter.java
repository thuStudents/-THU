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

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private ArrayList<RestaurantItems> restaurantLocations = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public RestaurantAdapter(Context context) {
        this.context = context;
    }



    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.restaurant_name.setText(restaurantLocations.get(position).getRestaurant_name());
        holder.restaurant_image.setImageResource(restaurantLocations.get(position).getRestaurant_image());
        holder.restaurant_address.setText(restaurantLocations.get(position).getRestaurant_address());

        /**
         * If the View is expanded, set its visibility to VISIBLE
         * If the View isn't expanded, set its visibility to GONE
         */
        boolean isExpanded = restaurantLocations.get(position).isExtendable_restaurant();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return  restaurantLocations.size();
    }

    public void setContacts(ArrayList<RestaurantItems> contacts) {
        this.restaurantLocations = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
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

            /**
             * the setExpanded sets whether the layout is expanded or not, animating if it has already been laid out.
             */
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
