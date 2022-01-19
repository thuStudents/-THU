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

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.ViewHolder> {

    private ArrayList<BarItems> barLocations = new ArrayList<>();
    private Context context;

    /**
     *pass in the data
     */
    public BarAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bar_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    /**
     * pass our data to our ViewHolders
     */
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.bar_name.setText(barLocations.get(position).getBar_name());
        holder.bar_image.setImageResource(barLocations.get(position).getBar_image());
        holder.bar_address.setText(barLocations.get(position).getBar_address());

        /**
         * If the View is expanded, set its visibility to VISIBLE
         * If the View isn't expanded, set its visibility to GONE
         */
        boolean isExpanded = barLocations.get(position).isExtendable_bar();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return  barLocations.size();
    }

    public void setContacts(ArrayList<BarItems> contacts) {
        this.barLocations = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView bar_name, bar_address;
        private ImageView bar_image;
        private LinearLayout linearLayout;
        private RelativeLayout extendableLayout;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bar_name =itemView.findViewById(R.id.bar_name);
            bar_image = itemView.findViewById(R.id.bar_image);
            bar_address = itemView.findViewById(R.id.bar_address);
            parent = itemView.findViewById(R.id.parent);
            linearLayout = itemView.findViewById(R.id.linear_layout5);
            extendableLayout = itemView.findViewById(R.id.extendable_bar);

            /**
             * the setExpanded sets whether the layout is expanded or not, animating if it has already been laid out.
             */
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BarItems barItems = barLocations.get(getAdapterPosition());
                    barItems.setExtendable_bar(!barItems.isExtendable_bar());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
