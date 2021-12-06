package de.thu.ulm.cafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.R;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.CafeViewHolder> {

    ArrayList<CafeItems> cafeLocations;

    public CafeAdapter(ArrayList<CafeItems> cafeLocations) {
        this.cafeLocations = cafeLocations;
    }

    @NonNull
    @Override
    public CafeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cafe_row, parent, false);
        return new CafeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeViewHolder holder, int position) {


        CafeItems cafeItems = cafeLocations.get(position);
        holder.cafe_name.setText(cafeLocations.get(position).getCafe_name());
        holder.cafe_time.setText(cafeLocations.get(position).getCafe_time());
        holder.cafe_image.setImageResource(cafeLocations.get(position).getCafe_image());

        boolean isExpanded = cafeLocations.get(position).isExpanded_c();
        holder.expandableLayout_c.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return cafeLocations.size();
    }


    public class CafeViewHolder extends RecyclerView.ViewHolder {

        TextView cafe_name, cafe_time;
        ImageView cafe_image;
        LinearLayout linearLayout_c;
        RelativeLayout expandableLayout_c;


        public CafeViewHolder(@NonNull View itemView) {
            super(itemView);

            cafe_name = itemView.findViewById(R.id.cafe_name);
            cafe_time = itemView.findViewById(R.id.cafe_time);
            cafe_image = itemView.findViewById(R.id.cafe_image);


            linearLayout_c = itemView.findViewById(R.id.linear_layout2);
            expandableLayout_c = itemView.findViewById(R.id.expandable_cafe);

            linearLayout_c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CafeItems cafeItems = cafeLocations.get(getAdapterPosition());
                    cafeItems.setExpanded_c(!cafeItems.isExpanded_c());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}
