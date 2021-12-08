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

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.ViewHolder> {

    private ArrayList<BarItems> barLocations = new ArrayList<>();

    private Context context;

    public BarAdapter(Context context) {
        this.context = context;
    }



    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bar_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.bar_name.setText(barLocations.get(position).getBar_name());
        holder.bar_image.setImageResource(barLocations.get(position).getBar_image());
        holder.bar_address.setText(barLocations.get(position).getBar_address());

        boolean isExpanded = barLocations.get(position).isExtendable_bar();
        holder.extendableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  barLocations.size();
    }

    public void setContacts(ArrayList<BarItems> contacts) {
        this.barLocations = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
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
