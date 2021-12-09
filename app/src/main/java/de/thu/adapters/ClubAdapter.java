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

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private ArrayList<ClubItems> clubLocations = new ArrayList<>();

    private Context context;

    public ClubAdapter(Context context) {
        this.context = context;
    }

    public ClubAdapter() {
    }

    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.fun_name.setText(clubLocations.get(position).getFunName());
        holder.fun_image.setImageResource(clubLocations.get(position).getFunImage());
        holder.fun_address.setText(clubLocations.get(position).getFunAddress());

        boolean isExpanded = clubLocations.get(position).isExtendable_club();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  clubLocations.size();
    }

    public void setContacts(ArrayList<ClubItems> contacts) {
        this.clubLocations = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
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