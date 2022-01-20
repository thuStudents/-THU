package de.thu.city;

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

import de.thu.R;

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.ViewHolder> {

    private ArrayList<CinemaItems> cinemaLocations = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public CinemaAdapter(Context context) {
        this.context = context;
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinema_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.cinema_name.setText(cinemaLocations.get(position).getCinema_name());
        holder.cinema_image.setImageResource(cinemaLocations.get(position).getCinema_image());
        holder.cinema_address.setText(cinemaLocations.get(position).getCinema_address());

        /**
         * If the View is expanded, set its visibility to VISIBLE
         * If the View isn't expanded, set its visibility to GONE
         */
        boolean isExpanded = cinemaLocations.get(position).isExtendable_cinema();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return  cinemaLocations.size();
    }

    public void setContacts(ArrayList<CinemaItems> contacts) {
        this.cinemaLocations = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView cinema_name, cinema_address;
        private ImageView cinema_image;
        private LinearLayout linearLayout;
        private RelativeLayout extendableLayout;


        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cinema_name =itemView.findViewById(R.id.cinema_name);
            cinema_image = itemView.findViewById(R.id.cinema_image);
            cinema_address = itemView.findViewById(R.id.cinema_address);

            parent = itemView.findViewById(R.id.parent);

            linearLayout = itemView.findViewById(R.id.linear_layout6);
            extendableLayout = itemView.findViewById(R.id.extendable_cinema);

            /**
             * the setExpanded sets whether the layout is expanded or not, animating if it has already been laid out.
             */
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CinemaItems cinemaItems = cinemaLocations.get(getAdapterPosition());
                    cinemaItems.setExtendable_cinema(!cinemaItems.isExtendable_cinema());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
