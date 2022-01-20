package de.thu.city;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.R;

public class LatestUpdatesAdapter extends RecyclerView.Adapter<LatestUpdatesAdapter.LatestUpdatesViewHolder> {

    ArrayList<LatestUpdatesItems> latestUpdatesLocations;

    public LatestUpdatesAdapter(ArrayList<LatestUpdatesItems> latestUpdatesLocations) {
        this.latestUpdatesLocations = latestUpdatesLocations;
    }

    @NonNull
    @Override
    public LatestUpdatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_updates, parent, false);
        LatestUpdatesViewHolder latestUpdatesViewHolder = new LatestUpdatesViewHolder(view);
        return new LatestUpdatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LatestUpdatesViewHolder holder, int position) {
        LatestUpdatesItems latestUpdatesItems = latestUpdatesLocations.get(position);

        holder.imageLU.setImageResource(latestUpdatesLocations.get(position).getLatestUpdatesImage());



    }

    @Override
    public int getItemCount() {
        return latestUpdatesLocations.size();
    }

    public static class LatestUpdatesViewHolder extends RecyclerView.ViewHolder{


        ImageView imageLU;
        TextView titleLU, descriptionLU;

        public LatestUpdatesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLU = itemView.findViewById(R.id.latest_updates_imageview);


        }
    }
}
