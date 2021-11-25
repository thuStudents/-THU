package de.thu;

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

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private ArrayList<ClubItems> fun = new ArrayList<>();

    private Context context;

    public ClubAdapter(Context context) {
        this.context = context;
    }

    public ClubAdapter() {
    }

    //create view holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create view obj
        //view group parent of all the layout files, parent of rel layout, const layout... -> tells where we want to attach the view obj
        //false cause redundancy i guess
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.fun_name.setText(fun.get(position).getFunName());
        holder.fun_des.setText(fun.get(position).getFunDes());
        holder.fun_image.setImageResource(fun.get(position).getFunImage());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, fun.get(position).getFunName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });



    }


    //return the count of different items in our adapter
    @Override
    public int getItemCount() {
        return  fun.size();
    }

    public void setContacts(ArrayList<ClubItems> contacts) {
        this.fun = contacts;
        notifyDataSetChanged();
    }

    //inner class needed for generating View objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fun_name, fun_des;
        private ImageView fun_image;


        private CardView parent;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fun_name =itemView.findViewById(R.id.fun_name);
            fun_des = itemView.findViewById(R.id.fun_des);
            fun_image = itemView.findViewById(R.id.fun_image);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
