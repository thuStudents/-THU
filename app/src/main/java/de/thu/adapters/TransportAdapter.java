package de.thu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import de.thu.TransportItems;

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.ViewHolder> {

    private ArrayList<TransportItems> transportLocations = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public TransportAdapter(Context context) {
        this.context = context;
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_transport, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.transport_name.setText(transportLocations.get(position).getTransportName());
        holder.transport_des.setText(transportLocations.get(position).getTransportDes());
        holder.transport_image.setImageResource(transportLocations.get(position).getTransportImage());

        boolean isExpanded = transportLocations.get(position).isExtended_t();
        holder.expandableLayout_transport.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        /**
         * respond to click events
         start the intent which links to the Google maps with the corresponding address
         */
        holder.transport_des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ding.eu/"));
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
        return  transportLocations.size();
    }

    public void setContacts(ArrayList<TransportItems> contacts) {
        this.transportLocations = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView transport_name, transport_des;
        private ImageView transport_image;
        private LinearLayout linearLayout_transport;
        private RelativeLayout expandableLayout_transport;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            transport_name =itemView.findViewById(R.id.transport_name);
            transport_des =itemView.findViewById(R.id.transport_des);
            transport_image = itemView.findViewById(R.id.transport_image);

            parent = itemView.findViewById(R.id.parent);

            linearLayout_transport = itemView.findViewById(R.id.linear_layout3);
            expandableLayout_transport = itemView.findViewById(R.id.expandale_transport);

            linearLayout_transport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TransportItems transportItems = transportLocations.get(getAdapterPosition());
                    transportItems.setExtended_t(!transportItems.isExtended_t());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
