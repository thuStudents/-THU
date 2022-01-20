package de.thu.city;

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

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.CafeViewHolder> {

    ArrayList<CafeItems> cafeLocations;

    /**
     *pass in the data
     */
    public CafeAdapter(ArrayList<CafeItems> cafeLocations) {
        this.cafeLocations = cafeLocations;
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public CafeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cafe_row, parent, false);
        return new CafeViewHolder(view);
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull CafeViewHolder holder, int position) {


        CafeItems cafeItems = cafeLocations.get(position);
        holder.cafe_name.setText(cafeLocations.get(position).getCafe_name());
        holder.cafe_time.setText(cafeLocations.get(position).getCafe_time());
        holder.cafe_image.setImageResource(cafeLocations.get(position).getCafe_image());
        holder.cafe_address.setText(cafeLocations.get(position).getCafe_address());
        holder.cafe_t.setText(cafeLocations.get(position).getCafe_t());

        /**
         * If the View is expanded, set its visibility to VISIBLE
         * If the View isn't expanded, set its visibility to GONE
         */
        boolean isExpanded = cafeLocations.get(position).isExpanded_c();
        holder.expandableLayout_c.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return cafeLocations.size();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class CafeViewHolder extends RecyclerView.ViewHolder {

        TextView cafe_name, cafe_time, cafe_address, cafe_t;
        ImageView cafe_image;
        LinearLayout linearLayout_c;
        RelativeLayout expandableLayout_c;


        public CafeViewHolder(@NonNull View itemView) {
            super(itemView);

            cafe_name = itemView.findViewById(R.id.cafe_name);
            cafe_time = itemView.findViewById(R.id.cafe_time);
            cafe_image = itemView.findViewById(R.id.cafe_image);
            cafe_address = itemView.findViewById(R.id.cafe_address);
            cafe_t = itemView.findViewById(R.id.cafe_t);


            linearLayout_c = itemView.findViewById(R.id.linear_layout2);
            expandableLayout_c = itemView.findViewById(R.id.expandable_cafe);

            /**
             * the setExpanded sets whether the layout is expanded or not, animating if it has already been laid out.
             */
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
