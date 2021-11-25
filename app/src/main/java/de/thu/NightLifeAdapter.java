package de.thu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class NightLifeAdapter extends RecyclerView.Adapter<NightLifeAdapter.ViewHolder> {

    private ArrayList<NightLifeItems> nightstuff = new ArrayList<>();

    private Context context;

    public NightLifeAdapter(Context context) {
        this.context = context;
    }

    public NightLifeAdapter() {
    }

    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_night_life, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.nightlife_name.setText(nightstuff.get(position).getNightName());
        holder.nightlife_des.setText(nightstuff.get(position).getNightDes());
        holder.nightlife_imageView.setImageResource(nightstuff.get(position).getNightImage());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(position){
                    case 0:
                        v.getContext().startActivity(new Intent(v.getContext(), ClubActivity.class));

                    case 1:
                        Toast.makeText(context, nightstuff.get(position).getNightName() + " Selected", Toast.LENGTH_SHORT).show();

                    case 2:
                        Toast.makeText(context, nightstuff.get(position).getNightName() + " Selected", Toast.LENGTH_SHORT).show();

                    case 3:
                        Toast.makeText(context, nightstuff.get(position).getNightName() + " Selected", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  nightstuff.size();
    }

    public void setContacts(ArrayList<NightLifeItems> contacts) {
        this.nightstuff = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nightlife_name, nightlife_des;
        private ImageView nightlife_imageView;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nightlife_name =itemView.findViewById(R.id.nightlife_name);
            nightlife_des = itemView.findViewById(R.id.nightlife_des);
            nightlife_imageView = itemView.findViewById(R.id.nightlife_imageView);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
