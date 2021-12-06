package de.thu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        return latestUpdatesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LatestUpdatesViewHolder holder, int position) {
        LatestUpdatesItems latestUpdatesItems = latestUpdatesLocations.get(position);

        holder.imageLU.setImageResource(latestUpdatesLocations.get(position).getLatestUpdatesImage());
        holder.titleLU.setText(latestUpdatesLocations.get(position).getLatestUpdatesTitle());
        holder.descriptionLU.setText(latestUpdatesLocations.get(position).getLatestUpdatesDescription());


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
            titleLU = itemView.findViewById(R.id.latest_updates_title);
            descriptionLU = itemView.findViewById(R.id.latest_updates_description);

        }
    }
}