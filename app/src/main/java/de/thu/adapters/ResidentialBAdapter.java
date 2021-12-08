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

import de.thu.R;
import de.thu.ResidentialBuildingsItems;

public class ResidentialBAdapter extends RecyclerView.Adapter<ResidentialBAdapter.ViewHolder> {

    private ArrayList<ResidentialBuildingsItems> resBuild = new ArrayList<>();

    private Context context;

    public ResidentialBAdapter(Context context) {
        this.context = context;
    }

    public ResidentialBAdapter() {
    }

    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.residentialb_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.resb_name.setText(resBuild.get(position).getResidentialbName());
        holder.resb_image.setImageResource(resBuild.get(position).getResidentialBImage());


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, resBuild.get(position).getResidentialbName() + " Selected", Toast.LENGTH_SHORT).show();

            }
        });




    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  resBuild.size();
    }

    public void setContacts(ArrayList<ResidentialBuildingsItems> contacts) {
        this.resBuild = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView resb_name, resb_des;
        private ImageView resb_image;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resb_name=itemView.findViewById(R.id.resb_name);
            resb_image = itemView.findViewById(R.id.resb_image);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
