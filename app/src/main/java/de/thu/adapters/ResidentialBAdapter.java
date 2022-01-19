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

import de.thu.R;
import de.thu.ResidentialBuildingsItems;

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */
public class ResidentialBAdapter extends RecyclerView.Adapter<ResidentialBAdapter.ViewHolder> {

    private ArrayList<ResidentialBuildingsItems> resBuild = new ArrayList<>();

    private Context context;

    /**
     *pass in the data
     */
    public ResidentialBAdapter(Context context) {
        this.context = context;
    }

    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.residentialb_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * pass our data to our ViewHolders
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.resb_name.setText(resBuild.get(position).getResidentialbName());
        holder.resb_image.setImageResource(resBuild.get(position).getResidentialBImage());
        holder.resb_contacts.setText(resBuild.get(position).getResidentialbContacts());
        holder.resb_num.setText(resBuild.get(position).getResidentialNum());

        /**
         * respond to click events
         start the intent which links to the Google maps with the corresponding address
         */
        holder.resb_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.it/maps/search/"+ holder.resb_num.getText()));
                context.startActivity(browserIntent);
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

    public void setContacts(ArrayList<ResidentialBuildingsItems> contacts) {
        this.resBuild = contacts;
        notifyDataSetChanged();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView resb_name, resb_contacts, resb_num;
        private ImageView resb_image;

        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resb_name=itemView.findViewById(R.id.resb_name);
            resb_image = itemView.findViewById(R.id.resb_image);
            resb_num = itemView.findViewById(R.id.number_of_students);
            resb_contacts = itemView.findViewById(R.id.apartment_contact);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
