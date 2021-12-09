package de.thu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.PrivateBItems;
import de.thu.R;

public class PrivateBAdapter extends RecyclerView.Adapter<PrivateBAdapter.ViewHolder> {

    private ArrayList<PrivateBItems> resBuild = new ArrayList<>();

    private Context context;

    public PrivateBAdapter(Context context) {
        this.context = context;
    }

    public PrivateBAdapter() {
    }

    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.privateb_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.privb_name.setText(resBuild.get(position).getPrivateBName());
        holder.privb_image.setImageResource(resBuild.get(position).getPrivateBImage());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, resBuild.get(position).getPrivateBName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });



    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  resBuild.size();
    }

    public void setContacts(ArrayList<PrivateBItems> contacts) {
        this.resBuild = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView privb_name, privb_des;
        private ImageView privb_image;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            privb_name=itemView.findViewById(R.id.privb_name);
            privb_image = itemView.findViewById(R.id.privb_image);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
