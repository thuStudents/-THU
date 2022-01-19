package de.thu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.PrivateBItems;
import de.thu.R;

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class PrivateBAdapter extends RecyclerView.Adapter<PrivateBAdapter.ViewHolder> {

    private ArrayList<PrivateBItems> resBuild = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public PrivateBAdapter(Context context) {
        this.context = context;
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.privateb_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.privb_name.setText(resBuild.get(position).getPrivateBName());
        holder.privb_image.setImageResource(resBuild.get(position).getPrivateBImage());
        holder.privb_des.setText(resBuild.get(position).getPrivateBDes());
        holder.privb_add.setText(resBuild.get(position).getPrivateBAdd());

        /**
         * respond to click events
         * if the clicked view is in position 2
         * start the intent which links to the Studierentenwerk website
         * else start the intent wich links to the Google maps with the corresponding address
         */
        holder.privb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 2) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studierendenwerk-ulm.de/wp-content/uploads/privatzimmer/PZV_ulm.pdf"));
                    context.startActivity(browserIntent);
                } else {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.it/maps/search/" + holder.privb_add.getText()));
                    context.startActivity(browserIntent);
                }
            }
        });


    }


    /**
     * total number of rows
     */
    @Override
    public int getItemCount() {
        return  resBuild.size();
    }

    public void setContacts(ArrayList<PrivateBItems> contacts) {
        this.resBuild = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView privb_name, privb_des, privb_add;
        private ImageView privb_image;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            privb_name=itemView.findViewById(R.id.privb_name);
            privb_des=itemView.findViewById(R.id.apartment_cost_p);
            privb_add=itemView.findViewById(R.id.add_p);
            privb_image = itemView.findViewById(R.id.privb_image);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
