package de.thu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.position_tv.setText("Position "+ position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView position_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            position_tv = itemView.findViewById(R.id.position_tv);
        }
    }
}
