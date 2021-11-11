package de.thu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AutoScrollAdapter extends RecyclerView.Adapter<AutoScrollAdapter.ViewHolder> {

    View view;
    Context context;

    public AutoScrollAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        view = LayoutInflater.from(context).inflate(R.layout.rec_view_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.position_tv.setText("Position "+ position);
        //int id = getResources().getIdentifier("de.thu:drawable/news" + StringGenerated, null, null);
        switch (position) {
            case 0:
                holder.image_slider.setImageDrawable(context.getResources().getDrawable(R.drawable.news));
                break;
            case 1:
                holder.image_slider.setImageDrawable(context.getResources().getDrawable(R.drawable.morenews));
                break;
            case 2:
                holder.image_slider.setImageDrawable(context.getResources().getDrawable(R.drawable.evenmorenews));
                break;
        }


    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView position_tv;
        ImageView image_slider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            position_tv = itemView.findViewById(R.id.position_tv);
            image_slider = itemView.findViewById(R.id.slider);
        }
    }

    public View getView(int position, View view, ViewGroup parent) {
        return view;
    }
}
