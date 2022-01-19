package de.thu.adapters;

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
import de.thu.ClubItems;

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private ArrayList<ClubItems> clubLocations = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public ClubAdapter(Context context) {
        this.context = context;
    }

    public ClubAdapter() {
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.fun_name.setText(clubLocations.get(position).getFunName());
        holder.fun_image.setImageResource(clubLocations.get(position).getFunImage());
        holder.fun_address.setText(clubLocations.get(position).getFunAddress());

        /**
         * If the View is expanded, set its visibility to VISIBLE
         * If the View isn't expanded, set its visibility to GONE
         */
        boolean isExpanded = clubLocations.get(position).isExtendable_club();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return  clubLocations.size();
    }

    public void setContacts(ArrayList<ClubItems> contacts) {
        this.clubLocations = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fun_name, fun_address;
        private ImageView fun_image;
        private LinearLayout linearLayout;
        private RelativeLayout extendableLayout;


        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fun_name =itemView.findViewById(R.id.fun_name);
            fun_image = itemView.findViewById(R.id.fun_image);
            fun_address = itemView.findViewById(R.id.club_address);

            parent = itemView.findViewById(R.id.parent);

            linearLayout = itemView.findViewById(R.id.linear_layout4);
            extendableLayout = itemView.findViewById(R.id.extendable_club);

            /**
             * the setExpanded sets whether the layout is expanded or not, animating if it has already been laid out.
             */
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClubItems clubItems = clubLocations.get(getAdapterPosition());
                    clubItems.setExtendable_club(!clubItems.isExtendable_club());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}