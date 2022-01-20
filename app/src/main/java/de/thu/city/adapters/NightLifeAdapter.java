package de.thu.city.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.city.BarActivity;
import de.thu.city.CinemaActivity;
import de.thu.R;
import de.thu.city.RestaurantActivity;
import de.thu.city.ClubActivity;
import de.thu.city.NightLifeItems;

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class NightLifeAdapter extends RecyclerView.Adapter<NightLifeAdapter.ViewHolder> {

    private ArrayList<NightLifeItems> nightstuff = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public NightLifeAdapter(Context context) {
        this.context = context;
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_night_life, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.nightlife_name.setText(nightstuff.get(position).getNightName());
        holder.nightlife_imageView.setImageResource(nightstuff.get(position).getNightImage());

        /**
         * respond to click events
         * the clicked view is determined by taking it's position
         * the corresponding intent is started based on the View we click
         */
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(position){
                    case 0:
                        v.getContext().startActivity(new Intent(v.getContext(), ClubActivity.class));
                        break;

                    case 1:
                        v.getContext().startActivity(new Intent(v.getContext(), BarActivity.class));
                        break;

                    case 2:
                        v.getContext().startActivity(new Intent(v.getContext(), CinemaActivity.class));
                        break;

                    case 3:
                        v.getContext().startActivity(new Intent(v.getContext(), RestaurantActivity.class));
                        break;

                }

            }
        });


    }


    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return  nightstuff.size();
    }

    public void setContacts(ArrayList<NightLifeItems> contacts) {
        this.nightstuff = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nightlife_name;
        private ImageView nightlife_imageView;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nightlife_name =itemView.findViewById(R.id.nightlife_name);
            nightlife_imageView = itemView.findViewById(R.id.nightlife_imageview);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
