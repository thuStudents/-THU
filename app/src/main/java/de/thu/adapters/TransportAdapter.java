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
import de.thu.TransportItems;

public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.ViewHolder> {

    private ArrayList<TransportItems> transportLocations = new ArrayList<>();

    private Context context;

    public TransportAdapter(Context context) {
        this.context = context;
    }

    public TransportAdapter() {
    }

    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_transport, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.transport_name.setText(transportLocations.get(position).getTransportName());
        holder.transport_des.setText(transportLocations.get(position).getTransportDes());
        holder.transport_image.setImageResource(transportLocations.get(position).getTransportImage());

        boolean isExpanded = transportLocations.get(position).isExtended_t();
        holder.expandableLayout_transport.setVisibility(isExpanded ? View.VISIBLE : View.GONE);



    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  transportLocations.size();
    }

    public void setContacts(ArrayList<TransportItems> contacts) {
        this.transportLocations = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
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
