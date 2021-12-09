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

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.ViewHolder> {

    private ArrayList<CinemaItems> cinemaLocations = new ArrayList<>();

    private Context context;

    public CinemaAdapter(Context context) {
        this.context = context;
    }



    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinema_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.cinema_name.setText(cinemaLocations.get(position).getCinema_name());
        holder.cinema_image.setImageResource(cinemaLocations.get(position).getCinema_image());
        holder.cinema_address.setText(cinemaLocations.get(position).getCinema_address());

        boolean isExpanded = cinemaLocations.get(position).isExtendable_cinema();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  cinemaLocations.size();
    }

    public void setContacts(ArrayList<CinemaItems> contacts) {
        this.cinemaLocations = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
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
